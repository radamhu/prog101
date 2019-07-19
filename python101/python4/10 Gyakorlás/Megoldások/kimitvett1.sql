SELECT vasarlasok.datum AS datum, vevok.nev AS vevo, zoldsegek.nev AS aru, zoldsegek.egysegar*vasarlasok.mennyiseg AS ar
FROM vevok JOIN vasarlasok ON vevok.vevoazon=vasarlasok.vevo JOIN zoldsegek ON vasarlasok.aru=zoldsegek.zoldsegazon
WHERE datum LIKE "%-06-%"
ORDER BY datum,vevo;
