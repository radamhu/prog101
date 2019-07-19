BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS szemely (
	nev   text,
	szem  int,
	hely  text,
	szul  int,
	hal   int,
	PRIMARY KEY(szem)
);
INSERT INTO szemely VALUES ('Andrássy Gyula',1,'Oláhpatak',1823,1890);
INSERT INTO szemely VALUES ('Antall József',2,'Budapest',1932,1993);
INSERT INTO szemely VALUES ('Bánffy Dezső',3,'Kolozsvár',1843,1911);
INSERT INTO szemely VALUES ('Bárdossy László',4,'Szombathely',1890,1946);
INSERT INTO szemely VALUES ('Batthyány Lajos',5,'Pozsony',1807,1849);
INSERT INTO szemely VALUES ('Berinkey Dénes',6,'Csúz',1871,1944);
INSERT INTO szemely VALUES ('Bethlen István',7,'Gernyeszeg',1874,1946);
INSERT INTO szemely VALUES ('Bittó István',8,'Sárosfa',1822,1903);
INSERT INTO szemely VALUES ('Boross Péter',9,'Nagybajom',1928,NULL);
INSERT INTO szemely VALUES ('Dálnoki Miklós Béla',10,'Budapest',1890,1948);
INSERT INTO szemely VALUES ('Darányi Kálmán',11,'Budapest',1886,1939);
INSERT INTO szemely VALUES ('Dinnyés Lajos',12,'Alsódabas',1901,1961);
INSERT INTO szemely VALUES ('Dobi István',13,'Szőny',1898,1968);
INSERT INTO szemely VALUES ('Esterházy Móric',14,'Majkpuszta',1881,1960);
INSERT INTO szemely VALUES ('Fejérváry Géza',15,'Josephstadt',1833,1914);
INSERT INTO szemely VALUES ('Fock Jenő',16,'Kispest',1916,2001);
INSERT INTO szemely VALUES ('Friedrich István',17,'Malacka',1883,1951);
INSERT INTO szemely VALUES ('Garbai Sándor',18,'Kiskunhalas',1879,1947);
INSERT INTO szemely VALUES ('Gömbös Gyula',19,'Murga',1886,1936);
INSERT INTO szemely VALUES ('Grósz Károly',20,'Miskolc',1930,1996);
INSERT INTO szemely VALUES ('Hadik János',21,'Pálóc',1863,1933);
INSERT INTO szemely VALUES ('Hegedűs András',22,'Szilsárkány',1922,1999);
INSERT INTO szemely VALUES ('Horn Gyula',23,'Budapest',1932,NULL);
INSERT INTO szemely VALUES ('Huszár Károly',24,'Nussdorf',1882,1941);
INSERT INTO szemely VALUES ('Imrédy Béla',25,'Budapest',1891,1946);
INSERT INTO szemely VALUES ('Kádár János',26,'Fiume',1912,1989);
INSERT INTO szemely VALUES ('Kállai Gyula',27,'Berettyóújfalú',1910,1996);
INSERT INTO szemely VALUES ('Kállay Miklós',28,'Nyíregyháza',1887,1967);
INSERT INTO szemely VALUES ('Károlyi Gyula',29,'Nyírbakta',1871,1947);
INSERT INTO szemely VALUES ('Károlyi Mihály',30,'Budapest',1875,1955);
INSERT INTO szemely VALUES ('Khuen-Héderváry Károly',31,'Gräfenberg-fürdő',1849,1918);
INSERT INTO szemely VALUES ('Kossuth Lajos',32,'Monok',1802,1894);
INSERT INTO szemely VALUES ('Lakatos Géza',33,'Budapest',1890,1967);
INSERT INTO szemely VALUES ('Lázár György',34,'Isaszeg',1924,NULL);
INSERT INTO szemely VALUES ('Lónyai Menyhért',35,'Nagylónya',1822,1884);
INSERT INTO szemely VALUES ('Lukács László',36,'Zalatna',1850,1932);
INSERT INTO szemely VALUES ('Medgyessy Péter',37,'Budapest',1942,NULL);
INSERT INTO szemely VALUES ('Münnich Ferenc',38,'Seregélyes',1886,1967);
INSERT INTO szemely VALUES ('Nagy Ferenc',39,'Bisse',1903,1979);
INSERT INTO szemely VALUES ('Nagy Imre',40,'Kaposvár',1896,1958);
INSERT INTO szemely VALUES ('Németh Miklós',41,'Monok',1948,NULL);
INSERT INTO szemely VALUES ('Orbán Viktor',42,'Székesfehérvár',1963,NULL);
INSERT INTO szemely VALUES ('Peidl Gyula',43,'Ravazd',1873,1943);
INSERT INTO szemely VALUES ('Rákosi Mátyás',44,'Ada',1892,1971);
INSERT INTO szemely VALUES ('Simonyi-Semadam Sándor',45,'Csesznek',1864,1946);
INSERT INTO szemely VALUES ('Szálasi Ferenc',46,'Kassa',1897,1946);
INSERT INTO szemely VALUES ('Szapáry Gyula',47,'Pest',1832,1905);
INSERT INTO szemely VALUES ('Széll Kálmán',48,'Gasztony',1843,1915);
INSERT INTO szemely VALUES ('Szemere Bertalan',49,'Vatta',1812,1869);
INSERT INTO szemely VALUES ('Szlávy József',50,'Győr',1818,1900);
INSERT INTO szemely VALUES ('Sztójay Döme',51,'Versec',1883,1946);
INSERT INTO szemely VALUES ('Teleki Pál',52,'Budapest',1879,1941);
INSERT INTO szemely VALUES ('Tildy Zoltán',53,'Losonc',1889,1961);
INSERT INTO szemely VALUES ('Tisza István',54,'Pest',1861,1918);
INSERT INTO szemely VALUES ('Tisza Kálmán',55,'Geszt',1830,1902);
INSERT INTO szemely VALUES ('Wekerle Sándor',56,'Mór',1848,1921);
CREATE TABLE IF NOT EXISTS elnokok (
	azon	int,
	szem	int,
	mettol	int,
	meddig	int,
	PRIMARY KEY(azon)
);
INSERT INTO elnokok VALUES (1,5,1848,1848);
INSERT INTO elnokok VALUES (2,32,1848,1849);
INSERT INTO elnokok VALUES (3,49,1849,1849);
INSERT INTO elnokok VALUES (4,1,1867,1871);
INSERT INTO elnokok VALUES (5,35,1871,1872);
INSERT INTO elnokok VALUES (6,50,1872,1874);
INSERT INTO elnokok VALUES (7,8,1874,1875);
INSERT INTO elnokok VALUES (8,55,1875,1890);
INSERT INTO elnokok VALUES (9,47,1890,1892);
INSERT INTO elnokok VALUES (10,56,1892,1895);
INSERT INTO elnokok VALUES (11,3,1895,1899);
INSERT INTO elnokok VALUES (12,48,1899,1903);
INSERT INTO elnokok VALUES (13,31,1903,1903);
INSERT INTO elnokok VALUES (14,54,1903,1905);
INSERT INTO elnokok VALUES (15,15,1905,1906);
INSERT INTO elnokok VALUES (16,56,1906,1910);
INSERT INTO elnokok VALUES (17,31,1910,1912);
INSERT INTO elnokok VALUES (18,36,1912,1913);
INSERT INTO elnokok VALUES (19,54,1913,1917);
INSERT INTO elnokok VALUES (20,14,1917,1917);
INSERT INTO elnokok VALUES (21,56,1917,1918);
INSERT INTO elnokok VALUES (22,21,1918,1918);
INSERT INTO elnokok VALUES (23,30,1918,1919);
INSERT INTO elnokok VALUES (24,6,1919,1919);
INSERT INTO elnokok VALUES (25,18,1919,1919);
INSERT INTO elnokok VALUES (26,43,1919,1919);
INSERT INTO elnokok VALUES (27,17,1919,1919);
INSERT INTO elnokok VALUES (28,24,1919,1920);
INSERT INTO elnokok VALUES (29,45,1920,1920);
INSERT INTO elnokok VALUES (30,52,1921,1921);
INSERT INTO elnokok VALUES (31,7,1921,1931);
INSERT INTO elnokok VALUES (32,29,1931,1932);
INSERT INTO elnokok VALUES (33,19,1932,1936);
INSERT INTO elnokok VALUES (34,11,1936,1938);
INSERT INTO elnokok VALUES (35,25,1938,1939);
INSERT INTO elnokok VALUES (36,52,1939,1941);
INSERT INTO elnokok VALUES (37,4,1941,1942);
INSERT INTO elnokok VALUES (38,28,1942,1944);
INSERT INTO elnokok VALUES (39,51,1944,1944);
INSERT INTO elnokok VALUES (40,33,1944,1944);
INSERT INTO elnokok VALUES (41,46,1944,1945);
INSERT INTO elnokok VALUES (42,10,1944,1945);
INSERT INTO elnokok VALUES (43,53,1945,1946);
INSERT INTO elnokok VALUES (44,39,1946,1947);
INSERT INTO elnokok VALUES (45,12,1947,1948);
INSERT INTO elnokok VALUES (46,13,1948,1952);
INSERT INTO elnokok VALUES (47,44,1952,1953);
INSERT INTO elnokok VALUES (48,40,1953,1955);
INSERT INTO elnokok VALUES (49,22,1955,1956);
INSERT INTO elnokok VALUES (50,40,1956,1956);
INSERT INTO elnokok VALUES (51,26,1956,1958);
INSERT INTO elnokok VALUES (52,38,1958,1961);
INSERT INTO elnokok VALUES (53,26,1961,1965);
INSERT INTO elnokok VALUES (54,27,1965,1967);
INSERT INTO elnokok VALUES (55,16,1967,1975);
INSERT INTO elnokok VALUES (56,34,1975,1987);
INSERT INTO elnokok VALUES (57,20,1987,1987);
INSERT INTO elnokok VALUES (58,41,1988,1990);
INSERT INTO elnokok VALUES (59,2,1990,1993);
INSERT INTO elnokok VALUES (60,9,1993,1994);
INSERT INTO elnokok VALUES (61,23,1994,1998);
INSERT INTO elnokok VALUES (62,42,1998,2002);
INSERT INTO elnokok VALUES (63,37,2002,2004);
COMMIT;
