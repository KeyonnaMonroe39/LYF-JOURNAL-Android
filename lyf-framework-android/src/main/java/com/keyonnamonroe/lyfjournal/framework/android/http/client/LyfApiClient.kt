package com.keyonnamonroe.lyfjournal.framework.android.http.client

import android.content.Context
import com.keyonnamonroe.lyfjournal.framework.android.http.configuration.ClientConfiguration
import com.keyonnamonroe.lyfjournal.framework.android.http.interfaces.ApiClientInterface
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.request.internal.HttpMethod
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.request.internal.HttpRequest
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.request.internal.RequestPayload

/**
 * Used to access Youtube and Linkedin APIs.
 *
 * @property context Context Context Interface to global information about an application environment.
 * @property clientConfiguration ClientConfiguration Contains necessary configuration data for
 * forming requests.
 * @constructor
 */
open class LyfApiClient(
    private val context: Context,
    private var clientConfiguration: ClientConfiguration
) : BaseApiClient<ClientConfiguration>(clientConfiguration), ApiClientInterface {

    /**
     * Returns [ClientConfiguration] information used by the [LyfApiClient].
     * @return [ClientConfiguration]
     */
    override fun getClientConfiguration(): ClientConfiguration {
        return this.clientConfiguration
    }

    /**
     * Update client configuration.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @param clientConfiguration ClientConfiguration REQUIRED: Configuration that collects
     * information necessary to perform request operations.
     */
    override fun updateClientConfiguration(
        clientConfiguration: ClientConfiguration
    ) {
        // update client configuration
        this.clientConfiguration = clientConfiguration
        super.configuration = clientConfiguration
    }

    /**
     * Update client configuration with new [apiKey] information.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @property apiKey REQUIRED: Api key required for performing requests.
     */
    override fun updateYoutubeApiKey(
        apiKey: String?
    ) {
        // update client configuration
        this.clientConfiguration.youtubeApiKey = apiKey
        super.configuration = clientConfiguration
    }

    /**
     * Update client configuration with new [baseUrl] information.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @param baseUrl String? REQUIRED: Base url to perform necessary requests.
     */
    override fun updateYoutubeBaseUrl(
        baseUrl: String?
    ) {
        // update client configuration
        this.clientConfiguration.youtubeBaseUrl = baseUrl
        super.configuration = clientConfiguration
    }

    /**
     * Returns a collection of zero or more channel resources that match the request criteria.
     *
     * <p>Do not provide a request body when calling this method.</p>
     *
     * Ref- https://developers.google.com/youtube/v3/docs/channels/list
     */
    override fun getYoutubeChannelsList() {
        // compose HTTP request
        val httpRequest = HttpRequest(
            url = clientConfiguration.youtubeChannelsListUrl,
            httpMethod = HttpMethod.GET,
            requestPayload = RequestPayload.EmptyRequestPayload
        )
    }

    /**
     * Returns a collection of playlist items that match the API request parameters. You can
     * retrieve all of the playlist items in a specified playlist or retrieve one or more
     * playlist items by their unique IDs.
     *
     * <p>Do not provide a request body when calling this method.</p>
     *
     * Ref- https://developers.google.com/youtube/v3/docs/playlistItems/list
     */
    override fun getYoutubePlaylistItemsList() {
        // compose HTTP request
        val httpRequest = HttpRequest(
            url = clientConfiguration.youtubePlaylistItemsListUrl,
            httpMethod = HttpMethod.GET,
            requestPayload = RequestPayload.EmptyRequestPayload
        )
    }

}