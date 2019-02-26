package com.github.twitch4j.streamlabs4j.api.domain

/** Scopes that can be requested when creating a token */
enum class StreamlabsScopes(private val value: String) {

    DONATIONS_CREATE("donations.create"),
    DONATIONS_READ("donations.read"),
    ALERTS_CREATE("alerts.create"),
    ALERTS_WRITE("alerts.write"),
    LEGACY_TOKEN("legacy.token"),
    SOCKET_TOKEN("socket.token"),
    POINTS_READ("points.read"),
    POINTS_WRITE("points.write"),
    CREDITS_WRITE("credits.write"),
    PROFILES_WRITE("profiles.write"),
    JAR_WRITE("jar.write"),
    WHEEL_WRITE("wheel.write");

    override fun toString() = this.value
}