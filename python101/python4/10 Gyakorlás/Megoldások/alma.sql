SELECT zoldsegesek.nev AS zoldseges, SUM(vasarlasok.mennyiseg) AS osszesen
FROM vasarlasok JOIN zoldsegek ON vasarlasok.aru=zoldsegek.zoldsegazon JOIN zoldsegesek ON vasarlasok.zoldseges=zoldsegesek.zoldsegesazon
WHERE zoldsegek.nev='alma'
GROUP BY zoldsegesek.zoldsegesazon
ORDER BY osszesen DESC LIMIT 1;