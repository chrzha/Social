CREATE TABLE `social_images` (
	`id` INT(11) NOT NULL,
	`title` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`content` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`path` VARCHAR(200) NOT NULL COLLATE 'utf8_unicode_ci'
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB;

CREATE TABLE `social_user` (
	`id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',
	`password` VARCHAR(50) NOT NULL COLLATE 'utf8_unicode_ci',
	`role_id` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`id`),
	INDEX `FK_role_id` (`role_id`),
	CONSTRAINT `FK_role_id` FOREIGN KEY (`role_id`) REFERENCES `social_role` (`role_id`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB;

CREATE TABLE `social_role` (
	`role_id` INT(11) NOT NULL,
	`role_name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	`role_desc` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8_unicode_ci',
	PRIMARY KEY (`role_id`)
)
COLLATE='utf8_unicode_ci'
ENGINE=InnoDB;