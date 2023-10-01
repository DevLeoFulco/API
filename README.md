# API de Gerenciamento de Pessoas

Esta API permite o gerenciamento de pessoas e seus endereços. Ela oferece endpoints para criar, editar, consultar, listar pessoas, criar endereços para pessoas, listar endereços da pessoa e definir o endereço principal da pessoa.

## Endpoints

### Pessoas

#### Criar Pessoa

- **URL:** `/pessoas`
- **Método:** POST
- **Descrição:** Cria uma nova pessoa.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Nome da Pessoa",
    "dataNascimento": "Data de Nascimento (yyyy-MM-dd)"
  }
  ```
- **Resposta de Sucesso (JSON):**
  ```json
  {
    "id": 1,
    "nome": "Nome da Pessoa",
    "dataNascimento": "Data de Nascimento (yyyy-MM-dd)"
  }
  ```

#### Editar Pessoa

- **URL:** `/pessoas/{id}`
- **Método:** PUT
- **Descrição:** Edita os dados de uma pessoa existente.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "nome": "Novo Nome",
    "dataNascimento": "Nova Data de Nascimento (yyyy-MM-dd)"
  }
  ```
- **Resposta de Sucesso (JSON):**
  ```json
  {
    "id": 1,
    "nome": "Novo Nome",
    "dataNascimento": "Nova Data de Nascimento (yyyy-MM-dd)"
  }
  ```

#### Consultar Pessoa

- **URL:** `/pessoas/{id}`
- **Método:** GET
- **Descrição:** Consulta os detalhes de uma pessoa pelo ID.
- **Resposta de Sucesso (JSON):**
  ```json
  {
    "id": 1,
    "nome": "Nome da Pessoa",
    "dataNascimento": "Data de Nascimento (yyyy-MM-dd)"
  }
  ```

#### Listar Pessoas

- **URL:** `/pessoas`
- **Método:** GET
- **Descrição:** Lista todas as pessoas cadastradas.
- **Resposta de Sucesso (JSON):** Uma lista de objetos de pessoa.

### Endereços

#### Criar Endereço para Pessoa

- **URL:** `/enderecos`
- **Método:** POST
- **Descrição:** Cria um novo endereço para uma pessoa.
- **Corpo da Requisição (JSON):**
  ```json
  {
    "logradouro": "Rua da Pessoa",
    "cep": "CEP da Pessoa",
    "numero": "Número da Pessoa",
    "cidade": "Cidade da Pessoa"
  }
  ```
- **Resposta de Sucesso (JSON):**
  ```json
  {
    "id": 1,
    "logradouro": "Rua da Pessoa",
    "cep": "CEP da Pessoa",
    "numero": "Número da Pessoa",
    "cidade": "Cidade da Pessoa"
  }
  ```

#### Listar Endereços da Pessoa

- **URL:** `/enderecos/pessoa/{pessoaId}`
- **Método:** GET
- **Descrição:** Lista todos os endereços de uma pessoa pelo ID da pessoa.
- **Resposta de Sucesso (JSON):** Uma lista de objetos de endereço.

#### Definir Endereço Principal da Pessoa

- **URL:** `/pessoas/{pessoaId}/endereco/{enderecoId}/principal`
- **Método:** PUT
- **Descrição:** Define o endereço principal de uma pessoa.
- **Resposta de Sucesso (JSON):**
  ```json
  {
    "id": 1,
    "logradouro": "Rua Principal",
    "cep": "CEP Principal",
    "numero": "Número Principal",
    "cidade": "Cidade Principal",
    "principal": true
  }
  ```

## Exemplos de Uso

### Criar uma Pessoa

```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "nome": "João Silva",
  "dataNascimento": "1990-05-15"
}' http://localhost:8080/pessoas
```

### Editar uma Pessoa

```bash
curl -X PUT -H "Content-Type: application/json" -d '{
  "nome": "Maria Santos",
  "dataNascimento": "1985-09-20"
}' http://localhost:8080/pessoas/1
```

### Consultar uma Pessoa

```bash
curl http://localhost:8080/pessoas/1
```

### Listar Pessoas

```bash
curl http://localhost:8080/pessoas
```

### Criar um Endereço para Pessoa

```bash
curl -X POST -H "Content-Type: application/json" -d '{
  "logradouro": "Rua A",
  "cep": "12345-678",
  "numero": "123",
  "cidade": "Cidade A"
}' http://localhost:8080/enderecos
```

### Listar Endereços da Pessoa

```bash
curl http://localhost:8080/enderecos/pessoa/1
```

### Definir Endereço Principal da Pessoa

```bash
curl -X PUT http://localhost:8080/pessoas/1/endereco/2/principal
```

## Tecnologias Utilizadas

- Spring Boot
- H2 Database
- Java 17

## Executando a Aplicação

Para executar a aplicação, siga os seguintes passos:

1. Clone o repositório do GitHub:

   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd seu-repositorio
   ```

3. Execute a aplicação Spring Boot:

   ```bash
   ./mvnw spring-boot:run
   ```

Agora a API estará em execução e você poderá acessar os endpoints conforme necessário.

Lembre-se de configurar corretamente as credenciais do GitHub para evitar problemas de autenticação ao clonar o repositório.
