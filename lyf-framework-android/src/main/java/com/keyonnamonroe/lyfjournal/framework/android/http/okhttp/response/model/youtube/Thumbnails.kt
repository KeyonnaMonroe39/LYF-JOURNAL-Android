package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property default ImageDetails? The default thumbnail image. The default thumbnail for a
 * video – or a resource that refers to a video, such as a playlist item or search
 * result – is 120px wide and 90px tall. The default thumbnail for a channel is 88px wide
 * and 88px tall.
 * @property medium ImageDetails? A higher resolution version of the thumbnail image. For a video
 * (or a resource that refers to a video), this image is 320px wide and 180px tall. For a channel,
 * this image is 240px wide and 240px tall.
 * @property high ImageDetails? A high resolution version of the thumbnail image. For a video
 * (or a resource that refers to a video), this image is 480px wide and 360px tall. For a channel,
 * this image is 800px wide and 800px tall.
 * @property standard ImageDetails? A high resolution version of the thumbnail image.
 * @property maxres ImageDetails? A high resolution version of the thumbnail image.
 * @constructor
 */
data class Thumbnails(
    @SerializedName("default") var default: ImageDetails? = null,
    @SerializedName("medium") var medium: ImageDetails? = null,
    @SerializedName("high") var high: ImageDetails? = null,
    @SerializedName("standard") var standard: ImageDetails? = null,
    @SerializedName("maxres") var maxres: ImageDetails? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Thumbnails].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Thumbnails()
    }
}