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
                                            `property_id` VARCHAR(36) NOT NULL,
                                            `property_address` VARCHAR(50) NOT NULL,
                                            `property_type` VARCHAR(45) NOT NULL,
                                            `property_city` VARCHAR(85) NOT NULL,
                                            `property_description` VARCHAR(500) NOT NULL,
                                            `property_bedrooms_number` INT NOT NULL,
                                            `property_bathrooms_number` INT NOT NULL,
                                            `property_private_area` INT NOT NULL,
                                            `property_built_area` INT NOT NULL,
                                            `property_service_level` INT NOT NULL,
                                            `property_condition` VARCHAR(45) NOT NULL,
                                            `property_delivery_date` DATE NOT NULL,
                                            `property_latitude` DECIMAL NOT NULL,
                                            `property_longitude` DECIMAL NOT NULL,
                                            `property_images` VARCHAR(1000) NULL DEFAULT NULL,
                                            `property_offers` VARCHAR(1000) NULL DEFAULT NULL,
                                            `property_questions` VARCHAR(1000) NULL DEFAULT NULL,
                                            PRIMARY KEY (`property_id`));
