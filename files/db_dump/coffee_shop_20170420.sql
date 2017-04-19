-- MySQL dump 10.16  Distrib 10.1.19-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: localhost
-- ------------------------------------------------------
-- Server version	10.1.19-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `business_rules`
--

DROP TABLE IF EXISTS `business_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_rules` (
  `property` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `value` int(11) NOT NULL,
  PRIMARY KEY (`property`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_rules`
--

LOCK TABLES `business_rules` WRITE;
/*!40000 ALTER TABLE `business_rules` DISABLE KEYS */;
INSERT INTO `business_rules` VALUES ('delivery',200),('free_cup',5),('free_delivery',1000);
/*!40000 ALTER TABLE `business_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `buyer`
--

DROP TABLE IF EXISTS `buyer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `buyer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `patronymic` varchar(30) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(90) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `name` (`first_name`(10),`last_name`(10),`patronymic`(10))
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `buyer`
--

LOCK TABLES `buyer` WRITE;
/*!40000 ALTER TABLE `buyer` DISABLE KEYS */;
INSERT INTO `buyer` VALUES (1,'Иван','Иванов','Иванович','Берлин, Жукова, 45'),(10,'Test_n','Test_sn','Test_pt','Address_test'),(12,'Donald','Duck','','Paris, Disney Land'),(18,'Гена','Крокодил','Рептилия','Река Амазонка');
/*!40000 ALTER TABLE `buyer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goods`
--

DROP TABLE IF EXISTS `goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name_en` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `name_ru` varchar(90) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `disabled` char(1) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goods`
--

LOCK TABLES `goods` WRITE;
/*!40000 ALTER TABLE `goods` DISABLE KEYS */;
INSERT INTO `goods` VALUES (1,'Test Coffee Sort 1','Тест Кофе Сорт 1',50,'Y'),(2,'Test Coffee Sort 2','Тест Кофе Сорт 2',100,'N'),(3,'Test Coffee Sort 3','Тест Кофе Сорт 3',150,'N'),(4,'Test Coffee Sort 4','Тест Кофе Сорт 4',200,'N'),(5,'Test Coffee Sort 5','Тест Кофе Сорт 5',250,'N'),(6,'Test Coffee Sort 6','Тест Кофе Сорт 6',200,'N'),(7,'Test Coffee Sort 7','Тест Кофе Сорт 7',180,'N'),(8,'Test Coffee Sort 8','Тест Кофе Сорт 8',160,'N');
/*!40000 ALTER TABLE `goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `localization`
--

DROP TABLE IF EXISTS `localization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `localization` (
  `attribute` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `en` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `ru` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  KEY `attr` (`attribute`(15))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `localization`
--

LOCK TABLES `localization` WRITE;
/*!40000 ALTER TABLE `localization` DISABLE KEYS */;
INSERT INTO `localization` VALUES ('homeButton','home','домой'),('appealMakeOrder','Please, make order','Пожалуйста, сделайте заказ'),('shopName','Coffee Shop','Кофейная лавка'),('firstName','First name','Имя'),('lastName','Last Name','Фамилия'),('patronymic','Patronymic','Отчество'),('address','Address','Адрес'),('yourOrder','Your order:','Ваш заказ:'),('confirm','Confirm','Подтвердить'),('coffeeSort','Coffee sort','Сорт кофе'),('price','Price','Цена'),('amount','Amount','Количество'),('cost','Cost','Стоимость'),('summ','Summ:','Сумма:'),('delivery','Delivery:','Доставка:'),('discount','Discount:','Скидка:'),('total','Total:','Всего:'),('each','each','каждая'),('cupFree','cup free','кружка бесплатно'),('order','Order','Заказать'),('messageIncorrectAmount','incorrect amount values were input','введено некорректное значение количества'),('messageNoSelectedSorts','No one sort wasn\'t selected','Ни один сорт не был выбран'),('messageFieldAddressEmpty','Field \"Address\" can\'t be empty or less than 10 symbols ','Поле \"Адрес\" не может быть пустым или содержать менее 10 символов'),('messageOrderProcessingError','Order processing error...Try again','Возникла ошибка при обработке заказа... Попробуйте снова.'),('messageOrderAccepted','Your order was accepted','Ваш заказ принят');
/*!40000 ALTER TABLE `localization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_id` int(11) NOT NULL,
  `goods_id` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_index` (`order_id`),
  KEY `order_id` (`order_id`),
  KEY `order_id_2` (`order_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `order_item_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,1,2,7),(2,1,1,2),(3,1,2,3),(7,5,2,3),(8,5,3,2),(9,6,2,3),(10,6,3,5),(11,6,4,1),(17,12,4,10);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` datetime NOT NULL,
  `buyer_id` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `delivery` int(11) NOT NULL,
  `cost` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `buyer` (`buyer_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`buyer_id`) REFERENCES `buyer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2017-04-14 21:52:00',1,100,200,800),(5,'2017-04-16 22:23:33',10,0,200,800),(6,'2017-04-17 22:41:36',12,-150,0,1100),(12,'2017-04-18 15:23:16',18,-400,0,1600);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-20  0:13:12
