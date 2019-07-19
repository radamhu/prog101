<!--
Nyisd meg ezt a fájlt a Visual Studio Code-ban, majd nyisd meg mellé az előnézeti képet a jobb felső sarokban lévő Open Preview to the Side gombbal!
Figyeld meg, hogy ugyanúgy írhatunk megjegyzéseket, mint a HTML-ben, és ezek nem jelennek meg az eredményben!
-->

# Markdown bevezetés

A MarkDown formátum fő célja, hogy könnyű legyen írni és olvasni a szöveget. "Sima szöveget" használ a formázáshoz, és a szöveget HTML-re, PDF-re, vagy docx-re lehet fordítani.

Leggyakrabban Readme fájlokhoz használják, például a GitHub-on.

Több változata is van, amelyek csak kisebb kiegészítésekben térnek el egymástól, az alapok mindben ugyanazok.

A Visual Studio Code a [CommonMark](http://commonmark.org/) Markdown specifikációt használja, a GitHub a [Github Flavored MarkDown](https://github.github.com/gfm/)-t, amely a CommonMark-on alapul.

Bármelyik editort használhatjuk szövegszerkesztőként. Mi a Visual Studio Code-t fogjuk, amely alapból támogatja a MarkDown formátum használatát, és a támogatás bővítményekkel is kiegészíthető.

Például telepítsd a _markdownlint_ nevű bővítményt! Ez zöld hullámvonallal jelöli a markdown formátumú szövegben a hibákat, következetlenségeket.

---

## Bekezdések

A bekezdéseket mindig üres sorokkal választjuk el egymástól.

Például ez egy új bekezdés.

> **FELADAT**: Próbáld ki, mi történik, ha törlöd az előző két bekezdés közötti üres sort! És ha ezután teszel két szóközt az első mondat végére?

---

## Címsorok

A címsorokat a '#' szimbólummal jelöljük. '#' jelzi az egyes szintű címsort, '##' a kettes szintűt stb. Nézd meg, hogyan jelöltük ennek a szakasznak a címét!

> **FELADAT**: Készíts egy hármas szintű címsort a feladat alá!



Az egyes szintű címsorokat dupla aláhúzással, a kettes szintűeket pedig egyszeres aláhúzással is jelölheted. Nem muszáj végighúzni a vonalat.

Példák:

Egyes szintű címsor
===================

Kettes szintű címsor
--------------------

A zöld hullámvonalat ezért kaptuk, mert nem voltunk következetesek a címsorok jelölésében.

---

## Elválasztó vonal

Elválasztó vonalat három vagy több kötőjellel, csillaggal, vagy aláhúzással (-, *, _) készíthetsz. Célszerű mindenhol ugyanazt a jelölést alkalmazni, másképp itt is figyelmeztetést kapunk.

Példák:

---
***
___

## Idézetek

Az idézeteket (vagy amit kiemelten szeretnénk formázni) a '>' szimbólum jelöli (már használtuk a feladatoknál).

Példa:

> Ez egy idézet

A címsor és az idézet együtt is használható.

Példa:

> # H1 idézet

---

## Kiemelés

A dőlt betűket a szöveg előtti és utáni '*'-gal vagy '_'-sal jelölheted.

A félkövér betűket '**'-gal vagy '__'-sal adhatod meg.

Példák:

*Dőlt betűk*
__Félkövér betűk__

> **FELADAT**: Legyen a szakasz elején lévő szövegben a dőlt szó dőlt, a félkövér pedig félkövér! Próbáld ki, mi történik, ha három '*'-ot vagy '_'-t használsz!

---

## Listák

 A listaelemek jelöléséhez a következő karaktereket használhatod (a sor elején):  
 '-', '*', '+' (egy listában lehetőleg csak egyfélét használj!)

Példák:

- elem
* elem
+ elem
- sdfsd
- jdhgsa

Alpontokat (két szóközös) behúzással készíthetsz.

Példa:

- pont
  - alpont

A számozott listákban adj meg számokat!

Példa:

1. elem 1
2. elem 2
3. elem 3

> **FELADAT**: Készíts egy felsorolást a három kedvenc TV műsorodból a feladat alá!

> **FELADAT**: Készíts egy számozott listát kedvenc gyümölcseidből a feladat alá! Mi történik, ha nem sorban következnek a számok, vagy mindegyik elé 1-et írsz?

---

## Hivatkozások

Ha csak a hivatkozást szeretnéd megjeleníteni, add meg < és > jelek között!

Példa: <http://index.hu>

> **FELADAT** Készíts az iskolai honlapra mutató hivatkozást  ide: 

A hivatkozás szövegét [ és ] között adhatod meg, de ebben az esetben a hivatkozást zárójelek közé kell tenni.

Példa: [GitHub](http://www.github.com)

> **FELADAT** Készíts egy hivatkozást a https://code.visualstudio.com/ címre Visual Studio Code néven ide:

Ha többször is meg kell adni ugyanazt a hivatkozást, akkor készíthetsz hozzá egy referenciát, és azt használhatod helyette. Így nem kell másolnod a hivatkozást, és szükség esetén egyszerre mindenhol módosítható.

Példa:

[PC World][pcw]

[pcw]: https://pcworld.hu/

Az oldal másik részén lévő címsorokra is készíthetünk hivatkozást. Ekkor a címsor szövege elé egy '#"-et kell tenni, a szóközök helyett pedig kötőjelet, a címet pedig csupa kisbetűvel kell írni. Ilyen hivatkozásokból akár tartalomjegyzéket is készíthetünk az oldalhoz.

Példa:

[Elválasztó vonal](#elválasztó-vonal)

> Próbáld ki a fent hivatkozást, majd ugorj vissza ide az <kbd>Alt+balra nyíl</kbd> billentyűk megnyomásával!

## Képek

A képek megadása hasonlít a hivatkozásokéhoz, csak elé kell tenni egy '!'-t.

Példa:

![Pogány Frigyes](http://poganysuli.hu/images/pf.jpg)

A kép helyi fájl is lehet. Szükség esetén meg kell adni az elérési utat.

A hivatkozásokhoz hasonlóan a képekhez is lehet referenciákat készíteni.

> **FELADAT**: Szúrd be a feladat után a ribbon.jpg képet! Az alternatív szöveg Szalagok legyen!



---

## Programkód

A soron belüli kódot `backtick` karakterekkel lehet jelölni (\` \`). Beírása: <kbd>AltGr+7</kbd>

A kód blokkokat 3 backtick karakterrel, vagy 4 szóközös behúzással jelölheted.

Példa:

``` 
var num = 0;
var num2 = 0;
```

A nyitó backtick karakterek mellett ajánlott megadni a programozási nyelvet is, mert így színezi is a kódot. (Erre figyelmeztet az előző példában a zöld hullámvonal.)

Javascript példa:

```javascript
var num = 0;
var num2 = 0;
```

HTML példa:

```html
<div>
    <p>This is an html example</p>
</div>
```

---

## Táblázatok

A táblázat oszlopai elé és után pipe (|) karaktert kell tenni. A fejlécet egy olyan sorral választjuk el az adatoktól, amelyben az adatok helyett - jelek vannak. (Minden cellában legalább három.)

Példa:

| Fejléc 1 | Fejléc 2 | Fejléc 3 |
| --- | --- | --- |
| Adat 1 | Adat 2 | Adat 3 | 

Figyeld meg, hogy a celláknak nem kell egyforma szélesnek lenniük! Ha viszont olvasható szöveget szeretnél, célszerű egyforma hosszúra írni őket!

> **FELADAT**: Egyenlítsd ki a cellák szélességét a fenti táblázatban! Utána készíts egy új sort a táblázat végére!

A cellákban alapértelmezésben balra vannak igazítva az adatok. Az elválasztó vonalnál kettőspontokkal jelölhetjük, ha egy oszlopban mást szeretnénk.

Ha a vonal végére teszünk kettőspontot (`---:`), akkor jobbra fog igazítani az oszlopban, ha mindkét végére (`:---:`), akkor pedig középre.

Example

| Fejléc | Fejléc 1 | Fejléc 2  |
| ------ | :------: | --------: |
| Balra igazítva | Középre igazítva | Jobbra igazítva | 

---

## HTML kód

A szövegbe tetszőleges HTML kódot is írhatunk.
Például az alábbi kód:

```html
<p>HTML bekezdés</p>
```

... eredménye ez lesz:

<p>HTML bekezdés</p>

---

## CSS kód

A style tag segítségével CSS kódot is megadhatunk. Például:

```html
    <style>
        body {
            background-color:lightyellow;
        }
    </style>
```

---

## Más formátumokra alakítás

Ehhez telepítenünk kell egy kiegészítőt. Többféle lehetőség van, legegyszerűbb a Markdown PDF kiegészítő használata.

> **FELADAT**: Telepítsd a Markdown PDF kiegészítőt, majd próbáld ki az exportálást mindegyik formátumba!  
Az exportáláshoz kattints a jobb gombbal a szövegre, majd válaszd a `Markdown PDF: export` kezdetű parancsok valamelyikét!  
Nézd meg a készített fájlokat! Milyen problémák adódhatnak az átalakításnál?
