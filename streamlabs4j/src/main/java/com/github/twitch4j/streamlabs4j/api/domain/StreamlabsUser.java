package com.github.twitch4j.streamlabs4j.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.github.twitch4j.streamlabs4j.api.annotation.Unofficial;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

/**
 * Streamlabs User
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamlabsUser {

    /**
     * Streamlabs User Information
     */
    private StreamlabsUserInformation streamlabs;

    /**
     * Twitch User Information
     */
    private Optional<TwitchUserInformation> twitch;

    /**
     * YouTube User Information
     */
    private Optional<YoutubeUserInformation> youtube;

    /**
     * Mixer User Information
     */
    private Optional<MixerUserInformation> mixer;

    /**
     * Facebook User Information
     */
    private Optional<FacebookUserInformation> facebook;

    /**
     * Streamlabs information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StreamlabsUserInformation {

        /**
         * Id of the user
         */
        private Long id;

        /**
         * Name displayed on Streamlabs' website
         */
        private String displayName;

        /**
         * Primary platform selected by the user
         */
        @Unofficial
        private String primary;

    }

    /**
     * Twitch information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TwitchUserInformation {

        /**
         * Id of the user
         */
        private Long id;

        /**
         * Name of the user lowercase
         */
        private String name;

        /**
         * Name displayed on Twitch's website
         */
        private String displayName;

    }

    /**
     * YouTube information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class YoutubeUserInformation {

        /**
         * Id of the user
         */
        private String id;

        /**
         * Channel title
         */
        private String title;

    }

    /**
     * Mixer information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MixerUserInformation {

        /**
         * Id of the user
         */
        private Long id;

        /**
         * Name displayed on Mixer's website
         */
        private String name;

    }

    /**
     * Facebook information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FacebookUserInformation {

        /**
         * Id of the user
         */
        private Long id;

        /**
         * Name displayed on Facebook's website
         */
        private String name;

    }

}
