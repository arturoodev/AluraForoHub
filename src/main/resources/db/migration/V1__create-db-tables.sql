-- -----------------------------------------------------
-- Table `foroalura`.`profile`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foroalura`.`profile` ;

CREATE TABLE IF NOT EXISTS `foroalura`.`profile` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foroalura`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foroalura`.`user` ;

CREATE TABLE IF NOT EXISTS `foroalura`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `username` VARCHAR(255) NULL,
  `password` VARCHAR(255) NULL,
  `profile_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_profile1_idx` (`profile_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_profile1`
    FOREIGN KEY (`profile_id`)
    REFERENCES `foroalura`.`profile` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foroalura`.`course`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foroalura`.`course` ;

CREATE TABLE IF NOT EXISTS `foroalura`.`course` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foroalura`.`topic`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foroalura`.`topic` ;

CREATE TABLE IF NOT EXISTS `foroalura`.`topic` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NULL,
  `message` VARCHAR(255) NULL,
  `creation_date` DATETIME NULL,
  `status` VARCHAR(30) NULL,
  `user_id` INT NOT NULL,
  `course_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_topic_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_topic_course1_idx` (`course_id` ASC) VISIBLE,
  CONSTRAINT `fk_topic_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `foroalura`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_topic_course1`
    FOREIGN KEY (`course_id`)
    REFERENCES `foroalura`.`course` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `foroalura`.`response`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `foroalura`.`response` ;

CREATE TABLE IF NOT EXISTS `foroalura`.`response` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `message` VARCHAR(255) NULL,
  `creation_date` DATETIME NULL,
  `solution` VARCHAR(255) NULL,
  `topic_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_response_topic_idx` (`topic_id` ASC) VISIBLE,
  INDEX `fk_response_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_response_topic`
    FOREIGN KEY (`topic_id`)
    REFERENCES `foroalura`.`topic` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_response_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `foroalura`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;