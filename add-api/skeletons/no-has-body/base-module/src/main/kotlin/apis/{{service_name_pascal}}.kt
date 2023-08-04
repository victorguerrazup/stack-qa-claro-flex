package apis

import constants.{{service_name_pascal}}Const
import constants.BaseConst
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response

class {{service_name_pascal}} : Base() {

    private val {{service_name_camelcase}}Const = {{service_name_pascal}}Const()
    private val baseConst = BaseConst()

    fun {{service_method_lower}}(): Response {
        val response = Given {
            spec(specificationAuthenticated())
            basePath(baseConst._PATH)
        } When {
            {{service_method_lower}}({{service_name_camelcase}}Const.PATH_{{service_name_macrocase}})
        } Extract {
            response()
        }

        if(response.statusCode == 200){
            //Defina as propriedades necessárias
            massProperties.setProperty("", response.jsonPath().getString(""))
        }

        return response
    }
}