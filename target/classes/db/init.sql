CREATE TABLE `uspto_patent_info` (
	`patent_id` INT(11) NOT NULL AUTO_INCREMENT,
	`patent_number` VARCHAR(50) NOT NULL DEFAULT '0',
	`patent_name` VARCHAR(500) NOT NULL DEFAULT '0',
	`owner_name` VARCHAR(500) NULL DEFAULT '0',
	`patent_url` VARCHAR(500) NULL DEFAULT '0',
	`patent_abstract` TEXT NULL,
	`version` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`patent_id`)
);
CREATE TABLE `users` (
	`userid` VARCHAR(50) NOT NULL,
	`username` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`email` VARCHAR(50) NOT NULL,
	`adminflag` INT(11) NULL DEFAULT '0'
);
CREATE TABLE `users_version` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`userid` VARCHAR(50) NOT NULL DEFAULT '0',
	`version` VARCHAR(50) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`)
);
