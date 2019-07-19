for $orszag in //country
let $orszagNev:=$orszag /@name/string()
where $orszag//@population/number()>100000000
order by $orszag/@population/number() descending
return <ország népesség="{$orszag/@population/string()}">{$orszagNev}</ország>