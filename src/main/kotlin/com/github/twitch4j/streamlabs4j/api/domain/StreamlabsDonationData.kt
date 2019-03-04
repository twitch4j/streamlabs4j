package com.github.twitch4j.streamlabs4j.api.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.util.*

/** Donations holder */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
@JsonIgnoreProperties(ignoreUnknown = true)
class StreamlabsDonationsData {

    /** List of donations */
    val data: List<StreamlabsDonation> = listOf()

    /** Streamlabs Donation */
    @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    @JsonIgnoreProperties(ignoreUnknown = true)
    class StreamlabsDonation {

        /** Id of the donation */
        @JsonProperty("donation_id")
        val id: String = ""

        /** Date of creation */
        @JsonIgnore
        private var creationDate: Date = Date()

        /** Currency used */
        val currency: String = ""

        /** Amount */
        val amount: Double = 0.toDouble()

        /** Donor's name */
        val name: String = ""

        /** Message */
        val message: String? = null

        @JsonProperty("created_at")
        private fun convertEpoch(epoch: String) {
            creationDate = Date(java.lang.Long.parseLong(epoch))
        }

    }

}
