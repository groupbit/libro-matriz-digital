-- MySQL dump 10.16  Distrib 10.1.38-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: libroMatrizDigital
-- ------------------------------------------------------
-- Server version	10.1.38-MariaDB-0ubuntu0.18.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `id` int(11) NOT NULL,
  `actividad` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `estadoCivil` varchar(255) DEFAULT NULL,
  `familiaresACargo` varchar(255) DEFAULT NULL,
  `fechaDeNacimiento` date DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `hijos` int(11) NOT NULL,
  `horarioHabitual` time DEFAULT NULL,
  `lugarDeNacimiento` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `obraSocial` varchar(255) DEFAULT NULL,
  `propietarioTelefonoAlternativo` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `telefonoAlternativo` varchar(255) DEFAULT NULL,
  `trabaja` bit(1) NOT NULL,
  `carrera_id` int(11) DEFAULT NULL,
  `direccion_id` int(11) DEFAULT NULL,
  `titulo_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK86hueaus40jscj8n9txjvb3ur` (`carrera_id`),
  KEY `FK4e74jwq75t2vtgfxr8tle7oli` (`direccion_id`),
  KEY `FKh8hbo7sluc7fqwjr06jf34tyq` (`titulo_id`),
  CONSTRAINT `FK4e74jwq75t2vtgfxr8tle7oli` FOREIGN KEY (`direccion_id`) REFERENCES `Direccion` (`id`),
  CONSTRAINT `FK86hueaus40jscj8n9txjvb3ur` FOREIGN KEY (`carrera_id`) REFERENCES `Carrera` (`id`),
  CONSTRAINT `FKh8hbo7sluc7fqwjr06jf34tyq` FOREIGN KEY (`titulo_id`) REFERENCES `EstudioCursado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Alumno_EstudioCursado`
--

DROP TABLE IF EXISTS `Alumno_EstudioCursado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno_EstudioCursado` (
  `Alumno_id` int(11) NOT NULL,
  `otrosTitulos_id` int(11) NOT NULL,
  UNIQUE KEY `UK_p8eq3w7igqp5k3qlvwedgavdp` (`otrosTitulos_id`),
  KEY `FKllrxo3k1nwslck1916wxp9vsx` (`Alumno_id`),
  CONSTRAINT `FKllrxo3k1nwslck1916wxp9vsx` FOREIGN KEY (`Alumno_id`) REFERENCES `Alumno` (`id`),
  CONSTRAINT `FKthd9l4j9q1ipm813putv4kwe9` FOREIGN KEY (`otrosTitulos_id`) REFERENCES `EstudioCursado` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Animal`
--

DROP TABLE IF EXISTS `Animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Animal` (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Carrera`
--

DROP TABLE IF EXISTS `Carrera`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Carrera` (
  `id` int(11) NOT NULL,
  `archivada` bit(1) DEFAULT NULL,
  `duracion` float NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `resolucion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Cursada`
--

DROP TABLE IF EXISTS `Cursada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cursada` (
  `id` int(11) NOT NULL,
  `anio` int(11) NOT NULL,
  `estado` int(11) DEFAULT NULL,
  `notaFinal` int(11) NOT NULL,
  `materia_id` int(11) DEFAULT NULL,
  `alumno_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrx8i1y7ks8l93bvnfbn00pgiv` (`materia_id`),
  KEY `FKsrw2yi8py0x3ular6dk34v5jx` (`alumno_id`),
  CONSTRAINT `FKrx8i1y7ks8l93bvnfbn00pgiv` FOREIGN KEY (`materia_id`) REFERENCES `Materia` (`id`),
  CONSTRAINT `FKsrw2yi8py0x3ular6dk34v5jx` FOREIGN KEY (`alumno_id`) REFERENCES `Alumno` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Direccion`
--

DROP TABLE IF EXISTS `Direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Direccion` (
  `id` int(11) NOT NULL,
  `altura` int(11) NOT NULL,
  `calle` varchar(255) DEFAULT NULL,
  `codigoPostal` varchar(255) DEFAULT NULL,
  `departamento` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `partido` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `EstudioCursado`
--

DROP TABLE IF EXISTS `EstudioCursado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EstudioCursado` (
  `id` int(11) NOT NULL,
  `anioEgreso` int(11) NOT NULL,
  `distrito` varchar(255) DEFAULT NULL,
  `institucion` varchar(255) DEFAULT NULL,
  `nombreTitulo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Examen`
--

DROP TABLE IF EXISTS `Examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Examen` (
  `id` int(11) NOT NULL,
  `ausente` bit(1) NOT NULL,
  `calificacion` float NOT NULL,
  `tipoDeExamen` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Materia`
--

DROP TABLE IF EXISTS `Materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materia` (
  `id` int(11) NOT NULL,
  `anioEnCarrera` int(11) NOT NULL,
  `docente` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `promocionable` bit(1) DEFAULT NULL,
  `carrera_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs5rc95ma6734n72byjss18x0j` (`carrera_id`),
  CONSTRAINT `FKs5rc95ma6734n72byjss18x0j` FOREIGN KEY (`carrera_id`) REFERENCES `Carrera` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Materia_Materia`
--

DROP TABLE IF EXISTS `Materia_Materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materia_Materia` (
  `Materia_id` int(11) NOT NULL,
  `correlativas_id` int(11) NOT NULL,
  KEY `FKmi92jg4sj1xh2o1xhlt2xcj1r` (`correlativas_id`),
  KEY `FK4ouvg8ndn5lv5aq4vt9brcc6p` (`Materia_id`),
  CONSTRAINT `FK4ouvg8ndn5lv5aq4vt9brcc6p` FOREIGN KEY (`Materia_id`) REFERENCES `Materia` (`id`),
  CONSTRAINT `FKmi92jg4sj1xh2o1xhlt2xcj1r` FOREIGN KEY (`correlativas_id`) REFERENCES `Materia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-20 19:20:49
