package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.Status.Companion.EMPTY

/**
 * Serialized model.
 *
 * @property totalResults Int? The total number of results in the result set.
 * @property resultsPerPage Int? The number of results included in the API response.
 * @constructor
 */
data class PageInfo(
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("resultsPerPage") var resultsPerPage: Int? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [PageInfo].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = PageInfo()
    }
}