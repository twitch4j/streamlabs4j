package com.github.twitch4j.streamlabs4j.auth;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.domain.IdentityProvider;
import com.github.twitch4j.streamlabs4j.auth.providers.StreamlabsIdentityProvider;

public class StreamlabsAuth {

    /**
     * Credential Manager
     */
    private final CredentialManager credentialManager;

    /**
     * Streamlabs Identity Provider
     *
     * @param credentialManager Credential Manager
     * @param clientId OAuth2 Client Id
     * @param clientSecret OAuth2 Client Secret
     * @param redirectUrl OAuth2 Redirect Url
     */
    public StreamlabsAuth(CredentialManager credentialManager, String clientId, String clientSecret, String redirectUrl) {
        this.credentialManager = credentialManager;

        // register the twitch identityProvider
        IdentityProvider identityProvider = new StreamlabsIdentityProvider(clientId, clientSecret, redirectUrl);
        this.credentialManager.registerIdentityProvider(identityProvider);
    }

}
