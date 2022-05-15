-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 15 mai 2022 à 16:51
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hme_todolist`
--

-- --------------------------------------------------------

--
-- Structure de la table `corbeille`
--

DROP TABLE IF EXISTS `corbeille`;
CREATE TABLE IF NOT EXISTS `corbeille` (
                                           `id_tache` int(11) NOT NULL AUTO_INCREMENT,
                                           `nom_tache` varchar(50) NOT NULL,
                                           `terminee` tinyint(1) NOT NULL DEFAULT '0',
                                           `deadline` date NOT NULL,
                                           `ref_type` int(11) NOT NULL,
                                           `ref_liste` int(11) NOT NULL,
                                           PRIMARY KEY (`id_tache`),
                                           KEY `fk_tache_liste` (`ref_liste`),
                                           KEY `fk_tache_type` (`ref_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `historique`
--

DROP TABLE IF EXISTS `historique`;
CREATE TABLE IF NOT EXISTS `historique` (
                                            `id_historique` int(11) NOT NULL AUTO_INCREMENT,
                                            `type` varchar(512) NOT NULL,
                                            `action` varchar(512) NOT NULL,
                                            `ref_user` int(11) NOT NULL,
                                            PRIMARY KEY (`id_historique`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `liste`
--

DROP TABLE IF EXISTS `liste`;
CREATE TABLE IF NOT EXISTS `liste` (
                                       `id_liste` int(11) NOT NULL AUTO_INCREMENT,
                                       `nom_liste` varchar(50) NOT NULL,
                                       `date` date DEFAULT NULL,
                                       `ref_user` int(11) NOT NULL,
                                       PRIMARY KEY (`id_liste`),
                                       KEY `fk_liste_user` (`ref_user`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `liste`
--

INSERT INTO `liste` (`id_liste`, `nom_liste`, `date`, `ref_user`) VALUES
    (5, 'I\'m a list', NULL, 2);

-- --------------------------------------------------------

--
-- Structure de la table `tache`
--

DROP TABLE IF EXISTS `tache`;
CREATE TABLE IF NOT EXISTS `tache` (
                                       `id_tache` int(11) NOT NULL AUTO_INCREMENT,
                                       `nom_tache` varchar(50) NOT NULL,
                                       `terminee` tinyint(1) NOT NULL DEFAULT '0',
                                       `deadline` date NOT NULL,
                                       `ref_type` int(11) NOT NULL,
                                       `ref_liste` int(11) NOT NULL,
                                       PRIMARY KEY (`id_tache`),
                                       KEY `fk_tache_liste` (`ref_liste`),
                                       KEY `fk_tache_type` (`ref_type`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `tache`
--

INSERT INTO `tache` (`id_tache`, `nom_tache`, `terminee`, `deadline`, `ref_type`, `ref_liste`) VALUES
                                                                                                   (1, 'Acheter de la banane', 0, '2022-05-21', 2, 5),
                                                                                                   (5, 'Acheter du sucre roux', 0, '2022-05-21', 2, 5),
                                                                                                   (6, 'task', 0, '2022-04-26', 2, 5),
                                                                                                   (9, 'Acheter cuillere en bois', 0, '2022-04-27', 1, 5),
                                                                                                   (10, 'Manger', 0, '2022-05-21', 1, 5);

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

DROP TABLE IF EXISTS `type`;
CREATE TABLE IF NOT EXISTS `type` (
                                      `id_type` int(11) NOT NULL AUTO_INCREMENT,
                                      `nom_type` varchar(50) NOT NULL,
                                      `ref_type` int(11) DEFAULT NULL,
                                      `ref_user` int(11) NOT NULL,
                                      PRIMARY KEY (`id_type`),
                                      KEY `fk_type_type` (`ref_type`),
                                      KEY `ref_user` (`ref_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id_type`, `nom_type`, `ref_type`, `ref_user`) VALUES
                                                                       (1, 'Cuisine', NULL, 2),
                                                                       (2, 'Patisserie', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
                                      `id_user` int(11) NOT NULL AUTO_INCREMENT,
                                      `nom` varchar(50) NOT NULL,
                                      `prenom` varchar(50) NOT NULL,
                                      `mail` varchar(50) NOT NULL,
                                      `mdp` varchar(50) NOT NULL,
                                      `est_admin` tinyint(1) NOT NULL DEFAULT '0',
                                      PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `mail`, `mdp`, `est_admin`) VALUES
    (2, 'TRAN', 'Killian', 't@test.te', 'test', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `liste`
--
ALTER TABLE `liste`
    ADD CONSTRAINT `fk_liste_user` FOREIGN KEY (`ref_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `tache`
--
ALTER TABLE `tache`
    ADD CONSTRAINT `fk_tache_liste` FOREIGN KEY (`ref_liste`) REFERENCES `liste` (`id_liste`),
    ADD CONSTRAINT `fk_tache_type` FOREIGN KEY (`ref_type`) REFERENCES `type` (`id_type`);

--
-- Contraintes pour la table `type`
--
ALTER TABLE `type`
    ADD CONSTRAINT `fk_type_type` FOREIGN KEY (`ref_type`) REFERENCES `type` (`id_type`),
    ADD CONSTRAINT `type_ibfk_1` FOREIGN KEY (`ref_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/* */