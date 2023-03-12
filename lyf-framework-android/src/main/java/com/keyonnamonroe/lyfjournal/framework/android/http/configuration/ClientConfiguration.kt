package com.keyonnamonroe.lyfjournal.framework.android.http.configuration

// exceptions
internal const val ILLEGAL_ARGUMENT_EXCEPTION_API_KEY =
    "Failed to read ApiKey. This field can not be empty."
internal const val ILLEGAL_ARGUMENT_EXCEPTION_BASE_URL =
    "Failed to read `baseUrl`. This field can not be empty."

/**
 * Mikros Analytics initialization meta data/settings.
 *
 * @property commonConfiguration [CommonClientConfigurationProperties] Common configuration properties.
 * @property youtubeBaseUrl String? Base url will be used to perform requests.
 * @constructor
 */
data class ClientConfiguration(
    private val commonConfiguration: CommonClientConfigurationProperties?
) : BaseClientConfiguration() {

    /**
     * Api key is required for performing requests.
     *
     * @property youtubeApiKey Api key required for performing requests.
     */
    override var youtubeApiKey: String?
        get() = commonConfiguration?.youtubeApiKey
        set(value) {
            commonConfiguration?.youtubeApiKey = value
        }

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
    override var youtubeBaseUrl: String?
        get() = commonConfiguration?.youtubeBaseUrl
        set(value) {
            commonConfiguration?.youtubeBaseUrl = value
        }


    // build encapsulated urls
    internal val youtubeChannelsListUrl = "$youtubeBaseUrl$PATH_CHANNELS_LIST"
    internal val youtubePlaylistItemsListUrl = "$youtubeBaseUrl$PATH_PLAYLIST_ITEMS_LIST"

    companion object {
        // encapsulated url paths
        private const val PATH_CHANNELS_LIST = "channels"
        private const val PATH_PLAYLIST_ITEMS_LIST = "playlistItems"
    }

    /**
     * Builder pattern is a creational design pattern. It means it solves problems
     * related to object creation.
     *
     * <p>Builder pattern is used to create instance of very complex object having telescoping
     * constructor in easiest way.</p>
     *
     * @property youtubeApiKey String? REQUIRED: Api key required for performing requests.
     * @property youtubeBaseUrl String? REQUIRED: Base url to perform necessary requests.
     * @constructor
     */
    data class Builder(
        private var youtubeApiKey: String? = null,
        private var youtubeBaseUrl: String? = null
    ) {

        /**
         * Setter for Api key for performing requests.
         *
         * @param apiKey REQUIRED: Api key required for performing requests.
         * @return [ClientConfiguration.Builder]
         */
        fun setYouTubeApiKey(apiKey: String?) = apply {
            youtubeApiKey = apiKey
        }

        /**
         * Setter for setting base url.
         *
         * NOTE: You do not need to provide the full url. Only the base url is necessary.
         *
         * @param baseUrl REQUIRED: Base url to perform necessary requests.
         * @return [ClientConfiguration.Builder]
         */
        fun setYoutubeBaseUrl(baseUrl: String?) = apply {
            youtubeBaseUrl = baseUrl
        }

        /**
         * Create the [ClientConfiguration] object.
         * Will throw [IllegalArgumentException] if required attributes aren't set.
         * REQUIRED: [youtubeBaseUrl]
         *
         * @return [ClientConfiguration]
         * @throws [IllegalArgumentException]
         */
        @Throws(IllegalArgumentException::class)
        fun create(): ClientConfiguration {
            when {
                youtubeApiKey.isNullOrEmpty() -> throw IllegalArgumentException(
                    ILLEGAL_ARGUMENT_EXCEPTION_API_KEY
                )
                youtubeBaseUrl.isNullOrEmpty() -> throw IllegalArgumentException(
                    ILLEGAL_ARGUMENT_EXCEPTION_BASE_URL
                )
                else -> {
                    val commonConfiguration = CommonClientConfigurationProperties()
                    commonConfiguration.youtubeApiKey = youtubeApiKey
                    commonConfiguration.youtubeBaseUrl = youtubeBaseUrl
                    return ClientConfiguration(
                        commonConfiguration = commonConfiguration
                    )
                }
            }
        }
    }
}