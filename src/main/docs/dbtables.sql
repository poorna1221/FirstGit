--
-- Table structure for table `album`
--

DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `albumname` varchar(20) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`album_id`),
  UNIQUE KEY `album_id` (`album_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=latin1;



--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cat_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cat_cod` varchar(20) NOT NULL,
  `cat_description` varchar(80) DEFAULT NULL,
  `cat_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cat_id`),
  UNIQUE KEY `cat_id` (`cat_id`),
  UNIQUE KEY `cat_cod` (`cat_cod`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=latin1;




--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `brand_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `brand_code` varchar(20) NOT NULL,
  `brand_image` varchar(80) DEFAULT NULL,
  `brand_name` varchar(20) DEFAULT NULL,
  `brand_desc` varchar(80) DEFAULT NULL,
  `cat_id` bigint(20) NOT NULL,
  PRIMARY KEY (`brand_id`),
  UNIQUE KEY `brand_id` (`brand_id`),
  UNIQUE KEY `brand_code` (`brand_code`),
  KEY `FK59A4B871DD8ADBF` (`cat_id`),
  CONSTRAINT `FK59A4B871DD8ADBF` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=600 DEFAULT CHARSET=latin1;


--
-- Table structure for table `product_type`
--

DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `prod_type_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_type_code` varchar(20) NOT NULL,
  `prod_type_desc` varchar(20) DEFAULT NULL,
  `prod_type_name` varchar(20) DEFAULT NULL,
  `prod_type_stock` bigint(20) DEFAULT NULL,
  `cat_id` bigint(20) NOT NULL,
  PRIMARY KEY (`prod_type_id`),
  UNIQUE KEY `prod_type_id` (`prod_type_id`),
  UNIQUE KEY `prod_type_code` (`prod_type_code`),
  KEY `FK3C79388A1DD8ADBF` (`cat_id`),
  CONSTRAINT `FK3C79388A1DD8ADBF` FOREIGN KEY (`cat_id`) REFERENCES `category` (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=800 DEFAULT CHARSET=latin1;


--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prod_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `imgepath` varchar(45) DEFAULT NULL,
  `prod_avalabulity` char(1) DEFAULT NULL,
  `prod_code` varchar(20) NOT NULL,
  `prod_count` int(11) DEFAULT NULL,
  `prod_desc` varchar(80) DEFAULT NULL,
  `prod_name` varchar(20) DEFAULT NULL,
  `prod_offers` char(1) DEFAULT NULL,
  `prod_price` double DEFAULT NULL,
  `prod_video` char(1) DEFAULT NULL,
  `brand_id` bigint(20) NOT NULL,
  `prod_type_id` bigint(20) NOT NULL,
  PRIMARY KEY (`prod_id`),
  UNIQUE KEY `prod_id` (`prod_id`),
  UNIQUE KEY `prod_code` (`prod_code`),
  KEY `FKED8DCCEFDA9EFA68` (`prod_type_id`),
  KEY `FKED8DCCEF94A35BE5` (`brand_id`),
  CONSTRAINT `FKED8DCCEF94A35BE5` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`brand_id`),
  CONSTRAINT `FKED8DCCEFDA9EFA68` FOREIGN KEY (`prod_type_id`) REFERENCES `product_type` (`prod_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=latin1;


--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `cart_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_id` bigint(20) NOT NULL,
  PRIMARY KEY (`cart_id`),
  UNIQUE KEY `cart_id` (`cart_id`),
  KEY `FK9DB7E397AF745AD` (`prod_id`),
  CONSTRAINT `FK9DB7E397AF745AD` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2000 DEFAULT CHARSET=latin1;



DROP TABLE IF EXISTS `product_color`;
CREATE TABLE `product_color` (
  `prod_color_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_color_name` varchar(20) DEFAULT NULL,
  `prod_id` bigint(20) NOT NULL,
  PRIMARY KEY (`prod_color_id`),
  UNIQUE KEY `prod_color_id` (`prod_color_id`),
  KEY `FK51B9B013AF745AD` (`prod_id`),
  CONSTRAINT `FK51B9B013AF745AD` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3000 DEFAULT  CHARSET=latin1;


--
-- Table structure for table `order_details`
--

DROP TABLE IF EXISTS `order_details`;
CREATE TABLE `order_details` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cart_id` bigint(20) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `order_id` (`order_id`),
  KEY `FK521CF251710E98CB` (`cart_id`),
  CONSTRAINT `FK521CF251710E98CB` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`cart_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5000 DEFAULT CHARSET=latin1;





--
-- Table structure for table `product_color`
--

DROP TABLE IF EXISTS `product_color`;
CREATE TABLE `product_color` (
  `prod_color_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_color_name` varchar(20) DEFAULT NULL,
  `prod_id` bigint(20) NOT NULL,
  PRIMARY KEY (`prod_color_id`),
  UNIQUE KEY `prod_color_id` (`prod_color_id`),
  KEY `FK51B9B013AF745AD` (`prod_id`),
  CONSTRAINT `FK51B9B013AF745AD` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8000 DEFAULT CHARSET=latin1;



--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
  `tran_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `tran_date` datetime DEFAULT NULL,
  `order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`tran_id`),
  UNIQUE KEY `tran_id` (`tran_id`),
  KEY `FK7FA0D2DE96C45806` (`order_id`),
  CONSTRAINT `FK7FA0D2DE96C45806` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10000 DEFAULT CHARSET=latin1;


--
-- Table structure for table `wish_lists`
--

DROP TABLE IF EXISTS `wish_lists`;
CREATE TABLE `wish_lists` (
  `wishlist_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prod_id` bigint(20) NOT NULL,
  PRIMARY KEY (`wishlist_id`),
  UNIQUE KEY `wishlist_id` (`wishlist_id`),
  KEY `FK2E241DFDAF745AD` (`prod_id`),
  CONSTRAINT `FK2E241DFDAF745AD` FOREIGN KEY (`prod_id`) REFERENCES `product` (`prod_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12000 DEFAULT CHARSET=latin1;



--
-- Table structure for table `useraccount`
--

DROP TABLE IF EXISTS `useraccount`;
CREATE TABLE `useraccount` (
  `account_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active` char(1) DEFAULT NULL,
  `email_id` varchar(20) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `album_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `cart_id` bigint(20) NOT NULL,
  `wishlist_id` bigint(20) NOT NULL,
  PRIMARY KEY (`account_id`),
  UNIQUE KEY `account_id` (`account_id`),
  KEY `FK449CD402710E98CB` (`cart_id`),
  KEY `FK449CD40245512526` (`wishlist_id`),
  KEY `FK449CD40296C45806` (`order_id`),
  KEY `FK449CD4026D1CBE15` (`album_id`),
  CONSTRAINT `FK449CD4026D1CBE15` FOREIGN KEY (`album_id`) REFERENCES `album` (`album_id`),
  CONSTRAINT `FK449CD40245512526` FOREIGN KEY (`wishlist_id`) REFERENCES `wish_lists` (`wishlist_id`),
  CONSTRAINT `FK449CD402710E98CB` FOREIGN KEY (`cart_id`) REFERENCES `shopping_cart` (`cart_id`),
  CONSTRAINT `FK449CD40296C45806` FOREIGN KEY (`order_id`) REFERENCES `order_details` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15000 DEFAULT CHARSET=latin1;



--
-- Table structure for table `shipping_address`
--

DROP TABLE IF EXISTS `shipping_address`;
CREATE TABLE `shipping_address` (
  `shipping_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address2` varchar(45) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `pincode` int(11) DEFAULT NULL,
  `address1` varchar(45) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `title` varchar(5) DEFAULT NULL,
  `account_id` bigint(20) NOT NULL,
  PRIMARY KEY (`shipping_id`),
  UNIQUE KEY `shipping_id` (`shipping_id`),
  KEY `FK29B89263B3A19004` (`account_id`),
  CONSTRAINT `FK29B89263B3A19004` FOREIGN KEY (`account_id`) REFERENCES `useraccount` (`account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16000 DEFAULT CHARSET=latin1;



