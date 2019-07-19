/* 1. feladat:  */

/* 3. feladat:  */
SELECT nev FROM epizodok WHERE sorozat = '1/5';

/* 4. feladat:  */
SELECT COUNT(*) as 'epizódok száma' FROM epizodok;

/* 5. feladat:  */
SELECT DISTINCT szinesz FROM forgatokonyv WHERE szinesz IS NOT NULL ORDER BY szinesz;

/* 6. feladat:  */
SELECT reszletek FROM forgatokonyv WHERE szinesz = 'John Cleese' AND resz = 'Italian lesson';

/* 7. feladat:  */
SELECT szinesz as színész, count(*) as 'bejegyzések száma' 
FROM forgatokonyv 
WHERE szinesz IS NOT NULL GROUP BY szinesz
ORDER BY COUNT(*) DESc LIMIt 1;