package controllers
import response.ResponseBuilder
import httpstatus.HttpStatus

class NotFoundController : Controller {
    val statusCode = HttpStatus.NotFound
    private lateinit var requestBody: String

    override fun action(): ResponseBuilder {
        return ResponseBuilder(statusCode)
    }

    override fun setBody(body: String) {
        requestBody = body
    }
}
