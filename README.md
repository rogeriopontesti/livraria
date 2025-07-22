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
### Pré-requisitos

- Lógica de programação (qualquer linguagem)
- Programação orientada a objetos (qualquer linguagem)
- Ferramentas
    - IDE de sua preferência
    - Postman

### Objetivos da Aula

- Desenvolver uma API RESTful utilizando Spring Boot com foco em boas práticas de desenvolvimento.
- Modelar e implementar entidades do domínio de uma livraria: **Livro**, **Autor**, **Editora** e **Resenha**.
- Aplicar o uso do **Spring Data JPA** para persistência de dados com repositórios.
- Praticar o mapeamento de **relacionamentos entre entidades** (ex: muitos-para-um, um-para-muitos).
- Realizar operações básicas de CRUD (Create, Read, Update, Delete) para as entidades da aplicação.
- Explorar o uso do banco de dados em memória **H2** para facilitar os testes e desenvolvimento local.
- Testar endpoints utilizando ferramentas como Postman ou Insomnia.
- Refletir sobre os princípios da arquitetura MVC e separação de responsabilidades na construção de APIs.

### 📚 Visão Geral do Sistema

A **API Livraria** é um sistema desenvolvido com **Spring Boot** e **Spring Data JPA** que tem como objetivo simular o backend de uma livraria digital. A aplicação permite o gerenciamento de livros, autores, editoras e resenhas, proporcionando uma estrutura simples para estudo de relacionamentos entre entidades, persistência de dados e criação de endpoints RESTful.

A modelagem foi pensada para representar cenários reais, onde:

- Um **Livro** possui um **Autor**, uma **Editora** e pode ter várias **Resenhas**.
- Um **Autor** pode estar associado a vários livros.
- Uma **Editora** pode publicar diversos livros.
- Cada **Resenha** está ligada a um único livro e traz uma avaliação/opinião do leitor.

A API é ideal para fins educacionais, demonstrando conceitos práticos de **JPA**, controle de rotas HTTP com **Spring MVC** e uso de banco de dados em memória (**H2**) para facilitar os testes.

