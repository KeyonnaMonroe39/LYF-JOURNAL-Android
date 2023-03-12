package com.keyonnamonroe.lyfjournal.framework.android.http.configuration

import com.keyonnamonroe.lyfjournal.framework.android.http.client.BaseApiClient

/**
 * Used to abstract the attributes used in HTTP request in [BaseApiClient].
 */
abstract class BaseClientConfiguration {

    /**
     * Api key is required for performing requests.
     *
     * @property youtubeApiKey Api key required for performing requests.
     */
    abstract var youtubeApiKey: String?

    /**
     * Base url is required for performing requests.
     *
     * <p>The base url is sanitized, so if a base url is set that does not include a protocol,
     * a protocol (https) will automatically be added. If a protocol already exists, no modifications
     * will occur. If you do not include the ending backslash, a backslash will be appended
     * to the end, otherwise no modifications will occur.</p>
     *
     * @property youtubeBaseUrl REQUIRED: Base url will be used to perform requests.
     */
    abstract var youtubeBaseUrl: String?
}