package com.github.twitch4j.streamlabs4j.api.utils

import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.httpPost
import com.github.twitch4j.streamlabs4j.api.utils.RequestType.GET
import com.github.twitch4j.streamlabs4j.api.utils.RequestType.POST

class RequestBuilder {

    var endpoint = ""

    var parameters: Parameters = mutableListOf()

    var type = GET

    fun build(): Request = when (type) {
        GET -> endpoint.httpGet(parameters)
        POST -> endpoint.httpPost(parameters)
    }

}
