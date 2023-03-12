package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property kind String? The kind, or type, of the referred resource.
 * @property videoId String? If the snippet.resourceId.kind property's value is youtube#video,
 * then this property will be present and its value will contain the ID that YouTube uses to
 * uniquely identify the video in the playlist.
 * @constructor
 */
data class ResourceId(
    @SerializedName("kind") var kind: String? = null,
    @SerializedName("videoId") var videoId: String? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [ResourceId].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = ResourceId()
    }
}