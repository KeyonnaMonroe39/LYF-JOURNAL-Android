package com.keyonnamonroe.lyfjournal.framework.android.http.client

import android.os.Handler
import android.os.Looper
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.keyonnamonroe.lyfjournal.framework.android.constants.Constants
import com.keyonnamonroe.lyfjournal.framework.android.http.configuration.BaseClientConfiguration
import com.keyonnamonroe.lyfjournal.framework.android.http.interfaces.HttpRequestExecutor
import com.keyonnamonroe.lyfjournal.framework.android.http.interfaces.HttpResponseCallback
import com.keyonnamonroe.lyfjournal.framework.android.http.logger.LoggerInterceptor
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.OkHttpRequestExecutor
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.*
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger

/**
 * This abstract class encapsulates HTTP logic.
 *
 * @param T : BaseClientConfiguration Used to abstract the attributes used in HTTP request in.
 * @property configuration T This property contains necessary info to make the HTTP requests.
 * @property okHttpRequestExecutor HttpRequestExecutor This interface establishes a common contract for hiding HTTP library dependencies.
 * @property handler Handler Class used to run a message loop for a thread.
 * @property gson Gson This is the main class for using Gson.
 * @constructor
 */
abstract class BaseApiClient<T : BaseClientConfiguration>(
    protected var configuration: T,
    protected val okHttpRequestExecutor: HttpRequestExecutor = OkHttpRequestExecutor(
        interceptor = LoggerInterceptor()
    ),
    private val handler: Handler = Handler(Looper.getMainLooper()),
    protected val gson: Gson = Gson()
) {
    // post runnable hook
    // causes the Runnable to be added to the message queue. The runnable will be run on
    // the thread to which a handler is attached.
    private var postRunnableHook: () -> Unit = {}

    // listener
    private var onHttpRequestListener: OnHttpRequestListener? = null

    /**
     * Interface for tracking http requests (success/fail).
     */
    protected interface OnHttpRequestListener {
        fun onHttpRequest(
            identifier: String?,
            statusCode: Int?,
            isHttpSuccess: Boolean
        )
    }

    /**
     * Method is used to track http requests (success/fail).
     *
     * @param listener OnHttpRequestListener Callback for tracking http requests (success/fail).
     */
    protected fun registerHttpRequestListener(listener: OnHttpRequestListener) {
        onHttpRequestListener = listener
    }

    /**
     * Listen for the [HttpResponseCallback] and update [ResponseCallback] accordingly.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param emptyResponse Empty object for [T].
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    protected inline fun <reified T : EmptyStateInfo> getHttpResponseCallback(
        identifier: String? = null,
        emptyResponse: T,
        responseCallback: ResponseCallback<T>? = null
    ) = object : HttpResponseCallback {
        override fun onSuccess(responseItem: ResponseItem) {
            // track http request
            handleHttpRequestTracker(
                identifier = identifier,
                statusCode = responseItem.statusCode.code,
                isHttpSuccess = true
            )
            // handle valid http response
            handleValidHttpResponse(
                identifier = identifier,
                responseItem = responseItem,
                emptyResponse = emptyResponse,
                responseCallback = responseCallback,
                tClass = T::class.java
            )
        }

        override fun onFailure(errorItem: ErrorItem) {
            // track http request
            handleHttpRequestTracker(
                identifier = identifier,
                statusCode = errorItem.statusCode?.code,
                isHttpSuccess = false
            )
            // handle http failure
            handleHttpResponseFailure(
                identifier = identifier,
                errorItem = errorItem,
                responseCallback = responseCallback
            )
        }

        override fun onCancelled() {
            // no-op
        }
    }

    /**
     * Handle callbacks for [ResponseCallback] when a HTTP request concludes successfully.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param responseItem HTTP response item.
     * @param emptyResponse Empty object for [T].
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    protected fun <T : EmptyStateInfo> handleValidHttpResponse(
        identifier: String? = null,
        responseItem: ResponseItem,
        emptyResponse: T,
        responseCallback: ResponseCallback<T>?,
        tClass: Class<T>
    ) {
        when (responseItem) {
            is ResponseItem.StringResponseItem -> {
                try {
                    val responseData = gson.fromJson(responseItem.response, tClass)
                    handleResponseSuccess(
                        identifier = identifier,
                        httpStatusCode = responseItem.statusCode,
                        responseData = responseData,
                        responseCallback = responseCallback
                    )
                } catch (e: JsonSyntaxException) {
                    e.printStackTrace()
                    Logger.e(Constants.TAG, e.message, e)
                    handleNonHttpFailure(
                        identifier = identifier,
                        exception = e,
                        responseCallback = responseCallback
                    )
                }
            }
            is ResponseItem.EmptyResponseItem -> {
                handleResponseSuccess(
                    identifier = identifier,
                    httpStatusCode = responseItem.statusCode,
                    responseData = emptyResponse,
                    responseCallback = responseCallback
                )
            }
        }
    }

    /**
     * Handle callbacks for [ResponseCallback] when a response succeeds.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param httpStatusCode Represents an HTTP status with code and message.
     * @param responseData Response data.
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    private fun <T : EmptyStateInfo> handleResponseSuccess(
        identifier: String? = null,
        httpStatusCode: HttpStatusCode,
        responseData: T,
        responseCallback: ResponseCallback<T>?
    ) = notifyWithHandler {
        responseCallback?.onSuccess(
            Response.Success(
                httpStatusCode = httpStatusCode,
                response = responseData,
                identifier = identifier
            )
        )
    }

    /**
     * Handle callbacks for [ResponseCallback] when a response fails.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param errorItem Distinguishes between a runtime error and a failed HTTP response.
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    private fun <T : EmptyStateInfo> handleResponseFailure(
        identifier: String? = null,
        errorItem: ErrorItem,
        responseCallback: ResponseCallback<T>?
    ) = notifyWithHandler {
        responseCallback?.onFailure(
            Response.Failure(
                errorItem = errorItem,
                identifier = identifier
            )
        )
    }

    /**
     * Handle non-Http failures and callbacks for failures.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param exception An object that wraps an error event that occurred and contains information
     * about the error including its type.
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    private fun <T : EmptyStateInfo> handleNonHttpFailure(
        identifier: String? = null,
        exception: Exception,
        responseCallback: ResponseCallback<T>?
    ) {
        handleResponseFailure(
            identifier = identifier,
            errorItem = ErrorItem.GenericErrorItem(exception),
            responseCallback = responseCallback
        )
    }

    /**
     * Handle Http failures and callbacks for failures.
     *
     * @param T Generic type parameter.
     * @param identifier Description text or label for the HTTP request.
     * @param errorItem Distinguishes between a runtime error and a failed HTTP response.
     * @param responseCallback Callback to notify call-site of `onSuccess` and `onFailure` events.
     */
    protected fun <T : EmptyStateInfo> handleHttpResponseFailure(
        identifier: String? = null,
        errorItem: ErrorItem,
        responseCallback: ResponseCallback<T>?
    ) {
        handleResponseFailure(
            identifier = identifier,
            errorItem = errorItem,
            responseCallback = responseCallback
        )
    }

    /**
     * Method is used to track http requests.
     *
     * @param identifier Description text or label for the HTTP request.
     * @param statusCode The status code of the request.
     * @param isHttpSuccess True if the recent request was successful, otherwise false.
     */
    protected fun handleHttpRequestTracker(
        identifier: String? = null,
        statusCode: Int? = null,
        isHttpSuccess: Boolean
    ) {
        onHttpRequestListener?.onHttpRequest(
            identifier = identifier,
            statusCode = statusCode,
            isHttpSuccess = isHttpSuccess
        )
    }

    /**
     * Wrap [action] around [Handler]'s post call.
     */
    private fun notifyWithHandler(action: () -> Unit) = handler.post { action() }
        .also { postRunnableHook() }
}