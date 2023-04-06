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
    private val sitProperties: Properties = getProperties("sit.properties")

    private val restAssuredRequestFilter = RestAssuredRequestFilter()
    companion object {
        lateinit var massProperties: Properties
    }

    @BeforeAll
    fun setup() {
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