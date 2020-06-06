-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 06 juin 2020 à 08:08
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `edt`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`ID`, `Nom`) VALUES
(1, 'Mah'),
(2, 'Phy'),
(3, 'Info'),
(4, 'elec');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `ID_Utilisateur` int(10) NOT NULL,
  `ID_Cours` int(10) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`,`ID_Cours`),
  KEY `ID_Cours` (`ID_Cours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`ID_Utilisateur`, `ID_Cours`) VALUES
(3, 1),
(3, 2),
(17, 2),
(17, 3),
(18, 3),
(18, 4);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `ID_Utilisateur` int(10) NOT NULL,
  `Numero` int(10) NOT NULL,
  `ID_Groupe` int(10) NOT NULL,
  PRIMARY KEY (`ID_Utilisateur`),
  KEY `ID_Groupe` (`ID_Groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`ID_Utilisateur`, `Numero`, `ID_Groupe`) VALUES
(4, 1, 1),
(7, 2, 1),
(5, 4, 2),
(8, 8, 2),
(6, 16, 3),
(9, 32, 3),
(10, 64, 4),
(11, 128, 4),
(12, 256, 5),
(13, 512, 5),
(14, 1024, 6),
(15, 2048, 6);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `IDPromotion` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `IDPromotion` (`IDPromotion`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`ID`, `Nom`, `IDPromotion`) VALUES
(1, 'TD01', 1),
(2, 'TD02', 1),
(3, 'TD01', 2),
(4, 'TD02', 2),
(5, 'TD01', 3),
(6, 'TD02', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`ID`, `Nom`) VALUES
(1, '2021'),
(2, '2022'),
(3, '2023');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  `Capacite` int(10) NOT NULL,
  `ID_Site` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Site` (`ID_Site`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`ID`, `Nom`, `Capacite`, `ID_Site`) VALUES
(1, 'SC304', 30, 1),
(2, 'EM10', 200, 1),
(3, 'M314', 20, 2),
(4, 'Sousol', 50, 2),
(5, 'P415', 100, 3),
(6, 'P306', 35, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `SEMAINE` int(10) NOT NULL,
  `Date` date NOT NULL,
  `Heure_Debut` time NOT NULL,
  `Heure_Fin` time NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Etat` int(10) NOT NULL,
  `ID_Cours` int(10) NOT NULL,
  `ID_Type` int(10) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_Cours` (`ID_Cours`),
  KEY `ID_Type` (`ID_Type`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`ID`, `SEMAINE`, `Date`, `Heure_Debut`, `Heure_Fin`, `Nom`, `Etat`, `ID_Cours`, `ID_Type`) VALUES
(1, 1, '2020-06-03', '19:00:00', '22:00:00', 'Prototypage', 1, 4, 1),
(2, 1, '2020-01-01', '19:00:00', '22:00:00', 'Prototypage', 1, 4, 1),
(3, 1, '2020-06-02', '13:00:00', '14:00:00', 'Jesaispas', 1, 3, 2),
(4, 1, '2020-01-02', '14:00:00', '16:00:00', 'uncoursdetest', 1, 3, 2),
(5, 1, '2020-01-03', '14:00:00', '16:00:00', 'uncoursdetest', 1, 3, 2),
(6, 1, '2020-01-04', '14:00:00', '16:00:00', 'uncoursdetest', 1, 3, 2);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `ID_Seance` int(10) NOT NULL,
  `ID_Enseignant` int(10) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Enseignant`),
  KEY `ID_Enseignant` (`ID_Enseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_enseignants`
--

INSERT INTO `seance_enseignants` (`ID_Seance`, `ID_Enseignant`) VALUES
(1, 3),
(1, 17),
(2, 3),
(4, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupe`
--

DROP TABLE IF EXISTS `seance_groupe`;
CREATE TABLE IF NOT EXISTS `seance_groupe` (
  `ID_Seance` int(10) NOT NULL,
  `ID_Groupe` int(10) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Groupe`),
  KEY `ID_Groupe` (`ID_Groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_groupe`
--

INSERT INTO `seance_groupe` (`ID_Seance`, `ID_Groupe`) VALUES
(1, 1),
(1, 2),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `ID_Seance` int(10) NOT NULL,
  `ID_Salle` int(10) NOT NULL,
  PRIMARY KEY (`ID_Seance`,`ID_Salle`),
  KEY `ID_Salle` (`ID_Salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance_salles`
--

INSERT INTO `seance_salles` (`ID_Seance`, `ID_Salle`) VALUES
(1, 1),
(4, 1);

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`ID`, `Nom`) VALUES
(1, 'Eiffel1'),
(2, 'feuE3'),
(3, 'boE4');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Nom` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`ID`, `Nom`) VALUES
(1, 'TD'),
(2, 'Amphi'),
(3, 'TP'),
(4, 'MOOC'),
(5, 'DS');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Email` varchar(50) NOT NULL,
  `PASSWD` varchar(50) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Droit` int(5) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID`, `Email`, `PASSWD`, `Nom`, `Prenom`, `Droit`) VALUES
(4, 'antoine.benard@edu.ece.fr', 'motdepasse', 'Benard', 'Antoine', 4),
(2, 'referent@edu.ece.fr', 'motdepasse', 'jesuis', 'referent', 2),
(1, 'pierre.gabriel@edu.ece.fr', 'motdepasse', 'Gabriel', 'pierre', 1),
(5, 'jean.benard@edu.ece.fr', 'motdepasse', 'Benard', 'Jean', 4),
(6, 'antoine.bruno@edu.ece.fr', 'motdepasse', 'Bruno', 'Antoine', 4),
(7, 'olivier.44@edu.ece.fr', 'motdepasse', 'Olivier', '44', 4),
(8, 'alexandre.gommez@edu.ece.fr', 'motdepasse', 'Gommez', 'Alexandre', 4),
(9, 'noemie.pasquier@edu.ece.fr', 'motdepasse', 'Pasquier', 'Noemie', 4),
(10, 'aurelien.gadblet@edu.ece.fr', 'motdepasse', 'Gadblet', 'Aurelien', 4),
(11, 'charlotte.bichot@edu.ece.fr', 'motdepasse', 'Bichot', 'Charlotte', 4),
(12, 'celia.boyer@edu.ece.fr', 'motdepasse', 'Boyer', 'Celia', 4),
(13, 'pauline.maistred@edu.ece.fr', 'motdepasse', 'Mestre', 'Pauline', 4),
(14, 'baudouin.mestre@edu.ece.fr', 'motdepasse', 'Mestre', 'Baudouin', 4),
(15, 'clement.dufour@edu.ece.fr', 'motdepasse', 'Dufour', 'Clement', 4),
(16, 'fanny.dufour@edu.ece.fr', 'motdepasse', 'Dufour', 'Fanny', 4),
(3, 'marine.michenaud@edu.ece.fr', 'motdepasse', 'Michenaud', 'Marine', 3),
(17, 'waleed.mouhali@edu.ece.fr', 'motdepasse', 'Mouhali', 'waleed', 3),
(18, 'jena.dujardin@edu.ece.fr', 'motdepasse', 'Dujardin', 'Jean', 3);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
