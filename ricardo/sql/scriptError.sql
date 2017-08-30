/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */

DROP TABLE IF EXISTS `test`.`error`;
CREATE TABLE  `test`.`error` (
  `ERROR_ID` int NOT NULL AUTO_INCREMENT,
  `ERROR_DESC` varchar(100) NOT NULL,
  PRIMARY KEY (`ERROR_ID`)
) 
ENGINE=InnoDB;

insert into ERROR (ERROR_DESC) values ('404');
