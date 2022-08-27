-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.19 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             10.3.0.5771
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for sf_doboj_senzorski_podaci
CREATE DATABASE IF NOT EXISTS `sf_doboj_senzorski_podaci` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sf_doboj_senzorski_podaci`;

-- Dumping structure for table sf_doboj_senzorski_podaci.category
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT '0',
  `excerpt` varchar(1024) NOT NULL DEFAULT '0',
  `value1` varchar(32) DEFAULT NULL,
  `value2` varchar(32) DEFAULT NULL,
  `value3` varchar(32) DEFAULT NULL,
  `value4` varchar(32) DEFAULT NULL,
  `value5` varchar(32) DEFAULT NULL,
  `value6` varchar(32) DEFAULT NULL,
  `value7` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sf_doboj_senzorski_podaci.category: ~2 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`category_id`, `name`, `excerpt`, `value1`, `value2`, `value3`, `value4`, `value5`, `value6`, `value7`) VALUES
	(1, 'Temperatura i vlaznost', 'Temperatura i vlaznost na arduino senzorima', 'Temperatura', 'Vlaznost', NULL, NULL, NULL, NULL, NULL),
	(2, 'Snimanje dronom', 'Kapacitet saobracaja u ulici Svetog Save recimo', 'Broj auta', 'Broj pjesaka', NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table sf_doboj_senzorski_podaci.data
CREATE TABLE IF NOT EXISTS `data` (
  `data_id` int unsigned NOT NULL AUTO_INCREMENT,
  `value1` double unsigned NOT NULL DEFAULT '0',
  `value2` double unsigned NOT NULL DEFAULT '0',
  `value3` double unsigned NOT NULL DEFAULT '0',
  `value4` double unsigned NOT NULL DEFAULT '0',
  `value5` double unsigned NOT NULL DEFAULT '0',
  `value6` double unsigned NOT NULL DEFAULT '0',
  `value7` double unsigned NOT NULL DEFAULT '0',
  `category_id` int unsigned DEFAULT '0',
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`data_id`),
  KEY `fk_podatak_kategorija_id` (`category_id`),
  CONSTRAINT `fk_podatak_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sf_doboj_senzorski_podaci.data: ~23 rows (approximately)
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
INSERT INTO `data` (`data_id`, `value1`, `value2`, `value3`, `value4`, `value5`, `value6`, `value7`, `category_id`, `created_at`) VALUES
	(1, 3.74, 27.9, 0, 0, 0, 0, 0, NULL, '2022-01-09 20:56:24'),
	(2, 3.74, 27.1, 0, 0, 0, 0, 0, NULL, NULL),
	(3, 3.91, 26.43, 0, 0, 0, 0, 0, 1, NULL),
	(4, 3.91, 26.49, 0, 0, 0, 0, 0, 1, NULL),
	(5, 3.91, 29.19, 0, 0, 0, 0, 0, 1, NULL),
	(10, 2.74, 28.9, 0, 0, 0, 0, 0, 1, '2022-01-10 22:01:21'),
	(11, 4.9, 28.42, 0, 0, 0, 0, 0, NULL, '2022-01-12 23:21:45'),
	(12, 4.9, 28.42, 0, 0, 0, 0, 0, 1, '2022-01-12 23:21:57'),
	(13, 4.9, 28.44, 0, 0, 0, 0, 0, 1, '2022-01-12 23:22:10'),
	(14, 2.1, 28.24, 0, 0, 0, 0, 0, 1, '2022-01-12 23:24:50'),
	(15, 2.1, 28.14, 0, 0, 0, 0, 0, 1, '2022-01-13 00:28:26'),
	(16, 24, 3, 0, 0, 0, 0, 0, 1, '2022-01-19 17:24:57'),
	(17, 25.2, 3.1, 0, 0, 0, 0, 0, 1, '2022-01-19 17:25:34'),
	(18, 25.2, 3.4, 0, 0, 0, 0, 0, 1, '2022-01-19 17:25:38'),
	(19, 25.9, 3.5, 0, 0, 0, 0, 0, 1, '2022-01-19 17:25:46'),
	(20, 25.9, 3.51, 0, 0, 0, 0, 0, 1, '2022-01-19 17:25:48'),
	(21, 28.1, 2.85, 0, 0, 0, 0, 0, 1, '2022-01-19 17:26:26'),
	(22, 28.1, 2.89, 0, 0, 0, 0, 0, 1, '2022-01-19 17:26:30'),
	(23, 31.1, 3.2, 0, 0, 0, 0, 0, 1, '2022-01-19 17:27:45'),
	(24, 32.1, 3.2, 0, 0, 0, 0, 0, 1, '2022-01-19 17:27:51'),
	(25, 31.18, 3.2, 0, 0, 0, 0, 0, 1, '2022-01-19 17:27:59'),
	(26, 31.18, 3.22, 0, 0, 0, 0, 0, 1, '2022-02-10 18:03:26'),
	(27, 31.18, 1.19, 0, 0, 0, 0, 0, 1, '2022-02-10 18:19:32'),
	(28, 31.18, 1.19, 0, 0, 0, 0, 0, 1, '2022-02-10 18:30:01'),
	(29, 19.18, 1.38, 0, 0, 0, 0, 0, 1, '2022-02-10 18:34:10');
/*!40000 ALTER TABLE `data` ENABLE KEYS */;

-- Dumping structure for table sf_doboj_senzorski_podaci.user
CREATE TABLE IF NOT EXISTS `user` (
  `administrator_id` int unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL DEFAULT '0',
  `password` varchar(256) NOT NULL DEFAULT '0',
  `role` varchar(16) NOT NULL DEFAULT 'administrator',
  PRIMARY KEY (`administrator_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table sf_doboj_senzorski_podaci.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`administrator_id`, `username`, `password`, `role`) VALUES
	(1, 'administrator', '$2a$10$Mq6C/TMFoNzx4c/d/kXxTO4moQc5kpR6I9bQikMetUzejQsj/07su', 'administrator');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
