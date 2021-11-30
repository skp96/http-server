import controllers.*
import router.Router
import kotlin.test.*

class RouterTest {
    private val badRequestController = BadRequestController()
    private val notFoundController = NotFoundController()
    private val router = Router(badRequestController, notFoundController)

    @Test
    fun `expect addRoute member to add GET method to the simple_get route`() {
        val simpleGetController: Controller = SimpleGetController()
        router.addRoute("GET", "/simple_get", simpleGetController)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("/simple_get" to mutableMapOf("GET" to simpleGetController))
        assertEquals(expectation, router.routes)
    }

    @Test
    fun `expect addRoute member to add GET method to simple_get_with_body route`() {
        val simpleGetWithBodyController: Controller = SimpleGetWithBodyController()
        router.addRoute("GET", "/simple_get_with_body", simpleGetWithBodyController)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("/simple_get_with_body" to mutableMapOf("GET" to simpleGetWithBodyController))
        assertEquals(expectation, router.routes)
    }

    @Test
    fun `expect getController to return a controller from simple_get_with_body route`() {
        val simpleGetWithBodyController: Controller = SimpleGetWithBodyController()
        router.addRoute("GET", "/simple_get_with_body", simpleGetWithBodyController)
        val controller = router.getController("GET", "/simple_get_with_body")
        assertIs<SimpleGetWithBodyController>(controller)
    }

    @Test
    fun `expect addRoute member to add HEAD method to simple_get route`() {
        val simpleGetController: Controller = SimpleGetController()
        router.addRoute("HEAD", "/simple_get", simpleGetController)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("/simple_get" to mutableMapOf("HEAD" to simpleGetController))
        assertEquals(expectation, router.routes)
    }

    @Test
    fun `expect getController to return a controller from simple_get route when http method is HEAD`() {
        val simpleGetController: Controller = SimpleGetController()
        router.addRoute("HEAD", "/simple_get", simpleGetController)
        val controller = router.getController("HEAD", "/simple_get")
        assertIs<SimpleGetController>(controller)
    }

    @Test
    fun `expect addRoute member to add HEAD method to head_request route`() {
        val simpleGetController: Controller = SimpleGetController()
        router.addRoute("HEAD", "/head_request", simpleGetController)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("/head_request" to mutableMapOf("HEAD" to simpleGetController))
        assertEquals(expectation, router.routes)
    }


    @Test
    fun `expect getController to return a controller from head_request route when http method is HEAD`() {
        val simpleGetController: Controller = SimpleGetController()
        router.addRoute("HEAD", "/head_request", simpleGetController)
        val controller = router.getController("HEAD", "/head_request")
        assertIs<SimpleGetController>(controller)
    }

    @Test
    fun `expect addRoute member to add OPTIONS method to method_options route`() {
        val methodOptionsController = MethodOptionsController()
        router.addRoute("OPTIONS", "/method_options", methodOptionsController)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("OPTIONS" to mutableMapOf("/method_options" to methodOptionsController))
        assertEquals(expectation, router.routes)
    }

    @Test
    fun `expect getController to return controller from method_options route when http method is OPTIONS`() {
        router.addRoute("OPTIONS", "/method_options", MethodOptionsController())
        val controller = router.getController("OPTIONS", "/method_options")
        assertIs<MethodOptionsController>(controller)
    }

    @Test
    fun `expect addRoute member to add OPTIONS method to method_options2 route`() {
        val methodOptions2Controller = MethodOptions2Controller()
        router.addRoute("OPTIONS", "/method_options2", methodOptions2Controller)
        val expectation: MutableMap<String, MutableMap<String, Controller>> = mutableMapOf("OPTIONS" to mutableMapOf("/method_options2" to methodOptions2Controller))
        assertEquals(expectation, router.routes)
    }

    @Test
    fun `expect getController to return controller from method_options2 route when http method is OPTIONS`() {
        router.addRoute("OPTIONS", "/method_options2", MethodOptions2Controller())
        val controller = router.getController("OPTIONS", "/method_options2")
        assertIs<MethodOptions2Controller>(controller)
    }

}
