-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2019. Már 30. 20:46
-- Kiszolgáló verziója: 5.7.14
-- PHP verzió: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `futas`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `naplo`
--

CREATE TABLE `naplo` (
  `futasID` int(11) NOT NULL,
  `datum` date NOT NULL,
  `tav` int(11) NOT NULL,
  `ido` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `naplo`
--

INSERT INTO `naplo` (`futasID`, `datum`, `tav`, `ido`) VALUES
(1, '2019-02-01', 1000, 400),
(2, '2019-02-08', 1100, 435),
(3, '2019-02-15', 1200, 446),
(4, '2019-02-22', 1300, 462),
(5, '2019-03-01', 1400, 502),
(6, '2019-03-08', 1500, 540),
(7, '2019-03-15', 1600, 559),
(8, '2019-03-22', 1700, 610),
(9, '2019-03-29', 1800, 619),
(10, '2019-03-30', 2000, 700);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
