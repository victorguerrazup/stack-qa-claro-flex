package tests

import apis.{{service_name_pascal}}
import apis.Base
import factories.{{service_name_pascal}}Factory
import org.junit.jupiter.api.Test
import utils.Mass
import validations.{{service_name_pascal}}Validate

class {{service_name_pascal}}Tests: Base() {

    private val {{service_name_camelcase}} = {{service_name_pascal}}()
    private val {{service_name_camelcase}}Factory = {{service_name_pascal}}Factory()
    private val {{service_name_camelcase}}Validate = {{service_name_pascal}}Validate()
    private val mass = Mass()

    @Test
    fun my_test() {
        val response = {{service_name_camelcase}}.post(
            {{service_name_camelcase}}Factory.myFactory()
        )
        {{service_name_camelcase}}Validate.responseSuccess(response)
    }
}