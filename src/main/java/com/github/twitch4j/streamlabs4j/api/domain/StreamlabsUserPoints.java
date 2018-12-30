package com.github.twitch4j.streamlabs4j.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

/**
 * Streamlabs user points
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamlabsUserPoints {

    /**
     * Id of the user
     */
    private String id;

    /**
     * Streaming platform
     */
    private String platform;

    /**
     * Channel name
     */
    private String channel;

    /**
     * Username (not the one from the channel)
     */
    private String username;

    /**
     * Experience points of the user
     */
    @JsonProperty("exp")
    private int experience;

    /**
     * Loyalty points
     */
    private int points;

    /**
     * Unknown id (will document it later)
     */
    @JsonProperty("ta_id")
    private Optional<String> taId;

    /**
     *
     */
    private String status;

    private int timeWatched;

    /**
     * Date of creation
     */
    @JsonIgnore
    private Optional<Date> creationDate;

    @JsonProperty("created_at")
    private void convertEpoch(String epoch) {
        if (epoch != null) {
            creationDate = Optional.of(new Date(Long.parseLong(epoch)));
        }
    }

    /**
     * Date of update
     */
    @JsonIgnore
    private Date updateDate;

    @JsonProperty("updated_at")
    private void convertDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            updateDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
