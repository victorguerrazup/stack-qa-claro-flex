package factories

import pojos.{{service_name_pascal}}Pojo
import utils.Mass

class {{service_name_pascal}}Factory {

    private val mass = Mass()

    fun myFactory() : {{service_name_pascal}}Pojo {
      val {{service_name_camelcase}}Pojo = {{service_name_pascal}}Pojo()
      return {{service_name_camelcase}}Pojo
    }

}