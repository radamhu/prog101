06. Öröklődés 1.
================

Öröklődés
---------

Egy új osztályt egy másik osztály gyermekeként (leszármazottjaként) is
létrehozhatunk.

A gyermek osztály örökli a szülőjétől annak adattagjait, metódusait,
tagosztályait, azaz a gyermek osztály rendelkezik ezekkel a tagokkal,
anélkül, hogy definiálnia kellene.

A gyermek osztály ezen kívül definiálhat új tagokat is, valamint
megváltoztathatja az örökölt metódusokat (override: a metódus a
gyermekben is létezik, csak másképpen).

Ahol egy program a szülő osztály példányát várja (pl. paraméterként),
ott a gyermek osztály is használható. Más szóval: a szülő helyére
bármikor helyettesíthetünk gyermeket, mert a gyermek mindent tud, amit a
szülője.

Az öröklődés előnyei:

-   Modellezi a valós életet (pl. állat -\> emlős -\> kutya -\> ... ).

-   A kódot újra fel lehet használni (pl. egy gombot szeretnénk
    módosítani: csak a különbségeket kell megadni).

-   A helyettesíthetőség miatt általánosabb kódot lehet írni.

Az öröklődés hátránya, hogy a szülő osztály módosítása a gyermekekre is
hat, ezért a tervezésre sokkal jobban oda kell figyelni.

Szabályok
---------

-   A Java nyelvben csak egyszeres öröklés létezik. Azaz egy osztálynak
    > csak egy szülője lehet. (Pl. a C++ nyelvben lehet több szülő is.)

-   Egy osztály nem lehet saját maga szülője.

-   Egy szülőnek lehet több gyermeke.

-   Meg lehet tiltani, hogy egy osztálynak legyenek leszármazottai.
    > Ehhez az osztályra használni kell a final módosítót.

-   A gyermeknek szintén lehetnek gyermekei, így egy fa struktúra
    > alakulhat ki. A rokonsági kapcsolat elnevezése: ős és
    > leszármazott. Tehát ha egy osztály őse egy másiknak akkor vagy
    > szülője vagy a szülő szülője, stb.

-   A gyermek gyermeke örökli a szülőjének az örökölt tagjait is.

-   A gyermek minden adattagot, metódust és tagosztályt örököl, nem
    > választhatja meg, hogy melyeket örököl és melyeket nem.

-   A kontruktor nem öröklődik!

-   Ha egy osztálynak nem adok meg szülő osztályt, akkor automatikusan a
    > java.lang.Object osztály lesz a szülője.\
    > Tehát minden osztálynak van szülője, kivéve az Object-et. Az
    > Object a leszármazási fastruktúra gyökere. Az Object osztály
    > örökölhető tagjaival (pl. toString metódus) tehát minden osztály
    > rendelkezik.

-   Bár egy leszármazott örökli a szülője adattagjait, metódusait,
    > tagosztályait, de nem biztos, hogy közvetlenül használhatja őket.
    > Ha ugyanis a szülő osztály adattagja private, akkor a leszármazott
    > közvetlenül nem éri el a tagot. Közvetve persze elérheti, például
    > egy publikus metódus segítségével.

Gyermek osztály definiálása
---------------------------

Az osztály fejlécének végén az extends kulcsszó után meg kell adni a
szülő osztályt.

Például:

public class Szulo {\
public int a;\
private int b;\
\
public void metodus1() {\
}\
}

public class Gyermek **extends Szulo** {\
private double c;\
\
public void metodus2() {\
}\
}

A Gyermek osztály a Szulo leszármazottja. Három adattagja van: a, b, c,
és két metódusa: metodus1, és metodus2 (plusz azok a tagok, amelyeket a
Szulo szülőjétől, az Object osztálytól örököl).

Örökölt tagok elérése
---------------------

Az örökölt tagokat a leszármazott, ha eléri, akkor ugyanúgy
használhatja, mint a sajátjait.

Tehát a Gyemrek osztály belsejében a metodus1-et meghívhatja a nevével,
és az a adattagot is használhatja. A b adattagot nincs joga közvetlenül
elérni, de ha van olyan publikus metódusa a Szulo-nek amellyel értéket
lehet neki adni, akkor azon keresztül használhatja.

Ilyenkor használható a protected módosító (a private helyett). Azt a
tagot, amelyet protected módosítóval látunk el, eléri bármelyik
leszármazott (pontosabban a protected tagot elérik még az azonos
csomagban levő osztályok is, függetlenül attól, hogy leszármazott vagy
sem).

Örökölt tagok inicializálása
----------------------------

Mivel a leszármazott nem éri el őseinek a private tagjait, így hiába
létezik ilyen tagja, a konstruktorában nem képes közvetlenül
inicializálni azt.

Például adott a következő szülő osztály:

public class Szulo {\
private int a;\
private int b;\
\
public Szulo(int a, int b) {\
this.a = a;\
this.b = b;\
}\
\...\
}

És van egy gyermeke, amelynek van egy adata:

public class Gyermek extends Szulo {\
private int c;\
\...\
}

Ennek a Gyermek osztálynak a példányosításakor célszerű lenne mind a
három adattagját inicializálni, csakhogy a konstruktora nem nézhet ki
így:

public Gyermek(int a, int b, int c) {\
this.a = a;\
this.b = b;\
this.c = c;\
}\
hiszen a this.a és a this.b hivatkozás hibás, mert a private örökölt
tagokhoz nincs joga hozzáférni.

Az nem lenne jó, ha csak emiatt kénytelenek lennénk a szülő osztályban
setter metódusokat készíteni. Lehet, hogy csak egyszer beállítható
adattagokat szeretnénk, vagy az is lehet, hogy a szülő osztályt más írta
és nincs is lehetőségünk módosítani, esetleg a forrás nem is áll
rendelkezésünkre.

A megoldás az, hogy a konstruktor meghívja a szülőjének a konstruktorát,
elvégre az azért van, hogy inicializálja a saját tagjait. Ezt a
konstruktor első utasításaként tehetjük meg a\
super(paraméterek);\
utasítással.

Például:

public Gyermek(int a, int b, int c) {\
super(a, b);\
this.c = c;\
}

Ha a szülő osztálynak több konstruktora is van, akkor bármelyiket
meghívhatjuk (a paraméterek alapján dönti el, hogy melyik hívódik meg).

Ezek szerint egy konstruktor első utasítása lehet:

-   **this**(paraméterek); utasítás, amellyel az osztály egy másik
    > konstruktorát hívjuk meg (lásd konstruktor túlterhelés)

-   **super**(paraméterek); utasítás, amellyel a szülő osztály egyik
    > konstruktorát hívjuk meg

-   ha **egyik sem**, akkor automatikusan beszúródik egy super();
    > utasítás, amely a szülő osztály paraméter nélküli konstruktorát
    > hívja meg.

Ebből következik, hogy a szülő osztálynak mindenképpen meghívódik a
konstruktora, a szülő osztály konstruktora pedig meghívja az ő
szülőjének a konstruktorát, és így tovább egészen az Object osztályig,
amelynek már nincs szülője.

A példányosítás folyamata
-------------------------

Nézzük meg a példányosítás menetét:

1.  Hely foglalódik a példányváltozók számára, de nem csak az osztályban
    > definiáltak számára, hanem az örököltek számára is.

2.  Inicializálja a példányváltozókat a definícióban megadott
    > inicializálással vagy a default értékkel.

3.  Meghívódik az osztály konstruktora, amely első lépésként meghívja a
    > szülőjének a konstruktorát, amely első lépésként meghívja az ő
    > szülőjének a konstruktorát, és így tovább az Object osztályig.\
    > Tehát egy osztály példányosításakor először az Object
    > konstruktorában levő utasítások hajtódnak végre, majd visszatér a
    > végrehajtás a gyermekébe és annak a konstruktorának az utasításai
    > hajtódnak végre, és így tovább egészen addig az osztályig,
    > amelyiket példányosítjuk.

4.  A konstruktor visszatér a példányra mutató referenciával (a példány
    > címével).

A konstruktor hívási mechanizmus következményei
-----------------------------------------------

-   Ha egy osztály konstruktorának első utasításában nincs this() vagy
    > super() hívás (és ezért automatikusan beszúródik egy super()),
    > akkor a szülő osztályban kell lennie paraméter nélküli
    > konstruktornak.

-   Ugyanez megfordítva: ha egy osztálynak nincs paraméter nélküli
    > konstruktora, akkor a gyerekének konstruktorában kötelező a
    > super(paraméterek) utasítást használni, megadva a szülőnek szóló
    > paramétereket.

-   Ha egy osztálynak egyáltalán nincs konstruktora, akkor a szülőjének
    > kell lennie paraméter nélküli konstruktorának. Hiszen a default
    > konstruktor első utasítása automatikusan super();

Feladat
-------

A lecke anyagát egy árukkal kapcsolatos példán fogjuk kipróbálni.
Először definiálunk egy általános Aru osztályt, majd ennek
leszármazottjaként egy speciálisabb Kenyer osztályt.

1.  Indítsd el a NetBeans programot, és kezdj egy új projektet AruDemo
    néven!

2.  Nevezd át az automatikusan létrehozott csomagot arus-ra (Refactor,
    Rename)! Ez a parancs minden osztályban átírja a csomag nevét.
    Ellenőrizd az AruDemo osztályban!

3.  Készíts egy új, Aru nevű osztályt, main() metódus nélkül!

4.  Készítsd el az Aru osztály példányváltozóit és konstruktorát az
    alábbiak szerint:\
    ![](.\/06Öröklődés1/media/image1.png){width="5.25in"
    height="3.5in"}

5.  Készíts egy metódust, amely kiszámítja az áru bruttó árát!\
    ![](.\/06Öröklődés1/media/image2.png){width="6.072916666666667in"
    height="0.6875in"}

6.  Készíts egy metódust, amely kiírja egy áru adatait! Ez írja felül az
    örökölt toString() metódust!\
    ![](.\/06Öröklődés1/media/image3.png){width="4.833333333333333in"
    height="0.875in"}

7.  Készíts egy metódust, amely egy adott százalékkal megnöveli az áru
    nettó árát!\
    ![](.\/06Öröklődés1/media/image4.png){width="6.28125in"
    height="0.6666666666666666in"}

8.  Készíts egy metódust, amely összehasonlítja az áru bruttó árát a
    paraméterként kapott másik áru bruttó árával! Ha az első drágább, a
    visszaadott érték 1, ha az első olcsóbb, akkor -1, egyébként (ha
    egyenlőek), akkor 0.\
    ![](.\/06Öröklődés1/media/image5.png){width="4.322916666666667in"
    height="2.2083333333333335in"}

9.  Hozz létre egy Kenyer nevű osztályt, amely az Aru osztály
    leszármazottja!

10. Legyen egy mennyiseg nevű privát adattagja!\
    ![](.\/06Öröklődés1/media/image6.png){width="3.625in"
    height="1.78125in"}

11. Konstruktora inicializálja a saját és a szülő osztály adattagjait!\
    ![](.\/06Öröklődés1/media/image7.png){width="7.25in"
    height="0.875in"}

12. Legyen egy publikus metódusa a mennyiség lekérdezésére!\
    ![](.\/06Öröklődés1/media/image8.png){width="3.7708333333333335in"
    height="0.6875in"}

13. Legyen egy privát metódusa a bruttó egységár meghatározására!\
    ![](.\/06Öröklődés1/media/image9.png){width="3.9583333333333335in"
    height="0.6354166666666666in"}

14. Legyen osztálymetódusa, amely igaz értéket ad vissza, ha a
    paraméterként kapott két Kenyer közül az elsőnek nagyobb az
    egységára (bruttóár/mennyiség)! Ez használja az előző pontban
    készített privát egysegar metódust!\
    ![](.\/06Öröklődés1/media/image10.png){width="6.09375in"
    height="0.6666666666666666in"}

A következő leckében folytatjuk.
