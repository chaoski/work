/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */

DROP TABLE IF EXISTS `test`.`log`;
CREATE TABLE  `test`.`log` (
  `LOG_ID` int NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL,
  `fk_app_id` int NOT NULL,
  `fk_error_id` int NOT NULL,
  PRIMARY KEY (`LOG_ID`),
  constraint foreign key (fk_app_id) references app (APP_ID),
  constraint foreign key (fk_error_id) references error (ERROR_ID)
) 
ENGINE=InnoDB;

insert into LOG (USER_NAME, fk_app_id, fk_error_id) values ('Ricardo',1,1);

 
