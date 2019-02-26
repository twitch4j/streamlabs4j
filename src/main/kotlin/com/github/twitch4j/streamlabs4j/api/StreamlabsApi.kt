package com.github.twitch4j.streamlabs4j.api

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelError
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.github.kittinunf.fuel.reactor.monoResultObject
import com.github.kittinunf.result.Result
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser

class StreamlabsApi(
    private val clientId: String,
    private val clientSecret: String
) {

    private val baseUrl = "https://streamlabs.com/api/v1.0"

    private val userAgent =
        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36"

    init {
        FuelManager.instance.basePath = baseUrl
        FuelManager.instance.baseHeaders = mapOf(
            "User-Agent" to userAgent,
            "client-id" to clientId
        )
    }

    fun getUser(authToken: String) {
        val mapper = object : ResponseDeserializable<StreamlabsUser> {
            override fun deserialize(content: String) =
                jacksonObjectMapper().readValue<StreamlabsUser>(content)
        }

        val s = Fuel
            .get("/user", listOf("access_token" to authToken))
            .monoResultObject(mapper)
            .map(Result<StreamlabsUser, FuelError>::get)
            .map { it.youtube?.title }
            .onErrorReturn("woops")
            .block()

        println(s)
    }
}