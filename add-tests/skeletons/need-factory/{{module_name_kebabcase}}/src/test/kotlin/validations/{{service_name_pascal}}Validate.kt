package validations

import io.restassured.response.Response
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.assertAll

class {{service_name_pascal}}Validate {

    fun responseSuccess(response: Response ) {
        assertAll("{{service_name_pascal}} Success",
            { Assertions.assertNotNull(response) },
            { Assertions.assertEquals(201, response.statusCode) }
            //Adicione suas validações
        )
    }
}