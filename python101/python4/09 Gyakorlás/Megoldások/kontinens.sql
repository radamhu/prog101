SELECT kontinens,count(*) AS db
FROM fold JOIN iro ON fold.azon=iro.szulhely
GROUP BY kontinens
ORDER BY db DESC;