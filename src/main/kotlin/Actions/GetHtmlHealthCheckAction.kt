package Actions

import Utilities.FileIo
import contenttype.HttpContentTypes
import request.Request
import response.ResponseBuilder
import java.io.File

class GetHtmlHealthCheckAction(private val fileIo: FileIo): Action {
    private val headers = mapOf("Content-Type" to (HttpContentTypes.HTML.type + HttpContentTypes.HTML.parameter))
    private lateinit var requestBody: String

    override fun act(responseBuilder: ResponseBuilder, request: Request): String {
        val responseBody = fileIo.readResource("src/main/resources/health_check.html")
        responseBuilder.setHeaders(headers)
        responseBuilder.setBody(responseBody)
        return responseBuilder.build()
    }

    override fun setBody(body: String) {
        requestBody = body
    }
}
