--
-- File generated with SQLiteStudio v3.1.1 on K szept. 4 18:52:45 2018
--
-- Text encoding used: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: evek
CREATE TABLE evek (
    az        INTEGER PRIMARY KEY,
    nev       TEXT,
    szuletett INTEGER,
    meghalt   INTEGER
);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (1, 'Ady Endre', 1877, 1919);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (2, 'Arany János', 1817, 1882);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (3, 'Babits Mihály', 1883, 1941);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (4, 'Csokonai Vitéz Mihály', 1773, 1805);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (5, 'Illyés Gyula', 1902, 1983);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (6, 'József Attila', 1905, 1937);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (7, 'Kölcsey Ferenc', 1790, 1838);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (8, 'Petőfi Sándor', 1823, 1849);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (9, 'Radnóti Miklós', 1909, 1944);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (10, 'Tóth Árpád', 1886, 1928);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (13, 'Adam', 1980, NULL);
INSERT INTO evek (az, nev, szuletett, meghalt) VALUES (14, 'Juhász Gyula', NULL, NULL);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
