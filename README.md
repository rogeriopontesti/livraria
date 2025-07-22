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

#### 🔁 Relacionamentos entre Entidades

- Um **Livro** pode ter **vários Autores** e um **Autor** pode ter **vários Livros** → _Relacionamento Many-to-Many_.
- Um **Livro** pertence a uma única **Editora**, e uma **Editora** pode publicar **vários Livros** → _Relacionamento Many-to-One / One-to-Many_.
- Um **Livro** possui exatamente **uma Resenha**, e cada **Resenha** está associada a um único **Livro** → _Relacionamento One-to-One_.

### 📌 Diagrama de Classes

![Diagrama de Classes da API Livraria](./caminho/para/diagrama%20de%20classes%20livraria.png)


### 🔄 Exemplo de Relacionamento One-to-Many / Many-to-One

![Exemplo de One-to-Many Editora ↔ Livros](./caminho/para/um%20para%20muitos%20e%20muitos%20para%20um.png)

A API é ideal para fins educacionais, pois permite aplicar conceitos práticos de modelagem de dados, relacionamento entre entidades com **JPA**, e criação de endpoints RESTful com **Spring MVC**, além do uso de banco em memória (**H2**) para facilitar testes e desenvolvimento local.
