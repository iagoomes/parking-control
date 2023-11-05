# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Validation](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#io.validation)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#using.devtools)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Validation](https://spring.io/guides/gs/validating-form-input/)



# Projeto de Parquímetro

Este é um projeto de refatoração de uma solução de parquímetro, utilizando conceitos de APIs, persistência de dados e otimização para melhorar a eficiência e escalabilidade do sistema. Neste projeto, estamos utilizando Java 17, Spring Boot 3.1.5, um banco de dados Oracle e a biblioteca Lombok. Este README fornece informações essenciais sobre a estrutura do projeto, como configurá-lo e como usá-lo.

## Requisitos

Para executar este projeto, é necessário ter as seguintes ferramentas e bibliotecas instaladas:

- Java 17 ☕
- Spring Boot 3.1.5
- Banco de dados Oracle
- Lombok

Certifique-se de configurar um banco de dados Oracle e fornecer as credenciais apropriadas no arquivo de configuração, conforme descrito nas seções abaixo.

## Configuração

### Banco de Dados

Certifique-se de ter um banco de dados Oracle configurado e pronto para uso. Você precisará fornecer as informações de conexão no arquivo de configuração do aplicativo Spring Boot.

No arquivo `src/main/resources/application.properties`, defina as seguintes propriedades com as informações do seu banco de dados:

```properties
spring.datasource.url=jdbc:oracle:thin:@localhost:1521/SEU_BANCO_DE_DADOS
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
```

## Executando o Aplicativo

Agora você pode executar o aplicativo Spring Boot. Use a seguinte linha de comando para iniciar o aplicativo:
`mvn spring-boot:run`  
O aplicativo será iniciado e estará pronto para ser usado.

# Swagger

Este projeto inclui a documentação da API com o Swagger. Você pode acessar a documentação da API por meio do Swagger UI, que está disponível no seguinte URL após iniciar o aplicativo: http://localhost:8080/swagger-ui.html

### Uso do Parquímetro

O sistema de parquímetro é acessado por meio de APIs RESTful. Você pode usar ferramentas como Swagger, Postman ou qualquer cliente HTTP para interagir com as APIs. A seguir, estão alguns exemplos de operações que você pode realizar:


### 🌐Adicionar um Veículo Estacionado

```
POST http://localhost:8080/api/estacionamento/veiculo
{
"placa": "ABC123",
"tempoEstacionadoMinutos": 60
}
```

### 🌐Obter Informações de um Veículo Estacionado

`GET http://localhost:8080/api/estacionamento/veiculo/ABC123`


### 🌐Encerrar o Estacionamento de um Veículo

`POST http://localhost:8080/api/estacionamento/veiculo/ABC123/encerrar`


### 🌐Listar Todos os Veículos Estacionados

`GET http://localhost:8080/api/estacionamento/veiculos`

# Otimização e Escalabilidade

Este projeto utiliza um banco de dados Oracle para armazenar informações sobre veículos estacionados, garantindo um acesso rápido e confiável aos dados. Além disso, foram aplicadas técnicas de otimização para minimizar a necessidade de acesso frequente ao banco de dados, melhorando o desempenho geral do sistema.

A estrutura do projeto e a escolha de tecnologias modernas, como Spring Boot, permitem que o sistema seja facilmente escalável para lidar com um grande volume de dados no futuro.

Este README fornece uma visão geral do projeto e das operações disponíveis. Consulte a documentação da API do Swagger ou o código-fonte para obter detalhes adicionais sobre como usar e estender o sistema de parquímetro.