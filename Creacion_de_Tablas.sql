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