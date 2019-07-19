--
-- File generated with SQLiteStudio v3.2.1 on Sze nov. 7 05:46:55 2018
--
-- Text encoding used: System
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Table: adatok
DROP TABLE IF EXISTS adatok;
CREATE TABLE adatok(
    helyezes INTEGER PRIMARY KEY, 
    nev TEXT, 
    vagyon INTEGER, 
    ev INTEGER, 
    ceg TEXT, 
    orszag TEXT
);
INSERT INTO adatok (helyezes, nev, vagyon, ev, ceg, orszag) VALUES (1, 'Larry Ellison', 43, 1945, 'Oracle', 'USA');
INSERT INTO adatok (helyezes, nev, vagyon, ev, ceg, orszag) VALUES (2, 'Carlos Slim Helu', 73, 1940, 'telecom', 'Mexikó');
INSERT INTO adatok (helyezes, nev, vagyon, ev, ceg, orszag) VALUES (3, 'Bill Gates', 67, 1956, 'Microsoft', 'USA');
INSERT INTO adatok (helyezes, nev, vagyon, ev, ceg, orszag) VALUES (4, 'Amancio Ortega', 57, 1936, 'Zara', 'Spanyolország');
INSERT INTO adatok (helyezes, nev, vagyon, ev, ceg, orszag) VALUES (5, 'Warren Buffet', 53.5, 1931, 'Berkshire Hathaway', 'USA');

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
