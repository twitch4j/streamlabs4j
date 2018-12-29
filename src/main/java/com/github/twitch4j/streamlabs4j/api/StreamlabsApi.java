package com.github.twitch4j.streamlabs4j.api;

import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser;
import com.netflix.hystrix.HystrixCommand;
import feign.Param;
import feign.RequestLine;

public interface StreamlabsApi {

    /**
     * Gets information about the user associated with the specified token
     *
     * @param authToken Your Authentication Token
     * @return the user associated with this token
     */
    @RequestLine("GET /user?access_token={access_token}")
    HystrixCommand<StreamlabsUser> getUser(
        @Param("access_token") String authToken
    );

}
