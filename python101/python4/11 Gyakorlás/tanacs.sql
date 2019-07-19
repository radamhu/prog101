SELECT gazda.nev,sum(kezeles.dij) AS osszeg
FROM gazda JOIN kutya ON gazda.gazdaazon=kutya.gazdaazon
                         JOIN kezeles ON kutya.kutyaazon=kezeles.kutyaazon
						 JOIN kezelestipus ON kezeles.kezelestipazon=kezelestipus.kezelestipusazon
WHERE kezelestipus.jelleg='tanácsadás'
GROUP BY gazda.gazdaazon
ORDER BY osszeg DESC LIMIT 1;