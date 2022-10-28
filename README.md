#  Projeto inventário Spring Boot

Sistema de inventario básico com APIs REST usando Spring Boot

##  Como executar

Este aplicativo possui o Tomcat 9 incorporado. Nenhuma instalação do Tomcat ou JBoss é necessária.
* Clonar este repositório
* Certifique-se de estar usando JDK 17 e Maven 3.x

* Se tiver usando Spring Tolls siga os passos:
* file -> import -> maven -> existing Maven Project e seleciona o local do projeto

## Documentação da API

#### Retorna todos os produtos

```http
  GET /api/produto
```

#### Retorna um produto 

```http
  GET /api/produto/${id} 
```

#### Adiciona um produto

```http
  POST /api/produto/${id} 
```

#### Deleta um produto

```http
  DELETE /api/produto/${id} 
```

#### Filtrar pelo codigo do produto 

```http
  GET /api/produto/codigo/${codigo} 
```

### Alguns endpoints

```
http://localhost:8080/api/produto
http://localhost:8080/api/local
http://localhost:8080/api/tipo
http://localhost:8080/api/pessoa
```
### Banco de dados 
Foi utilizado o DBeaver com MySql.
Estrutura do banco:
![banco-inventario](https://user-images.githubusercontent.com/116357603/198710947-397bb008-04f7-4580-9b10-a5cf5d30f9cc.png)

###  Para visualizar a API documentada pelo Swagger 
```
Execute o servidor e navegue até http://localhost:8080/swagger-ui/index.html#/
```

