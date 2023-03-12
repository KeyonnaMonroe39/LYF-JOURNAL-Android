package com.keyonnamonroe.lyfjournal.framework.android.http.interfaces

import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.ErrorItem
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.ResponseItem

/**
 * A success/failure driven callback for HTTP response(s).
 */
interface HttpResponseCallback {

    /**
     * Callback for a successful HTTP response.
     *
     * @param responseItem The response body of the HTTP request.
     */
    fun onSuccess(responseItem: ResponseItem)

    /**
     * Callback for failed HTTP response.
     *
     * @param errorItem The status code for the HTTP request.
     */
    fun onFailure(errorItem: ErrorItem)

    /**
     * Callback for a cancelled HTTP request.
     */
    fun onCancelled()
}