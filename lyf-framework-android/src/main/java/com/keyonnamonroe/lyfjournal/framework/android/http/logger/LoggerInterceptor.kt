package com.keyonnamonroe.lyfjournal.framework.android.http.logger

import com.keyonnamonroe.lyfjournal.framework.android.constants.Constants
import com.keyonnamonroe.lyfjournal.framework.android.logger.Logger
import okhttp3.Interceptor
import okhttp3.Response
import okio.Buffer
import java.io.EOFException
import java.io.IOException
import java.nio.charset.Charset
import java.nio.charset.UnsupportedCharsetException

private const val END_HTTP = "<-- END HTTP"
private const val CANNOT_DECODE_RESPONSE_BODY =
    "Couldn't decode the response body. Charset is likely malformed."

internal class LoggerInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        // request
        val request = chain.request()

        // print url
        Logger.d(TAG_URL, request.url.toString())

        // request body
        val requestBody = request.body
        if (requestBody != null) {
            val buffer = Buffer()
            var charset: Charset? = UTF8

            try {
                requestBody.writeTo(buffer)
                val contentType = requestBody.contentType()
                if (contentType != null) {
                    charset = contentType.charset(UTF8)
                }

                if (isPlainText(buffer) && charset != null) {
                    Logger.d(TAG_REQ, buffer.readString(charset))
                    Logger.d(
                        TAG_REQ, "--> END " + request.method
                                + " (" + requestBody.contentLength() + "-byte body)"
                    )
                } else {
                    Logger.d(
                        TAG_REQ, "--> END " + request.method + " (binary "
                                + requestBody.contentLength() + "-byte body omitted)"
                    )
                }
            } catch (e: IOException) {
                e.printStackTrace()
                Logger.e(Constants.TAG, e.message, e)
            }

        } else {
            // no request body
            Logger.d(TAG_REQ, "Sending request ${request.url} ${chain.connection()}")
            Logger.d(TAG_REQ, "--> END " + request.method)
        }

        // response
        val t1 = System.nanoTime()
        val response: Response
        try {
            response = chain.proceed(request)
        } catch (e: Exception) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
            throw e
        }

        val t2 = System.nanoTime()
        val responseBody = response.body
        val contentLength = responseBody.contentLength()
        Logger.d(
            TAG_RES,
            "<-- ${response.code} ${response.message} ${response.request.url} (${(t2 - t1) / 1e6} ms)"
        )

        // request body
        val source = responseBody.source()
        source.request(java.lang.Long.MAX_VALUE) // Buffer the entire body.
        val buffer = source.buffer

        var charset: Charset? = UTF8
        val contentType = responseBody.contentType()
        if (contentType != null) {
            try {
                charset = contentType.charset(UTF8)
            } catch (e: UnsupportedCharsetException) {
                e.printStackTrace()
                Logger.e(Constants.TAG, e.message, e)
                Logger.d(TAG_RES, CANNOT_DECODE_RESPONSE_BODY)
                Logger.d(TAG_RES, END_HTTP)
                return response
            }

        }
        // print response details
        // return response if not plain text
        if (!isPlainText(buffer)) {
            Logger.d(TAG_RES, "")
            Logger.d(TAG_RES, "<-- END HTTP (binary " + buffer.size + "-byte body omitted)")
            return response
        }
        // print response details
        if (contentLength != 0L && charset != null) {
            Logger.d(TAG_RES, "")
            Logger.d(TAG_RES, buffer.clone().readString(charset))
        }
        Logger.d(TAG_RES, "<-- END HTTP (" + buffer.size + "-byte body)")
        return response
    }

    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     *
     * @param buffer A collection of bytes in memory.
     */
    private fun isPlainText(buffer: Buffer): Boolean {
        try {
            val prefix = Buffer()
            val byteCount = if (buffer.size < 64) buffer.size else 64
            buffer.copyTo(prefix, 0, byteCount)
            for (i in 0..15) {
                if (prefix.exhausted()) {
                    break
                }
                val codePoint = prefix.readUtf8CodePoint()
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false
                }
            }
            return true
        } catch (e: EOFException) {
            e.printStackTrace()
            Logger.e(Constants.TAG, e.message, e)
            return false // Truncated UTF-8 sequence
        }
    }

    companion object {
        private val UTF8 = Charset.forName("UTF-8")
        internal const val TAG_REQ = "req-"
        internal const val TAG_RES = "res-"
        internal const val TAG_URL = "url-"
    }
}