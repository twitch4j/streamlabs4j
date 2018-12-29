package com.github.twitch4j.streamlabs4j.api;

import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
}
