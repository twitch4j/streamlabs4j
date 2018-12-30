package com.github.twitch4j.streamlabs4j.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Alert profiles
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamlabsAlertProfiles {

    /**
     * Profiles
     */
    private List<StreamlabsProfile> profiles;

    /**
     * Id of the current active profile
     */
    private int activeProfile;

    /**
     * Profile information
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StreamlabsProfile {

        /**
         * Profile id
         */
        private int id;

        /**
         * Profile name
         */
        private String name;

        /**
         * Profile description
         */
        private String description;

    }

}
