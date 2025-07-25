#   API Livraria

> Exemplo de objeto relacional para um esquema de livraria utilizando Spring Data JPA<

## Realização

[![rogeriopontesti dev](https://i.postimg.cc/9MptbzH0/rogeriopontesti.png)](https://github.com/rogeriopontesti)

[![rogeriopontesti no Instagram](https://i.postimg.cc/J75T2knx/1298747-instagram-brand-logo-social-media-icon.png)](https://www.instagram.com/rogeriopontesti)
[![rogeriopontesti no LinkedIn](https://i.postimg.cc/vH8PFZxs/317725-linkedin-social-icon.png)](https://www.linkedin.com/in/rogeriopontesti)
[![rogeriopontesti no Gmail](https://i.postimg.cc/bN6mzf12/7089163-gmail-google-icon.png)](mailto:rogeriopontesti@gmail.com)
[![rogeriopontesti no Youtube](https://i.postimg.cc/kXyL89g5/4375133-logo-youtube-icon.png)](https://www.youtube.com/@rogeriopontesti)
[![rogeriopontesti no WhatsApp](https://i.postimg.cc/SKtXsVDd/1783351-chatting-messages-social-media-whatsapp-internet-icon.png)](https://wa.me/5548991877781)

##
### ✅ Pré-requisitos

Para melhor aproveitamento do conteúdo, é recomendável ter conhecimentos prévios em:

- 🧠 **Lógica de Programação** (em qualquer linguagem)
- 🧱 **Programação Orientada a Objetos** (POO)
- 🛠️ **Ferramentas recomendadas**
  - IDE de sua preferência (ex: IntelliJ, VS Code, Eclipse)
  - Postman ou Insomnia para testes de API

### 🎯 Objetivos da Aula

Esta aula tem como propósito desenvolver uma API RESTful com **Spring Boot** utilizando práticas modernas de desenvolvimento. Ao final, o aluno será capaz de:

- ✅ Desenvolver uma API RESTful utilizando **Spring Boot** com foco em boas práticas.
- ✅ Modelar e implementar as entidades do domínio de uma livraria: **Livro**, **Autor**, **Editora** e **Resenha**.
- ✅ Aplicar o uso do **Spring Data JPA** para persistência de dados com repositórios.
- ✅ Mapear corretamente os **relacionamentos entre entidades**:
  - 🔄 Muitos-para-Muitos (`@ManyToMany`)
  - 🔁 Um-para-Muitos / Muitos-para-Um (`@OneToMany` / `@ManyToOne`)
  - 🔗 Um-para-Um (`@OneToOne`)
- ✅ Realizar operações básicas de **CRUD** (_Create, Read, Update, Delete_) nas entidades.
- ✅ Utilizar o banco de dados **H2 (em memória)** para facilitar testes e desenvolvimento local.
- ✅ Testar os endpoints REST utilizando ferramentas como **Postman** ou **Insomnia**.
- ✅ Refletir sobre os princípios da **arquitetura MVC** e a **separação de responsabilidades** no desenvolvimento de APIs modernas.

### 📚 Visão Geral do Sistema

A **API Livraria** é um sistema desenvolvido com **Spring Boot** e **Spring Data JPA** com o objetivo de simular o backend de uma livraria digital. A aplicação permite o gerenciamento das seguintes entidades: **Livro**, **Autor**, **Editora** e **Resenha**, respeitando os relacionamentos e regras de negócio definidos em um modelo orientado a objetos.

- [Spring Initializr](https://start.spring.io/)

[![Spring Initializr](https://i.postimg.cc/mZVLcmT7/livraria-start-spring-io.png)](https://i.postimg.cc/mZVLcmT7/livraria-start-spring-io.png)

#### 🔁 Relacionamentos entre Entidades

- Um **Livro** pode ter **vários Autores** e um **Autor** pode ter **vários Livros** → _Relacionamento Many-to-Many_.
- Um **Livro** pertence a uma única **Editora**, e uma **Editora** pode publicar **vários Livros** → _Relacionamento Many-to-One / One-to-Many_.
- Um **Livro** possui exatamente **uma Resenha**, e cada **Resenha** está associada a um único **Livro** → _Relacionamento One-to-One_.

### 📌 Diagrama de Classes

[![Diagrama de Classes da API Livraria](https://i.postimg.cc/W4PPJFzJ/diagrama-de-classes-livraria.png)](https://i.postimg.cc/W4PPJFzJ/diagrama-de-classes-livraria.png)

### 🔄 Exemplo de Relacionamento One-to-Many / Many-to-One

[![Exemplo de One-to-Many Editora ↔ Livros](https://i.postimg.cc/cLyQv1xK/um-para-muitos-e-muitos-para-um.png)](https://i.postimg.cc/cLyQv1xK/um-para-muitos-e-muitos-para-um.png)

### 🔄 Exemplo de Relacionamento Many-to-Many

[![Exemplo de Many-to-Many Editora ↔ Livros](https://i.postimg.cc/mk77wKVZ/muitos-para-muitos.png)](https://i.postimg.cc/mk77wKVZ/muitos-para-muitos.png)

### 🔄 Exemplo de Relacionamento One-to-One

[![Exemplo de One-to-One Editora ↔ Livros](https://i.postimg.cc/kX9SC1f8/um-para-um.png)](https://i.postimg.cc/kX9SC1f8/um-para-um.png)

A API é ideal para fins educacionais, pois permite aplicar conceitos práticos de modelagem de dados, relacionamento entre entidades com **JPA**, e criação de endpoints RESTful com **Spring MVC**, além do uso de banco em memória (**H2**) para facilitar testes e desenvolvimento local.

### ⚙️ Configurações do Banco de Dados (application.properties)

```properties

# Dados de conexão com o banco H2
spring.datasource.url=jdbc:h2:mem:livraria
spring.datasource.username=sa
spring.datasource.password=

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Mostrar SQL formatado no console
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

```

### 🗃️ Script SQL para Popular o Banco

```sql

INSERT INTO autores (id, nome) VALUES ('d1a3df01-bb2f-4d70-9d9b-a111fa663f02', 'Machado de Assis');
INSERT INTO autores (id, nome) VALUES ('5b1d72a9-43a4-4e4c-9e17-3e9f17e489e9', 'Clarice Lispector');
INSERT INTO editoras (id, nome) VALUES ('e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf', 'Companhia das Letras');
INSERT INTO editoras (id, nome) VALUES ('f2c24d5b-70b8-4bc7-9a0b-730e8d539f91', 'Editora Globo');
INSERT INTO livros (id, titulo, editora_id)  VALUES ('aaa111bb-222c-433d-844e-555fff666111', 'Dom Casmurro', 'e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf');
INSERT INTO livros (id, titulo, editora_id)  VALUES ('aaa111bb-222c-433d-844e-555fff666121', 'Curso de PHP', 'e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf');
INSERT INTO livro_autores (livro_id, autor_id)  VALUES ('aaa111bb-222c-433d-844e-555fff666111', 'd1a3df01-bb2f-4d70-9d9b-a111fa663f02');
INSERT INTO resenhas (id, resenha, livro_id)  VALUES ('1e234567-aaaa-bbbb-cccc-12345678eeee', 'Uma obra-prima da literatura brasileira.', 'aaa111bb-222c-433d-844e-555fff666111');

```

### 🧪 Exemplos de Testes na API
#### 🔍 CRUD Autores

##### GET: Lista autores

- http://localhost:8080/autores

##### GET: Encontra autor pelo ID

- http://localhost:8080/autores/5b1d72a9-43a4-4e4c-9e17-3e9f17e489e9

##### GET: Encontrar autor pelo nome

- http://localhost:8080/autores/nome/machado

##### POST: Salvar autor

- http://localhost:8080/autores

```json
{
	"nome": "Rogerio Pontes"
}
```

##### DELETE: Deletar autor pelo ID

- http://localhost:8080/autores/d1a3df01-bb2f-4d70-9d9b-a111fa663f02

##### DELETE: Deletar autor pela entidade

- http://localhost:8080/autores

```json
{
	"id": "26c8ec90-808c-4570-a998-97afd9bb420e",
	"nome": "Rogerio Pontes"
}
```

##### PUT: Atualizar autor

- http://localhost:8080/autores/5a3a7ce3-9798-4e8b-a8e0-375d1302dad4

```json
{
	"id": "5a3a7ce3-9798-4e8b-a8e0-375d1302dad4",
	"nome": "Rogerio Pontes de Almeida"
}
```

### CRUD - Editoras

##### GET: Lista editores

- http://localhost:8080/editoras

##### GET: Encontra editora pelo ID

- http://localhost:8080/editoras/e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf

##### GET: Encontrar autora pelo nome

- http://localhost:8080/editoras/nome/Companhia

##### POST: Salvar editora

- http://localhost:8080/editoras

```json
{
	"nome": "Editora Moderna"
}
```

##### DELETE: Deletar editora pelo ID

- http://localhost:8080/editoras/e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf

##### DELETE: Deletar editora pela entidade

- http://localhost:8080/editoras

```json
{
    "id" : "e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf"
}
```

##### PUT: Atualizar editora

- http://localhost:8080/editoras/e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf

```json
{
	"id" : "e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf",
    	"nome" : "Editora Nova Abril Cultural"
}
```

### CRUD - Resenas

##### GET: Lista resenhas

- http://localhost:8080/resenhas

##### GET: Encontra resenha pelo ID

- http://localhost:8080/resenhas/1e234567-aaaa-bbbb-cccc-12345678eeee

##### GET: Encontrar resenha pelo trecho

- http://localhost:8080/resenhas/trecho/obra-prima

##### POST: Salvar resenha

- http://localhost:8080/resenhas

```json
{
  	"resenha": "Livro muito bom!",
  	"livroId": "aaa111bb-222c-433d-844e-555fff666121"
}
```

##### DELETE: Deletar resenha pelo ID

http://localhost:8080/resenhas/1e234567-aaaa-bbbb-cccc-12345678eeee

##### DELETE: Deletar resenha pela entidade

- http://localhost:8080/resenhas

```json
{
	"id": "1e234567-aaaa-bbbb-cccc-12345678eeee"
}
```

##### PUT: Atualizar resenha

- http://localhost:8080/resenhas/1e234567-aaaa-bbbb-cccc-12345678eeee

```json
{
	"id": "1e234567-aaaa-bbbb-cccc-12345678eeee",
	"resenha" : "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book."
}
```
