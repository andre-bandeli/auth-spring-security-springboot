## Autenticação e Autorização com Spring Security

![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
)
![Badge](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
)

### Resumo

Esta é uma api criada para fins de estudo sobre Spring Security, Spring Boot, JWT, MySQL e Docker.

### Ferramentas utilizadas:

#### JDK 11

- JDK 11: [JAVA SE 11 Archive Downloads - ORACLE](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- Maven: [Apache Maven](https://maven.apache.org/) | [Introdução ao Maven - DEVMEDIA](https://www.devmedia.com.br/introducao-ao-maven/25128) | [Instalando Maven](https://maven.apache.org/install.html)

#### Frameworks

- Spring Boot:
- Hibernate

#### Banco de Dados

- MySQL 

#### Containers

- Docker

### Instalação:

clone o projeto

        git clone https://github.com/andre-bandeli/auth-spring-security-springboot.git
entre na pasta do projeto, onde encontra-se o arquivo pom.xml:

        cd auth-security-springboot

Rode o comando para instalar as dependências através do maven:

        mvn clean install

### Testes de Requisição com Postman

Objeto JSON para autenticação/criação de usuário no banco de dados:

    {
        "nome": " ",
        "sobrenome": "",
        "email" : "",
        "password": ""
    }

Criar nova conta de usuário:

    POST: localhost:8080/api/v1/auth/register

Autenticar-se:

    POST: localhost:8080/api/v1/auth/autheticate

Página inicial (requer autenticação):

    GET: localhost:8080/api/v1/home

### Testes Unitários com JUnit e Mock

### Créditos

##### ![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)
#### Amigoscode: [Spring Boot 3 + Spring Security 6 - JWT Authentication and Authorisation [NEW] [2023]](https://www.youtube.com/watch?v=KxqlJblhzfI)

### Levantamento/Referências

docs.spring.io
- [The Security Filter Chain - Web Application Security](https://docs.spring.io/spring-security/site/docs/3.1.4.RELEASE/reference/security-filter-chain.html)
- [OAuth 2.0 Resource Server JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)

### Suporte

Em caso de dúvidas, sugestões ou melhorias, abra uma nova issue ou envie uma mensagem através de alguma de minhas redes:

- Email: andre.lbandeli@gmail.com
- Linkedin: https://www.linkedin.com/in/andrébandeli/