package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import java.util.*

/**
 * Serialized model.
 *
 * @property relatedPlaylists RelatedPlaylists? The relatedPlaylists object is a map that
 * identifies playlists associated with the channel, such as the channel's uploaded videos or
 * liked videos. You can retrieve any of these playlists using the playlists.list method.
 *
 * @property relatedPlaylists RelatedPlaylists?
 * @property videoId String? The ID that YouTube uses to uniquely identify a video. To retrieve the
 * video resource, set the id query parameter to this value in your API request.
 * @property note String? A user-generated note for this item. The property value has a maximum
 * length of 280 characters.
 * @property videoPublishedAt Date? The date and time that the video was published to YouTube.
 * The value is specified in ISO 8601 format.
 * @constructor
 */
data class ContentDetails(
    @SerializedName("relatedPlaylists") var relatedPlaylists: RelatedPlaylists? = null,
    @SerializedName("videoId") var videoId: String? = null,
    @SerializedName("note") var note: String? = null,
    @SerializedName("videoPublishedAt") var videoPublishedAt: Date? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [ContentDetails].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = ContentDetails()
    }
}
