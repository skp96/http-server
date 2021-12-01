package controllers

import response.ResponseBuilder
import httpstatus.HttpStatus

class RedirectController : Controller {
    private val statusCode = HttpStatus.MovedPermanently
    private val headers: Map<String, String> = mapOf("Location" to "http://127.0.0.1:5000/simple_get")

    override fun action(): ResponseBuilder {
        return ResponseBuilder(statusCode, headers = headers)
    }
}
