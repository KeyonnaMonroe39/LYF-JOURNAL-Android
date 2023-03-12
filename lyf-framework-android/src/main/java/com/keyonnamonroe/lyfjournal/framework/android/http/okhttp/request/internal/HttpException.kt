package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.request.internal

/**
 * Class to map [HttpException] in [OkHttpRequestExecutor].
 *
 * @property responseBody error string of [HttpException]
 */
data class HttpException(val responseBody: String?) : Exception(responseBody)