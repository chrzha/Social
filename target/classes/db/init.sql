CREATE TABLE IF NOT EXISTS `social_images` (
	`id` INT(11) NOT NULL,
	`title` VARCHAR(50) NULL DEFAULT NULL,
	`content` VARCHAR(200) NULL DEFAULT NULL,
	`path` VARCHAR(200) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `social_role` (
	`role_id` INT(11) NOT NULL,
	`role_name` VARCHAR(50) NULL DEFAULT NULL,
	`role_desc` VARCHAR(50) NULL DEFAULT NULL,
	PRIMARY KEY (`role_id`)
);
 
 
CREATE TABLE IF NOT EXISTS `social_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL,
	`password` VARCHAR(50) NOT NULL,
	`role_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_role_id` (`role_id`),
	CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `social_role` (`role_id`)
);
 

CREATE TABLE IF NOT EXISTS `uspto_patent_info` (
	`patent_id` INT NOT NULL AUTO_INCREMENT,
	`patent_number` VARCHAR(50) NOT NULL DEFAULT '0',
	`patent_name` VARCHAR(200) NOT NULL DEFAULT '0',
	`owner_name` VARCHAR(200) NOT NULL DEFAULT '0',
	`assignee_name` VARCHAR(200) NOT NULL DEFAULT '0',
	`patent_url` VARCHAR(200) NOT NULL DEFAULT '0',
	`field_name` VARCHAR(200) NOT NULL DEFAULT '0',
	`patent_abstract` TEXT(5000) NULL DEFAULT NULL,
	PRIMARY KEY (`patent_id`)
);
;