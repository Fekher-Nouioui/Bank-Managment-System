-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 23, 2020 at 04:25 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agencebanquaire`
--

-- --------------------------------------------------------

--
-- Table structure for table `agence`
--

DROP TABLE IF EXISTS `agence`;
CREATE TABLE IF NOT EXISTS `agence` (
  `idAgence` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(150) NOT NULL,
  `adresse` varchar(200) NOT NULL,
  PRIMARY KEY (`idAgence`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agence`
--

INSERT INTO `agence` (`idAgence`, `nom`, `adresse`) VALUES
(1, 'BIAT Omran Supérieur', 'Omran Superieur'),
(2, 'BIAT Manar 1', 'Manar 1'),
(3, 'BIAT Menzah 6', 'Menzah 6'),
(4, 'BIAT Ennaser', 'Ennaser');

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `profession` varchar(200) NOT NULL,
  `telephone` varchar(15) NOT NULL,
  `cin` varchar(10) NOT NULL,
  `idClient` int(11) NOT NULL AUTO_INCREMENT,
  `chiffreAffaire` decimal(10,0) DEFAULT NULL,
  `capacite` int(11) DEFAULT NULL,
  `nomEntreprise` varchar(200) DEFAULT NULL,
  `typeClient` varchar(50) NOT NULL,
  PRIMARY KEY (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`nom`, `prenom`, `profession`, `telephone`, `cin`, `idClient`, `chiffreAffaire`, `capacite`, `nomEntreprise`, `typeClient`) VALUES
('Fekher', 'Nouioui', 'Etudiant', '54250148', '11656971', 1, NULL, NULL, NULL, 'Normal'),
('Oumayma', 'Nouioui', 'Biologiste', '99852569', '12345678', 2, NULL, NULL, NULL, 'Normal'),
('Amor', 'Nouioui', 'Chef Service', '97431570', '14725836', 3, NULL, NULL, NULL, 'Normal'),
('Latifa', 'Derbali', 'Enseignante', '98945040', '98765432', 4, '2500', 150, 'Cloud Temple', 'Vip'),
('fayssel', 'maiga', 'etudiant', '659852355', '265985', 5, NULL, NULL, NULL, 'Normal'),
('Amine', 'Ouertani', 'Etudiant', '25489569', '11569758', 9, NULL, NULL, NULL, 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `compte`
--

DROP TABLE IF EXISTS `compte`;
CREATE TABLE IF NOT EXISTS `compte` (
  `rib` int(11) NOT NULL AUTO_INCREMENT,
  `solde` decimal(10,0) NOT NULL,
  `montantMensuel` decimal(10,0) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `dateDernierVersement` date DEFAULT NULL,
  `idAgence_fk` int(11) NOT NULL,
  `idClient_fk` int(11) NOT NULL,
  `typeCompte` varchar(50) NOT NULL,
  PRIMARY KEY (`rib`),
  KEY `idAgence_fk` (`idAgence_fk`),
  KEY `idClient_fk` (`idClient_fk`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compte`
--

INSERT INTO `compte` (`rib`, `solde`, `montantMensuel`, `dateCreation`, `dateDernierVersement`, `idAgence_fk`, `idClient_fk`, `typeCompte`) VALUES
(1, '1680', NULL, NULL, NULL, 3, 1, 'Salaire'),
(2, '2000', NULL, NULL, NULL, 4, 2, 'Salaire'),
(3, '8000', '5900', '2020-02-01', '2020-02-01', 1, 3, 'Epargne'),
(4, '4000', NULL, NULL, NULL, 4, 4, 'Vip'),
(5, '2580', NULL, NULL, NULL, 2, 5, 'Salaire'),
(9, '380', NULL, NULL, NULL, 3, 9, 'Salaire');

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS `transaction`;
CREATE TABLE IF NOT EXISTS `transaction` (
  `idTransaction` int(11) NOT NULL AUTO_INCREMENT,
  `ribCompteDepart` int(11) NOT NULL,
  `ribCompteArrive` int(11) DEFAULT NULL,
  `montant` decimal(10,0) NOT NULL,
  `typeTransaction` varchar(50) NOT NULL,
  PRIMARY KEY (`idTransaction`),
  KEY `idCompteDepart` (`ribCompteDepart`),
  KEY `idCompteArrive` (`ribCompteArrive`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`idTransaction`, `ribCompteDepart`, `ribCompteArrive`, `montant`, `typeTransaction`) VALUES
(1, 2, NULL, '2500', 'Depot'),
(2, 2, NULL, '5400', 'Retrait'),
(3, 3, NULL, '2100', 'Depot'),
(4, 4, NULL, '2500', 'Depot'),
(5, 4, NULL, '250', 'Retrait'),
(6, 4, 2, '830', 'Virement'),
(10, 2, NULL, '2500', 'Depot'),
(11, 2, NULL, '200', 'Retrait'),
(12, 2, NULL, '3300', 'Retrait'),
(16, 9, NULL, '2500', 'Depot'),
(17, 9, NULL, '200', 'Retrait'),
(18, 9, NULL, '7600', 'Retrait'),
(19, 2, 9, '480', 'Virement');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`idAgence_fk`) REFERENCES `agence` (`idAgence`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk2` FOREIGN KEY (`idClient_fk`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`ribCompteArrive`) REFERENCES `compte` (`rib`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk4` FOREIGN KEY (`ribCompteArrive`) REFERENCES `compte` (`rib`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
