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
 * Partial search of username
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamlabsPartialUserPoints {

    /**
     * Total of results
     */
    private int total;

    /**
     * Amount of results per page
     */
    private int perPage;

    /**
     * Current page
     */
    private int currentPage;

    /**
     * Last page
     */
    private int lastPage;

    /**
     * Position of the page's first element
     */
    private int from;

    /**
     * Position of the page's last element
     */
    private int to;

    /**
     * Results of the search
     */
    private List<UserPoints> data;

    /**
     * User points and time watched
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class UserPoints {

        /**
         * Name of the user lowercase
         */
        private String username;

        /**
         * Time spent watching (in seconds)
         */
        private int timeWatched;

        /**
         * Loyalty points
         */
        private int points;

    }

}
