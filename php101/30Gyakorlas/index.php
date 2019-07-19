<?php
session_start();
require_once("control/header.php");
require_once("control/control.php");

?>
    <body>
        <div>
           <?php
                if (!isset($_GET['megnez']) && !isset($_GET['felvesz']) && !isset($_GET['torol'])) {
                    // echo " form name-urlap action-—"szoftverleltar.php" method-GET novalidatez An";
                    // Teszteléskor megadhatjuk a novalidate paramétert, hogy ne ellenőrizze az űrlap értékeit.
                    print( <form name=urlap action='index.php' method=GET novalidate>\n);
                    echo " <h1>Szoftverleltár</h1>\n";
                    
                    echo " <fieldset>\n";
                        echo " <legend align=right>Szoftverleltár</legend>\n" ;
                        echo " <fieldset>\n";
                            echo " <legend>Gép</legend>\n";
                            echo " <p><label for-gepid>Id: </label>\n";
                            echo " <input type=text name=gepid value=NULL size=4 readonly>
                            Értéke automatikusan növekvő szám, így NULL érték kerül elküldésre.</p>\n";
                            echo " <p><label for=hely>Hely: </label>\n";
                            echo " <input type=text name=hely maxlength=4 size=4 reguired></p>\n";
                            echo " <p><label for=tipus>Típus: </label>\n";
                            echo " <input type=text name=tipus maxlength=8 size=8 reguired></p>\n";
                            echo " <p><label for=ipcim>IP-cím: </label>\n";
                            echo " <input type=text name=ipcim maxlength=12 size=12 reguired></p>\n";
                        echo " </fieldset>\n";
                        echo " <fieldset>\n";
                            echo " <legend>Szoftver</legend>\n";
                            echo " <p><label for=szoftverid>Id: </label>\n";
                            echo " <input type=number name=szoftverid min=1 max=999 reguired</p>\n";
                            echo " <p><label for=nev>Név: </label>\n";
                            echo " <input type=text name=nev maxlength=33 size=33 reguired></p>\n";
                            echo " <p><label for=kategoria>Kategória: </label>\n";
                            echo " <input type=text name=kategoria maxlength=26 size=26 reguired></p>\n";
                        echo " </fieldset>\n";
                        echo " <fieldset>\n";
                            echo " <legend>Telepítés</legend>\n" ;
                            echo " <p><label for=telepitesid>Id: </label>\n";
                            echo " <input type=text name=telepitesid value=NULL size=4 readonly>
                            Értéke automatikusan növekvő szám, így NULL érték kerül elküldésre.</p>\n";
                            echo " <p><label for=kulso_gepid>Gép id: </label>\n";
                            echo " <input type=number name=kulso_gepid min=1 max=99 reguired></p>\n";
                            echo " <p><label for=kulso_szoftverid>Szoftver id: </label>\n";
                            echo " <input typ=-number name=kulso_szoftverid min=1 max=999 reguired></p>\n";
                            echo " <p><label for=verzio>Verzió: </label>\n";
                            echo " <input type=text name=verzio maxlength=17 size=17></p>\n";
                            echo " <p><label for=datum>Dátum: </label>\n";
                            echo " <input type=date name=datum></p>\n" ;
                        echo " </fieldset>\n";
                        echo " <input type=submit name=megnez value='Megnéz'>\n";
                        echo " <input type=submit name=felvesz value='Felvesz'>\n";
                        echo " <input type=submit name=torol value='Töröl'>\n";
                    echo " </fieldset>\n";
                    echo " </form>\n";
                    echo " \n";
                } elseif (isset ($_GET['megnez'])) {
                    listaz();
                }
            ?>    
        </div>
    </body>
</html>
