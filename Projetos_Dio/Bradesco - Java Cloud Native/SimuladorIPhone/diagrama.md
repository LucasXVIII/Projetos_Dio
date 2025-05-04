```mermaid
classDiagram
    class ReprodutorMusical {
        +tocar(): void
        +pausar(): void
        +selecionarMusica(musica: String): void
    }

    class AparelhoTelefonico {
        +ligar(numero: String): void
        +atender(): void
        +iniciarCorreioVoz(): void
    }

    class NavegadorInternet {
        +exibirPagina(url: String): void
        +adicionarNovaAba(): void
        +atualizarPagina(): void
    }

    class iPhone {
    }

    iPhone ..|> ReprodutorMusical
    iPhone ..|> AparelhoTelefonico
    iPhone ..|> NavegadorInternet
```
