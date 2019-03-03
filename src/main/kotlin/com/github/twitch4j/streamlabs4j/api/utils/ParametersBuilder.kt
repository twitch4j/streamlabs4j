package com.github.twitch4j.streamlabs4j.api.utils

import com.github.kittinunf.fuel.core.Parameters

class ParametersBuilder {
    var parameters = mutableListOf<Pair<String, Any?>>()

    fun build(): Parameters {
        return parameters.toList()
    }

    infix fun String.with(that: Any?) {
        if (that != null) parameters.add(Pair(this, that))
    }
}
