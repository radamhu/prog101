A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!

1. feladat:



3. feladat:
select distinct partnerek.telepules as "Település" from partnerek order by partnerek.telepules asc;

4. feladat:
SELECT count(partnerek.telepules) as "Alkalmak" 
  FROM partnerek
       INNER JOIN
       kiszallitasok ON (partnerek.id = kiszallitasok.partnerid) 
       where partnerek.telepules="Vác"
ORDER BY partnerek.telepules ASC ;
5. feladat:
SELECT (kiszallitasok.karton) AS Legtobb
  FROM kiszallitasok
 WHERE kiszallitasok.datum > "2016-05-00" AND 
       kiszallitasok.datum < "2016-05-32"
 GROUP BY kiszallitasok.karton
 ORDER BY (kiszallitasok.karton) DESC
 LIMIT 1;

6. feladat:

SELECT partnerek.telepules
  FROM partnerek

 GROUP BY partnerek.telepules having  count(partnerek.id)>1
 ORDER BY count(partnerek.id) DESC;

7. feladat:

