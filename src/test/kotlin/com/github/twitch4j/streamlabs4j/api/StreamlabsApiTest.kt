package com.github.twitch4j.streamlabs4j.api

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
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

    @Test
    fun getDonationsTest() {
        val donations =
            api.getDonations(authToken, 100, null, null, null, null).execute()

        assertNotEquals(0, donations.data.size)

        assertTrue(
            donations.data.any { it.name == "yaourtgg" },
            "yaourtgg has donated at least once"
        )

        assertTrue(
            donations.data.any { it.name == "Hexafice" },
            "Hexafice has donated at least once"
        )

        assertTrue(
            donations.data.any { it.currency == "EUR" },
            "At least one donation in EUR"
        )

        assertTrue(
            donations.data.any { it.message != null },
            "One of the donations has a message"
        )

        assertTrue(
            donations.data.any { it.message == null },
            "One of the donations doesn't have a message"
        )
    }

    @Test
    fun createDonationTest() {
        val donation = api.createDonation(
            "test", null, "test", 10.0,
            "eur", null, authToken, null
        ).execute()

        assertNotEquals("", donation.donationId, "the returned code must not be empty")
    }

    @Test
    fun createAndGetDonation() {
        val id = api.createDonation(
            "creationTest", "some message", "test", 10.0,
            "eur", null, authToken, null
        ).execute().donationId

        val donations = api.getDonations(authToken, null, null, null, "eur", null).execute()

        assertTrue(donations.data.any { it.id == id }, "the previously created donation should be found")
    }
}
