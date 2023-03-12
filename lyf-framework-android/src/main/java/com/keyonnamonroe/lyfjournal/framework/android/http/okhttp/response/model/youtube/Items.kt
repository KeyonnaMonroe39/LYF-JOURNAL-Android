package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.Status.Companion.EMPTY

/**
 * Serialized model.
 *
 * @property kind String? Identifies the API resource's type. The value will be
 * youtube#channelListResponse.
 * @property etag String? The Etag of this resource.
 * @property id String? The ID that YouTube uses to uniquely identify the channel.
 * @property snippet Snippet? The snippet object contains basic details about the channel, such as
 * its title, description, and thumbnail images.
 * @property contentDetails ContentDetails? The contentDetails object encapsulates information
 * about the channel's content.
 * @property statistics Statistics? The statistics object encapsulates statistics for the channel.
 * @property topicDetails TopicDetails? The topicDetails object encapsulates information about
 * topics associated with the channel.
 * @property status Status? The status object encapsulates information about the privacy status of
 * the channel.
 * @property brandingSettings BrandingSettings? The brandingSettings object encapsulates information
 * about the branding of the channel.
 * @property auditDetails AuditDetails? The auditDetails object encapsulates channel data that a
 * multichannel network (MCN) would evaluate while determining whether to accept or reject a
 * particular channel. Note that any API request that retrieves this resource part must provid an
 * authorization token that contains the https://www.googleapis.com/auth/youtubepartner-channel-audit
 * scope. In addition, any token that uses that scope must be revoked when the MCN decides to accept
 * or reject the channel or within two weeks of the date that the token was issued.
 * @property contentOwnerDetails ContentOwnerDetails? The contentOwnerDetails object encapsulates
 * channel data that is relevant for YouTube Partners linked with the channel.
 * @property localizations The language of the localized metadata associated with the key value.
 * @constructor
 */
data class Items(
    @SerializedName("kind") var kind: String? = null,
    @SerializedName("etag") var etag: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("snippet") var snippet: Snippet? = null,
    @SerializedName("contentDetails") var contentDetails: ContentDetails? = null,
    @SerializedName("statistics") var statistics: Statistics? = null,
    @SerializedName("topicDetails") var topicDetails: TopicDetails? = null,
    @SerializedName("status") var status: Status? = null,
    @SerializedName("brandingSettings") var brandingSettings: BrandingSettings? = null,
    @SerializedName("auditDetails") var auditDetails: AuditDetails? = null,
    @SerializedName("contentOwnerDetails") var contentOwnerDetails: ContentOwnerDetails? = null,
    @SerializedName("localizations") var localizations: Localized? = null,
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Items].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Items()
    }
}