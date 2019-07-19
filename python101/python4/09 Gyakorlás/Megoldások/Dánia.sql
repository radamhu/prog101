SELECT orszag,count(*) AS db
FROM fold JOIN iro ON fold.azon=iro.szulhely
GROUP BY orszag
HAVING count(*) > 
	(SELECT count(*) AS db
	FROM fold JOIN iro ON fold.azon=iro.szulhely
	GROUP BY orszag
	HAVING orszag='Dánia')
ORDER BY db DESC;