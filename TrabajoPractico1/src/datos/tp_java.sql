# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : tp_java


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `tp_java`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

#
# Structure for the `electrodomestico` table : 
#

CREATE TABLE `electrodomestico` (
  `id` int(30) NOT NULL auto_increment,
  `precioBase` float(30,3) default NULL,
  `color` varchar(30) default NULL,
  `consumoEnergetico` varchar(30) default NULL,
  `peso` float(30,3) default NULL,
  `resolucion` float(30,3) default NULL,
  `sintonizador` tinyint(1) default NULL,
  `carga` float(30,3) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `electrodomestico` table  (LIMIT 0,500)
#

INSERT INTO `electrodomestico` (`id`, `precioBase`, `color`, `consumoEnergetico`, `peso`, `resolucion`, `sintonizador`, `carga`) VALUES 
  (1,10.5,'ROJO','100',45,123.4,1,NULL),
  (2,9.7,'BLANCO','120',67,NULL,NULL,180.8),
  (3,9.2,'AZUL','160',60,NULL,NULL,144),
  (4,8.8,'AZUL','221',10,101,0,NULL),
  (5,12.3,'ROJO','321',11,66,1,NULL);

COMMIT;

