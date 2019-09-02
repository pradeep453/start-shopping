1> CREATE TABLE `startshopping`.`category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

2>
CREATE TABLE `startshopping`.`product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `is_active` bit(1) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `purchases` int(11) NOT NULL DEFAULT 0,
  `quantity` int(11) NOT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `unit_price` double DEFAULT NULL,
  `views` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ;