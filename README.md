## Autenticação e Autorização com Spring Security

![SpringBoot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
)
![Badge](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white
)
![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white
)

## Resumo

Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.

- Autenticação em memória:
[login-page api](https://github.com/andre-bandeli/auth-spring-security-springboot/tree/main/login-page)
- Autenticação via Banco de dados: [consumer api](https://github.com/andre-bandeli/auth-spring-security-springboot/tree/main/consumer)
- Autenticação via Token JWT: [autentication api](https://github.com/andre-bandeli/auth-spring-security-springboot/tree/main/autentication)

## Requisitos:

#### Java

- JDK 11: [JAVA SE 11 Archive Downloads - ORACLE](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
- Maven: [Apache Maven](https://maven.apache.org/) | [Introdução ao Maven - DEVMEDIA](https://www.devmedia.com.br/introducao-ao-maven/25128) | [Instalando Maven](https://maven.apache.org/install.html)

#### Frameworks

- Spring Boot 3.0: [Spring Boot - spring.io](https://spring.io/projects/spring-boot)  | [Spring Initializer](https://start.spring.io/)
- Hibernate: [Hibernate](https://hibernate.org/) | [Guia de Referência - DEVMEDIA](https://www.devmedia.com.br/guia/hibernate/38312) | [O que é e o porque devo utilizar o Hibernate - Medium](https://medium.com/@leonardogiuliani/o-que-%C3%A9-e-porque-devo-utilizar-o-hibernate-66fae865a22f)

#### Banco de Dados
<i>obs: Esta api foi desenvolvida utilizando o intellij - Free Educational Licenses - que oferece um sistema gerenciador de banco de dados (SGBD) integrado a própria IDE. Como alternativa, sugiro o uso do DBeaver. [instalação ubuntu](https://www.edivaldobrito.com.br/dbeaver-no-ubuntu-e-derivados/)
</i>


- MySQL: [Dockerhub](https://hub.docker.com/_/mysql) | [Spring Boot application: Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)


#### Containers

- Docker: [Docker](https://www.docker.com/) | [Docker na prática - GeekHunter](https://blog.geekhunter.com.br/docker-na-pratica-como-construir-uma-aplicacao/) | [Instalando no ubuntu 20.0 - DigitalOcean](https://www.digitalocean.com/community/tutorials/how-to-install-and-use-docker-on-ubuntu-20-04-pt)

## Instalação

clone o projeto

        git clone https://github.com/andre-bandeli/auth-spring-security-springboot.git
entre na pasta do projeto, onde encontra-se o arquivo pom.xml:

        cd auth-security-springboot

Rode o comando para instalar as dependências através do maven:

        mvn clean install

O seguinte resultado é esperado:
![springboot_run](https://user-images.githubusercontent.com/87938869/212789128-3b8f4a5f-73d0-4257-b435-0743ec2b0a39.png)

seguido dos logs
![springboot_logs](https://user-images.githubusercontent.com/87938869/212789258-d7ac1cb6-3907-4583-857c-f48479c605ee.png)



## Testando requisições via Postman

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

Quando uma nova conta é registrada ou autenticada, cria-se um token JWT ncessário para realizar as requisições. Utilize o token gerado para utilizar na autenticação do Postman:
![postman](https://user-images.githubusercontent.com/87938869/212790022-45b6cc10-c6e9-4a15-aaae-6bd6bcc97417.png)


## Testes Unitários: JUnit 5 e Mocks

Estrutura do diretório de testes unitários
![dir](https://user-images.githubusercontent.com/87938869/212795310-32e147a2-8df6-4f60-abdd-a33dd47c272c.png)

## Créditos

<b><u>Amigoscode</u></b> (Youtube)
- [Spring Boot 3 + Spring Security 6 - JWT Authentication and Authorisation [NEW] [2023]](https://www.youtube.com/watch?v=KxqlJblhzfI)

<b><u>docs.spring.io</u></b> (Documentação)
- [The Security Filter Chain - Web Application Security](https://docs.spring.io/spring-security/site/docs/3.1.4.RELEASE/reference/security-filter-chain.html)
- [OAuth 2.0 Resource Server JWT](https://docs.spring.io/spring-security/reference/servlet/oauth2/resource-server/jwt.html)

## Suporte

Em caso de dúvidas, sugestões ou melhorias, abra uma nova issue ou envie uma mensagem através de alguma de minhas redes:

- Email: andre.lbandeli@gmail.com
- Linkedin: https://www.linkedin.com/in/andrébandeli/
