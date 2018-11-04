package com.github.twitch4j.streamlabs4j.api;

import com.netflix.hystrix.HystrixCommand;
import feign.Param;
import feign.RequestLine;

public interface StreamlabsApi {

    /**
     * Gets information about the user we specified the auth token for
     *
     * @param authToken Auth Token
     * @return StreamlabsUser
     */
    @RequestLine("GET /user?access_token={access_token}")
    HystrixCommand<Object> getUser(
        @Param("access_token") String authToken
    );

}
