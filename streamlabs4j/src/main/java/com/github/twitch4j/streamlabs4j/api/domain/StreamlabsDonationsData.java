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

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Donations holder
 */
@Data
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StreamlabsDonationsData {

    /**
     * List of donations
     */
    @JsonProperty("data")
    private List<StreamlabsDonation> donations;

    /**
     * Streamlabs Donation
     */
    @Data
    @Setter(AccessLevel.PRIVATE)
    @NoArgsConstructor
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class StreamlabsDonation {

        /**
         * Id of the donation
         */
        @JsonProperty("donation_id")
        private String id;

        /**
         * Date of creation
         */
        @JsonIgnore
        private Date creationDate;

        @JsonProperty("created_at")
        private void convertEpoch(String epoch) {
            creationDate = new Date(Long.parseLong(epoch));
        }

        /**
         * Currency used
         */
        private String currency;

        /**
         * Amount
         */
        private double amount;

        /**
         * Donor's name
         */
        private String name;

        /**
         * Message
         */
        private Optional<String> message;

    }

}
