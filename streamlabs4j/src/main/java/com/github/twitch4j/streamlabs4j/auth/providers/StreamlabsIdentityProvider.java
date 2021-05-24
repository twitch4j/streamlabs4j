package com.github.twitch4j.streamlabs4j.auth.providers;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.credentialmanager.identityprovider.OAuth2IdentityProvider;

import java.util.Optional;

/**
 * Streamlabs Identity Provider
 */
public class StreamlabsIdentityProvider extends OAuth2IdentityProvider {

    /**
     * Constructor
     *
     * @param clientId     OAuth Client Id
     * @param clientSecret OAuth Client Secret
     * @param redirectUrl  Redirect Url
     */
    public StreamlabsIdentityProvider(String clientId, String clientSecret, String redirectUrl) {
        super("streamlabs", "oauth2", clientId, clientSecret, "https://streamlabs.com/api/v1.0/authorize", "https://streamlabs.com/api/v1.0/token", redirectUrl);

        // overwrite scope separator
        this.scopeSeperator = "+";
        this.tokenEndpointPostType = "BODY";
    }

    /**
     * Get Auth Token Information
     *
     * @param credential OAuth2 Credential
     */
    public Optional<OAuth2Credential> getAdditionalCredentialInformation(OAuth2Credential credential) {
        return Optional.ofNullable(credential);
    }

}
