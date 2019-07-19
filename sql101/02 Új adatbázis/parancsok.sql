CREATE TABLE IF NOT EXISTS evek (
    az        INTEGER PRIMARY KEY,
    nev       TEXT,
    szuletett INTEGER,
    meghalt   INTEGER
);
INSERT INTO evek VALUES(1,'Ady Endre',1877,1919);
INSERT INTO evek VALUES(2,'Arany János',1817,1882);
INSERT INTO evek VALUES(3,'Babits Mihály',1883,1941);
INSERT INTO evek VALUES(4,'Csokonai Vitéz Mihály',1773,1805);
INSERT INTO evek VALUES(5,'Illyés Gyula',1902,1983);
INSERT INTO evek VALUES(6,'József Attila',1905,1937);
INSERT INTO evek VALUES(7,'Kölcsey Ferenc',1790,1838);
INSERT INTO evek VALUES(8,'Petőfi Sándor',1823,1849);
INSERT INTO evek VALUES(9,'Radnóti Miklós',1909,1944);
INSERT INTO evek VALUES(10,'Tóth Árpád',1886,1928);
INSERT INTO evek(nev) VALUES('Juhász Gyula');