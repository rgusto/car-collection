# CAR-COLLECTION

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens)
![Angular](https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white)


Projeto criado para o desafio Java com Spring Boot da empresa **Pitang**.

Consiste em uma API RESTful de criação de usuários e carros, com login.

Requisitos: Java 17 ou posterior e Maven 3.6 ou superior.

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/rgusto/car-collection.git
```

2. Instale as dependências com o Maven

## Como executar

1. Inicie a aplicação com o Maven;
```bash
mvn spring-boot:run
```
2. A API estará disponível através do endereço http://localhost:8081
3. A documentação da API estará disponível através do endereço http://localhost:8081/swagger-ui/index.html
4. Caso prefira, na raiz do projeto está localizado o arquivo **postman_colletion.json**, que pode ser importado no aplicativo **Postman** para executar os testes dos endpoints.
5. Para executar os testes unitários, basta executar o comando:
```bash
mvn verify
```
ou
```bash
mvn test
```

## Executando a aplicação do front-end

### Requisitos

* **Node.js** (última versão LTS): https://nodejs.org/pt-br/
* Via terminal, instalar o **Angular CLI**:
```bash
npm install -g @angular/cli
```

### Como executar 

* Acessar via terminal a pasta **car-collection-crud**, localizada na raiz do projeto;
* Executar o comando:
```bash
npm run start
```
* Após isso, a aplicação estará disponível através do endereço http://localhost:4200

## Histórias

* Criação das entidades **User** e **Car** e suas rotas;
* Inclusão de validações e tratamento de exceções;
* Implementação da autenticação de usuário;
* Configuração inicial do front-end;
* Criação do CRUD da entidade **User** no front-end: opções CREATE e READ;
* Criação do CRUD da entidade **User** no front-end: opções UPDATE e DELETE;
* Implementação dos testes unitários;
* Inclusão do Swagger.