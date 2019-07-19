select * from adatok;
select nev, vagyon from adatok where vagyon <50;
create table adatok2 as select * from adatok;
select nev,vagyon from adatok where 2013-ev>70 AND 2013-ev<79 order by nev;
select helyezes AS Helyezés, nev AS Név, (vagyon*280) AS Vagyon from adatok;
select avg(vagyon) as Átlag from adatok where ev<1950;
select orszag, count(orszag) as Darab from adatok group by orszag order by Darab desc;