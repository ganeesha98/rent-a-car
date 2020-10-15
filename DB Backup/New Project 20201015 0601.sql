-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.30-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema vehicle_rental_app
--

CREATE DATABASE IF NOT EXISTS vehicle_rental_app;
USE vehicle_rental_app;

--
-- Definition of table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `booking_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `booking_vehicle_id` varchar(45) DEFAULT NULL,
  `booking_employee_id` int(10) unsigned DEFAULT '1',
  `booking_status` tinyint(1) unsigned DEFAULT NULL,
  `booking_detail` varchar(450) DEFAULT NULL,
  `booking_targeted_location` varchar(450) DEFAULT NULL,
  `booking_payment_type` varchar(45) DEFAULT NULL,
  `booking_payment_amount` decimal(10,2) DEFAULT '0.00',
  `booking_customer_id` varchar(450) DEFAULT '1',
  PRIMARY KEY (`booking_id`),
  KEY `FK_booking_1` (`booking_vehicle_id`),
  KEY `FK_booking_2` (`booking_employee_id`),
  KEY `FK_booking_3` (`booking_customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booking`
--

/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
INSERT INTO `booking` (`booking_id`,`booking_date`,`booking_vehicle_id`,`booking_employee_id`,`booking_status`,`booking_detail`,`booking_targeted_location`,`booking_payment_type`,`booking_payment_amount`,`booking_customer_id`) VALUES 
 (1,'2020-10-14 18:31:49','WP XY 2088',0,1,'test remark','test  booking address ','CASH','10000.00','amal'),
 (2,'2020-10-15 05:01:28','WP XY 2088',0,1,'test remark','test  booking address ','CASH','5900.00','amal'),
 (3,'2020-10-15 05:06:45','WP XY 2088',0,1,'test remark','test  booking address ','CASH','5900.00','amal');
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;


--
-- Definition of table `customers`
--

DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_name` varchar(450) DEFAULT NULL,
  `customer_email` varchar(450) DEFAULT NULL,
  `customer_contact_no` varchar(45) DEFAULT NULL,
  `customer_address` varchar(450) DEFAULT NULL,
  `customer_status` tinyint(1) unsigned DEFAULT NULL,
  `customer_detail` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers`
--

/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` (`customer_id`,`customer_name`,`customer_email`,`customer_contact_no`,`customer_address`,`customer_status`,`customer_detail`) VALUES 
 (1,'amal','232amal@gmail.com','01171002001','test address',1,'123'),
 (2,'test user','001amal@gmail.com','0117123456','test address 2',0,'123'),
 (3,'test user 3','gachamalki@gmail.com','01171002001','test address 3',1,'123');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;


--
-- Definition of table `drivers`
--

DROP TABLE IF EXISTS `drivers`;
CREATE TABLE `drivers` (
  `driver_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `driver_name` varchar(450) DEFAULT NULL,
  `driver_reg_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `driver_email` varchar(450) DEFAULT NULL,
  `driver_address` varchar(450) DEFAULT NULL,
  `driver_contact` varchar(450) DEFAULT NULL,
  `driver_remark` varchar(45) DEFAULT '1',
  PRIMARY KEY (`driver_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drivers`
--

/*!40000 ALTER TABLE `drivers` DISABLE KEYS */;
INSERT INTO `drivers` (`driver_id`,`driver_name`,`driver_reg_date`,`driver_email`,`driver_address`,`driver_contact`,`driver_remark`) VALUES 
 (1,'bawantha ','2020-10-14 07:09:02','bawa@test.lk','new address','3894593534','0'),
 (2,'mathila','2020-10-14 07:55:43','test@gmail.com','test address  - m','38793589','1'),
 (3,'vidath','2020-10-14 08:41:40','test@gmail.com','test address  - m','38793589','1'),
 (4,'mathila','2020-10-14 08:50:30','test@gmail.com','test address  - m','38793589','0');
/*!40000 ALTER TABLE `drivers` ENABLE KEYS */;


--
-- Definition of table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `employee_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(450) DEFAULT NULL,
  `employee_nic` varchar(45) DEFAULT NULL,
  `employee_category_id` varchar(100) DEFAULT '1' COMMENT '1',
  `employee_address` varchar(450) DEFAULT NULL,
  `employee_contact` varchar(450) DEFAULT NULL,
  `employee_email` varchar(450) DEFAULT NULL,
  `employee_remark` varchar(450) DEFAULT NULL,
  `employee_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

/*!40000 ALTER TABLE `employees` DISABLE KEYS */;
INSERT INTO `employees` (`employee_id`,`employee_name`,`employee_nic`,`employee_category_id`,`employee_address`,`employee_contact`,`employee_email`,`employee_remark`,`employee_status`) VALUES 
 (1,'amal','910532789v','1','test address 1 ','11936537','test@gmail.com','test remark',1),
 (2,'vidath','387468749v','1','test address ','8734684592','test@test.lk',NULL,0),
 (3,NULL,NULL,'1',NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `employees` ENABLE KEYS */;


--
-- Definition of table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
CREATE TABLE `feedbacks` (
  `feedback_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `feedback_comment` varchar(450) DEFAULT NULL,
  `feedback_name` varchar(450) DEFAULT NULL,
  `feedback_email` varchar(450) DEFAULT NULL,
  `feedback_status` tinyint(1) unsigned DEFAULT '1',
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedbacks`
--

/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
INSERT INTO `feedbacks` (`feedback_id`,`feedback_comment`,`feedback_name`,`feedback_email`,`feedback_status`) VALUES 
 (2,'test ncomment ','amal','232amal@gmail.com',1);
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;


--
-- Definition of table `login_detail`
--

DROP TABLE IF EXISTS `login_detail`;
CREATE TABLE `login_detail` (
  `login_detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `login_detail_login_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `login_detail_user_id` int(10) unsigned NOT NULL,
  `login_detail_logout_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `login_detail_status` tinyint(1) unsigned DEFAULT NULL,
  `login_detail_detail` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`login_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_detail`
--

/*!40000 ALTER TABLE `login_detail` DISABLE KEYS */;
INSERT INTO `login_detail` (`login_detail_id`,`login_detail_login_date`,`login_detail_user_id`,`login_detail_logout_date`,`login_detail_status`,`login_detail_detail`) VALUES 
 (121,'2020-10-14 20:50:51',1,'2020-10-14 20:50:51',1,' User gachamalki@gmail.com -  browser Chrome-86.0.4240.75 -  os Windows'),
 (122,'2020-10-15 04:34:41',1,'2020-10-15 04:34:41',1,' User 232amal@gmail.com -  browser Chrome-86.0.4240.75 -  os Windows');
/*!40000 ALTER TABLE `login_detail` ENABLE KEYS */;


--
-- Definition of table `payments`
--

DROP TABLE IF EXISTS `payments`;
CREATE TABLE `payments` (
  `payment_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `payment_ref_no` varchar(45) DEFAULT NULL,
  `payment_amount` decimal(10,2) DEFAULT '0.00',
  `payment_status` tinyint(1) unsigned DEFAULT '1',
  `payment_remark` varchar(450) DEFAULT NULL,
  PRIMARY KEY (`payment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payments`
--

/*!40000 ALTER TABLE `payments` DISABLE KEYS */;
INSERT INTO `payments` (`payment_id`,`payment_ref_no`,`payment_amount`,`payment_status`,`payment_remark`) VALUES 
 (1,'NC WP 3320','15000.00',0,'test payment'),
 (2,'WP CBD 9900','26000.00',1,'test payment 2'),
 (3,'WP XY 2088','5900.00',1,'Cust Name : amal');
/*!40000 ALTER TABLE `payments` ENABLE KEYS */;


--
-- Definition of table `vehicle_categories`
--

DROP TABLE IF EXISTS `vehicle_categories`;
CREATE TABLE `vehicle_categories` (
  `vehicle_category_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_category_name` varchar(450) DEFAULT NULL,
  `vehicle_category_detail` varchar(100) DEFAULT NULL,
  `vehicle_category_status` tinyint(1) unsigned DEFAULT NULL,
  PRIMARY KEY (`vehicle_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle_categories`
--

/*!40000 ALTER TABLE `vehicle_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehicle_categories` ENABLE KEYS */;


--
-- Definition of table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
CREATE TABLE `vehicles` (
  `vehicle_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `vehicle_reg_no` varchar(45) DEFAULT NULL,
  `vehicle_model_name` varchar(100) DEFAULT NULL,
  `vehicle_availability` tinyint(1) unsigned DEFAULT NULL,
  `vehicle_category_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicles`
--

/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` (`vehicle_id`,`vehicle_reg_no`,`vehicle_model_name`,`vehicle_availability`,`vehicle_category_id`) VALUES 
 (1,'WP XY 2088','Toyota Premeo 2010 G Grade',1,1),
 (2,'NC KG 3254','Nissan Premera 2007 ',0,1),
 (3,'WP SS 3254','Zusuki Alto K10 ',1,1),
 (4,'WP CBD 2222','BMW 318i MSport 2018',1,1),
 (5,'WP CAA 9000','Audi A5 S Line 2020',1,1);
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
