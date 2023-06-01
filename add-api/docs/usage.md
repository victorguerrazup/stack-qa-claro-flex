Na pasta do projeto, execute o comando:

```shell
stk apply plugin stack-qa-kotlin-rest-assured/add-api
```

Informe os dados conforme solicitado:

```shell
? Nome da API  (Api) Api
? Método HTTP POST
? A API possui um payload? Yes
```

Os seguintes arquivos serão criados:

```
base-module
    └── src
        └── main
            └── kotlin
                ├── apis
                │   └── Api.kt
                ├── constants
                │   └── ApiConst.kt
                └── pojos
                    └── ApiPojo.kt
```