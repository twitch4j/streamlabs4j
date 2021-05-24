package com.github.twitch4j.streamlabs4j.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsApiError;
import feign.Request;
import feign.Response;
import feign.RetryableException;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ContextedRuntimeException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StreamlabsApiErrorDecoder implements ErrorDecoder {

    // Decoder
    final Decoder decoder;

    // Error Decoder
    final ErrorDecoder defaultDecoder = new Default();

    // ObjectMapper
    final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Constructor
     *
     * @param decoder Feign Decoder
     */
    public StreamlabsApiErrorDecoder(Decoder decoder) {
        this.decoder = decoder;
    }

    /**
     * Overwrite the Decode Method to handle custom error cases
     *
     * @param methodKey Method Key
     * @param response  Response
     * @return Exception
     */
    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            String responseBody = IOUtils.toString(response.body().asInputStream(), StandardCharsets.UTF_8.name());

            if (response.status() == 503) {
                // If you get an HTTP 503 (Service Unavailable) error, retry once.
                // If that retry also results in an HTTP 503, there probably is something wrong with the downstream service.
                // Check the status page for relevant updates.
                return new RetryableException("getting service unavailable, retrying ...", Request.HttpMethod.GET, null);
            }

            StreamlabsApiError apiError = objectMapper.readValue(responseBody, StreamlabsApiError.class);
            return new ContextedRuntimeException("Streamlabs API Error")
                .addContextValue("requestUrl", response.request().url())
                .addContextValue("requestMethod", response.request().httpMethod())
                .addContextValue("requestHeaders", response.request().headers().entrySet().toString())
                .addContextValue("responseBody", responseBody)
                .addContextValue("errorType", apiError.getError())
                .addContextValue("errorMessage", apiError.getErrorDescription());
        } catch (IOException fallbackToDefault) {
            return defaultDecoder.decode(methodKey, response);
        }
    }
}
