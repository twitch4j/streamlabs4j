package com.github.twitch4j.streamlabs4j.api;

import com.netflix.hystrix.HystrixCommand;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Map;

public interface StreamlabsApi {

    /**
     * Gets information about the user we specified the auth token for
     *
     * @param authToken   Auth Token
     * @return StreamlabsUser
     */
    @RequestLine("GET /user")
    @Headers("Authorization: Bearer {token}")
    HystrixCommand<Map<String, Object>> getUser(
        @Param("token") String authToken
    );

}
