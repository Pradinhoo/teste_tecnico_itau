# Desafio Técnico Itaú - Vaga Júnior

Esta aplicação é uma API RESTful desenvolvida em Java com Spring Boot, que recebe transações financeiras e retorna estatísticas sobre essas transações em tempo real, conforme o desafio técnico do Itaú.

## 🚀 Tecnologias Utilizadas

* Java 17
* Spring Boot
* Maven
* Docker

---

## 🧪 Funcionalidades

A API possui os seguintes endpoints:

### `POST /transacao`

Recebe uma transação financeira.

**Exemplo de Requisição:**

```bash
curl -X POST http://localhost:8080/transacao \
-H "Content-Type: application/json" \
-d '{
      "valor": 123.45,
      "dataHora": "2025-08-22T14:00:00.000-03:00"
    }'
```

**Respostas:**

* `201 Created` → Transação aceita.
* `422 Unprocessable Entity` → Transação inválida (regras de negócio não atendidas).
* `400 Bad Request` → Requisição malformada.

---

### `DELETE /transacao`

Apaga todas as transações armazenadas.

**Exemplo de Requisição:**

```bash
curl -X DELETE http://localhost:8080/transacao
```

**Resposta:**

* `200 OK` → Sem body.

---

### `GET /estatistica`

Retorna estatísticas das transações dos últimos 60 segundos.

**Exemplo de Requisição:**

```bash
curl -X GET http://localhost:8080/estatistica
```

**Resposta:**

```json
{
  "count": 10
  "sum": 1234.56,
  "avg": 123.46,
  "max": 200.00,
  "min": 50.00,
}
```

### `GET /estatistica{número de segundos desejados}`

Retorna estatísticas das transações dos segundos que o usuário determinar.

**Exemplo de Requisição:**

```bash
curl -X GET http://localhost:8080/estatistica{120}
```

**Resposta:**

```json
{
  "count": 10
  "sum": 1234.56,
  "avg": 123.46,
  "max": 200.00,
  "min": 50.00,
}
```

---

## 🛠️ Como Executar

### 1. Clonar o Repositório

```bash
git clone https://github.com/Pradinhoo/teste_tecnico_itau.git
cd teste_tecnico_itau
```

### 2. Construir o Projeto

```bash
./mvnw clean install
```

### 3. Executar a Aplicação

```bash
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

---

### 4. Executar com Docker (opcional)

```bash
docker build -t teste_tecnico_itau:1.0 .
docker run -p 8080:8080 teste_tecnico_itau:1.0
```

---

## ✅ Próximas tarefas

* Criação de testes unitários utilizando JUnit 5 e Mockito
* Criação de logs para acompanhar a execução
* Criação de healthcheck
