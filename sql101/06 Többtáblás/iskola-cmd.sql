SELECT osztalyok.osztaly, osztalyok.of, diakok.nev, diakok.osztaly FROM osztalyok, diakok;
SELECT osztalyok.osztaly, osztalyok.of, diakok.nev, diakok.osztaly 
FROM osztalyok, diakok 
WHERE osztalyok.osztaly=diakok.osztaly;

SELECT osztalyok.osztaly, osztalyok.of, diakok.nev, diakok.osztaly 
FROM osztalyok 
JOIN diakok ON osztalyok.osztaly=diakok.osztaly;

SELECT osztalyok.osztaly, osztalyok.of, diakok.nev 
FROM osztalyok 
JOIN diakok ON osztalyok.osztaly=diakok.osztaly
WHERE osztalyok.osztaly LIKE "_A";

SELECT A.nev, B.nev 
FROM diakok AS A 
JOIN diakok AS B ON A.osztaly=B.osztaly;

SELECT osztalyok.of, count(diakok.nev) 
FROM osztalyok 
LEFT JOIN diakok ON osztalyok.osztaly=diakok.osztaly
GROUP BY osztalyok.of;
