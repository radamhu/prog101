-- 3. feladat
SELECT DISTINCT telepules 
FROM partnerek
ORDER BY telepules;

-- 4. feladat
SELECT count(*) AS alkalmak
FROM kiszallitasok
JOIN partnerek ON kiszallitasok.partnerid=partnerek.id
WHERE telepules='Vác';

-- 5. feladat
SELECT max(karton) AS legtobb
FROM kiszallitasok
WHERE datum BETWEEN '2016-05-01' AND '2016-05-31';

-- 6. feladat
-- feltétel csak a HAVING-ben!
SELECT telepules
FROM partnerek
GROUP BY telepules
HAVING count(*) > 1;

-- 7. feladat
SELECT gynev AS ital, sum(karton)*6 AS doboz
FROM gyumolcslevek
JOIN kiszallitasok ON gyumolcslevek.id=kiszallitasok.gyumleid
GROUP BY ital
ORDER BY doboz DESC
LIMIT 3;