package com.github.twitch4j.streamlabs4j.api.interceptors;

import com.github.twitch4j.streamlabs4j.api.StreamlabsApiBuilder;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * Injects ClientId Header, the User Agent and other common headers into each API Request
 */
public class CommonHeaderInterceptor implements RequestInterceptor {

    /**
     * Reference to the Client Builder
     */
    private final StreamlabsApiBuilder streamlabsApiBuilder;

    /**
     * Constructor
     *
     * @param streamlabsApiBuilder Twitch Client Builder
     */
    public CommonHeaderInterceptor(StreamlabsApiBuilder streamlabsApiBuilder) {
        this.streamlabsApiBuilder = streamlabsApiBuilder;
    }

    /**
     * Client Auth Header Interceptor
     *
     * @param template Feign RequestTemplate
     */
    @Override
    public void apply(RequestTemplate template) {
        template.header("Client-Id", streamlabsApiBuilder.getClientId());
        template.header("User-Agent", streamlabsApiBuilder.getUserAgent());
    }
}
