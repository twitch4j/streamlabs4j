package com.github.twitch4j.streamlabs4j.api.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter(AccessLevel.PRIVATE)
@Getter
public class StreamlabsApiError {

    /**
     * Error Type
     */
    private String error;

    /**
     * Error Description
     */
    private String errorDescription;

}
