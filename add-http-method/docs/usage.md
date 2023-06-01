Na pasta do projeto, execute o comando:

```shell
stk apply plugin stack-qa-kotlin-rest-assured/add-http-method
```

Informe os dados conforme solicitado:

```shell
? Nome da API  (Api) Api
? Método HTTP POST
? A API possui um payload? Yes
```

Uma função similar a esta será adicionada à classe da API:

```kotlin
fun post(apiPojo: ApiPojo) : Response {
  val response = Given {
      spec(specificationBase())
      basePath(baseConst.PATH)
      contentType(ContentType.JSON)
      body(apiPojo)
      log().all()
  } When {
      post(apiConst.PATH_API)
  } Then {
      log().all()
  } Extract {
      response()
  }
}
```

Caso não exista, o seguinte arquivo será criado:

```
base-module
    └── src
        └── main
            └── kotlin
                └── pojos
                    └── ApiPojo.kt
```