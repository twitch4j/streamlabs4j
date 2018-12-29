package com.github.twitch4j.streamlabs4j.api;

import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsDonationsData;
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StreamlabsApiTest {

    private StreamlabsApi api = StreamlabsApiBuilder.builder()
        .withClientId(System.getenv("STREAMLABS_CLIENT_ID"))
        .withClientSecret(System.getenv("STREAMLABS_CLIENT_SECRET"))
        .build();

    private String authToken = System.getenv("STREAMLABS_AUTH_TOKEN");

    @Test
    public void getUserTests() {

        StreamlabsUser user = api.getUser(authToken).execute();

        assertEquals("YaourtGG", user.getStreamlabs().getDisplayName());
        assertEquals((long) 610660, (long) user.getStreamlabs().getId());

        assertTrue(user.getTwitch().isPresent());

        assertEquals((long) 31524709, (long) user.getTwitch().get().getId());
        assertEquals("YaourtGG", user.getTwitch().get().getDisplayName());
        assertEquals("yaourtgg", user.getTwitch().get().getName());
    }

    @Test
    public void getDonationsTest() {
        StreamlabsDonationsData donations = api.getDonations(authToken, 100, "", "", "", "").execute();

        assertNotEquals(0, donations.getDonations().size());

        assertTrue(donations.getDonations()
            .stream()
            .anyMatch(donation -> donation.getName().equals("yaourtgg")),
            "yaourtgg has donated at least once");

        assertTrue(donations.getDonations()
            .stream()
            .anyMatch(donation -> donation.getName().equals("Hexafice")),
            "Hexafice has donated at least once");

        assertTrue(donations.getDonations()
            .stream()
            .anyMatch(donation -> donation.getCurrency().equals("EUR")),
            "At least one donation in EUR");

        assertTrue(donations.getDonations()
            .stream()
            .anyMatch(donation -> donation.getMessage().isPresent()),
            "One of the donations has a message");

        assertTrue(donations.getDonations()
            .stream()
            .anyMatch(donation -> donation.getMessage().equals(Optional.empty())),
            "One of the donations doesn't have a message");
    }

}
