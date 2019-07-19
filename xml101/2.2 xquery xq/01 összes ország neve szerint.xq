(:az összes ország nevét ABC sorrendben:)
for $orszag in //country
let $orszagNev:=$orszag /@name/string()
order by $orszag/@name/string()
return $orszag/@name/string()
