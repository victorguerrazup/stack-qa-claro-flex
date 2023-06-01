Na pasta do projeto, execute o comando:

```shell
stk apply plugin stack-qa-kotlin-rest-assured/add-database-connection
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
    └── src
        └── main
            ├── kotlin
            │   ├── database
            │   │   └── ConnectionSQL.kt
            └── resources
                └── properties
                    └── <environemt>.properties
```