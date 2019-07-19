03. Osztályváltozók
===================

Osztályváltozók
---------------

Már tudjuk, hogy a metódusok minden példányra közösek, az adattagok
viszont minden példányra külön léteznek. Ezek a példányváltozók,
amelyeknek minden példánynál különböző lehet az értékük.

Szükség lehet azonban olyan adattagokra is, amelyek minden példányra
közösek. Ilyenek definiálására is van lehetőség a Java-ban. Ezeket
nevezzük osztályváltozóknak.

Egy osztályváltozók akkor jön létre, amikor az osztály betöltődik.

Az osztályváltozók definiálásához használni kell a static módosítót,
pl.\
public static int a;

(Bár néha a módosító miatt statikus tagoknak is nevezzük az
osztályváltozókat, a statikus szó senkit ne tévesszen meg. A statikus
ebben az esetben nem jelent állandóságot!)

Az osztályváltozókat, akárcsak a metódusokat, az osztály bármelyik
példánya használhatja. Osztályon belül ugyanúgy a nevével lehet rá
hivatkozni.

Másik osztályból az osztálynévvel szoktak rá hivatkozni. Például:\
Osztaly.a

Ez akkor is használható, ha nincs egyetlen példány sem az osztályból.

Ha vannak példányok, akkor azok nevével is hivatkozhatunk. Például
tegyük fel, hogy p1 és p2 példányunk van az Osztály-ból. Ekkor így is
hivatkozhatunk az a osztályváltozóra:\
p1.a\
p2.a

Ebben az esetben a fenti két hivatkozás ugyanarra a közös változóra
hivatkozik.

Osztálymetódusok
----------------

A metódusok közösek a példányokra nézve, mégis érdemes megkülönböztetni
az osztály- és példánymetódusokat.

Az osztálymetódusok ugyanis nem függnek példánytól, tehát használhatók
azelőtt vagy anélkül is, hogy példányt hoznánk létre.

Ennek következményeként egy osztálymetódusban nem ismert az aktuális
példány fogalom, tehát nincs this. Nem hivatkozhatunk a
példányváltozókra sem. Használhatunk benne osztályváltozókat vagy
paraméterváltozókat.

Osztálymetódusok definiálásához is a static módosítóra van szükség.
Például:\
public static int eveknyugdijig() ...

Eddig is találkoztunk már osztálymetódusokkal. Ilyenek voltak például a
Math.sqrt() és az Arrays.sort() metódusok. Ezek az osztállyal
kapcsolatos szolgáltatásokat nyújtanak, és a használatukhoz nem kell
példányt létrehozni az osztályból.

Ezen kívül akkor is osztálymetódusokat használunk, amikor osztályváltozó
értékét kell lekérdezni, vagy beállítani.

A main metódus, amelyet minden programban használunk, szintén statikus.
És ha nem hozunk létre példányt a main metódus osztályából, akkor az
osztály (például az AlkalmazottDemo) metódusainak és adattagjainak is
statikusaknak kell lenniük.

Feladat
-------

Ebben a leckében kiegészítjük az alkalmazottakkal kapcsolatos feladatot,
és közben kipróbáljuk a ma tanultakat. A megoldást úgy fogjuk
kiegészíteni, hogy megadja a nyugdíjig hátralévő éveket is.

1.  Indítsd el a NetBeans programot, és nyisd meg az AlkalmazottDemo
    projektet!

2.  Szeretnénk tárolni a dolgozók születési évét is. Vegyél fel egy
    privát szulev nevű, egész típusú példányváltozót!

3.  Készíts egy getSzulev() nevű publikus metódust, amellyel
    lekérdezhető a születési év!

4.  Az új adat miatt a konstruktort is módosítani kell, hogy a születési
    évet is beállítsa:\
    ![](.\/media/image1.png){width="5.625in"
    height="0.9479166666666666in"}

5.  A konstruktor hívásakor is meg kell adni a harmadik paramétert,
    ezért a főprogramban módosítani kell a hívást:\
    ![](.\/media/image2.png){width="5.5625in" height="0.21875in"}\
    Próbáld ki a programot!

6.  Az alkalmazottak korának meghatározásához szükség van az aktuális
    évre, a nyugdííjig hátralévő évek kiszámításához pedig a korhatárra.
    Ezek az adatok közösek minden alkalmazottra, ezért
    osztályváltozókban tároljuk őket:\
    ![](.\/media/image3.png){width="3.6458333333333335in"
    height="1.15625in"}

7.  Mivel ezek privát változók, csak publikus metódusokkal lehet őket
    módosítani. Ezek is osztálymetódusok lesznek:\
    ![](.\/media/image4.png){width="4.802083333333333in"
    height="1.1458333333333333in"}\
    Figyeld meg, hogy az osztályváltozókat az osztály nevével
    különböztettük meg a paraméterváltozóktól! (itt nincs this)

8.  Most már meghatározhatjuk a nyugdíjig hátralévő évek számát egy
    metódussal:\
    ![](.\/media/image5.png){width="3.6979166666666665in"
    height="0.59375in"}

9.  Írasd ki az eredményt a többi adattal együtt! Módosítsd az adatok()
    metódust így:\
    ![](.\/media/image6.png){width="5.541666666666667in"
    height="0.5833333333333334in"}

10. Futtasd a programot!

11. Állítsd az évet 2018-ra a főprogram elején!\
    ![](.\/media/image7.png){width="6.75in"
    height="0.8958333333333334in"}\
    Figyeld meg, hogy a metódust az Alkalmazott osztály nevével
    azonosítottuk, és már az alkalmazott példány létrehozása előtt!!!

12. Módosítsd a nyugdíjkorhatárt 67 évre, majd írasd ki ismét az
    adatokat!\
    ![](.\/media/image8.png){width="6.75in"
    height="1.5416666666666667in"}\
    Próbáld ki!

Aktuális dátum megállapítása
----------------------------

Nem túl elegáns, hogy a program elején kézzel kell beállítani az
aktuális évet. Nézzük meg, hogy a Java-ban hogyan lehet lekérdezni az
évet:

![](.\/media/image9.png){width="6.78125in" height="2.625in"}

Próbáld ki!

A dátum meghatározásához a Calendar osztályt használjuk. Ebből
kivételesen nem a new segítségével lehet új példányt létrehozni, hanem a
getInstance() metódussal. (Ezt gyártó metódusnak nevezik.)

A most változó ezek után tartalmazza az aktuális dátumot és időt,
amelyeket le lehet lekérdezni. A YEAR helyén a következő állandókat is
lehet használni: MONTH, DAY, DAY\_OF MONTH, DAY\_OF\_WEEK,
DAY\_OF\_YEAR, WEEK\_OF\_MONTH, WEEK\_OF\_YEAR, HOUR\_OF\_DAY, MINUTE,
...

Mit jelentenek ezek?

Kérdés
------

Miért nem az alkalmazottak korát tároltuk a születési év helyett?
