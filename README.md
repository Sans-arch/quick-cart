

# 🛒 QuickCart

**QuickCart** é uma API backend monolítica de e-commerce simplificado desenvolvida com **Java 21** e **Spring Boot 3**. O projeto aplica conceitos de **Clean Architecture**, **DDD**, autenticação com **JWT**, e utiliza **PostgreSQL**, **Redis** e **Docker** como infraestrutura principal.

## 📌 Objetivo

Criar uma base sólida de backend que sirva como template para projetos de APIs modernas, seguras e escaláveis, com foco em boas práticas de arquitetura e design.

---

## 🧰 Tecnologias e Ferramentas

- **Java 21**
- **Spring Boot 3.2**
- **Spring Security + JWT**
- **Spring Data JPA**
- **Flyway** – Migrations de banco de dados
- **PostgreSQL**
- **Redis** – Caching com Spring Cache
- **Docker & Docker Compose**
- **Springdoc OpenAPI** – Documentação da API
- **Lombok**
- **JUnit 5 + Testcontainers** – Testes automatizados

---

## 📦 Estrutura do Projeto

```
src/
└── main/java/com/quickcart/
    ├── domain/           # Regras de negócio (entidades, interfaces)
    ├── application/      # Casos de uso (orquestra lógica)
    ├── infrastructure/   # Banco de dados, cache, configurações
    ├── presentation/     # Controllers, DTOs, mapeamentos
    └── security/         # Configuração de autenticação e JWT
```

---

## 🚀 Funcionalidades (MVP)

- [ ] CRUD de Produtos
- [ ] Carrinho de compras por usuário
- [ ] Criação de pedidos
- [ ] Registro e login de usuários (JWT)
- [ ] Caching de produtos e carrinhos com Redis
- [ ] Documentação automática com Swagger
- [ ] Testes com banco e cache em containers

---

## 🐳 Como rodar com Docker

```bash
# Subir serviços
docker-compose up -d

# Acessar PostgreSQL
localhost:5432
user: shop
pass: shop

# Acessar Redis
localhost:6379
```

---

## 🔧 Configuração do application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/quickcartdb
spring.datasource.username=shop
spring.datasource.password=shop

spring.redis.host=localhost
spring.redis.port=6379

spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true

spring.cache.type=redis
```

---

## 📚 Documentação da API

Acesse [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) após rodar a aplicação.

---

## 🧪 Testes

- Testes unitários e de integração com **JUnit 5**
- Containers reais com **Testcontainers** (PostgreSQL e Redis)

---

## 📌 Roadmap

- [ ] Estruturação do domínio com DDD
- [ ] Casos de uso da aplicação
- [ ] Segurança com JWT
- [ ] Integração com cache Redis
- [ ] Cobertura de testes com containers
- [ ] Deploy na nuvem (futuro)

---

## 📄 Licença

MIT License.

---

## 👨‍💻 Autor

**Santiago**  
Engenheiro de Software focado em desenvolvimento backend, arquitetura limpa e APIs robustas.