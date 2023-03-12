package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property likes String? The ID of the playlist that contains the channel's liked videos.
 * Use the playlistItems.insert and playlistItems.delete methods to add or remove items from
 * that list.
 * @property uploads Int? The ID of the playlist that contains the channel's uploaded videos.
 * Use the videos.insert method to upload new videos and the videos.delete method to delete
 * previously uploaded videos.
 * @constructor
 */
data class RelatedPlaylists(
    @SerializedName("likes") var likes: String? = null,
    @SerializedName("uploads") var uploads: Int? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [RelatedPlaylists].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = RelatedPlaylists()
    }
}
