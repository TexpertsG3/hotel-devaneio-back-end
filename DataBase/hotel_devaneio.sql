CREATE DATABASE  IF NOT EXISTS `hotel_devaneio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `hotel_devaneio`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel_devaneio
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `administrador`
--

DROP TABLE IF EXISTS `administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `administrador` (
                                 `id_administrador` int NOT NULL AUTO_INCREMENT,
                                 `nome_admin` varchar(100) NOT NULL,
                                 `senha_admin` varchar(100) NOT NULL,
                                 `id_contato` int NOT NULL,
                                 `id_endereco` int NOT NULL,
                                 PRIMARY KEY (`id_administrador`),
                                 KEY `fk_administrador_contato_idx` (`id_contato`),
                                 KEY `fk_administrador_endereco_idx` (`id_endereco`),
                                 CONSTRAINT `fk_administrador_contato` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id_contato`),
                                 CONSTRAINT `fk_administrador_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
                         `id_cargo` int NOT NULL AUTO_INCREMENT,
                         `nome_cargo` varchar(100) NOT NULL,
                         `descricao_cargo` varchar(255) NOT NULL,
                         PRIMARY KEY (`id_cargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contato`
--

DROP TABLE IF EXISTS `contato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contato` (
                           `id_contato` int NOT NULL AUTO_INCREMENT,
                           `email` varchar(255) NOT NULL,
                           `telefone` varchar(45) NOT NULL,
                           `celular` varchar(45) NOT NULL,
                           PRIMARY KEY (`id_contato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `dados_hotel`
--

DROP TABLE IF EXISTS `dados_hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dados_hotel` (
                               `id_dados_hotel` int NOT NULL AUTO_INCREMENT,
                               `nome` varchar(255) NOT NULL,
                               `cnpj` varchar(14) NOT NULL,
                               `id_contato` int NOT NULL,
                               `id_endereco` int NOT NULL,
                               PRIMARY KEY (`id_dados_hotel`),
                               KEY `fk_dados_hotel_contato_idx` (`id_contato`),
                               KEY `fk_dados_hotel_endereco_idx` (`id_endereco`),
                               CONSTRAINT `fk_dados_hotel_contato` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id_contato`) ON DELETE CASCADE ON UPDATE CASCADE,
                               CONSTRAINT `fk_dados_hotel_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `endereco` (
                            `id_endereco` int NOT NULL AUTO_INCREMENT,
                            `rua` varchar(100) NOT NULL,
                            `bairro` varchar(100) NOT NULL,
                            `numero` int unsigned NOT NULL,
                            `cep` varchar(8) NOT NULL,
                            `cidade` varchar(100) NOT NULL,
                            `uf` varchar(2) NOT NULL,
                            `complemento` varchar(100) NOT NULL,
                            PRIMARY KEY (`id_endereco`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
                               `id_funcionario` int NOT NULL AUTO_INCREMENT,
                               `nome_funcionario` varchar(100) NOT NULL,
                               `sobrenome_funcionario` varchar(100) NOT NULL,
                               `cpf` int NOT NULL,
                               `id_cargo` int NOT NULL,
                               `id_contato` int NOT NULL,
                               `id_endereco` int NOT NULL,
                               `id_hotel` int NOT NULL,
                               PRIMARY KEY (`id_funcionario`),
                               UNIQUE KEY `cpf_UNIQUE` (`cpf`),
                               KEY `fk_funcionario_cargo_idx` (`id_cargo`),
                               KEY `fk_funcionario_contato_idx` (`id_contato`),
                               KEY `fk_funcionario_endereco_idx` (`id_endereco`),
                               KEY `fk_funcionario_id_hotel_idx` (`id_hotel`),
                               CONSTRAINT `fk_funcionario_id_cargo` FOREIGN KEY (`id_cargo`) REFERENCES `cargo` (`id_cargo`),
                               CONSTRAINT `fk_funcionario_id_contato` FOREIGN KEY (`id_contato`) REFERENCES `contato` (`id_contato`),
                               CONSTRAINT `fk_funcionario_id_endereco` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`),
                               CONSTRAINT `fk_funcionario_id_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hospede`
--

DROP TABLE IF EXISTS `hospede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospede` (
                           `id_hospede` int NOT NULL,
                           `nome` varchar(100) NOT NULL,
                           `sobrenome` varchar(100) NOT NULL,
                           `cpf` int NOT NULL,
                           `senha` varchar(25) NOT NULL,
                           `id_contato` int NOT NULL,
                           `id_hotel` int DEFAULT NULL,
                           PRIMARY KEY (`id_hospede`),
                           UNIQUE KEY `cpf_UNIQUE` (`cpf`),
                           KEY `fsdf_idx` (`id_hotel`),
                           CONSTRAINT `fk_hospede_id_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
                         `id_hotel` int NOT NULL AUTO_INCREMENT,
                         `id_dados_hotel` int NOT NULL,
                         PRIMARY KEY (`id_hotel`),
                         UNIQUE KEY `id_dados_hotel_UNIQUE` (`id_dados_hotel`),
                         KEY `fk_hotel_dadosHotel_idx` (`id_dados_hotel`),
                         CONSTRAINT `fk_hotel_dadosHotel` FOREIGN KEY (`id_dados_hotel`) REFERENCES `dados_hotel` (`id_dados_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `promocao`
--

DROP TABLE IF EXISTS `promocao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promocao` (
                            `id_promocao` int NOT NULL AUTO_INCREMENT,
                            `nome_promocao` varchar(100) DEFAULT NULL,
                            `desconto` decimal(10,2) unsigned DEFAULT NULL,
                            `data_inicio` datetime DEFAULT NULL,
                            `data_fim` datetime DEFAULT NULL,
                            PRIMARY KEY (`id_promocao`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `quarto`
--

DROP TABLE IF EXISTS `quarto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quarto` (
                          `id_quarto` int NOT NULL AUTO_INCREMENT,
                          `id_hotel` int NOT NULL,
                          `nome` varchar(255) NOT NULL,
                          `descricao` varchar(255) NOT NULL,
                          `preco` decimal(10,2) unsigned NOT NULL,
                          PRIMARY KEY (`id_quarto`),
                          KEY `fk_quarto_hotel_idx` (`id_hotel`),
                          CONSTRAINT `fk_quarto_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
                           `id_reserva` int NOT NULL AUTO_INCREMENT,
                           `id_hospede` int NOT NULL,
                           `check_in` datetime NOT NULL,
                           `check_out` datetime NOT NULL,
                           `qtd_adultos` int unsigned NOT NULL,
                           `qtd_criancas` int unsigned NOT NULL,
                           `id_quarto` int NOT NULL,
                           `id_hotel` int NOT NULL,
                           `total_servicos` decimal(10,2) unsigned NOT NULL,
                           `total_reserva` decimal(10,2) unsigned NOT NULL,
                           PRIMARY KEY (`id_reserva`),
                           KEY `fk_reserva_quarto_idx` (`id_quarto`),
                           KEY `fk_reserva_hotel_idx` (`id_hotel`),
                           KEY `fk_reserva_hospede_idx` (`id_hospede`),
                           CONSTRAINT `fk_reserva_hospede` FOREIGN KEY (`id_hospede`) REFERENCES `hospede` (`id_hospede`) ON DELETE CASCADE ON UPDATE CASCADE,
                           CONSTRAINT `fk_reserva_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`) ON DELETE CASCADE ON UPDATE CASCADE,
                           CONSTRAINT `fk_reserva_quarto` FOREIGN KEY (`id_quarto`) REFERENCES `quarto` (`id_quarto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva_servico`
--

DROP TABLE IF EXISTS `reserva_servico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva_servico` (
                                   `idreserva_servico` int NOT NULL AUTO_INCREMENT,
                                   `id_reserva` int NOT NULL,
                                   `id_servico_adicional` int NOT NULL,
                                   PRIMARY KEY (`idreserva_servico`),
                                   KEY `fk_reserva_servico_id_reserva_idx` (`id_reserva`),
                                   KEY `fk_reserva_servico_id_servico_adicional_idx` (`id_servico_adicional`),
                                   CONSTRAINT `fk_reserva_servico_id_reserva` FOREIGN KEY (`id_reserva`) REFERENCES `reserva` (`id_reserva`),
                                   CONSTRAINT `fk_reserva_servico_id_servico_adicional` FOREIGN KEY (`id_servico_adicional`) REFERENCES `servico_adicional` (`id_servico_adicional`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servico_adicional`
--

DROP TABLE IF EXISTS `servico_adicional`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servico_adicional` (
                                     `id_servico_adicional` int NOT NULL AUTO_INCREMENT,
                                     `nome` varchar(255) NOT NULL,
                                     `preco` decimal(10,2) unsigned NOT NULL,
                                     `id_hotel` int NOT NULL,
                                     PRIMARY KEY (`id_servico_adicional`),
                                     KEY `fk_servico_adicional_id_hotel_idx` (`id_hotel`) /*!80000 INVISIBLE */,
                                     CONSTRAINT `fk_servico_adicional_id_hotel` FOREIGN KEY (`id_hotel`) REFERENCES `hotel` (`id_hotel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping events for database 'hotel_devaneio'
--

--
-- Dumping routines for database 'hotel_devaneio'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-03-08 22:43:36