package database

class {{table_name_pascalcase}} : ConnectionSQL(
    "{% if schema_name != '' %}{{schema_name|lower}}.{% endif %}{{table_name|lower}}",
    {{database_name_camelcase}}Connection()
) {

  fun getAll(): List<Map<String, Any?>> {
        return selectAll()
    }
}