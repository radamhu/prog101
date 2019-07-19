SELECT osztalyok.of, avg(diakok.atlag) 
FROM osztalyok 
JOIN diakok ON osztalyok.osztaly=diakok.osztaly
GROUP BY osztalyok.of;
