package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property title String? The channel's title. The title has a maximum length of 30 characters.
 * @property description String? The channel description, which appears in the channel information
 * box on your channel page. The property's value has a maximum length of 1000 characters.
 * @property keywords String? Keywords associated with your channel. The value is a space-separated
 * list of strings. Channel keywords might be truncated if they exceed the maximum allowed length
 * of 500 characters or if they contained unescaped quotation marks ("). Note that the 500 character
 * limit is not a per-keyword limit but rather a limit on the total length of all keywords.
 * @property trackingAnalyticsAccountId String? The ID for a Google Analytics account that you
 * want to use to track and measure traffic to your channel.
 * @property moderateComments Boolean? This setting determines whether user-submitted comments
 * left on the channel page need to be approved by the channel owner to be publicly visible.
 * The default value is false.
 * @property unsubscribedTrailer String? The video that should play in the featured video module in
 * the channel page's browse view for unsubscribed viewers. Subscribed viewers may see a different
 * video that highlights more recent channel activity.
 *
 * <p>If specified, the property's value must be the YouTube video ID of a public or unlisted video
 * that is owned by the channel owner.</p>
 * @property defaultLanguage String? The language of the text in the channel resource's
 * snippet.title and snippet.description properties.
 * @property country String? The country with which the channel is associated. Update this property
 * to set the value of the snippet.country property.
 * @constructor
 */
data class Channel(
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("keywords") var keywords: String? = null,
    @SerializedName("trackingAnalyticsAccountId") var trackingAnalyticsAccountId: String? = null,
    @SerializedName("moderateComments") var moderateComments: Boolean? = null,
    @SerializedName("unsubscribedTrailer") var unsubscribedTrailer: String? = null,
    @SerializedName("defaultLanguage") var defaultLanguage: String? = null,
    @SerializedName("country") var country: String? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Channel].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Channel()
    }
}
