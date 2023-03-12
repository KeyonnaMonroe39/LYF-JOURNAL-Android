package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import java.util.*

/**
 * Serialized model.
 *
 * @property contentOwner String? The ID of the content owner linked to the channel.
 * @property timeLinked Date? The date and time of when the channel was linked to the content owner.
 * The value is specified in ISO 8601 format.
 * @constructor
 */
data class ContentOwnerDetails(
    @SerializedName("contentOwner") var contentOwner: String? = null,
    @SerializedName("timeLinked") var timeLinked: Date? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [ContentOwnerDetails].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = ContentOwnerDetails()
    }
}
