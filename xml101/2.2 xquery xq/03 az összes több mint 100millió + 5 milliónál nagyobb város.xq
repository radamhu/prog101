(:írok egy ciklust a 1000m-nél nagyobb városokra:)
(: visszavárom az országot + a várost:)
(: 1 / jel, akkor csak az adott atrributum, ha // akkor mélyebbről is feleszi az attrubútum értéket:)
(:most ide varázsolom a városokat is xquery for ciklussal:)
(: adott ország városára írom a ciklust:)
for $o in //country
where $o//@population/number()>100000000
return <ország népesség="{$o/@population/string()}" név="{$o/@name/string()}">
{
  for $v in $o//city
  where $v/@population/number()>5000000
  return <város népesség="{$o/@population/string()}">{$v/name/string()}</város>
}
</ország>