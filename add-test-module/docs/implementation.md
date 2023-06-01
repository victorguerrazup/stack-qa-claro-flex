Os módulos de teste serão adicionados ao projeto através da criação dos seguintes arquivos:

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

Além disso, o arquivo _settings.gradle.kts_ será editado para incluir o novo módulo:
```kotlin
...
include("novo-modulo")
```