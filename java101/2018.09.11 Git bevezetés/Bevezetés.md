# Bevezetés

## Alapfogalmak

**Version control** (Verziókövetés): Változások követése, előző változatok
megőrzése, összehasonlítása, szükség esetén visszatérés egy korábbi változathoz.

Egy program írása közben különböző változatokat mentünk. Mindegyik az előző
továbbfejlesztése, bővítése.

![x](media/e84495ce9af5ef7d48bb24d602fde8d0.png)

Munka közben gyakran mentünk a lemezre, de csak azokat a változatokat kell
megőrizni, amelyek egy-egy komolyabb módosítást tartalmaznak.

![x](media/2a99d5ba6344b7e4e81d7a3e8395745b.png)

---

A szoftverek általában sok fájlból állnak, és mindegyiket követni kell.

**Repository** (raktár): A projekthez tartozó fájlok különböző változatainak tárolására szolgál.
Általában egy mappa, amelyben almappák is lehetnek.

Ha kézzel végezzük egy fájl verziókövetését, a mappánk így nézhet ki:

![x](media/4cf658c1f087e46def1a62b663d1a4fd.png)

Több fájl esetén az egész mappából készíthetünk több változatot.

**Commit**: Egy pillanatfelvétel a fájlokról, amelyhez később vissza lehet
térni.  
(RevXX, filefixup-XX)

Igeként *to commit*: egy pillanatfelvételt készíteni és elmenteni.

**Branch**: Ág. Több változatot fejlesztünk.

Például:

![x](media/95d356fac33156422cff6dbd6242e9ba.png)

## git

A legelterjedtebb verziókezelő rendszer (version control system). Linus Torvalds
vezetésével készítették a Linux kernel fejlesztéséhez.

![x](media/371f9621015a099bafdea5b7e4b7da78.png)

Legfontosabb jellemzői:

**Staging area**: Itt adjuk meg, hogy az új és a módosított fájlok közül mit
szeretnénk commit-olni a repository-ba.

**Distributed repository**: Mindenkinek saját, helyi másolata van a
repository-ról, és abban dolgozik. A
módosításokat időnként át kell másolni a többiek példányaiba is. Így egyszerre sokan dolgozhatnak ugyanazon a projekten.

![remote](media/remote-repo-explain.png)

**Branching**: A fejlesztők külön ágakon dolgoznak, amelyeket később
összefésülnek (merging).

Általában van egy fő ág, a master. Ebből készítenek elágazásokat különböző
fejlesztésekhez, hibajavításokhoz. Amikor ezek elkészülnek, akkor összefésülik a
fő ággal, majd törlik az elkészült ágat. (Vannak más, összetettebb stratégiák
is.)

![x](media/d93d30541d37f86b7ad38b5a1d88af5a.png)

## GitHub

Egy cég internetes szolgáltatása (<https://github.com/>), ahol tárolhatjuk,
kezelhetjük és megoszthatjuk a Git repository-kat. 
A jegyzet írásakor (2017-ben) már 26 millió felhasználónál járnak, és 2018-ban a Micorosoft felvásárolta a céget.

![x](media/78e54ebe2e28c5aed64c1941de96c0c2.png)

A szolgáltatás igénybevételéhez regisztrálni kell név, e-mail cím és jelszó
megadásával.

Kétféle terv (plan) közül választhatunk:

- *free*: ingyenes, de csak nyilvános (public) projektjeink lehetnek. Mi ezt
 fogjuk használni.

- *fizetős*: pénzbe kerül, de lehetnek privát projektjeink is.

### Fontos fogalmak

- **Push** művelet: a helyi repository módosításainak feltöltése a távoli Github repository-ba.

- **Pull** művelet: Módosítások letöltése a távoli Github repository-ból a  helyibe. (másoké is!)

- **Collaborator**: akivel/akikkel együtt dolgozunk egy projekten.

- **Fork**: elágazás: Valaki más lemásolja a repository-mat, és utána sajátjaként fejleszti tovább.

### Új repository létrehozása

1. Regisztrálj a GitHub szolgáltatásra, majd jelentkezz be!

2. Kattints a jobb felső sarokban lévő + jelre, majd válaszd a `New repository` parancsot!

3. Adj nevet az új repository-nak (proba1), és írj egy rövid leírást!

4. Kapcsold be az `Initialize this repository with a README` jelölőnégyzetet, majd kattints a `Create Repository` gombra!  
   ![x](media/dba85f4dae0fe1cb8e47b74c8020ee2a.png)

5. Nézd meg az új repository tartalmát!  

### Első commit-unk

1. Kattints a README.md fájlra, majd a megjelenő ablakban az `Edit this file`
    gombra (ceruza)!

2. Módosíts valamit a szövegen, például írd be egy új sorba, hogy második sor! A szöveg Markdown formátumban van (erre utal az .md kiterjesztés is).

3. Válts át a `Preview changes` fülre, és nézd meg a módosításokat!

4. Írj egy üzenetet a változásokhoz (pl. README.md módosítása)!

5. A commit (pillanatfelvétel készítése) kétféleképpen történhet: lehet a master branch-ba (főágba), vagy egy új ágba. Válaszd most a fő ágat, majd kattints a `Commit changes` gombra!

### Új ág készítése

1. Válts vissza a proba1 repository-ra, és kattints a Branch: master gombra!

2. Írj be egy nevet (pl. újág), majd kattints a `Create branch`
   gombra! Ezzel létrejön egy új ág, amely a master ág másolata.  
   ![x](media/107ae0ab4bdec2a0ce570216c4903e15.png)

3. Kattints a `New file` gombra, majd adj nevet az új fájlnak (ujfile.md)!

4. Írj be valamit, nézd meg az előképet, majd commit-old az újág-ba! Így a master ágba nem kerül bele.  
   ![x](media/7e2ac99510b31d472b7be0c15eaa531c.png)

5. Kattints a `3 commits` gombra, hogy megnézd az újág commit-jeit!  
   ![x](media/54ebe0cfa993cc69e9970d811cd8c487.png)

6. Figyeld meg, hogy a master ág commit-jei is átmásolódtak ide az újág létrehozásakor!

7. Figyeld meg, hogy minden commit-nak (és minden más objektumnak) van egy SHA    azonosítója, amelynek első része látható, és az egész rámásolható a vágólapra egy gombbal (pl. 165e52ce75a9e3eb432aedc5772891ad3f94b288)!

8. Kattints a README.md módosítása commit-re, és nézd meg, milyen módosításokat tartalmaz! Próbáld ki a `Split` gombot!  
   ![x](media/853de9f0ba894ed88903863aba7a034d.png)

9. Kattints a `Browse files` gombra! Mit látsz, és mit nem?

### Ágak egyesítése

1. Menj vissza az előző oldalra (a commit-ekhez), és kattints a `Compare & pull request` gombra! Figyeld meg, hogy az ágak automatikusan összefésülhetők!  
  ![x](media/72d70996927a0cd149c3bad491922ae7.png)

2. Az ágak összefésülését lehet, hogy más végzi. Írj neki egy üzenetet, majd nyomd meg a `Create Pull Request` gombot!  
  ![x](media/03f20fcb215e134b8ee9c2c90a168f7a.png)

3. Nézd meg a Pull request lapot, majd kattints a `Merge pull request` gombra! Utána nyomd meg a `Confirm merge` gombot is!  
  ![x](media/fda8f5f8eaf7092d821e407c41ab5034.png)

4. Töröld le a feleslegessé vált ágat!  
  ![](media/1d5a07369c4ec6f9c5909dc5b0598ed5.png)

## Házi feladat

Jelentkezz be a GitHub oldalra, és kattints az Explore gombra! Nézz meg néhány projektet!
