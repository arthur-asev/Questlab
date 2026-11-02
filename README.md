# QuestLab — início do projeto

Projeto didático para praticar Java, Spring Boot, JPA/Hibernate, PostgreSQL, Flyway e JUnit.

## O que já está implementado

- API REST versionada para criar e consultar questões.
- Separação básica em Controller, Service, Repository, Entity e DTOs.
- Validação de entrada com Jakarta Bean Validation.
- Persistência com Spring Data JPA/Hibernate.
- Migração inicial do banco pelo Flyway.
- Tratamento simples de erros 400 e 404.
- Testes unitários do cálculo de pontuação com JUnit 5.
- PostgreSQL local via Docker Compose.

## Pré-requisitos

- JDK 21
- Maven 3.6.3 ou superior
- Docker com o comando `docker compose`

Confira as instalações:

```bash
java -version
mvn -version
docker --version
docker compose version
```

## Executar

Na pasta deste projeto:

```bash
docker compose up -d
mvn test
mvn spring-boot:run
```

A aplicação ficará disponível em `http://localhost:8080`.

## Criar uma questão

```bash
curl -i -X POST http://localhost:8080/api/v1/questions \
  -H 'Content-Type: application/json' \
  -d '{
    "statement": "Qual anotação JPA identifica uma entidade persistente?",
    "difficulty": "BASIC",
    "source": "Estudos de Java"
  }'
```

O esperado é HTTP `201 Created` e um JSON com o ID gerado.

## Listar questões

```bash
curl -i http://localhost:8080/api/v1/questions
```

## Consultar uma questão específica

Substitua `1` pelo ID retornado no cadastro:

```bash
curl -i http://localhost:8080/api/v1/questions/1
```

## Ver os logs do PostgreSQL

```bash
docker compose logs -f postgres
```

## Parar o PostgreSQL

```bash
docker compose down
```

O volume mantém os dados. Para apagar também os dados locais do banco, use `docker compose down -v` (isso é destrutivo).

## Próximas evoluções recomendadas

1. Adicionar `Subject` e `Topic`, com relacionamentos JPA.
2. Incluir alternativas e a regra de exatamente uma alternativa correta.
3. Criar paginação e filtros com `Pageable`.
4. Testar o serviço com Mockito e os endpoints com MockMvc.
5. Criar simulados e tentativas com transações.
6. Adicionar Spring Security e autorização por usuário.
