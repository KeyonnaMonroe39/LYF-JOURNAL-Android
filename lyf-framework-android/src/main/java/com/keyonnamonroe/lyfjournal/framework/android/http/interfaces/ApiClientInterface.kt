package com.keyonnamonroe.lyfjournal.framework.android.http.interfaces

import com.keyonnamonroe.lyfjournal.framework.android.http.client.LyfApiClient
import com.keyonnamonroe.lyfjournal.framework.android.http.configuration.ClientConfiguration

interface ApiClientInterface : YoutubeApiClientInterface {

    /**
     * Returns [ClientConfiguration] information used by the [LyfApiClient].
     * @return [ClientConfiguration]
     */
    fun getClientConfiguration(): ClientConfiguration

    /**
     * Update client configuration.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @param clientConfiguration ClientConfiguration REQUIRED: Configuration that collects
     * information necessary to perform request operations.
     */
    fun updateClientConfiguration(clientConfiguration: ClientConfiguration)

    /**
     * Update client configuration with new [apiKey] information.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @property apiKey REQUIRED: Api key required for performing requests.
     */
    fun updateYoutubeApiKey(apiKey: String?)

    /**
     * Update client configuration with new [baseUrl] information.
     *
     * The updated changes only apply if [LyfApiClient] is initialized.
     *
     * @param baseUrl String? REQUIRED: Base url to perform necessary requests.
     */
    fun updateYoutubeBaseUrl(baseUrl: String?)
}
