DROP DATABASE IF EXISTS cruddb;
CREATE DATABASE cruddb;
USE `cruddb`;

DROP TABLE IF EXISTS `Pessoa`;
CREATE TABLE `Pessoa` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `cruddb`.`Pessoa` (`id`, `nome`) VALUES ('1', 'Joãozinho');
INSERT INTO `cruddb`.`Pessoa` (`id`, `nome`) VALUES ('2', 'Zezinho');
INSERT INTO `cruddb`.`Pessoa` (`id`, `nome`) VALUES ('3', 'Luizinho');
