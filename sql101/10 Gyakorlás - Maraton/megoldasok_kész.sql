-- 1 . feladat (az SQLite-ban nem szükséges, de más rendszerben ezt kellene beírni)
CREATE DATABASE maratonvalto
DEFAULT CHARACTER SET utf8
COLLATE utf8_hungarian_ci;

-- 2. feladat
-- lefuttatni az SQL fájlokat
-- táblák szerkezetét értelmezni, tartalmát megnézni
-- varchar()-t text-ként kezeli
-- az eredmenyek táblában két mező együtt a kulcs!

-- 3. feladat
INSERT INTO eredmenyek VALUES (1044, 4, 15765);

-- 4. feladat
SELECT fnev AS futo, szulev
FROM futok
WHERE ffi=0
ORDER BY fnev ASC;

-- 5. feladat
SELECT fnev AS futo, 2016-szulev AS kor
FROM futok
WHERE kor >= 42
ORDER BY szulev, szulho;

-- 6. feladat
SELECT fnev AS futo, ido
FROM futok
JOIN eredmenyek ON futok.fid=eredmenyek.futo
WHERE ffi=1
ORDER BY ido
LIMIT 10;

-- 7. feladat
SELECT csapat, sum(ido) AS csapatido
FROM futok 
JOIN eredmenyek ON futok.fid=eredmenyek.futo
GROUP BY csapat
ORDER BY csapatido;