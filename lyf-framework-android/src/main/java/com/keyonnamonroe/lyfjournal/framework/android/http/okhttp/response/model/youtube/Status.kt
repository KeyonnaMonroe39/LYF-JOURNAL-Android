package com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.model.youtube

import com.google.gson.annotations.SerializedName
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.YoutubeListResponse.Companion.EMPTY
import com.keyonnamonroe.lyfjournal.framework.android.http.okhttp.response.internal.EmptyStateInfo

/**
 * Serialized model.
 *
 * @property privacyStatus String? Privacy status of the channel.
 *
 * <p>Valid values for this property are:
 * -- private
 * -- public
 * -- unlisted</p>
 * @property isLinked Boolean? Indicates whether the channel data identifies a user that is
 * already linked to either a YouTube username or a Google+ account. A user that has one of these
 * links already has a public YouTube identity, which is a prerequisite for several actions, such
 * as uploading videos.
 * @property longUploadsStatus String? Indicates whether the channel is eligible to upload videos
 * that are more than 15 minutes long. This property is only returned if the channel owner
 * authorized the API request.
 *
 * <p>Valid values for this property are:
 * -- allowed: This channel can upload videos that are more than 15 minutes long.
 * -- disallowed: This channel is not able or eligible to upload videos that are more than 15
 * minutes long. A channel is only eligible to upload long videos if it is in good standing based
 * on YouTube Community Guidelines and it does not have any worldwide Content ID blocks on its
 * content.
 * -- eligible: This channel is eligible to upload videos that are more than 15 minutes long.
 * However, the channel owner must first enable the ability to upload longer videos at
 * https://www.youtube.com/verify.</p>
 * @property madeForKids Boolean? This value indicates whether the channel is designated as
 * child-directed, and it contains the current "made for kids" status of the channel. For example,
 * the status might be determined based on the value of the selfDeclaredMadeForKids property.
 * @property selfDeclaredMadeForKids Boolean? In a channels.update request, this property allows
 * the channel owner to designate the channel as child-directed. The property value is only
 * returned if the channel owner authorized the API request.
 * @constructor
 */
data class Status(
    @SerializedName("privacyStatus") var privacyStatus: String? = null,
    @SerializedName("isLinked") var isLinked: Boolean? = null,
    @SerializedName("longUploadsStatus") var longUploadsStatus: String? = null,
    @SerializedName("madeForKids") var madeForKids: Boolean? = null,
    @SerializedName("selfDeclaredMadeForKids") var selfDeclaredMadeForKids: Boolean? = null
) : EmptyStateInfo {

    override fun isEmpty(): Boolean = this == EMPTY

    companion object {

        /**
         * An empty object instance for [Status].
         *
         * If the API responds with a successful response that has an empty body, you can reference
         * this [EMPTY] instance.
         */
        val EMPTY = Status()
    }
}
