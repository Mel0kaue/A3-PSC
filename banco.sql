#criar o database com o nome de bd_a3
CREATE DATABASE IF NOT EXIST bda3;

#entrar no banco bd_a3
USE bd_a3;

#remove as tabelas para serem criadas
drop table if exists tb_ferramentas;
drop table if exists tb_amigos;
drop table if exists tb_emprestimos;

CREATE DATABASE IF NOT EXIST bd_a3;

USE bd_a3;

CREATE TABLE IF NOT EXISTS bd_a3.tb_ferramentas (
    ID INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    marca VARCHAR(100) NOT NULL,
    custo DECIMAL(10,2) NOT NULL,
    PRIMARY KEY (ID),
    UNIQUE INDEX id_UNIQUE (ID ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 34
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci

CREATE TABLE IF NOT EXISTS bd_a3.tb_amigos (
    ID INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    PRIMARY KEY (ID),
    UNIQUE INDEX ID_UNIQUE (ID ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 14
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci

CREATE TABLE IF NOT EXISTS bd_a3.tb_emprestimos (
    ID INT UNSIGNED NOT NULL AUTO_INCREMENT,
    amigo VARCHAR(100) NOT NULL,
    ferramenta VARCHAR(100) NOT NULL,
    Status VARCHAR(100) NOT NULL,
    data DATE NULL DEFAULT NULL,
    PRIMARY KEY (ID),
    UNIQUE INDEX ID_UNIQUE (ID ASC) VISIBLE)
    ENGINE = InnoDB
    AUTO_INCREMENT = 22
    DEFAULT CHARACTER SET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci