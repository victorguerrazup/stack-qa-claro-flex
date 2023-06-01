O novo método será adicionado na linha anterior à primeira função declarada na na classe da API.

Exemplo:

1. API existente com somente o método GET

```kotlin
...
class Api : Base() {

  private val apiConst = ApiConst()
  private val baseConst = BaseConst()

  fun get() : Response {
    val response = Given {
        spec(specificationBase())
        basePath(baseConst.PATH)
        log().all()
    } When {
        get(apiConst.PATH_API)
    } Then {
        log().all()
    } Extract {
        response()
    }
  }
}
```

2. Adicionando um método POST:

```kotlin
...
class Api : Base() {

  private val apiConst = ApiConst()
  private val baseConst = BaseConst()

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

  fun get() : Response {
    val response = Given {
        spec(specificationBase())
        basePath(baseConst.PATH)
        log().all()
    } When {
        get(apiConst.PATH_API)
    } Then {
        log().all()
    } Extract {
        response()
    }
  }
}
```