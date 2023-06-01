A nova conexão será aplicada através da adição dos dados de conexão no arquivo de properties do ambiente informado e adição do método para conexão ao banco de dados na classe ConnectionSQL.

Arquivo de propriedades:
```properties
db.database.port = 5432
db.database.name = database
db.database.user = user
db.database.password = password
```

Classe ConnectionSQL:
```kotlin
...
  companion object {
    fun databaseConnection() : Connection {
      val databasePrefix = "db.database"
      val connection: Connection?
      val host = envProperties.getProperty("${databasePrefix}.host")
      val port = envProperties.getProperty("${databasePrefix}.port")
      val database = envProperties.getProperty("${databasePrefix}.name")
      val user = envProperties.getProperty("${databasePrefix}.user")
      val password = envProperties.getProperty("${databasePrefix}.password")
      val url = "jdbc:postgresql://${host}:${port}/${database}"
      Class.forName("org.postgresql.Driver")
      connection = DriverManager.getConnection(url, user, password)
      return connection
    }
  }
...
```