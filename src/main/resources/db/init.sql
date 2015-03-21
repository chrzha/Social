CREATE TABLE `uspto_patent_info` (
	`patent_id` INT(11) NOT NULL AUTO_INCREMENT,
	`patent_number` VARCHAR(50) NOT NULL DEFAULT '0',
	`patent_name` VARCHAR(200) NOT NULL DEFAULT '0',
	`owner_name` VARCHAR(200) NULL DEFAULT '0',
	`assignee_name` VARCHAR(200) NULL DEFAULT '0',
	`patent_url` VARCHAR(500) NULL DEFAULT '0',
	`field_name` VARCHAR(200) NULL DEFAULT '0',
	`patent_abstract` TEXT NULL,
	PRIMARY KEY (`patent_id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;
