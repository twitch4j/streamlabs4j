package com.github.twitch4j.streamlabs4j.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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

    // Streamlabs User Information
    private StreamlabsUserInformation streamlabs;

    // Twitch User Information
    private Optional<TwitchUserInformation> twitch;

    // Youtube User Information
    private Optional<YoutubeUserInformation> youtube;

    // Mixer User Information
    private Optional<MixerUserInformation> mixer;

    // Facebook User Information
    private Optional<FacebookUserInformation> facebook;

    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StreamlabsUserInformation {

        // UserId
        private Long id;

        // DisplayName
        private String displayName;

    }

    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TwitchUserInformation {

        // UserId
        private Long id;

        // Name
        private String name;

        // DisplayName
        private String displayName;

    }

    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class YoutubeUserInformation {

        // UserId
        private String id;

        // Title
        private String title;

    }

    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MixerUserInformation {

        // UserId
        private Long id;

        // Name
        private String name;

    }

    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FacebookUserInformation {

        // UserId
        private Long id;

        // Name
        private String name;

    }

}
