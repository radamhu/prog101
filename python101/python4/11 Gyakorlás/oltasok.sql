SELECT kezeles2.kezelesazon
FROM kezeles2 
JOIN kezelestipus ON kezeles2.kezelestipazon=kezelestipus.kezelestipusazon
WHERE kezelestipus.jelleg='védőoltás' AND kezeles2.kezdet>='2010-07-01';