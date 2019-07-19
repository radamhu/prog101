-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2018. Feb 17. 08:20
-- Kiszolgáló verziója: 5.7.14
-- PHP verzió: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `gepnaplo`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `gepek`
--

CREATE TABLE `gepek` (
  `az` int(11) NOT NULL,
  `gepnev` varchar(20) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `iskola` varchar(40) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `osztaly` varchar(8) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `nev` varchar(50) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `ido` datetime NOT NULL,
  `allapot` varchar(50) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `gepek`
--

INSERT INTO `gepek` (`az`, `gepnev`, `iskola`, `osztaly`, `nev`, `ido`, `allapot`) VALUES
(1, '1', 'pogány', '14ed', 'Balog Zsolt', '2019-02-06 08:30:00', 'rendben'),
(2, 't1', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14ed', 'józsi', '2019-02-09 18:52:26', 'Rendben.'),
(14, 'Joe-HP', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14ed', 'Tóth József', '2019-02-10 11:24:59', 'Rendben.'),
(17, '122HP4', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14.ED', 'Darázsi Márk', '2019-02-10 11:33:48', 'Rendben.'),
(18, '122HP7', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14de', 'vaska gergely', '2019-02-10 11:45:50', 'Rendben.'),
(21, '122HP8', 'BKSZC Pogány Frigyes Szakgimnáziuma', '13D', 'Fábián Tamás', '2019-02-10 11:47:57', 'Rendben'),
(22, '122HP2', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14ED', 'Milan', '2019-02-10 11:49:00', 'Rendben.'),
(23, '122HP6', 'Pogány Frigyes', 'szoftver', 'Attila', '2019-02-10 11:49:44', 'Minden rendben'),
(24, '122HP2', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14ED', 'Toth Milan', '2019-02-10 11:49:43', 'Rendben.'),
(25, '122HP4', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14.ED', 'Zsoltika', '2019-02-10 11:49:44', 'Rendben.'),
(31, '122HP8', 'BKSZC Pogány Frigyes Szakgimnáziuma', '14 ED', 'Fábián Tamás NEW', '2019-02-10 11:52:12', 'All Right'),
(36, 'Joe-HP', 'BKSZC Pogány Frigyes Szakgimnáziuma', '123', 'Tóth József', '2019-02-10 11:54:38', 'Rendben.')

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `gepek`
--
ALTER TABLE `gepek`
  ADD PRIMARY KEY (`az`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `gepek`
--
ALTER TABLE `gepek`
  MODIFY `az` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
