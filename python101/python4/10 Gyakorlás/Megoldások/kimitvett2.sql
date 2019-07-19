SELECT vasarlasok.datum AS datum, vevok.nev AS vevo, zoldsegek.nev AS aru, zoldsegek.egysegar*vasarlasok.mennyiseg AS ar
FROM vasarlasok JOIN vevok ON vasarlasok.vevo=vevok.vevoazon JOIN zoldsegek ON vasarlasok.aru=zoldsegek.zoldsegazon
WHERE datum LIKE "%-06-%"
ORDER BY datum,vevo;
