package com.github.twitch4j.streamlabs4j.api

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StreamlabsApiTest {

    private val api = StreamlabsApi(
        System.getenv("STREAMLABS_CLIENT_ID"),
        System.getenv("STREAMLABS_CLIENT_SECRET")
    )

    private val authToken = System.getenv("STREAMLABS_AUTH_TOKEN")

    @Test
    fun getUser() {
        val user = api.getUser(authToken).execute()

        assertEquals("YaourtGG", user.streamlabs.displayName)
        assertEquals(610660.toLong(), user.streamlabs.id)

        assertTrue(user.twitch != null)

        assertEquals(31524709, user.twitch?.id)
        assertEquals("YaourtGG", user.twitch?.displayName)
        assertEquals("yaourtgg", user.twitch?.name)
    }
}
