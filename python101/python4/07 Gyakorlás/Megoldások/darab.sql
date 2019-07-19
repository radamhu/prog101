SELECT orszag,count(*) AS Darab 
FROM adatok 
GROUP BY orszag 
ORDER BY Darab DESC;