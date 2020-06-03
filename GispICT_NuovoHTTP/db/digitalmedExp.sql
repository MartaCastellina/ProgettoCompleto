-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              10.4.12-MariaDB - mariadb.org binary distribution
-- S.O. server:                  Win64
-- HeidiSQL Versione:            11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dump della struttura del database digitalmed
CREATE DATABASE IF NOT EXISTS `digitalmed` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `digitalmed`;

-- Dump della struttura di tabella digitalmed.arduino
CREATE TABLE IF NOT EXISTS `arduino` (
  `IDArduino` int(11) NOT NULL,
  `Temperatura` int(11) DEFAULT NULL,
  `IDReparto` int(11) DEFAULT NULL,
  `TempMAX` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDArduino`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella digitalmed.arduino: ~0 rows (circa)
/*!40000 ALTER TABLE `arduino` DISABLE KEYS */;
INSERT INTO `arduino` (`IDArduino`, `Temperatura`, `IDReparto`, `TempMAX`) VALUES
	(2, NULL, NULL, 100),
	(123, 10, 1, 50);
/*!40000 ALTER TABLE `arduino` ENABLE KEYS */;

-- Dump della struttura di tabella digitalmed.farmaci
CREATE TABLE IF NOT EXISTS `farmaci` (
  `IDPharma` int(11) NOT NULL DEFAULT 0,
  `Name` char(50) DEFAULT NULL,
  `Conservation` int(11) DEFAULT NULL,
  `Link` tinytext DEFAULT NULL,
  `Reorder` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPharma`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella digitalmed.farmaci: ~10 rows (circa)
/*!40000 ALTER TABLE `farmaci` DISABLE KEYS */;
INSERT INTO `farmaci` (`IDPharma`, `Name`, `Conservation`, `Link`, `Reorder`) VALUES
	(1, 'Oki', 20, 'https://www.codifa.it/farmaci/o/oki-granulato-ketoprofene-sale-di-lisina-analgesici-fans', NULL),
	(2, 'Plasil', 20, 'https://www.codifa.it/farmaci/p/plasil-compressa-metoclopramide-cloridrato-procinetici', NULL),
	(3, 'Lasix', 20, 'https://www.codifa.it/farmaci/l/lasix-compressa-furosemide-diuretici-dell-ansa', NULL),
	(4, 'Cardura', 20, 'https://www.codifa.it/farmaci/c/cardura-doxazosin-mesilato-alfabloccanti', NULL),
	(5, 'Almarytm', 20, 'https://www.codifa.it/farmaci/a/almarytm-compressa-flecainide-acetato-antiaritmici', NULL),
	(6, 'Deltacortene', 20, 'https://www.codifa.it/farmaci/d/deltacortene-prednisone-corticosteroidi', NULL),
	(7, 'Cetirizina', 20, 'https://www.codifa.it/farmaci/c/cetirizina-abc-cetirizina-dicloridrato-antiallergici-antistaminici', NULL),
	(8, 'Coumadin', 20, 'https://www.codifa.it/farmaci/c/coumadin-warfarin-sodico-anticoagulanti-indiretti', NULL),
	(9, 'Mittoval', 20, 'https://www.codifa.it/farmaci/m/mittoval-compressa-a-rilascio-modificato-alfuzosina-cloridrato-ipertrofia-prostatica-benigna', NULL),
	(10, 'Tachipirina', 20, 'https://www.codifa.it/farmaci/t/tachipirina-compressa-granulato-supposta-paracetamolo-antipiretici-analgesici-fans', NULL);
/*!40000 ALTER TABLE `farmaci` ENABLE KEYS */;

-- Dump della struttura di tabella digitalmed.magazzinoreparti
CREATE TABLE IF NOT EXISTS `magazzinoreparti` (
  `IDWard` int(11) NOT NULL,
  `NameWard` varchar(50) DEFAULT NULL,
  `IDPharma` varchar(50) NOT NULL,
  `NamePharma` varchar(50) DEFAULT NULL,
  `Quantity` int(11) DEFAULT NULL,
  `ExpDate` date NOT NULL,
  `IdArduino` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPharma`,`IDWard`,`ExpDate`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella digitalmed.magazzinoreparti: ~22 rows (circa)
/*!40000 ALTER TABLE `magazzinoreparti` DISABLE KEYS */;
INSERT INTO `magazzinoreparti` (`IDWard`, `NameWard`, `IDPharma`, `NamePharma`, `Quantity`, `ExpDate`, `IdArduino`) VALUES
	(100, 'Surgery', '1', 'Oki', 6, '2020-05-01', NULL),
	(100, 'Surgery', '1', 'Oki', 20, '2020-05-21', NULL),
	(100, 'Surgery', '1', 'Oki', 50, '2020-06-24', NULL),
	(100, 'Surgery', '1', 'Oki', 40, '2020-07-15', NULL),
	(100, 'Surgery', '1', 'Oki', 98, '2020-07-22', NULL),
	(100, 'Surgery', '1', 'OKI', 20, '2021-04-01', NULL),
	(102, 'Emergency department', '1', 'OKI', 20, '2020-10-01', NULL),
	(103, 'Cardiac Surgery', '1', 'OKI', 10, '2021-03-25', NULL),
	(105, 'Psychiatry', '1', 'OKI', 5, '2021-01-01', NULL),
	(102, 'Emergency department', '10', 'Tachipirina', 8, '2020-04-25', NULL),
	(101, 'Cardiology', '2', 'Plasil', 70, '2020-05-30', NULL),
	(106, 'Pneumology', '2', 'Plasil', 60, '2020-07-31', NULL),
	(100, 'Surgery', '3', 'Lasix', 10, '2020-09-01', NULL),
	(106, 'Pneumology', '3', 'Lasix', 70, '2021-04-01', NULL),
	(104, 'Neurology', '4', 'Cardura', 1, '2020-07-01', NULL),
	(106, 'Pneumology', '4', 'Cardura', 44, '2020-10-01', NULL),
	(101, 'Cardiology', '5', 'Almarytm', 10, '2020-09-05', NULL),
	(103, 'Cardiac Surgery', '5', 'Almarytm', 10, '2020-09-01', NULL),
	(104, 'Neurology', '5', 'Almarytm', 10, '2021-01-01', NULL),
	(102, 'Emergency department', '6', 'Deltacortene', 10, '2021-04-01', NULL),
	(106, 'Pneumology', '6', 'Deltacortene', 20, '2020-07-31', NULL),
	(103, 'Cardiac Surgery', '8', 'Coumadin', 10, '2021-04-01', NULL),
	(106, 'Pneumology', '9', 'Mittoval', 74, '2020-07-31', NULL);
/*!40000 ALTER TABLE `magazzinoreparti` ENABLE KEYS */;

-- Dump della struttura di tabella digitalmed.richieste
CREATE TABLE IF NOT EXISTS `richieste` (
  `IdWardRiceve` int(11) NOT NULL,
  `NomeRiceve` varchar(50) DEFAULT NULL,
  `IdWardRichiede` int(11) NOT NULL,
  `NomeRichiede` varchar(50) DEFAULT NULL,
  `IdPharma` int(11) NOT NULL,
  `NamePharma` varchar(50) DEFAULT NULL,
  `Qty` int(11) NOT NULL,
  `ExpDate` date NOT NULL,
  PRIMARY KEY (`IdWardRiceve`,`IdPharma`,`Qty`,`ExpDate`,`IdWardRichiede`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella digitalmed.richieste: ~3 rows (circa)
/*!40000 ALTER TABLE `richieste` DISABLE KEYS */;
INSERT INTO `richieste` (`IdWardRiceve`, `NomeRiceve`, `IdWardRichiede`, `NomeRichiede`, `IdPharma`, `NamePharma`, `Qty`, `ExpDate`) VALUES
	(100, 'Surgery', 101, 'Cardiology', 1, 'Oki', 10, '2020-07-15'),
	(106, 'Pneumology', 101, 'Cardiology', 3, 'Lasix', 5, '2021-04-01'),
	(106, 'Pneumology', 103, 'Cardiac Surgery', 4, 'Cardura', 1, '2020-10-01'),
	(106, 'Pneumology', 100, 'Surgery', 9, 'Mittoval', 2, '2020-07-31');
/*!40000 ALTER TABLE `richieste` ENABLE KEYS */;

-- Dump della struttura di tabella digitalmed.statistiche
CREATE TABLE IF NOT EXISTS `statistiche` (
  `IDPharma` int(11) NOT NULL,
  `Withdrawal` date NOT NULL,
  `Quantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`IDPharma`,`Withdrawal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dump dei dati della tabella digitalmed.statistiche: ~0 rows (circa)
/*!40000 ALTER TABLE `statistiche` DISABLE KEYS */;
INSERT INTO `statistiche` (`IDPharma`, `Withdrawal`, `Quantity`) VALUES
	(1, '2020-04-21', 4);
/*!40000 ALTER TABLE `statistiche` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
