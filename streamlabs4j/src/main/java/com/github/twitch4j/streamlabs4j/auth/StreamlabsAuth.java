package com.github.twitch4j.streamlabs4j.auth;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.twitch4j.streamlabs4j.auth.providers.StreamlabsIdentityProvider;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamlabsAuth {

    /**
     * Credential Manager
     */
    private final CredentialManager credentialManager;

    /**
     * Identity Provider
     */
    @Getter
    private StreamlabsIdentityProvider identityProvider;

    /**
     * Streamlabs Identity Provider
     *
     * @param credentialManager Credential Manager
     * @param clientId          OAuth2 Client Id
     * @param clientSecret      OAuth2 Client Secret
     * @param redirectUrl       OAuth2 Redirect Url
     */
    public StreamlabsAuth(CredentialManager credentialManager, String clientId, String clientSecret, String redirectUrl) {
        this.credentialManager = credentialManager;

        // log
        log.debug("AUTH: Initializing Module ...");

        // register the twitch identityProvider
        this.identityProvider = new StreamlabsIdentityProvider(clientId, clientSecret, redirectUrl);
        this.credentialManager.registerIdentityProvider(identityProvider);
    }

}
