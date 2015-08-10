CREATE SCHEMA myblog;

CREATE  TABLE IF NOT EXISTS `myblog`.`articles` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `title` VARCHAR(45) NOT NULL COMMENT 'Заголовок статьи' ,
  `text` TEXT NOT NULL COMMENT 'Текст статьи' ,
  `date` TIMESTAMP NOT NULL DEFAULT now() COMMENT 'Дата добавления статьи.' ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `title_UNIQUE` (`title` ASC) );

CREATE  TABLE IF NOT EXISTS `myblog`.`users` (
  `login` VARCHAR(15) NOT NULL COMMENT 'Логин' ,
  `pass` VARCHAR(45) NOT NULL COMMENT 'Пароль' ,
  PRIMARY KEY (`login`) );

CREATE  TABLE IF NOT EXISTS `myblog`.`groupuser` (
  `name` VARCHAR(20) NOT NULL,
  `users_login` VARCHAR(15),
  PRIMARY KEY (`name`)
);

CREATE INDEX fk_groupuser_users ON `myblog`.`groupuser`(users_login ASC ) ;
ALTER TABLE `myblog`.`groupuser` ADD constraint fk_groupuser_users foreign key (`users_login`) REFERENCES `myblog`.`users` (`login` );

CREATE  TABLE IF NOT EXISTS `myblog`.`messages` (
  `id` INT NOT NULL ,
  `text` VARCHAR(255) NOT NULL COMMENT 'Текст сообщения' ,
  `date` TIMESTAMP NOT NULL DEFAULT now() COMMENT 'Дата мессаги' ,
  `users_login` VARCHAR(15) NOT NULL COMMENT 'Юзер пославший мессагу' ,
  `articles_id` INT NOT NULL COMMENT 'Статье к которой послан комент' ,
  PRIMARY KEY (`id`) );


CREATE INDEX `fk_messages_users1` ON `myblog`.`messages`  (`users_login` ASC);
CREATE INDEX `fk_messages_articles1` ON `myblog`.`messages` (`articles_id` ASC);
ALTER TABLE `myblog`.`messages` ADD CONSTRAINT `fk_messages_users1` FOREIGN KEY (`users_login` ) REFERENCES `myblog`.`users` (`login` );
ALTER TABLE `myblog`.`messages` ADD CONSTRAINT `fk_messages_articles1` FOREIGN KEY (`articles_id` ) REFERENCES `myblog`.`articles` (`id` );

CREATE  TABLE IF NOT EXISTS `myblog`.`groupuser_has_articles` (
  `groupuser_name` VARCHAR(20) NOT NULL ,
  `articles_id` INT NOT NULL ,
  PRIMARY KEY (`groupuser_name`, `articles_id`));

CREATE INDEX `fk_groupuser_has_articles_articles1` ON `myblog`.`groupuser_has_articles` (`articles_id` ASC);
CREATE INDEX `fk_groupuser_has_articles_groupuser1` ON `myblog`.`groupuser_has_articles`  (`groupuser_name` ASC);
ALTER TABLE `myblog`.`groupuser_has_articles`
	ADD CONSTRAINT `fk_groupuser_has_articles_groupuser1`
    FOREIGN KEY (`groupuser_name` ) REFERENCES `myblog`.`groupuser` (`name` );
ALTER TABLE `myblog`.`groupuser_has_articles`
	ADD CONSTRAINT `fk_groupuser_has_articles_articles1`
	FOREIGN KEY (`articles_id` )  REFERENCES `myblog`.`articles` (`id` );


CREATE  TABLE `myblog`.`Contacts` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(45) NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  `value` VARCHAR(60) NOT NULL ,
  PRIMARY KEY (`id`));

CREATE INDEX `FK_Login_Contacts` ON `myblog`.`Contacts`  (`login` ASC);
ALTER TABLE `myblog`.`Contacts` ADD CONSTRAINT  `value_UNIQUE` UNIQUE(`value` ASC);
ALTER TABLE `myblog`.`Contacts` ADD CONSTRAINT `FK_Login_Contacts`  FOREIGN KEY (`login` )
			REFERENCES `myblog`.`users` (`login` ) ON DELETE CASCADE ON UPDATE CASCADE;