package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube.Items
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube.PageInfo

/**
 * Data transfer object (DTO) for request. Returns a collection of zero or more channel resources
 * that match the request criteria.
 *
 * <p>Resources
 * -- Channel List: https://developers.google.com/youtube/v3/docs/channels/list
 * -- PlaylistItems List: https://developers.google.com/youtube/v3/docs/playlistItems/list
 *
 * -- Channel List Item: https://developers.google.com/youtube/v3/docs/channels#resource
 * -- PlaylistItems List Item: https://developers.google.com/youtube/v3/docs/playlistItems#resource
 * </p>
 *
 * @property kind String? Identifies the API resource's type. The value will be
 * youtube#channelListResponse.
 * @property etag String? The Etag of this resource.
 * @property nextPageToken String? The token that can be used as the value of the pageToken
 * parameter to retrieve the next page in the result set.
 * @property prevPageToken String? The token that can be used as the value of the pageToken
 * parameter to retrieve the previous page in the result set. Note that this property is not
 * included in the API response if the corresponding API request set the managedByMe parameter
 * to true.
 * @property pageInfo PageInfo? The pageInfo object encapsulates paging information for the result
 * set.
 * @property items List<Items>? A list of channels that match the request criteria.
 * @constructor
 */
data class YoutubeListResponse(
    @SerializedName("kind") val kind: String? = null,
    @SerializedName("etag") val etag: String? = null,
    @SerializedName("nextPageToken") val nextPageToken: String? = null,
    @SerializedName("prevPageToken") val prevPageToken: String? = null,
    @SerializedName("pageInfo") val pageInfo: PageInfo? = null,
    @SerializedName("items") val items: List<Items>? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [YoutubeListResponse].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = YoutubeListResponse()
    }
}
