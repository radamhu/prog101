SELECT count(*) AS db
FROM fold JOIN iro ON fold.azon=iro.szulhely
GROUP BY orszag
HAVING orszag='Dánia';