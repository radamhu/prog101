INSERT INTO palyak (nev, hossz, szelesseg, anyag) VALUES ("Tököl",1100, 50, "fű");
SELECT * FROM palyak WHERE anyag='beton';
SELECT nev, hossz FROM palyak WHERE hossz>=1500 ORDER BY hossz DESC;
SELECT nev FROM palyak GROUP BY nev HAVING COUNT(*)>1;
SELECT nev, hossz*szelesseg AS terulet FROM palyak ORDER BY terulet DESC LIMIT 1
SELECT DISTINCT nev FROM palyak WHERE anyag='fű' 
 AND nev NOT IN (SELECT DISTINCT nev FROM palyak WHERE anyag='beton')