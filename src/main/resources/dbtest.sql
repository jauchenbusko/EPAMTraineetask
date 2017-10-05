CREATE TABLE `ATM`.`clients` ( `id` INT(255) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `surname` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `login` VARCHAR(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
  `pin` INT(4) NOT NULL , `saldo` INT(255) NOT NULL ,
  PRIMARY KEY (`id`),
  UNIQUE (`login`))
  ENGINE = InnoDB CHARSET=utf8 COLLATE utf8_general_ci;

INSERT INTO clients VALUES (1, 'Name', 'Surname', 'login', 1111, 50 )
