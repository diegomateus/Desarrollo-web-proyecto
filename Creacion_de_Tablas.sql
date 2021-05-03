CREATE TABLE `employees` (
  `id` varchar(36) NOT NULL,
  `email` varchar(200) NOT NULL,
  `first_name` varchar(200) NOT NULL,
  `last_name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `is_administrator` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `appointments` (
  `id` varchar(36) NOT NULL,
  `property` varchar(1000) NOT NULL,
  `date_time` timestamp(4) NOT NULL,
  `assigned_employee` varchar(1000) DEFAULT NULL,
  `customer_first_name` varchar(200) NOT NULL,
  `customer_last_name` varchar(200) NOT NULL,
  `customer_email` varchar(200) NOT NULL,
  `customer_phone_number` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `real_estate`.`properties` (
  `id` VARCHAR(36) NOT NULL,
  `address` VARCHAR(50) NOT NULL,
  `property_type` VARCHAR(45) NOT NULL,
  `city` VARCHAR(85) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  `bedrooms_number` INT NOT NULL,
  `bathrooms_number` INT NOT NULL,
  `private_area` INT NOT NULL,
  `built_area` INT NOT NULL,
  `service_level` INT NOT NULL,
  `condition` VARCHAR(45) NOT NULL,
  `delivery_date` DATE NOT NULL,
  `latitude` BIGINT NOT NULL,
  `longitude` BIGINT NOT NULL,
  `images` VARCHAR(1000) NULL DEFAULT NULL,
  `offers` VARCHAR(1000) NULL DEFAULT NULL,
  `questions` VARCHAR(1000) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `real_estate`.`offers` (
  `id` VARCHAR(36) NOT NULL,
  `property_id` VARCHAR(36) NOT NULL,
  `price` INT NOT NULL,
  `action` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`));