package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.Status

/**
 * Data transfer object for all responses that returns only a [Status] and no data.
 *
 * @property status Status? Indicate whether a specific HTTP request has been successfully
 * completed.
 * @constructor
 */
data class EmptyResponse(
    @SerializedName("status") var status: Status? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [EmptyResponse].
         *
         * If the API were to respond back with a successful response but with an empty body,
         * clients will get back an [EMPTY] instance for [EmptyResponse].
         */
        val EMPTY = EmptyResponse()
    }
}