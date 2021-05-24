package com.github.twitch4j.streamlabs4j;

import com.github.twitch4j.streamlabs4j.api.StreamlabsApi;
import com.github.twitch4j.streamlabs4j.auth.StreamlabsAuth;

public class StreamlabsClient {

    /**
     * Auth
     */
    private final StreamlabsAuth auth;

    /**
     * API
     */
    private final StreamlabsApi api;

    /**
     * Constructor
     *
     * @param auth         Streamlabs Auth
     * @param api          Streamlabs API
     */
    public StreamlabsClient(StreamlabsAuth auth, StreamlabsApi api) {
        this.auth = auth;
        this.api = api;
    }

    /**
     * Get Auth
     *
     * @return StreamlabsAuth
     */
    public StreamlabsAuth getAuth() {
        if (this.auth == null) {
            throw new RuntimeException("You have not enabled the AUTH Module! Please check out the documentation on Streamlabs4J -> AUTH.");
        }

        return this.auth;
    }

    /**
     * Get Api
     *
     * @return StreamlabsApi
     */
    public StreamlabsApi getApi() {
        if (this.api == null) {
            throw new RuntimeException("You have not enabled the API Module! Please check out the documentation on Streamlabs4J -> API.");
        }

        return this.api;
    }
}
