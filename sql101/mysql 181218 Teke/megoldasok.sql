A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!


1. feladat:


3. feladat:
SELECT nev FROM `versenyzok` WHERE korcsop="A" ORDER BY nev ASC;

4. feladat:
SELECT DISTINCT rajtszam FROM versenyzok JOIN eredmenyek ON versenyzok.rajtszam = eredmenyek.versenyzo WHERE ures=0;

5. feladat:
SELECT nev, round(avg(tarolas),2) AS atlagpont FROM eredmenyek INNER JOIN versenyzok ON eredmenyek.versenyzo = versenyzok.rajtszam GROUP BY rajtszam ORDER BY atlagpont DESC;
6. feladat:
SELECT egyesuletek.nev FROM egyesuletek INNER JOIN versenyzok ON  versenyzok.egyid = egyesuletek.id GROUP BY egyesuletek.id ORDER BY COUNT(*) DESC LIMIT 1;

7. feladat:
SELECT 
	nev, 
    sum(teli+tarolas) AS eredmeny, 
    sum(tarolas) AS tarolas, 
    sum(ures) AS ures 
FROM eredmenyek 
INNER JOIN versenyzok ON eredmenyek.versenyzo = versenyzok.rajtszam
WHERE korcsop = 'B'
GROUP BY nev
ORDER BY eredmeny DESC, tarolas DESC, ures ASC;
