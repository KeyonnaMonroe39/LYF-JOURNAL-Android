package com.keyonnamonroe.lyfjournal.framework.android.http.configuration

import com.keyonnamonroe.lyfjournal.framework.android.http.client.LyfApiClient
import com.keyonnamonroe.lyfjournal.framework.android.utils.Utils.sanitizeUrl

/**
 * Common configuration properties. This class prevents redundancy of common configuration
 * attributes. A configuration collects information necessary to perform request operations
 * and instantiate the [LyfApiClient].
 */
class CommonClientConfigurationProperties {

    var youtubeApiKey: String? = null

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
    var youtubeBaseUrl: String? = null
        set(value) {
            field = sanitizeUrl(value.orEmpty())
        }
}