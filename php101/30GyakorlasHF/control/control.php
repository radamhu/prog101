<?php 

$adatbazis="szoftverleltar";
$kapcs= mysqli_connect("localhost", "root", "Pass.word1", $adatbazis);
mysqli_set_charset($kapcs, "UTF8");
mysqli_select_db($kapcs, $adatbazis);
$tablak=array("gep","szoftver","telepites");

function lista(){
    global $kapcs;
    $eredmeny = mysqli_query($kapcs, "SELECT * FROM gep");
    echo "<br>
        <details>\n
            <summary>Gép tábla tartalma</summary>\n
            <table>\n
            <tr>\n
                <th>Id</th>\n
                <th>Hely</th>\n
                <th>Típus</th>\n
                <th>IP cím</th>\n
            </tr>\n";
    while ($sor = mysqli_fetch_assoc($eredmeny)) {
        echo "
            <tr>\n
                <td>{$sor['id']}</td>\n
                <td>{$sor['hely']}</td>\n
                <td>{$sor['tipus']}</td>\n
                <td>{$sor['ipcim']}</td>\n
            </tr>\n";
    }
    echo "</table>\n
        </details>\n
        <br>\n";

    $eredmeny = mysqli_query($kapcs, "SELECT * FROM szoftver");
    echo "<details>\n
        <summary>Szoftver tábla tartalma</summary>\n
        <table>\n
        <tr>\n
            <th>Id</th>\n
            <th>Név</th>\n
            <th>Kategória</th>\n
        </tr>\n";
    while ($sor = mysqli_fetch_assoc($eredmeny)) {
        echo "
            <tr>\n
                <td>{$sor['id']}</td>\n
                <td>{$sor['nev']}</td>\n
                <td>{$sor['kategoria']}</td>\n
            </tr>\n";
    }
    echo "</table>\n
        </details>\n
        <br>\n";

    $eredmeny = mysqli_query($kapcs, "SELECT * FROM telepites");
    echo "<details>\n
        <summary>Telepítés tábla tartalma</summary>\n
        <table>\n
        <tr>\n
            <th>Id</th>\n
            <th>Gép id</th>\n
            <th>Szoftver id</th>\n
            <th>Verzió</th>\n
            <th>Dátum</th>\n
        </tr>\n";
    while ($sor = mysqli_fetch_assoc($eredmeny)) {
        echo "
            <tr>\n
                <td>{$sor['id']}</td>\n
                <td>{$sor['gepid']}</td>\n
                <td>{$sor['szoftverid']}</td>\n
                <td>{$sor['verzio']}</td>\n
                <td>{$sor['datum']}</td>\n
            </tr>\n";
    }
    echo "</table>\n
        </details>\n
        <br>\n";
}

if (isset($_POST['megnez'])) {
    lista();


} elseif (isset($_POST['felvesz'])) {
    if (!$_POST['hely'] == "" && !$_POST['tipus'] == "" && !$_POST['ipcim'] == "") {
        $sql = "INSERT INTO gep
VALUES({$_POST['gep_id']},
      '{$_POST['hely']}',
      '{$_POST['tipus']}',
      '{$_POST['ipcim']}')";
        mysqli_query($kapcs, $sql);
        echo "<table>\n
                <p>A gep tábla tartalma a következő rekorddal bővült:</p>\n
                <tr>\n
                <td>{$_POST['gep_id']}</td>\n
                <td>{$_POST['hely']}</td>\n
                <td>{$_POST['tipus']}</td>\n
                <td>{$_POST['ipcim']}</td>\n
                </tr>\n
                </table>\n";          
    }

    if (!$_POST['szoftver_id'] == "" && !$_POST['nev'] == "" && !$_POST['kategoria'] == "") {
        $sql = "INSERT INTO szoftver
VALUES({$_POST['szoftver_id']},
      '{$_POST['nev']}',
      '{$_POST['kategoria']}')";
        mysqli_query($kapcs, $sql);
        echo "<table>\n
                <p>A szoftver tábla tartalma a következő rekorddal bővült:</p>\n
                <tr>\n
                <td>{$_POST['szoftver_id']}</td>\n
                <td>{$_POST['nev']}</td>\n
                <td>{$_POST['kategoria']}</td>\n
                </tr>\n
                </table>\n";         
    }

    if (!$_POST['gepid'] == "" && !$_POST['szoftverid'] == "") {

        $sql = "INSERT INTO telepites
    VALUES({$_POST['id']},
        {$_POST['gepid']},
        {$_POST['szoftverid']},
        '{$_POST['verzio']}',
        '{$_POST['datum']}')";
        mysqli_query($kapcs, $sql);
        echo "<table>\n
            <p>A telepites tábla tartalma a következő rekorddal bővült:</p>\n
            <tr>\n
            <td>{$_POST['id']}</td>\n
            <td>{$_POST['gepid']}</td>\n
            <td>{$_POST['szoftverid']}</td>\n
            <td>{$_POST['verzio']}</td>\n
            <td>{$_POST['datum']}</td>\n
            </tr>\n
            </table>\n";
        
    }
    lista();
    
} elseif (isset($_POST['torol'])) {
    if (!$_POST['hely'] == "" && !$_POST['tipus'] == "" && !$_POST['ipcim'] == "") {

        $sql = "DELETE FROM gep
        WHERE(hely='{$_POST['hely']}'
        AND tipus='{$_POST['tipus']}'
        AND ipcim='{$_POST['ipcim']}')";
        mysqli_query($kapcs, $sql);
        echo "<p>
                A gep táblából a következő mezőkre érvényes feltételek együttes megléte esetén törlődnek rekordok: 
                hely={$_POST['hely']}, tipus={$_POST['tipus']}, ipcim= {$_POST['ipcim']}
                </p>";
    }
    if (!$_POST['szoftver_id'] == "" && !$_POST['nev'] == "" && !$_POST['kategoria'] == "") {

        $sql = "DELETE FROM szoftver
        WHERE(id='{$_POST['szoftver_id']}'
        AND nev='{$_POST['nev']}'
        AND kategoria='{$_POST['kategoria']}')";
        mysqli_query($kapcs, $sql);
        echo "<p>
                A szoftver táblából a következő mezőkre érvényes feltételek együttes megléte esetén törlődnek rekordok: 
                id={$_POST['szoftver_id']}, nev={$_POST['nev']}, kategoria= {$_POST['kategoria']}
                </p>";
    }
    if (!$_POST['gepid'] == "" && !$_POST['szoftverid'] == "" && !$_POST['verzio'] == "" && !$_POST['datum'] == "") {

        $sql = "DELETE FROM telepites
        WHERE gepid={$_POST['gepid']}
        AND szoftverid={$_POST['szoftverid']}
        AND verzio='{$_POST['verzio']}'
        AND datum='{$_POST['datum']}'";
        mysqli_query($kapcs, $sql);
        echo "<p>
                A telepites táblából a következő mezőkre érvényes feltételek együttes megléte esetén törlődnek rekordok: 
                gepid={$_POST['gepid']}, szoftverid={$_POST['szoftverid']}, verzio= {$_POST['verzio']}, datum= {$_POST['datum']}
                </p>";            
    }
    lista();
}
mysqli_close($kapcs);
?>