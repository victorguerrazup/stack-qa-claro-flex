package apis

import constants.BaseConst
import io.restassured.builder.RequestSpecBuilder
import io.restassured.specification.RequestSpecification
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import utils.RestAssuredRequestFilter
import java.io.InputStream
import java.util.*

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
open class Base {

    private val baseConst = BaseConst()
    companion object {
        lateinit var envProperties: Properties
        lateinit var massProperties: Properties
    }

    @BeforeAll
    fun setup() {
        var env = System.getenv("TEST_ENV")
        if (env == null) env = "sit"
        envProperties = getProperties("${env.lowercase()}.properties")
        massProperties = getProperties("mass.properties")
    }

    fun specificationBase() : RequestSpecification {
        return RequestSpecBuilder()
            .setBaseUri(sitProperties.getProperty("base.uri"))
            .build()
    }

    private fun getProperties(file:String) : Properties {
        val properties = Properties()
        val input: InputStream = this::class.java.getResourceAsStream("/properties/$file")
        properties.load(input)
        return properties
    }

}