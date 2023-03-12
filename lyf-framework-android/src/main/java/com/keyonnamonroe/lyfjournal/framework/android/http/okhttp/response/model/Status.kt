package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property statusCode Int? Indicate whether a specific HTTP request has been successfully
 * completed.
 * @property statusMessage String? Message from server regarding the request.
 * @constructor
 */
data class Status(
    @SerializedName("status_code") var statusCode: Int? = null,
    @SerializedName("status_message") var statusMessage: String? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Status].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Status()
    }
}