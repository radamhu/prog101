-- 1 . feladat (az SQLite-ban nem szükséges, de más rendszerben ezt kellene beírni)
CREATE DATABASE papirgyujtes
DEFAULT CHARACTER SET utf8
COLLATE utf8_hungarian_ci;

-- 2. feladat
-- lefuttatni az SQL fájlokat
-- táblák szerkezetét értelmezni, tartalmát megnézni
-- varchar, date maradt, de text-ként kezeli

-- 3. feladat
SELECT nev, osztaly, idopont, mennyiseg
FROM tanulok
JOIN leadasok ON tazon = tanulo
WHERE osztaly LIKE '1_';

-- 4. feladat
SELECT idopont, avg(mennyiseg) AS 'napi atlag'
FROM leadasok
GROUP BY idopont;


-- 5. feladat
SELECT DISTINCT osztaly
FROM tanulok
JOIN leadasok ON tazon = tanulo
WHERE idopont = '2016-10-28'
ORDER BY osztaly;

-- 6. feladat (tizedesek nem számítanak)
SELECT osztaly, sum(mennyiseg)/10000 AS mazsa
FROM tanulok
JOIN leadasok ON tazon = tanulo
GROUP BY osztaly
ORDER BY mazsa DESC;

-- 7. feladat
SELECT nev, osztaly, sum(mennyiseg) AS osszesen
FROM tanulok
JOIN leadasok ON tazon = tanulo
GROUP BY nev
ORDER BY osszesen DESC
LIMIT 10;