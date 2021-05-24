package com.github.twitch4j.streamlabs4j;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.twitch4j.streamlabs4j.api.StreamlabsApi;
import com.github.twitch4j.streamlabs4j.api.StreamlabsApiBuilder;
import com.github.twitch4j.streamlabs4j.auth.StreamlabsAuth;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.With;
import lombok.extern.slf4j.Slf4j;

/**
 * Builder to get a StreamlabsClient Instance by provided various options, to provide the user with a lot of customizable options.
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class StreamlabsClientBuilder {

    /**
     * Client ID
     */
    @With
    private String clientId;

    /**
     * Client Secret
     */
    @With
    private String clientSecret;

    /**
     * Redirect Url
     */
    @With
    private String redirectUrl = "http://localhost";

    /**
     * CredentialManager
     */
    @With
    private CredentialManager credentialManager = CredentialManagerBuilder.builder().build();

    /**
     * Initialize the builder
     *
     * @return Streamlabs Client Builder
     */
    public static StreamlabsClientBuilder builder() {
        return new StreamlabsClientBuilder();
    }

    /**
     * Initialize
     *
     * @return {@link StreamlabsClient} initialized class
     */
    public StreamlabsClient build() {
        // Client Id / Client Secret
        if (this.clientId == null || this.clientSecret == null) {
            throw new RuntimeException("You have not provided the required Client-Id/Client-Secret to use the rest api");
        }

        // Module: AUTH
        StreamlabsAuth auth = new StreamlabsAuth(credentialManager, clientId, clientSecret, redirectUrl);

        // Module: API
        StreamlabsApi api = StreamlabsApiBuilder.builder()
            .withClientId(clientId)
            .withClientSecret(clientSecret)
            .build();

        // Client Builder
        final StreamlabsClient client = new StreamlabsClient(auth, api);

        // Return new Client Instance
        return client;
    }

}
