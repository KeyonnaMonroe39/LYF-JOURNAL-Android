package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal

import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.Response.Success

/**
 * Provide [isEmpty] metadata about the [Success] object.
 */
interface EmptyStateInfo {

    /**
     * Returns `true` if [Response.Success.response] is an empty response object.
     */
    fun isEmpty(): Boolean
}