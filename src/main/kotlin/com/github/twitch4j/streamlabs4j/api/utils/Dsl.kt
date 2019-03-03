package com.github.twitch4j.streamlabs4j.api.utils

import com.github.kittinunf.fuel.core.Parameters
import com.github.kittinunf.fuel.core.Request

fun request(setup: RequestBuilder.() -> Unit): Request {
    val builder = RequestBuilder()
    builder.setup()
    return builder.build()
}

fun parameters(setup: ParametersBuilder.() -> Unit): Parameters {
    val builder = ParametersBuilder()
    builder.setup()
    return builder.build()
}
