CREATE TABLE IF NOT EXISTS
  `doctors` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `name` varchar(100) NOT NULL,
    `email` varchar(100) NOT NULL UNIQUE,
    `crm` varchar(6) NOT NULL UNIQUE,
    `specialty` varchar(100) NOT NULL,
    `public_area` varchar(100) NOT NULL,
    `neighborhood` varchar(100) NOT NULL,
    `zip` varchar(9) NOT NULL,
    `city` varchar(100) NOT NULL,
    `complement` varchar(100),
    `number` varchar(20),
    `state` varchar(2) NOT NULL,
    PRIMARY KEY (`id`)
  );