/*
 * Execute this script before before run the app 
 * Database: MySQL
 * 
 * Author: Loiane Groner
 * http://loianegroner.com (English)
 * http://loiane.com (Portuguese)
 */

DROP TABLE IF EXISTS `test`.`app`;
CREATE TABLE  `test`.`app` (
  `APP_ID` int NOT NULL AUTO_INCREMENT,
  `APP_NAME` varchar(50) NOT NULL,
  `APP_DESC` varchar(100) NOT NULL,
  `APP_STAT` varchar(50) NOT NULL,
  PRIMARY KEY (`APP_ID`)
) 
ENGINE=InnoDB;

insert into APP (APP_NAME, APP_DESC, APP_STAT) values ('WORD','EDITOR DE TEXTO', 'ACTIVA');
