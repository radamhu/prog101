A feladatok megoldására elkészített SQL parancsokat illessze be a feladat sorszáma után!

1. feladat:

3. feladat:

4. feladat:
SELECT vnev,nepesseg,terulet FROM varos WHERE terulet>400;
5. feladat:
SELECT vnev,nepesseg FROM varos JOIN megye ON varos.megyeid = megye.id WHERE mnev = "fejér" AND nepesseg > 15000;
6. feladat:
SELECT varostipus.vtip AS 'Város típus', COUNT(*) AS 'Városok száma',SUM(nepesseg) AS 'népesség' FROM varos JOIN varostipus ON varostipus.id=varos.vtipid WHERE varostipus.vtip != 'főváros' GROUP BY varostipus.vtip;
7. feladat:
SELECT mnev, COUNT(*) AS db FROM varos JOIN megye ON varos.megyeid = megye.id WHERE jaras <> kisterseg GROUP BY mnev HAVING db>8 ORDER BY db DESC;