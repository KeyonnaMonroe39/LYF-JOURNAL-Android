package com.keyonnamonroe.lyfjournal.framework.android.constants

import com.keyonnamonroe.lyfjournal.framework.android.BuildConfig

/**
 * General constants.
 */
object Constants {
    const val TAG = "LFY_Framework"

    // debuggable mode; true to see debug logs otherwise false
    const val DEBUG = BuildConfig.DEBUG_MODE

    /**
     * Official LYF4Kids YouTube channel used for all LYF video references.
     */
    const val OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL = "https://www.youtube.com/@Lyf4kids"

    /**
     * Video destination aliases for site/app copy that points to LYF4Kids video content.
     */
    object VideoDestinations {
        const val YOUTUBE_SEL_VIDEOS = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val ROOTS_OF_LYF_VIDEO_CONTENT = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val LYF4KIDS_VIDEO_LIBRARY = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val ANIMATED_LYF_TIPS = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val WATCH_ON_YOUTUBE = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val FAMILY_VIDEO_ACTIVITIES = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
        const val CLASSROOM_VIDEO_PROMPTS = OFFICIAL_LYF4KIDS_YOUTUBE_CHANNEL_URL
    }
}
