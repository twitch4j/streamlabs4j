package com.github.twitch4j.streamlabs4j.api.domain

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.databind.PropertyNamingStrategy.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

/** Streamlabs User */
@JsonNaming(SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
data class StreamlabsUser(
    val streamlabs: StreamlabsUserInformation,
    val youtube: YoutubeUserInformation?,
    val twitch: TwitchUserInformation?,
    val mixer: MixerUserInformation?,
    val facebook: FacebookUserInformation?
) {

    /** Streamlabs information */
    @JsonNaming(SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class StreamlabsUserInformation(
        val id: Long,
        val displayName: String
    )

    /** Twitch information */
    @JsonNaming(SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class TwitchUserInformation(
        val id: Long,
        val name: String,
        val displayName: String
    )

    /** YouTube information */
    @JsonNaming(SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class YoutubeUserInformation(val id: Long, val title: String)

    /** Mixer information */
    @JsonNaming(SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class MixerUserInformation(val id: Long, val name: String)

    /** Facebook information */
    @JsonNaming(SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    data class FacebookUserInformation(val id: Long, val name: String)

}
