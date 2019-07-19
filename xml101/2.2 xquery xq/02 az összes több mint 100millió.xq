for $orszag in //country
let $orszagNev:=$orszag /@name/string()
where $orszag//@population/number()>1000000
order by $orszag/@name/string() descending
return $orszag/@name/string()
