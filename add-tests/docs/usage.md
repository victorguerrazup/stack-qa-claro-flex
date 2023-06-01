Na pasta do projeto, execute o comando:

```shell
stk apply plugin stack-qa-kotlin-rest-assured/add-tests
```

Informe os dados conforme solicitado:

```shell
? Nome do módulo  (new-module) Novo Modulo
? API sob teste  (Api) Api
? Os testes precisam de um factory? Yes
```

Os seguintes arquivos serão criados:

```
novo-modulo
    └── src
        └── test
            └── kotlin
                ├── factories
                │   └── ApiFactory.kt
                ├── tests
                │   └── ApiTests.kt
                └── validations
                    └── ApiValidate.kt
```