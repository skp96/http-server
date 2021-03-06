package Actions
import response.HttpResponseBuilder
import httpstatus.HttpStatus
import request.Request
import response.ResponseBuilder

class MethodNotAllowedAction(private val allowedMethods: MutableSet<String>) : Action {
    private val statusCode = HttpStatus.MethodNotAllowed
    private lateinit var requestBody: String

    override fun act(responseBuilder: ResponseBuilder, request: Request): String {
        val headers = generateAllowHeader()
        responseBuilder.setStatusCode(statusCode)
        responseBuilder.setHeaders(headers)
        return responseBuilder.build()
    }

    override fun setBody(body: String) {
        requestBody = body
    }

    private fun generateAllowHeader(): Map<String, String> {
        val headerValues = mutableListOf<String>()

        for (methods in allowedMethods) {
            headerValues += methods
        }
        return mapOf("Allow" to headerValues.joinToString())
    }
}
