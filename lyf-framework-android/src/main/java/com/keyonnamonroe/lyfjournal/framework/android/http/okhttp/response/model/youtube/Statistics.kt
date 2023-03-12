package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property viewCount Long? The number of times the channel has been viewed.
 * @property subscriberCount Long? The number of subscribers that the channel has. This value is
 * rounded down to three significant figures. Please see the Revision History or the YouTube Help
 * Center for more details about how subscriber counts are rounded.
 * @property hiddenSubscriberCount Boolean? Indicates whether the channel's subscriber count is
 * publicly visible.
 * @property videoCount Long? The number of public videos uploaded to the channel. Note that the
 * value reflects the count of the channel's public videos only, even to owners. This behavior is
 * consistent with counts shown on the YouTube website.
 * @constructor
 */
data class Statistics(
    @SerializedName("viewCount") var viewCount: Long? = null,
    @SerializedName("subscriberCount") var subscriberCount: Long? = null,
    @SerializedName("hiddenSubscriberCount") var hiddenSubscriberCount: Boolean? = null,
    @SerializedName("videoCount") var videoCount: Long? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Statistics].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Statistics()
    }
}
