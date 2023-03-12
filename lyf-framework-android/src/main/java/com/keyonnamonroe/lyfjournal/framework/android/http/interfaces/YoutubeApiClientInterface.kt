package com.keyonnamonroe.lyfjournal.framework.android.http.interfaces

interface YoutubeApiClientInterface {

    /**
     * Returns a collection of zero or more channel resources that match the request criteria.
     *
     * <p>Do not provide a request body when calling this method.</p>
     *
     * Ref- https://developers.google.com/youtube/v3/docs/channels/list
     */
    fun getYoutubeChannelsList()

    /**
     * Returns a collection of playlist items that match the API request parameters. You can
     * retrieve all of the playlist items in a specified playlist or retrieve one or more
     * playlist items by their unique IDs.
     *
     * <p>Do not provide a request body when calling this method.</p>
     *
     * Ref- https://developers.google.com/youtube/v3/docs/playlistItems/list
     */
    fun getYoutubePlaylistItemsList()
}