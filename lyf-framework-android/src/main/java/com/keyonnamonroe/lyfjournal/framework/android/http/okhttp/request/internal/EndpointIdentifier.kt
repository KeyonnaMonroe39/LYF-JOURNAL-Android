package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.request.internal

/**
 * Enumeration to add request identifier to [Response.Success] and [Response.Failure]
 * @param requestName Request name intended to be used as identifier at [Response.Success] and
 * [Response.Failure]
 */
internal enum class EndpointIdentifier constructor(private val requestName: String) {
    YOUTUBE("Youtube"),
    LINKEDIN("Linkedin");

    override fun toString(): String {
        return requestName
    }
}