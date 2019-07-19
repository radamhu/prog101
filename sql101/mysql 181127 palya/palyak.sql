-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2017. Nov 05. 12:18
-- Kiszolgáló verziója: 5.7.14
-- PHP verzió: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `repterek`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `palyak`
--

CREATE TABLE `palyak` (
  `az` int(11) NOT NULL,
  `nev` varchar(35) NOT NULL,
  `hossz` int(4) DEFAULT NULL,
  `szelesseg` int(3) DEFAULT NULL,
  `anyag` varchar(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

--
-- A tábla adatainak kiíratása `palyak`
--

INSERT INTO `palyak` (`az`, `nev`, `hossz`, `szelesseg`, `anyag`) VALUES
(1, 'Budapest-Ferihegy', 3010, 45, 'beton'),
(2, 'Budapest-Ferihegy', 3707, 45, 'beton'),
(3, 'Budapest-Ferihegy', 900, 23, 'beton'),
(4, 'Budapest-Ferihegy', 900, 23, 'beton'),
(5, 'Debreceni nemzetközi repülőtér', 2500, 40, 'beton'),
(6, 'Debreceni nemzetközi repülőtér', 2500, 40, 'beton'),
(7, 'Debreceni nemzetközi repülőtér', 2500, 90, 'beton'),
(8, 'Debreceni nemzetközi repülőtér', 1000, 100, 'fű'),
(9, 'Győr-Pér', 1450, 30, 'beton'),
(10, 'Győr-Pér', 1450, 30, 'beton'),
(11, 'Győr-Pér', 1340, 150, 'fű'),
(12, 'Győr-Pér', 900, 150, 'fű'),
(13, 'Pécs-Pogány Repülőtér', 1500, 30, 'beton'),
(14, 'Sármellék nemzetközi repülőtér', 2500, 60, 'beton'),
(15, 'Sármellék nemzetközi repülőtér', 1000, 45, 'fű'),
(16, 'Sármellék nemzetközi repülőtér', 30, 45, 'beton'),
(17, 'Fertőszentmiklós', 985, 23, 'beton'),
(18, 'Nyíregyháza', 1000, 20, 'beton'),
(19, 'Nyíregyháza', 1000, 60, 'fű'),
(20, 'Siófok-Kiliti', 2000, 50, 'fű'),
(21, 'Siófok-Kiliti', 2000, 50, 'fű'),
(22, 'Siófok-Kiliti', 2000, 140, 'fű'),
(23, 'Kecskeméti katonai repülőtér', 2499, 60, 'beton'),
(24, 'Kecskeméti katonai repülőtér', 2499, 60, 'beton'),
(25, 'Pápa', 2400, 60, 'beton'),
(26, 'Pápa', 2400, 60, 'beton'),
(27, 'Szolnok', 2000, 70, 'beton'),
(28, 'Szolnok', 2000, 50, 'fű'),
(29, 'Taszár', 2500, 60, 'beton'),
(30, 'Békéscsabai repülőtér', 1500, 30, 'beton'),
(31, 'Békéscsabai repülőtér', 1500, 30, 'fű'),
(32, 'Békéscsabai repülőtér', 800, 200, 'fű'),
(33, 'Székesfehérvár-Börgöndi repülőtér', 1200, 200, 'fű'),
(34, 'Budaörs', 980, 60, 'fű'),
(35, 'Budaörs', 750, 40, 'fű'),
(36, 'Budapest-Hármashatárhegy', 1000, 100, 'fű'),
(37, 'Dunakeszi', 800, 500, 'fű'),
(38, 'Dunaújváros', 950, 60, 'fű'),
(39, 'Esztergomi repülőtér', 1000, 80, 'fű'),
(40, 'Farkashegy', 1000, 200, 'fű'),
(41, 'Gödöllői repülőtér', 1000, 100, 'fű'),
(42, 'Gyöngyös-Pipishegy', 760, 20, 'fű'),
(43, 'Hajdúszoboszló', 1000, 50, 'fű'),
(44, 'Hajdúszoboszló', 800, 50, 'fű'),
(45, 'Jakabszállás', 600, 18, 'fű'),
(46, 'Jakabszállás', 1000, 30, 'fű'),
(47, 'Kaposújlak', 610, 18, 'fű'),
(48, 'Kaposújlak', 1200, 200, 'fű'),
(49, 'Kecskéd ', 1000, 50, 'fű'),
(50, 'Kecskéd ', 1200, 50, 'fű'),
(51, 'Kiskunfélegyháza', 758, 160, 'fű'),
(52, 'Kiskunfélegyháza', 536, 100, 'fű'),
(53, 'Mezőkövesd', 800, 100, 'fű'),
(54, 'Miskolc', 850, 100, 'fű'),
(55, 'Miskolc', 800, 100, 'fű'),
(56, 'Szeged', 1185, 30, 'beton'),
(57, 'Szeged', 1177, 50, 'fű'),
(58, 'Szeged', 610, 50, 'fű'),
(59, 'Szentes', 750, 150, 'fű'),
(60, 'Szolnok-Szandaszőlős', 1050, 200, 'fű'),
(61, 'Szombathely', 1600, 500, 'fű'),
(62, 'Tököl', 2500, 80, 'beton');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `palyak`
--
ALTER TABLE `palyak`
  ADD PRIMARY KEY (`az`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `palyak`
--
ALTER TABLE `palyak`
  MODIFY `az` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
