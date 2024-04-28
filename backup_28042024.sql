CREATE DATABASE  IF NOT EXISTS `migibi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `migibi`;
-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: migibi
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `cat_alimento`
--

DROP TABLE IF EXISTS `cat_alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat_alimento` (
  `Id_Alimento` int NOT NULL AUTO_INCREMENT,
  `Id_Tipo_Alimento` int NOT NULL,
  `Alimento` varchar(250) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  `Es_Perecedero` tinyint(1) NOT NULL DEFAULT (true),
  PRIMARY KEY (`Id_Alimento`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Tipo_Alimento` (`Id_Tipo_Alimento`),
  CONSTRAINT `cat_alimento_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_alimento_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_alimento_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_alimento_ibfk_4` FOREIGN KEY (`Id_Tipo_Alimento`) REFERENCES `cat_tipo_alimento` (`Id_Tipo_Alimento`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_alimento`
--

LOCK TABLES `cat_alimento` WRITE;
/*!40000 ALTER TABLE `cat_alimento` DISABLE KEYS */;
INSERT INTO `cat_alimento` VALUES (1,5,'Huevos',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,1),(2,7,'Frijoles bayos',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,1),(3,1,'Calabacita',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,1),(4,9,'Sal con ajo en polvo',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `cat_alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_tipo_alimento`
--

DROP TABLE IF EXISTS `cat_tipo_alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat_tipo_alimento` (
  `Id_Tipo_Alimento` int NOT NULL AUTO_INCREMENT,
  `Tipo_Alimento` varchar(250) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  PRIMARY KEY (`Id_Tipo_Alimento`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  CONSTRAINT `cat_tipo_alimento_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_tipo_alimento_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_tipo_alimento_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_tipo_alimento`
--

LOCK TABLES `cat_tipo_alimento` WRITE;
/*!40000 ALTER TABLE `cat_tipo_alimento` DISABLE KEYS */;
INSERT INTO `cat_tipo_alimento` VALUES (1,'Vegetal',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(2,'Fruta',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(3,'Carne y pescado',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(4,'Lacteo',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(5,'Otro de origen animal',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(6,'Cereal',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(7,'Legumbre',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(8,'Bebida',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(9,'Especia',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL),(10,'Azúcares y grasas',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL);
/*!40000 ALTER TABLE `cat_tipo_alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_tipo_consumo`
--

DROP TABLE IF EXISTS `cat_tipo_consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat_tipo_consumo` (
  `Id_Tipo_Consumo` int NOT NULL AUTO_INCREMENT,
  `Tipo_Consumo` varchar(250) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Tipo_Consumo`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  CONSTRAINT `cat_tipo_consumo_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_tipo_consumo_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_tipo_consumo_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_tipo_consumo`
--

LOCK TABLES `cat_tipo_consumo` WRITE;
/*!40000 ALTER TABLE `cat_tipo_consumo` DISABLE KEYS */;
INSERT INTO `cat_tipo_consumo` VALUES (1,'Desayuno',1,1,'2024-04-28 02:33:38',NULL,NULL,NULL,NULL),(2,'Comida',1,1,'2024-04-28 02:33:38',NULL,NULL,NULL,NULL),(3,'Cena',1,1,'2024-04-28 02:33:38',NULL,NULL,NULL,NULL),(4,'Snack',1,1,'2024-04-28 02:33:38',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cat_tipo_consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cat_unidad_medida`
--

DROP TABLE IF EXISTS `cat_unidad_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cat_unidad_medida` (
  `Id_Unidad_Medida` int NOT NULL AUTO_INCREMENT,
  `Unidad_Medida` varchar(50) NOT NULL,
  `Abreviatura` varchar(5) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Unidad_Medida`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  CONSTRAINT `cat_unidad_medida_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_unidad_medida_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `cat_unidad_medida_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_unidad_medida`
--

LOCK TABLES `cat_unidad_medida` WRITE;
/*!40000 ALTER TABLE `cat_unidad_medida` DISABLE KEYS */;
INSERT INTO `cat_unidad_medida` VALUES (1,'litro','L',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(2,'mililitro','ml',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(3,'taza','tz',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(4,'unidad','',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(5,'cucharada','cda',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(6,'cucharadita','cdta',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(7,'taza','tz',1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `cat_unidad_medida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `Id_Compras` int NOT NULL AUTO_INCREMENT,
  `Id_Usuario_Compra` int NOT NULL,
  `Id_Unidad_Medida` int NOT NULL,
  `Fecha_Compra` datetime NOT NULL,
  `Cantidad` decimal(10,0) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Compras`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Usuario_Compra` (`Id_Usuario_Compra`),
  KEY `Id_Unidad_Medida` (`Id_Unidad_Medida`),
  CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `compras_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `compras_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `compras_ibfk_4` FOREIGN KEY (`Id_Usuario_Compra`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `compras_ibfk_5` FOREIGN KEY (`Id_Unidad_Medida`) REFERENCES `cat_unidad_medida` (`Id_Unidad_Medida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consumo`
--

DROP TABLE IF EXISTS `consumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consumo` (
  `Id_Consumo` int NOT NULL AUTO_INCREMENT,
  `Id_Receta` int NOT NULL,
  `Id_Usuario_Receta` int NOT NULL,
  `Fecha_Consumo` datetime NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Consumo`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Receta` (`Id_Receta`),
  CONSTRAINT `consumo_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `consumo_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `consumo_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `consumo_ibfk_4` FOREIGN KEY (`Id_Receta`) REFERENCES `receta` (`Id_Receta`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consumo`
--

LOCK TABLES `consumo` WRITE;
/*!40000 ALTER TABLE `consumo` DISABLE KEYS */;
/*!40000 ALTER TABLE `consumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta`
--

DROP TABLE IF EXISTS `receta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta` (
  `Id_Receta` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(250) NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Receta`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  CONSTRAINT `receta_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta`
--

LOCK TABLES `receta` WRITE;
/*!40000 ALTER TABLE `receta` DISABLE KEYS */;
INSERT INTO `receta` VALUES (1,'Cazuela de Huevo con Calabacitas y Frijoles',1,1,'2024-04-28 01:30:24',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `receta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_detalle`
--

DROP TABLE IF EXISTS `receta_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta_detalle` (
  `Id_Receta_Detalle` int NOT NULL AUTO_INCREMENT,
  `Id_Receta` int NOT NULL,
  `Id_Unidad_Medida` int NOT NULL,
  `Cantidad` decimal(10,0) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  `Id_Alimento` int NOT NULL,
  PRIMARY KEY (`Id_Receta_Detalle`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Receta` (`Id_Receta`),
  KEY `Id_Unidad_Medida` (`Id_Unidad_Medida`),
  KEY `Id_Alimento_2` (`Id_Alimento`),
  CONSTRAINT `Id_Alimento_2` FOREIGN KEY (`Id_Alimento`) REFERENCES `cat_alimento` (`Id_Alimento`),
  CONSTRAINT `receta_detalle_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_detalle_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_detalle_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_detalle_ibfk_4` FOREIGN KEY (`Id_Receta`) REFERENCES `receta` (`Id_Receta`),
  CONSTRAINT `receta_detalle_ibfk_6` FOREIGN KEY (`Id_Unidad_Medida`) REFERENCES `cat_unidad_medida` (`Id_Unidad_Medida`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_detalle`
--

LOCK TABLES `receta_detalle` WRITE;
/*!40000 ALTER TABLE `receta_detalle` DISABLE KEYS */;
INSERT INTO `receta_detalle` VALUES (1,1,4,4,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,1),(2,1,6,1,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,4),(3,1,7,1,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,2),(4,1,4,2,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL,3);
/*!40000 ALTER TABLE `receta_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receta_instrucciones`
--

DROP TABLE IF EXISTS `receta_instrucciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receta_instrucciones` (
  `Id_Receta_Instrucciones` int NOT NULL AUTO_INCREMENT,
  `Id_Receta` int NOT NULL,
  `Instruccion` varchar(3000) NOT NULL,
  `Orden` int NOT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Receta_Instrucciones`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Receta` (`Id_Receta`),
  CONSTRAINT `receta_instrucciones_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_instrucciones_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_instrucciones_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `receta_instrucciones_ibfk_4` FOREIGN KEY (`Id_Receta`) REFERENCES `receta` (`Id_Receta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receta_instrucciones`
--

LOCK TABLES `receta_instrucciones` WRITE;
/*!40000 ALTER TABLE `receta_instrucciones` DISABLE KEYS */;
INSERT INTO `receta_instrucciones` VALUES (1,1,'Corta las calabacitas en cuartos',1,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(2,1,'Mezcla el huevo con la sal con ajo y concina hasta que el huevo esté dorado ligeramente',2,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(3,1,'Agrega los frijoles con las calabacitas y cocina a fuego bajo por 9 minutos más',3,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL),(4,1,'Sirve y disfruta',4,1,1,'2024-04-28 02:34:41',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `receta_instrucciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `Id_Stock` int NOT NULL AUTO_INCREMENT,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  PRIMARY KEY (`Id_Stock`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `stock_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock_detalle`
--

DROP TABLE IF EXISTS `stock_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_detalle` (
  `Id_Stock_Detalle` int NOT NULL AUTO_INCREMENT,
  `Id_Tipo_Alimento` int NOT NULL,
  `Id_Unidad_Medida` int NOT NULL,
  `Cantidad` decimal(10,0) DEFAULT NULL,
  `Activo` tinyint(1) NOT NULL DEFAULT (1),
  `Id_Usuario_Alta` int NOT NULL,
  `Fecha_Alta` datetime NOT NULL,
  `Id_Usuario_Modif` int DEFAULT NULL,
  `Fecha_Modif` datetime DEFAULT NULL,
  `Id_Usuario_Baja` int DEFAULT NULL,
  `Fecha_Baja` datetime DEFAULT NULL,
  `Total` decimal(10,0) NOT NULL DEFAULT (0),
  `Cantidad_Consumida` decimal(10,0) NOT NULL DEFAULT (0),
  `Fecha_Caducidad` datetime DEFAULT NULL,
  `Es_Perecedero` tinyint(1) NOT NULL DEFAULT (true),
  `Id_Alimento` int NOT NULL,
  PRIMARY KEY (`Id_Stock_Detalle`),
  KEY `Id_Usuario_Alta` (`Id_Usuario_Alta`),
  KEY `Id_Usuario_Modif` (`Id_Usuario_Modif`),
  KEY `Id_Usuario_Baja` (`Id_Usuario_Baja`),
  KEY `Id_Tipo_Alimento` (`Id_Tipo_Alimento`),
  KEY `Id_Unidad_Medida` (`Id_Unidad_Medida`),
  KEY `Id_Alimento` (`Id_Alimento`),
  CONSTRAINT `Id_Alimento` FOREIGN KEY (`Id_Alimento`) REFERENCES `cat_alimento` (`Id_Alimento`),
  CONSTRAINT `stock_detalle_ibfk_1` FOREIGN KEY (`Id_Usuario_Alta`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `stock_detalle_ibfk_2` FOREIGN KEY (`Id_Usuario_Modif`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `stock_detalle_ibfk_3` FOREIGN KEY (`Id_Usuario_Baja`) REFERENCES `usuario` (`Id_Usuario`),
  CONSTRAINT `stock_detalle_ibfk_4` FOREIGN KEY (`Id_Tipo_Alimento`) REFERENCES `cat_tipo_alimento` (`Id_Tipo_Alimento`),
  CONSTRAINT `stock_detalle_ibfk_5` FOREIGN KEY (`Id_Unidad_Medida`) REFERENCES `cat_unidad_medida` (`Id_Unidad_Medida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_detalle`
--

LOCK TABLES `stock_detalle` WRITE;
/*!40000 ALTER TABLE `stock_detalle` DISABLE KEYS */;
/*!40000 ALTER TABLE `stock_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Id_Usuario` int NOT NULL AUTO_INCREMENT,
  `Nombre_Usuario` varchar(250) NOT NULL,
  `Contraseña` varchar(250) NOT NULL,
  `Cohabitantes` int NOT NULL DEFAULT (1),
  PRIMARY KEY (`Id_Usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Admin','123456789',1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vw_stock_detalle`
--

DROP TABLE IF EXISTS `vw_stock_detalle`;
/*!50001 DROP VIEW IF EXISTS `vw_stock_detalle`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vw_stock_detalle` AS SELECT 
 1 AS `Id_Stock_Detalle`,
 1 AS `Id_Alimento`,
 1 AS `Id_Tipo_Alimento`,
 1 AS `Id_Unidad_Medida`,
 1 AS `Cantidad`,
 1 AS `Activo`,
 1 AS `Total`,
 1 AS `Cantidad_Consumida`,
 1 AS `Fecha_Caducidad`,
 1 AS `Es_Perecedero`,
 1 AS `Alimento`,
 1 AS `Tipo_Alimento`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vw_stock_detalle`
--

/*!50001 DROP VIEW IF EXISTS `vw_stock_detalle`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vw_stock_detalle` AS select `sd`.`Id_Stock_Detalle` AS `Id_Stock_Detalle`,`sd`.`Id_Alimento` AS `Id_Alimento`,`sd`.`Id_Tipo_Alimento` AS `Id_Tipo_Alimento`,`sd`.`Id_Unidad_Medida` AS `Id_Unidad_Medida`,`sd`.`Cantidad` AS `Cantidad`,`sd`.`Activo` AS `Activo`,`sd`.`Total` AS `Total`,`sd`.`Cantidad_Consumida` AS `Cantidad_Consumida`,`sd`.`Fecha_Caducidad` AS `Fecha_Caducidad`,`sd`.`Es_Perecedero` AS `Es_Perecedero`,`ca`.`Alimento` AS `Alimento`,`cta`.`Tipo_Alimento` AS `Tipo_Alimento` from ((`stock_detalle` `sd` join `cat_alimento` `ca` on((`ca`.`Id_Alimento` = `sd`.`Id_Alimento`))) join `cat_tipo_alimento` `cta` on((`cta`.`Id_Tipo_Alimento` = `ca`.`Id_Tipo_Alimento`))) where ((`sd`.`Activo` = true) and (`sd`.`Total` > 0)) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-28  2:41:07
