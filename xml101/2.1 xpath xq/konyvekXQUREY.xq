(: 3000-nél drágább könyvek :)
for $k in //könyv
where $k/ár/number()>3000
order by $k/cím/string()
return $k/cím/string()