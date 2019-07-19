SELECT count(*) 
FROM (SELECT gazda.nev,count(gazda.gazdaazon)
	FROM gazda JOIN kutya ON gazda.gazdaazon=kutya.gazdaazon
	GROUP BY gazda.gazdaazon
	HAVING count(gazda.gazdaazon)>1);
