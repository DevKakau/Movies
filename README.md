# 🎬 Gerenciamento de Filmes com Banco de Dados

## 📌 Descrição
Este é um projeto de gerenciamento de filmes desenvolvido em **Java** com **JDBC** para interagir com um banco de dados relacional. O sistema permite realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados, possibilitando o cadastro, consulta, atualização e remoção de filmes.

## 🚀 Funcionalidades
- 📌 **Inserir** um novo filme no banco de dados
- ✏️ **Atualizar** informações de um filme existente
- 🗑️ **Deletar** um filme do banco de dados
- 📋 **Listar todos os filmes** cadastrados
- 🎭 **Listar filmes por gênero**
- 📅 **Listar filmes por ano de lançamento**

## 🛠️ Tecnologias Utilizadas
- **Java** (JDK 8+)
- **JDBC** para conexão com banco de dados
- **MySQL** como banco de dados relacional

## 🗄️ Estrutura do Projeto
```
📂 movie-management
├── 📂 src
│   ├── 📂 br/com/movie/main
│   │   └── Main.java  # Classe principal com menu interativo
│   ├── 📂 br/com/movie/DAO
│   │   └── MovieDAO.java  # Métodos para manipulação do banco de dados
│   ├── 📂 br/com/movie/connection
│   │   └── ConnectionDB.java  # Classe de conexão com o banco de dados
│   ├── 📂 br/com/movie/model
│   └── Movie.java  # Modelo de entidade Filme
```

## 🏗️ Configuração e Execução
### 1️⃣ Clonar o repositório
```bash
git clone https://github.com/seu-usuario/movie-management.git
cd movie-management
```

### 2️⃣ Configurar o banco de dados
Crie um banco de dados no MySQL e execute o seguinte script SQL:
```sql
CREATE DATABASE movie_db;

USE movie_db;

CREATE TABLE movies (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    anolancamento INT NOT NULL,
    genero VARCHAR(100) NOT NULL,
    duracao INT NOT NULL
);
```

### 3️⃣ Configurar a conexão com o banco
No arquivo `ConnectionDB.java`, altere as credenciais conforme o seu ambiente:
```java
private static final String URL = "jdbc:mysql://localhost:3306/movie_db";
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";
```

### 4️⃣ Executar o projeto
- Se estiver usando uma IDE (IntelliJ, Eclipse, VS Code), basta rodar a classe `Main.java`.
- Se preferir rodar pelo terminal:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="br.com.movie.main.Main"
```

## 📌 Melhorias Futuras
- ✅ Implementar interface gráfica (JavaFX ou Swing)
- ✅ Melhorar a validação das entradas do usuário
- ✅ Criar testes unitários para as operações do `MovieDAO`
- ✅ Adicionar suporte para mais bancos de dados (PostgreSQL, SQLite)

## 📄 Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---
Desenvolvido com ❤️ por Kauã Wikleff(https://github.com/DevKakau) 🚀

