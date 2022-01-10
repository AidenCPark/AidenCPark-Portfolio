-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: propertymanagement
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `emailthreads`
--

DROP TABLE IF EXISTS `emailthreads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `emailthreads` (
  `thread_id` int NOT NULL AUTO_INCREMENT,
  `renter_un` varchar(150) NOT NULL,
  `landlord_un` varchar(150) NOT NULL,
  PRIMARY KEY (`thread_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `emailthreads`
--

LOCK TABLES `emailthreads` WRITE;
/*!40000 ALTER TABLE `emailthreads` DISABLE KEYS */;
/*!40000 ALTER TABLE `emailthreads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `parameter` varchar(150) NOT NULL,
  `value` double NOT NULL,
  PRIMARY KEY (`parameter`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES ('fee',50),('period',30);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `id` int NOT NULL AUTO_INCREMENT,
  `propOwner` varchar(150) NOT NULL,
  `propType` enum('Apartment','Attached_House','Detached_House','Townhouse','Condo') NOT NULL,
  `numberOfBedrooms` int NOT NULL,
  `numberOfBathrooms` int NOT NULL,
  `furnished` tinyint(1) NOT NULL,
  `quadrant` enum('NE','NW','SE','SW') NOT NULL,
  `price` double NOT NULL,
  `propStatus` enum('active','rented','cancelled','suspended') NOT NULL,
  `fee` double NOT NULL,
  `feeDue` timestamp NOT NULL,
  `feePaid` tinyint(1) NOT NULL,
  `listDate` timestamp NOT NULL,
  `rentDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `propOwner_idx` (`propOwner`),
  CONSTRAINT `propOwner` FOREIGN KEY (`propOwner`) REFERENCES `registeredusers` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1,'APark','Apartment',2,2,1,'NE',30000,'rented',50,'2022-02-17 06:59:59',1,'2021-11-06 00:19:03','2021-12-10 21:40:27'),(2,'LLord','Condo',1,1,0,'SW',15000,'active',50,'2021-12-31 06:59:59',1,'2021-10-17 00:19:03',NULL),(3,'LLord','Attached_House',3,3,1,'NW',50000,'rented',50,'2022-01-03 06:59:59',1,'2021-11-03 00:19:03','2021-11-27 22:00:03'),(4,'APark','Detached_House',2,3,0,'SE',40000,'active',50,'2021-12-02 06:59:59',1,'2021-10-02 00:19:03',NULL),(5,'APark','Townhouse',2,2,0,'NE',30000,'cancelled',30,'2022-01-09 19:59:43',1,'2021-11-19 01:19:03',NULL),(6,'LLord','Apartment',2,1,1,'SW',25000,'suspended',50,'2021-12-06 06:59:59',0,'2021-11-19 01:19:03',NULL),(7,'APark','Condo',2,2,1,'NW',30000,'rented',30,'2022-01-09 20:01:08',1,'2021-12-09 01:19:03','2021-12-09 19:00:00'),(8,'LLord','Apartment',2,2,1,'NW',50000,'active',50,'2022-01-09 07:00:00',0,'2021-12-10 07:00:00',NULL),(9,'LLord','Townhouse',1,1,1,'NW',20000,'active',50,'2022-01-09 07:00:00',0,'2021-12-10 07:00:00',NULL);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeredusers`
--

DROP TABLE IF EXISTS `registeredusers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registeredusers` (
  `name` varchar(150) NOT NULL,
  `email` varchar(150) NOT NULL,
  `password` varchar(150) NOT NULL,
  `username` varchar(150) NOT NULL,
  `usertype` enum('RENTER','LANDLORD','MANAGER') NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeredusers`
--

LOCK TABLES `registeredusers` WRITE;
/*!40000 ALTER TABLE `registeredusers` DISABLE KEYS */;
INSERT INTO `registeredusers` VALUES ('Aiden','apark@gmail.com','ensf480','APark','LANDLORD'),('Emmanuel','eman@gmail.com','ensf480','EOmariOsei','RENTER'),('Henrique','handras@gmail.com','ensf480','HAndras','MANAGER'),('LL','LL@gmail.com,','ensf480','LLord','LANDLORD'),('Mathew','mpelletier@gmail.com','ensf480','MPelletier','RENTER');
/*!40000 ALTER TABLE `registeredusers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savedsearches`
--

DROP TABLE IF EXISTS `savedsearches`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `savedsearches` (
  `searchID` int NOT NULL AUTO_INCREMENT,
  `propType` enum('Apartment','Attached_House','Detached_House','Townhouse','Condo') DEFAULT NULL,
  `numberOfBedrooms` int DEFAULT NULL,
  `numberOfBathrooms` int DEFAULT NULL,
  `furnished` tinyint(1) DEFAULT NULL,
  `quadrant` enum('NE','NW','SE','SW') DEFAULT NULL,
  `maxPrice` double DEFAULT NULL,
  PRIMARY KEY (`searchID`),
  UNIQUE KEY `searchID_UNIQUE` (`searchID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savedsearches`
--

LOCK TABLES `savedsearches` WRITE;
/*!40000 ALTER TABLE `savedsearches` DISABLE KEYS */;
INSERT INTO `savedsearches` VALUES (8,'Apartment',1,1,NULL,NULL,40000),(9,NULL,2,2,1,'NW',NULL),(10,'Condo',NULL,NULL,NULL,'SW',20000),(11,'Townhouse',2,1,1,'SE',30000),(12,'Attached_House',NULL,NULL,NULL,NULL,NULL),(13,'Apartment',1,1,NULL,'SE',NULL),(14,'Apartment',1,1,NULL,'NE',NULL),(15,NULL,0,0,NULL,NULL,NULL);
/*!40000 ALTER TABLE `savedsearches` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subscriptions`
--

DROP TABLE IF EXISTS `subscriptions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subscriptions` (
  `searchID` int NOT NULL,
  `username` varchar(150) NOT NULL,
  PRIMARY KEY (`searchID`,`username`),
  KEY `Subscriber_idx` (`username`),
  CONSTRAINT `searchID` FOREIGN KEY (`searchID`) REFERENCES `savedsearches` (`searchID`),
  CONSTRAINT `Subscriber` FOREIGN KEY (`username`) REFERENCES `registeredusers` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subscriptions`
--

LOCK TABLES `subscriptions` WRITE;
/*!40000 ALTER TABLE `subscriptions` DISABLE KEYS */;
INSERT INTO `subscriptions` VALUES (10,'EOmariOsei'),(11,'EOmariOsei'),(11,'MPelletier'),(14,'MPelletier'),(15,'MPelletier');
/*!40000 ALTER TABLE `subscriptions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `threadmessages`
--

DROP TABLE IF EXISTS `threadmessages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `threadmessages` (
  `thread_id` int NOT NULL,
  `time` timestamp NOT NULL,
  `Message` text NOT NULL,
  PRIMARY KEY (`thread_id`,`time`),
  CONSTRAINT `threadID` FOREIGN KEY (`thread_id`) REFERENCES `emailthreads` (`thread_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `threadmessages`
--

LOCK TABLES `threadmessages` WRITE;
/*!40000 ALTER TABLE `threadmessages` DISABLE KEYS */;
/*!40000 ALTER TABLE `threadmessages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 22:39:02
