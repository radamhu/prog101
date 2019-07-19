SELECT szemely
FROM fold JOIN iro ON fold.azon=iro.szulhely
WHERE kontinens = (SELECT kontinens FROM fold JOIN iro ON fold.azon=iro.szulhely WHERE szemely='Pablo Neruda') ;