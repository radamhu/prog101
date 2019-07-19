SELECT ev,count(*) AS db
FROM fold JOIN  iro ON fold.azon=iro.szulhely
GROUP BY ev
HAVING count(*)>1;