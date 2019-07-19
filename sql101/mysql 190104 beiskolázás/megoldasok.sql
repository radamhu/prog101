A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!


1. feladat:


3. feladat:
ALTER TABLE `jelentkezesek` ADD CONSTRAINT `jelentkezesek_ibfk_1` FOREIGN KEY (`tag`) REFERENCES `tagozatok`(`akod`) ON DELETE RESTRICT ON UPDATE RESTRICT; 
ALTER TABLE `jelentkezesek` ADD CONSTRAINT `jelentkezesek_ibfk_2` FOREIGN KEY (`diak`) REFERENCES `diakok`(`oktazon`) ON DELETE RESTRICT ON UPDATE RESTRICT;
4. feladat:
UPDATE diakok  SET kpmagy = 43 WHERE oktazon = '0143302';

5. feladat:
SELECT nev FROM diakok WHERE kpmagy = 50 AND kpmat = 50 AND hozott > 40 ORDER BY nev;

6. feladat:
JOIN-nál fontos hogy honnan inudlok, mert akkor ahonnan indulok kapcsolom a hovához
SELECT agazat, COUNT(*) AS jelentkezoszam,
	max(hozott)-min(hozott) AS terjedelem
FROM diakok
JOIN jelentkezesek ON jelentkezesek.diak=diakok.oktazon
JOIN tagozatok ON tagozatok.akod=jelentkezesek.tag
WHERE hely=1 AND nyek=1
GROUP BY agazat
ORDER BY jelentkezoszam DESC;

7. feladat:
SELECT nev, agazat, nyek, hely, 2*hozott*kpmagy+kpmat AS osszpont
FROM diakok
JOIN jelentkezesek ON jelentkezesek.diak=diakok.oktazon
JOIN tagozatok ON tagozatok.akod = jelentkezesek.tag
ORDER BY agazat, osszpont DESC, hely;

