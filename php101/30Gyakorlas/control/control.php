<?php

    $adatbazis="szoftverleltar";
    $kapcs= mysqli_connect("localhost", "root", "Pass.word01", $adatbazis);
    mysqli_set_charset($kapcs, "UTF8");
    mysqli_select_db($kapcs, $adatbazis);
    $tablak=array("gep","szoftver","telepites");
    
    function listaz() {
        // egy kétdimenziós tömbben megkapjuk a táblák, azon belül
        // mezőik paraméterként elküldött értékeit
        $tomb=tombbe();
        foreach ($tomb as $tabla => $altomb) {
            // ciklussal végighaladok a tömbbön, melynek elemei a táblák nevei, 
            // alelemei pedig szintén tömbök (mezőneveikkel)
            echo "<details>\n"; // az egyes táblákat ezzel összecsukhatóvá/lenyithatóvá 
            echo "<summary>$tabla tábla tartalma</summary>\n"; // tesszük
            ${$tabla}= mysqli_query($GLOBALS["kapcs"], "SELECT * FROM $tabla");
            $lekerdezes=${$tabla}; // változó nevű változók: a lekérdezések neve
            echo "<table border=1>\n"; // $ gep, $szoftver, $telepites lesznek
            echo "<tr>\n"; // a mezők neveihez az altömbön is végigmegyünk
            foreach ($altomb as $mezo => $ertek)  // egy ciklussal és mezőfejléceként
                echo "<th>$mezo</th>\n"; // íratjuk ki az adatokat
            echo "</tr>\n";
            mysqli_data_seek($lekerdezes, 0); // a lekérdezett tábla
            while ($rekord = mysql_fetch_array($lekerdezes)) { // első rekordjára pozícionálunk
                // ciklus segítségével kiolvastatjuk az adatrekordokat
                echo "<tr>\n"; // a sorokon belül
                for ($k=0; $k<mysqli_num_fields($lekerdezes); $k++) { // ciklussal végigpásztázzuk az egyes mezőket hogy azok
                    $mezonev = $lekerdezes->fetch_field_direct{$k}->name; // sorszám szerinti nevei
                    $ertek=$rekord[$mezonev]; // és a rekordban lévő értékei
                    echo " <td>$ertek</td>\n"; // a megfelelő celléba kerüljön a táblázatba
                }
                echo "</tr>\n";
            }
            echo "</table>\n";
            echo "</details>\n";
            echo "<br><br>\n";
            mysqli_free_result($lekerdezes);
        }
    }
    
    function tombbe() {
        $i=0;
        $parameterek=array();
        foreach ($_GET as $urlapelem_nev => $ertek)  // a külldött paraméterek
            $parameterek[$i++]=$ertek; // összegyűjtése egy indexelhető tömbbe
        array_pop($parameterek); // az utolsó elem, az elküld gomb törlése    
        $tablak=$GLOBALS["tablak"]; // globális változóvá tesszük, mivel a függvényen kívüli
        $n=0;
        foreach ($tablak as $index => $tabla) { // az adatbázis táblának bejáráse
            ${$tablak[$index]}=mysqli_query($GLOBALS[$kapcs],"SELECT * from $tabla");
            $lekerdezes=${$tablak[$index]}; // változó nevű változók: lekérdezések neve
                                            // $gep, $szoftver, $telepites lesznek
            $mezo_darab=$lekerdezes->field_count; // igy kinyerhettuk azok mezodarabszámait
            $mezoinfo= mysqli_fetch_field($lekerdezes); // az adott tábla egyes mezőinek
            do { // a tulajdonságaira vagyunk kiváncsiak, ezek közül is a mezők neveire
                $tomb[$tabla][$mezoinfo->name]=$parameterek[$n];
                $n++;
            } while ($mezoinfo= mysqli_fetch_field($lekerdezes)); // ciklusban végigvesszük
        }
        return $tomb;
    }
?>