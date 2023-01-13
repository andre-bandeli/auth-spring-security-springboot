## Autenticação e Autorização com Spring Security

![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
)
![Badge](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
)

### Resumo

Esta é uma api criada para fins de estudo sobre Spring Security, Spring Boot, JWT, MySQL e Docker.


### Instalação:

clone o projeto

        git clone 
entre na pasta do projeto, onde encontra-se o arquivo pom.xml:

        cd 

Rode o comando para instalar as dependências através do maven:

        mvn clean install

### Ferramentas utilizadas:

- Java
- Docker
- Spring Boot
- Apache Maven
- MySQL


### Testes Postman

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

### Suporte

Em caso de dúvidas, sugestões ou melhorias, abra uma nova issue ou envie uma mensagem através de alguma de minhas redes:

- Email: andre.lbandeli@gmail.com
- Linkedin: https://www.linkedin.com/in/andrébandeli/