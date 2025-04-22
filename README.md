# 🛒 QuickCart

**QuickCart** é uma API REST para gerenciamento de produtos em um e-commerce simplificado.  
Desenvolvido com foco em boas práticas como Clean Architecture, DDD, versionamento de API e testes com Testcontainers.

---

## 🚀 Funcionalidades

- ✅ Cadastro de produtos (`POST /api/v1/products`)
- ✅ Listagem de produtos (`GET /api/v1/products`)
- ✅ Validação de dados com Bean Validation
- ✅ Tratamento global de erros com mensagens claras
- ✅ Documentação Swagger/OpenAPI
- ✅ Estrutura modular com separação de responsabilidades
- ✅ Pronto para expandir com autenticação JWT, novos agregados e muito mais

---

## 🧱 Arquitetura

O projeto segue a **Clean Architecture**, com inspiração em DDD e separação clara de responsabilidades:

```
quick-cart
├── domain         → Entidades e contratos (Product, ProductRepository)
├── application    → Casos de uso (CreateProductUseCase, etc.)
├── infrastructure → Configurações e integrações externas (JPA, Security, Swagger)
├── presentation   → API REST, DTOs, mappers e handlers de exceções (versionado por `v1`, `v2`, etc.)
```

---

## ⚙️ Tecnologias utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web & Spring Data JPA**
- **Spring Security (configurado, mas ainda sem autenticação)**
- **PostgreSQL** com **Flyway**
- **Testcontainers** para testes de integração
- **Swagger (springdoc-openapi)** para documentação da API
- **Docker Compose** (para PostgreSQL local)

---

## 📦 Como rodar o projeto

### Pré-requisitos

- Docker + Docker Compose
- Java 21
- Maven

### Subir o banco de dados com Docker

```bash
docker-compose up -d
```

### Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
`http://localhost:8080`

---

## 🔍 Documentação Swagger

Acesse a documentação interativa em:

```
http://localhost:8080/swagger-ui/index.html
```

Você poderá visualizar e testar os endpoints diretamente pela interface.

---

## 🧪 Testes

O projeto utiliza **TDD** e testes de integração com **Testcontainers** para garantir isolamento do ambiente real.

### Executar os testes:

```bash
./mvnw test
```

---

## 📮 Exemplo de uso da API

### ✅ Criar um produto

```http
POST /api/v1/products
Content-Type: application/json

{
  "name": "Mouse Gamer",
  "description": "Mouse com sensor óptico de alta precisão, 7200 DPI",
  "price": 149.90
}
```

### ✅ Listar produtos

```http
GET /api/v1/products
```

---

## 💡 Próximos passos

- [ ] Adicionar `GET /products/{id}`, `PUT`, `DELETE`
- [ ] Implementar autenticação com JWT
- [ ] Introduzir agregados como `Cart`, `Category`
- [ ] Adicionar testes da camada de apresentação (MockMvc)
- [ ] Implementar paginação e filtros

---

## 📄 Licença

Distribuído sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

---

## ✍️ Autor

Feito com 💙 por **Sans-arch**  
🔗 [linkedin.com/in/santiago-negreira](https://www.linkedin.com/in/santiago-negreira/)