package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property overallGoodStanding Boolean? This field indicates whether there are any issues with
 * the channel. Currently, this field represents the result of the logical AND operation over the
 * communityGuidelinesGoodStanding, copyrightStrikesGoodStanding, and contentIdClaimsGoodStanding
 * properties, meaning that this property has a value of true if all of those other properties
 * also have a value of true. However, this property will have a value of false if any of those
 * properties has a value of false. Note, however, that the methodology used to set this property's
 * value is subject to change.
 * @property communityGuidelinesGoodStanding Boolean? Indicates whether the channel respects
 * YouTube's community guidelines.
 * @property copyrightStrikesGoodStanding Boolean? Indicates whether the channel has any
 * copyright strikes.
 * @property contentIdClaimsGoodStanding Boolean? Indicates whether the channel has any
 * unresolved claims.
 * @constructor
 */
data class AuditDetails(
    @SerializedName("overallGoodStanding") var overallGoodStanding: Boolean? = null,
    @SerializedName("communityGuidelinesGoodStanding") var communityGuidelinesGoodStanding: Boolean? = null,
    @SerializedName("copyrightStrikesGoodStanding") var copyrightStrikesGoodStanding: Boolean? = null,
    @SerializedName("contentIdClaimsGoodStanding") var contentIdClaimsGoodStanding: Boolean? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [AuditDetails].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = AuditDetails()
    }
}
