package com.github.twitch4j.streamlabs4j.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.github.philippheuer.events4j.EventManager;
import com.github.twitch4j.streamlabs4j.api.interceptors.CommonHeaderInterceptor;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Logger;
import feign.Retryer;
import feign.hystrix.HystrixFeign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;
import lombok.extern.slf4j.Slf4j;

/**
 * Streamlabs API
 * <p>
 * Documentation: https://dev.streamlabs.com/reference
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class StreamlabsApiBuilder {

    /**
     * Event Manager
     */
    @Wither
    private EventManager eventManager;

    /**
     * Client Id
     */
    @Wither
    private String clientId = "";

    /**
     * Client Secret
     */
    @Wither
    private String clientSecret = "**SECRET**";

    /**
     * User Agent
     */
    private String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36";

    /**
     * BaseUrl
     */
    private String baseUrl = "https://streamlabs.com/api/v1.0";

    /**
     * Initialize the builder
     *
     * @return Twitch Helix Builder
     */
    public static StreamlabsApiBuilder builder() {
        return new StreamlabsApiBuilder();
    }

    /**
     * Twitch API Client (Helix)
     *
     * @return TwitchHelix
     */
    public StreamlabsApi build() {
        log.debug("API: Initializing Module ...");

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new Jdk8Module());

        HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000);
        HystrixCommandProperties.Setter().withExecutionTimeoutEnabled(false);

        return HystrixFeign.builder()
            .encoder(new JacksonEncoder(mapper))
            .decoder(new JacksonDecoder(mapper))
            .logger(new Logger.ErrorLogger())
            .errorDecoder(new StreamlabsApiErrorDecoder(new JacksonDecoder()))
            .logLevel(Logger.Level.BASIC)
            .requestInterceptor(new CommonHeaderInterceptor(this))
            .retryer(new Retryer.Default(1, 100, 3))
            .target(StreamlabsApi.class, baseUrl);
    }
}
