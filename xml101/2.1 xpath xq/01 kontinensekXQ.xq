for $k in //continent
let $kNEV := $k/@name/string() 
order by $kNEV
return $kNEV