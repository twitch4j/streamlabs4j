package com.github.twitch4j.streamlabs4j.api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsDonationsData
import com.github.twitch4j.streamlabs4j.api.domain.StreamlabsUser
import com.github.twitch4j.streamlabs4j.api.utils.RequestType.GET
import com.github.twitch4j.streamlabs4j.api.utils.parameters
import com.github.twitch4j.streamlabs4j.api.utils.request
import com.netflix.hystrix.HystrixCommand
import com.netflix.hystrix.HystrixCommandGroupKey

/** Class representing the api from [https://dev.streamlabs.com/reference] */
class StreamlabsApi(
    private val clientId: String,
    private val clientSecret: String
) {

    private val baseUrl: String = "https://streamlabs.com/api/v1.0"

    private val userAgent: String =
        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36"

    private val mapper: ObjectMapper = jacksonObjectMapper()

    init {
        FuelManager.instance.basePath = baseUrl
        FuelManager.instance.baseHeaders = mapOf(
            "User-Agent" to userAgent,
            "client-id" to clientId
        )
    }

    /**
     * Gets information about the user associated with the specified [token]
     *
     * @return the user associated with this [token]
     */
    fun getUser(token: String): HystrixCommand<StreamlabsUser> =
        result {
            request {
                endpoint = "/user"
                type = GET
                parameters = parameters {
                    "access_token" with token
                }
            }
        }

    /**
     * Gets donations about the user associated with the specified [token]
     *
     * The number of donations can be limited with the [limit] parameter.
     * Pagination is also supported so the [before] and [after]
     * parameters can be used simultaneously to limit the output.
     * It is also possible to filter the ouput by currency using the
     * [currency] parameter.
     * The [verified] parameter is used to include (true) real donations,
     * (false) api / web donations or (null) both.
     *
     * Requires the donation.read scope.
     *
     * @return a list of donations associated with this [token]
     */
    fun getDonations(
        token: String,
        limit: Int?,
        before: String?,
        after: String?,
        currency: String?,
        verified: Boolean?
    ): HystrixCommand<StreamlabsDonationsData> =
        result {
            request {
                endpoint = "/donations"
                type = GET
                parameters = parameters {
                    "access_token" with token
                    "limit" with limit
                    "before" with before
                    "after" with after
                    "currency" with currency
                    "verified" with verified
                }
            }
        }

    /** Wrap a function [block] returning a [T] into a HystrixCommand */
    private fun <T> hystrix(block: () -> T): HystrixCommand<T> {
        return object : HystrixCommand<T>(
            HystrixCommandGroupKey { baseUrl }) {

            override fun run(): T {
                return block()
            }
        }
    }

    /** Deserialize to [T] a given [block] returning a string */
    private inline fun <reified T> deserialize(block: () -> String): T {
        return mapper.readValue(block())
    }

    /** Get the result from a Fuel request in the [block] */
    private inline fun <reified T> result(crossinline block: () -> Request): HystrixCommand<T> {
        return hystrix {
            deserialize<T> {
                block()
                    .responseString()
                    .third // Get the third element of the Triple (which contains the result)
                    .get()
            }
        }
    }
}
