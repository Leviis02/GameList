## D1 - Configurar o GitHub
* Criar o repositório gameslist-backend-levi no GitHub
  * Será gerado o link para o repositório como nesse exemplo:
    https://github.com/levigoncalves/gameslist-backend-levi.git


## D1 - Configurar o Git Local
* Clonar o repositório do GitHub
  * abrir o Git Bash de dentro da pasta do projeto e:
```
  $ git clone https://github.com/levigoncalves/gameslist-backend-levi.git
```


## D1 - Criação do projeto base

Entrar no spring initializer e criar o projeto com os seguintes dados:
* Project: Maven
* Language: Java 
* Spring Boot: 3.1.0 
* Project Metadata:
  * Group: br.com.personal (vamos adotar essa estrutura para projetos pessoais)
  * Artifact: gameslist-backend-levi
  * Name: gameslist-backend-levi
  * Description: Catálogo de jogos
  * Package name: br.com.personal.gameslist-backend-levi
  * Packaging: Jar
  * Java: 17 
* Dependencies 
  * Spring Web
  * Spring JPA
  * H2
  * PostgreSQL

GERAR O PROJETO e COPIAR PARA A PASTA DO GIT LOCAL

## D1 - Configurar o projeto no IntelliJ
* Abrir o IntelliJ e criar um novo projeto a partir do projeto criado no spring initializer
* Configurar o arquivo application.properties para que ele faça o redirecionamento dos Profiles
### application.properties
```
spring.profiles.active=${APP_PROFILE:dev}
spring.jpa.open-in-view=false
```

* Criar e configurar o arquivo application-dev.properties para que ele seja o Profile Dev (com H2)
### application-dev.properties
```
# H2 Connection
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

# H2 Client
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Show SQL
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## D1 - Inicializar o projeto:
- Refatorar o arquivo GameslistBackendSandroApplication para GameslistBackendStartup (também nas classes de testes)
- Rodar o projeto por esse arquivo: GameslistBackendStartup
- Verificar se o H2 subiu:
  -- http://localhost:8080/h2-console
  -- JDBC URL: jdbc:h2:mem:testdb (A mesma que colocamos no arquivo application-dev.properties)

## D1 - COMMITAR
Apenas para manter o projeto base disponível para futuros projetos que utilizem as mesmas dependências.


## D2 - Entendendo o projeto
O projeto tem como objetivo armazenar um catálogo de jogos e classificá-los conforme a lista a qual cada jogo pertença. Veja o modelo de domínio abaixo
## Modelo de domínio _GamesList_

![Modelo de domínio DSList](https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/dslist-model.png)

Perceba que entre Game e GameList, há uma tabela associativa chamada Belonging, isso se faz necessário porque nessa relação de pertencimento "Belonging"
há um atributo a mais, chamado "position". Ou seja, no banco de dados, para cada associação entre Game e GameList, haverá um registro em Belonging, indicando
em qual "position" da lista o game se encontra.

## D2 - Criar os pacotes padrões de qualquer projeto spring WEB
* entities (ou models)
* services
* repositories
* controllers
* dtos

## D2 - Criar as entidades (classes) Game e GameList
* Gerar construtores: remover o super
* Gerar os getters e setters
* Gerar hashCode & equals: só com o id é suficiente
