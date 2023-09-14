package com.undsf.minecraft.yggdrasil.api

import org.slf4j.LoggerFactory
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

private val logger = LoggerFactory.getLogger(SimpleClient::class.java)

class SimpleClient(
    baseURL: String = MojangBaseURL,
): Client(baseURL) {
    private val httpClient = HttpClient.newHttpClient()
    override fun sendPostRequest(uri: String, payload: Any): Response {
        val url = "${baseURL}${uri}"
        val payloadJson = mapper.writeValueAsString(payload)
        logger.info("向 $url 发送请求报文：\n${payloadJson}")

        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString(payloadJson))
            .build()
        val response: HttpResponse<String> = httpClient.send(
            request,
            HttpResponse.BodyHandlers.ofString()
        )
        val resp = Response(
            response.statusCode(),
            response.body()
        )
        logger.info("接收到响应报文，状态码：${resp.status}，报文体：\n${resp.body}")
        return resp
    }
}