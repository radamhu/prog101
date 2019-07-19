Git a parancssorból
===================

Git telepítése
--------------

A Git-et Windowshoz a <https://git-scm.com/> címről töltheted le.

A telepítő több eszközt is telepít. Mi ezek közül a Git Bash-t fogjuk
használni. Ez egy Linux terminál, ebbe fogjuk begépelni a parancsokat.

Ha nincs a gépedre telepítve a Git, töltsd le és telepítsd!

Utána indítsd el a Git Bash programot! Az első használatnál meg kell
adni a felhasználónevet és az e-mail címet a következő parancsokkal:

**git config \--global user.name** *felhasználóneved*

**git config \--global user.email** *e-mail címed*

Klónozás
--------

1.  Jelentkezz be online a GitHub-ra!

2.  Válaszd ki a korábban készített *proba1* repository-t! Kattints a
    *Clone or download* gombra, majd az az ábrán jelzett helyre! Ez a
    vágólapra másolja a repository címét.

-   ![clone](./Parancssor/media/image1.png){width="4.3684208223972005in"
    height="2.2421052055993003in"}

3.  Készíts a számítógépeden egy *git* mappát! Ebbe fogunk klónozni.

4.  Ezután válts át arra a mappára, amelybe a klónozást szeretnéd! A
    parancsot úgy írtam be, hogy a fájlkezelőből áthúztam a mappát a cd
    parancsba:

-   ![cd](./Parancssor/media/image2.png){width="3.063157261592301in"
    height="1.5263156167979002in"}

5.  Írd be a **git clone** parancsot, és illeszd be a 2-es pontban
    kimásolt címet (Shift+Ins, vagy jobb kattintás és Paste):

-   ![clone](./Parancssor/media/image3.png){width="5.833333333333333in"
    height="2.5895636482939635in"}

6.  Nézd meg a fájlokat (a fájlkezelőben is)! Figyeld meg, hogy van egy
    rejtett *.git* mappa. Ebben tárolja a Git az objektumokat. Soha ne
    módosítsd ennek a mappának a tartalmát!

-   ![mappa](./Parancssor/media/image4.png){width="4.8in"
    height="1.2842104111986001in"}

Új repository
-------------

1.  Válts az egy szinttel feljebb lévő mappába! Hozz létre egy weblap2
    mappát, majd tedd aktuálissá!

-   ![mkdir](./Parancssor/media/image5.png){width="4.778946850393701in"
    height="2.621052055993001in"}

2.  Másold a fájlkezelővel az új weblap2 mappába a kapott fájlokat, majd
    listázd ki őket a dir paranccsal!

-   ![m](./Parancssor/media/image6.png){width="4.613444881889764in"
    height="0.6470581802274715in"}

3.  Készíts repository-t a mappából a **git init** paranccsal:

-   ![init](./Parancssor/media/image7.png){width="5.833333333333333in"
    height="0.6470067804024497in"}

4.  Add ki a **git status** parancsot:

-   ![status](./Parancssor/media/image8.png){width="5.833333333333333in"
    height="1.8581364829396325in"}

5.  A Git-ben jelezni kell, hogy mely fájlokat szeretnénk követni. Add
    hozzá a követendő fájlokhoz az aktuális mappa teljes tartalmát! Ezt
    nevezik (staging-nek.) Utána nézd meg újra a státuszt!

-   ![add](./Parancssor/media/image9.png){width="4.989472878390202in"
    height="2.8105260279965005in"}

6.  Készíts pillanatfelvételt a jelenlegi állapotról (commit)! Az üzenet
    legyen alapállapot!

-   ![commit](./Parancssor/media/image10.png){width="4.915788495188101in"
    height="1.2421052055993in"}

7.  Utána nézd meg újra a státuszt!

-   ![status](./Parancssor/media/image11.png){width="4.8842104111986in"
    height="0.863157261592301in"}

8.  Ezzel a helyi repository-ba mentettük a módosításokat. Nyisd meg a
    GitHub oldalad (jelentkezz be), és készíts egy új, üres repository-t
    weblap2 néven!

9.  A létrehozás után megjelenő oldalon másold a vágólapra az új
    repository címét:

-   ![cím](./Parancssor/media/image12.png){width="5.833333333333333in"
    height="0.6474748468941383in"}

10. Utána a bash-ben add meg a távoli repository-t a következő
    paranccsal (a címet az előző lépésben másoltuk a vágólapra)! Ettől
    kezdve a távoli repository-ra az origin névvel hivatkozhatsz. (Más
    nevet is lehet használni, de ezt szokták.)

-   ![remote](./Parancssor/media/image13.png){width="5.833333333333333in"
    height="0.404915791776028in"}

11. Végül másold a helyi repository-t a távoliba (közben be kell
    jelentkezned a GitHub-ra):

-   ![push](./Parancssor/media/image14.png){width="5.833333333333333in"
    height="1.6294761592300961in"}

    *Kiegészítés*: Ha a fenti parancsban megadod a -u kapcsolót
    (`gith push -u origin master`), azzal jelzed, hogy ezentúl a master
    ágat kell szinkronizálni. Így legközelebb nem kell megadnod az ágat,
    elég ennyit írnod: `git push`

12. Frissítsd a GitHub oldalt, és ellenőrizd a távoli repository-t!

Elágazás
--------

1.  Kezdj egy új ágat zöld néven, és válts át rá! Utána listázd az
    ágakat!

-   ![zöld](./Parancssor/media/image15.png){width="4.8105260279965005in"
    height="1.6315780839895013in"}

2.  A Notepad++-ban nyisd meg a *stilusok.css* fájlt, és állítsd át az
    oldal háttérszínét zöldre! (\#2b8f17)

3.  Mentsd a módosítást, majd nézd meg az eredményt a böngészőben!

4.  Nézd meg a státuszt, add hozzá a stage-hez a fájlokat, majd
    commit-old őket a helyi repository-ba!

-   ![commit](./Parancssor/media/image16.png){width="5.833333333333333in"
    height="2.9605916447944005in"}

5.  Utána töltsd fel az új zöld ágat a GitHub repository-ba az alábbi
    paranccsal, majd ellenőrizd az új ágat a GitHub-on! (Ismét be kell
    jelentkezni.)

-   ![push](./Parancssor/media/image17.png){width="5.833333333333333in"
    height="1.5893711723534558in"}

6.  Módosítsd a Notepad++-ban a weblap betűtípusát Cambria, serif-re, és
    mentsd a módosítást! Nézd meg az eredményt a böngészőben!

7.  Commit-old a változásokat a helyi repository zöld ágába! Most
    egyszerre végezd el a stage-elést és a commit-olást:

-   ![commit](./Parancssor/media/image18.png){width="4.894736439195101in"
    height="0.8315780839895013in"}

8.  Ellenőrizd az eddigi commit-okat:

-   ![log](./Parancssor/media/image19.png){width="5.833333333333333in"
    height="2.8593153980752404in"}

9.  Utána töltsd fel a módosításokat a GitHub repository-ba is!

-   ![push](./Parancssor/media/image20.png){width="5.833333333333333in"
    height="1.6142016622922135in"}

10. Próbaképpen válts vissza a master ágra, és frissítsd a böngészőben
    az oldalt! Utána válts vissza a zöld ágra, és nézd meg így is az
    oldalt! Mit tapasztalsz?

-   ![ágak](./Parancssor/media/image21.png){width="4.8526312335958in"
    height="1.4105260279965004in"}

Módosítások letöltése
---------------------

1.  Válts a böngészőben a GitHub oldalra, és a zöld ághoz adj hozzá egy
    README.md fájlt!

2.  Töltsd le a módosításokat a helyi repository-ba, és listázd ki a
    tartalmát:

-   ![pull](./Parancssor/media/image22.png){width="5.778946850393701in"
    height="2.5894728783902012in"}

Ágak egyesítése
---------------

1.  Helyben úgy egyesíthetnéd az ágakat, hogy átváltasz a master ágra
    (**git checkout master**), majd kiadod a **git merge zöld**
    parancsot. Most azonban a GitHub-on szeretnénk az egyesítést
    elvégezni, ezért válts a GitHub oldaladra, és a weblap2 projektben
    válaszd a *Pull request* fület!

2.  Kattints a *New pull request* gombra, válaszd ki a zöld ágat, majd
    kattints a *Create pull request* gombra!

-   ![pr](./Parancssor/media/image23.png){width="5.833333333333333in"
    height="5.5906813210848645in"}

    pr

3.  Írj egy üzenetet, majd itt is kattints a *Create pull request*
    gombra!

-   ![pr2](./Parancssor/media/image24.png){width="5.833333333333333in"
    height="4.847310804899387in"}

    pr2

4.  Erősítsd meg a műveletet a *Merge pull request*, majd a *Confirm
    merge* gomb megnyomásával!

-   ![confirm](./Parancssor/media/image25.png){width="5.833333333333333in"
    height="1.239397419072616in"}

    confirm

5.  Végül töröld a zöld ágat a GitHub-ról a *Delete branch* gombbal!

6.  Válts a bash-re, válts vissza a master ágra, és töltsd le a master
    ág módosításait! Ellenőrizd az oldalt a böngészőben!

-   ![pull](./Parancssor/media/image26.png){width="5.833333333333333in"
    height="3.2602734033245846in"}

7.  Töröld a helyi zöld ágat is!

-   ![del](./Parancssor/media/image27.png){width="4.8526312335958in"
    height="0.6947364391951006in"}
