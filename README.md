⏰ API de Agendamento de Tarefas

API REST desenvolvida com Java 21 e Spring Boot, responsável por gerenciar tarefas de usuários autenticados via JWT, com arquitetura limpa e comunicação entre microsserviços utilizando OpenFeign.

Projeto focado em boas práticas de desenvolvimento back-end, separação de responsabilidades e segurança.

🎯 Objetivo do Projeto

Construir uma API escalável e bem estruturada aplicando:

Clean Architecture

Princípios de responsabilidade única

Isolamento de regras de negócio

Comunicação entre microsserviços

Segurança com JWT

🚀 Funcionalidades

✅ Criar tarefa

✅ Atualizar tarefa

✅ Excluir tarefa

✅ Alterar status

✅ Buscar por período

✅ Buscar por e-mail

🔐 Validação via JWT

🔗 Integração com API de usuários

📍 Endpoints
🔹 Criar Tarefa
POST /tarefas

🔹 Buscar por Período
GET /tarefas/eventos?dataInicio=2026-01-01&dataFim=2026-01-30

🔹 Buscar por Email
GET /tarefas?email=usuario@email.com

🔹 Atualizar Tarefa
PUT /tarefas

🔹 Alterar Status
PATCH /tarefas

🔹 Deletar
DELETE /tarefas

🔐 Segurança

Spring Security

Autenticação via JWT

Filtro de validação de token

Token propagado automaticamente via OpenFeign

Endpoints protegidos

🔗 Comunicação Entre Microsserviços

A API utiliza OpenFeign para integração com o serviço de usuários.

Token JWT é propagado automaticamente

Comunicação desacoplada

Cliente HTTP declarativo

📚 Documentação

Swagger disponível em:

http://localhost:8080/swagger-ui.html

🛠️ Tecnologias

Java 21

Spring Boot

Spring Data JPA

Spring Security

JWT

OpenFeign

MongoDB

Docker

Maven

🧱 Arquitetura

Estrutura baseada em Clean Architecture:

src
 ├── application
 │    ├── usecase
 │    └── dto
 ├── domain
 │    ├── model
 │    └── repository
 ├── infrastructure
 │    ├── config
 │    ├── security
 │    └── client (Feign)
 └── controller


✔ Regras de negócio isoladas nos casos de uso
✔ Conversão entre Entity e DTO via Mapper
✔ Integrações externas desacopladas

📦 Exemplo de Requisição
📥 Criar Tarefa
{
  "titulo": "Estudar Microsserviços",
  "descricao": "Revisar OpenFeign e RabbitMQ",
  "dataEvento": "2026-02-15",
  "email": "usuario@email.com"
}

⚙️ Variáveis de Ambiente
Variável	Descrição
JWT_SECRET	Chave secreta para geração e validação do token
MONGO_URI	String de conexão com MongoDB
USER_API_URL	URL da API de usuários
🐳 Executando com Docker
docker run -d -p 8081:81 agendador-tarefas


Ou com docker-compose:

docker compose up -d
