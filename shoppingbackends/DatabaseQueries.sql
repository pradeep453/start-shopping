1> CREATE TABLE `startshopping`.`category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;