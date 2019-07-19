(:előszor városra írok for ciklust, legyen csak egy for returnel:)
(: aztán a paran folyókat keresem, házikóval megnézem a parana folyót, id-jére rákeresek:)
(: két dolog, azokat a városokat keresem amely városoknak alocated-e a gyermekeleme, pontosabban
annak a water attribútuma az ugyanaz az id-je mint a parana folyó id-je, akkor van annak a partján:)

for $v in //city
where $v/located_at/@water=//river[@name="Parana"]/@id/string()
order by $v/@latitude/number() descending
return $v/name/string()


