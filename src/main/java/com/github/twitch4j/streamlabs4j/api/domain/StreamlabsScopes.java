package com.github.twitch4j.streamlabs4j.api.domain;

public enum StreamlabsScopes {

    /**
     * Scopes
     */
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

    /**
     * Scope Text
     */
    private final String name;

    /**
     * Constructor
     *
     * @param name string value
     */
    private StreamlabsScopes(String name) {
        this.name = name;
    }

    /**
     * Custom ToString
     *
     * @return string
     */
    public String toString() {
        return this.name;
    }
}
