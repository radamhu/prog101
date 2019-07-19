2. feladat:

	SELECT eloadas.cim AS [Előadások címe],
       eloadas.ido AS Időpont
	FROM eloadas
	WHERE eloadas.ido LIKE "%2006%"
	ORDER BY eloadas.cim;
3. feladat:
SELECT eloadas.cim AS [Előadások címe],
       eloadas.ido AS Időpont,
tudos.nev as " Tudós"
FROM eloadas
  inner join kapcsolo on (eloadas.id = kapcsolo.eloadasid)
  inner join tudos on (kapcsolo.tudosid = tudos.id)
 WHERE eloadas.cim LIKE "%nyelv%"
 ORDER BY eloadas.cim;


4. feladat:
	SELECT tudos.terulet AS Tudomány,
       count(tudos.id) AS Db
	FROM tudos
	GROUP BY tudos.terulet
	ORDER BY count(tudos.id) DESC;
	
	
5. feladat:

	SELECT tudos.nev AS "Tudós",
	count(kapcsolo.eloadasid) as "előadás"
	FROM kapcsolo
    inner join tudos on (kapcsolo.tudosid = tudos.id)
    
	group by kapcsolo.tudosid having count(kapcsolo.eloadasid)>1
	ORDER BY (kapcsolo.eloadasid)

6. feladat:
		SELECT eloadas.cim AS [Előadás címe],
		eloadas.ido AS Ideje,
		SUBSTR( (
		SELECT eloadas.ido FROM eloadas WHERE eloadas.cim = "Mit tud az emberi agy?"), 1, 7) AS evhonap
		FROM eloadas
		WHERE SUBSTR(eloadas.ido, 1, 7) = evhonap
		ORDER BY eloadas.ido;
6. feladat:
	select tudos.terulet as "Terület",
	count(tudos.id) as "Db"
	from tudos
group by tudos.terulet
order by count(tudos.id)desc;
