Na pasta do projeto, execute o comando:

```shell
stk apply plugin stack-qa-kotlin-rest-assured/apply-database
```

Informe os dados conforme solicitado:

```shell
? Tipo de banco de dados postgresql
? Ambiente sit
? Servidor (host)  (localhost)
? Porta (porta)  (5432)
? Nome da base dados  (database) database_customer
? Usuário do banco dados  (user)
? Senha do banco dados  (password)
```

Os seguintes arquivos serão alterados:

```
base-module
    ├── build.gradle.kts
    └── src
        └── main
            └── kotlin
                └── database
                    └── ConnectionSQL.kt
```