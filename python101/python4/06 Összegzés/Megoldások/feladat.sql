SELECT mufaj,sum(bevetel) 
FROM top10 
WHERE nemzet='amerikai'
GROUP BY mufaj
HAVING  sum(bevetel) >100000000
ORDER BY  sum(bevetel)  DESC;