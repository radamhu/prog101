DELETE
FROM vevok2
WHERE vevok2.vevoazon NOT IN (SELECT DISTINCT vevok2.vevoazon
FROM vevok2 JOIN vasarlasok ON vevok2.vevoazon=vasarlasok.vevo);