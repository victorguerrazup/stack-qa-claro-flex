package apis

import constants.{{service_name_pascal}}Const
import constants.BaseConst
import io.restassured.http.ContentType
import io.restassured.module.kotlin.extensions.Extract
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import io.restassured.response.Response
import pojos.{{service_name_pascal}}Pojo

class {{service_name_pascal}} : Base() {

  private val {{service_name_camelcase}}Const = {{service_name_pascal}}Const()
  private val baseConst = BaseConst()

  fun {{service_method_lower}}({{service_name_camelcase}}Pojo: {{service_name_pascal}}Pojo) : Response {
        val response = Given {
            spec(specificationBase())
            basePath(baseConst.PATH)
            contentType(ContentType.JSON)
            body({{service_name_camelcase}}Pojo)
            log().all()
        } When {
            {{service_method_lower}}({{service_name_camelcase}}Const.PATH_{{service_name_macrocase}})
        } Then {
            log().all()
        } Extract {
            response()
        }

        if(response.statusCode == 200){
            //Defina as propriedades necessárias
            massProperties.setProperty("", response.jsonPath().getString(""))
        }

        //Print as propriedades necessárias
        println(massProperties.getProperty(""))

        return response
    }
}