2. 
SELECT * FROM szalloda ORDER BY besorolas DESC, szalloda.nev;

3.
SELECT szalloda.nev, indulas, ar 
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
JOIN helyseg ON szalloda.helyseg_az = helyseg.az
WHERE orszag = "Tunézia";

4.
SELECT orszag, szalloda.nev, besorolas, indulas, ar
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
JOIN helyseg ON szalloda.helyseg_az = helyseg.az
WHERE indulas LIKE "2018-03%" AND tenger_tav=0;
(A dátumra vonatkozó feltételt lehetne BETWEEN-nel is.)
5.
SELECT orszag, szalloda.az, ar
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
JOIN helyseg ON szalloda.helyseg_az = helyseg.az
WHERE szalloda.besorolas<5 AND szalloda.felpanzio=1 AND szalloda.repter_tav<=20
GROUP BY orszag, szalloda.az, ar
ORDER BY ar LIMIT 5;
vagy:
SELECT DISTINCT orszag, szalloda.az, ar
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
JOIN helyseg ON szalloda.helyseg_az = helyseg.az
WHERE szalloda.besorolas<5 AND szalloda.felpanzio=1 AND szalloda.repter_tav<=20
ORDER BY ar LIMIT 5;

6.
SELECT indulas, indulas+idotartam-1 AS erkezes, 6*ar AS osszkoltseg
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
JOIN helyseg ON szalloda.helyseg_az = helyseg.az
WHERE szalloda.nev="marhaba"
ORDER BY indulas DESC;

7.
SELECT szalloda.nev, COUNT(*) AS db
FROM szalloda 
JOIN tavasz ON szalloda.az = tavasz.szalloda_az
GROUP BY szalloda.nev;