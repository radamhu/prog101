SELECT mufaj,sum(nezo) AS Néző 
FROM top10 
GROUP BY mufaj 
HAVING sum(nezo)>20000
ORDER BY sum(nezo) DESC;
