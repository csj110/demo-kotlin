# demo-kotlin

## [step 0](https://github.com/pull-vert/demo-kotlin/tree/master)
Direct commit from Spring Initializr

## [step 1](https://github.com/pull-vert/demo-kotlin/tree/step1-skeleton)
Empty files for the demo

## [step 2](https://github.com/pull-vert/demo-kotlin/tree/step2-mongo-reactive)
MongoDB app is complete :
* classic Spring annotations (@Service, @Repository...)
* Cow entity (data class entity)
* CowRepository Spring Data Interface
* CowHandler provide Functional functions (= take ServerRequest as parameter and returns Mono<ServerResponse>)
* ApiRoutes provides all Http REST Endpoints of the App
* DatabaseInitializer initializes the embedded MongoDB with test datas
* CowRepositoryTest provides JUnit tests for CowRepository
* ApiTest uses WebTestClient to call real Http REST API
