A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!


1. feladat:
CREATE DATABASE nyelviskola
 DEFAULT CHARACTER SET utf8
 COLLATE utf8_hungarian_ci;

3. feladat:
ALTER TABLE vizsgak
 ADD FOREIGN KEY (nyelvid) REFERENCES nyelvek(id);
 ALTER TABLE jelentkezesek
 ADD FOREIGN KEY (vizsga) REFERENCES vizsgak(sorsz); 

4. feladat:
UPDATE jelentkezesek
 SET mobil='30784613'
 WHERE sorsz = 9;

5. feladat:
INSERT INTO nyelvek
 VALUES
 (8, 'holland');

6. feladat:
SELECT
 min(2018-szulev) AS legfiatalabb,
 max(2018-szulev) AS legidosebb
 FROM jelentkezesek; 

7. feladat:
Innentől az 5-ös
SELECT idopont
 FROM vizsgak INNER JOIN jelentkezesek
 ON vizsgak.sorsz = jelentkezesek.vizsga
 GROUP BY idopont
 HAVING count(nev)=25
 ORDER BY idopont DESC; 

8. feladat:
Innentől az 5-ös
SELECT
 nyelv,
 szint,
 count(nev) AS vizsgazo
 FROM vizsgak INNER JOIN jelentkezesek
 ON vizsgak.sorsz = jelentkezesek.vizsga
 INNER JOIN nyelvek
 ON vizsgak.nyelvid=nyelvek.id
 GROUP BY nyelv, szint
 ORDER BY vizsgazo DESC; 