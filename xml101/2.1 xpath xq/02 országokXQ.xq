for $k in //country
let $kNEV := $k/@name[1]/string()
order by $kNEV
return $kNEV