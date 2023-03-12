package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.Status.Companion.EMPTY
import java.util.*

/**
 * Serialized model.
 *
 * @property title String? The channel's title.
 * @property description String? The channel's description. The property's value has a maximum
 * length of 1000 characters.
 * @property customUrl String? The channel's custom URL. The YouTube Help Center explains
 * eligibility requirements for getting a custom URL as well as how to set up the URL.
 * @property publishedAt Date? The date and time that the channel was created. The value is
 * specified in ISO 8601 format.
 * @property thumbnails Thumbnails? A map of thumbnail images associated with the channel. For each
 * object in the map, the key is the name of the thumbnail image, and the value is an object that
 * contains other information about the thumbnail.
 *
 * <p>When displaying thumbnails in your application, make sure that your code uses the image URLs
 * exactly as they are returned in API responses. For example, your application should not use the
 * http domain instead of the https domain in a URL returned in an API response.</p>
 * @property defaultLanguage String? The language of the text in the channel resource's
 * snippet.title and snippet.description properties.
 * @property localized Localized? The snippet.localized object contains a localized title and
 * description for the channel or it contains the channel's title and description in the default
 * language for the channel's metadata.
 * @property country String? The country with which the channel is associated. To set this
 * property's value, update the value of the brandingSettings.channel.country property.
 * @property channelId String? The ID that YouTube uses to uniquely identify the user that added
 * the item to the playlist.
 * @property channelTitle String? The channel title of the channel that the playlist item belongs
 * to.
 * @property playlistId String? The ID that YouTube uses to uniquely identify the playlist that
 * the playlist item is in.
 * @property position Int? The order in which the item appears in the playlist. The value uses a
 * zero-based index, so the first item has a position of 0, the second item has a position of 1,
 * and so forth.
 * @property resourceId ResourceId? The id object contains information that can be used to uniquely
 * identify the resource that is included in the playlist as the playlist item.
 * @property videoOwnerChannelTitle String? The channel title of the channel that uploaded this
 * video.
 * @property videoOwnerChannelId String? The channel ID of the channel that uploaded this video.
 * @constructor
 */
data class Snippet(
    // channels
    @SerializedName("title") var title: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("customUrl") var customUrl: String? = null,
    @SerializedName("publishedAt") var publishedAt: Date? = null,
    @SerializedName("thumbnails") var thumbnails: Thumbnails? = null,
    @SerializedName("defaultLanguage") var defaultLanguage: String? = null,
    @SerializedName("localized") var localized: Localized? = null,
    @SerializedName("country") var country: String? = null,
    // playlist items
    @SerializedName("channelId") var channelId: String? = null,
    @SerializedName("channelTitle") var channelTitle: String? = null,
    @SerializedName("playlistId") var playlistId: String? = null,
    @SerializedName("position") var position: Int? = null,
    @SerializedName("resourceId") var resourceId: ResourceId? = null,
    @SerializedName("videoOwnerChannelTitle") var videoOwnerChannelTitle: String? = null,
    @SerializedName("videoOwnerChannelId") var videoOwnerChannelId: String? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Snippet].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Snippet()
    }
}