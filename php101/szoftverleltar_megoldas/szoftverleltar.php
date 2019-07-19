<!DOCTYPE html>
<html lang="hu">

<head>
    <meta charset="UTF-8">
    <title>Szoftverleltár</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <div class="tarolo">
        <h1>Szoftverleltár</h1>
        <fieldset>
            <legend id="cim">Szoftverleltár</legend>
            <form action="szoftverleltar.php" method="post">
                <fieldset>
                    <legend>Gép</legend>
                    <label for="gep_id">Id:</label>
                    <input type="text" id="gep_id" name="gep_id" value="NULL" readonly><br>
                    <label for="hely">Hely*:</label>
                    <input type="text" id="hely" name="hely" maxlength="4" value="" require><br>
                    <label for="tipus">Típus*:</label>
                    <input type="text" id="tipus" name="tipus" maxlength="8" value="" require><br>
                    <label for="ipcim">IP-cím*:</label>
                    <input type="text" id="ipcim" name="ipcim" maxlength="12" value="" require><br>
                </fieldset>
                <fieldset>
                    <legend>Szoftver</legend>
                    <label for="szoftver_id">Id:</label>
                    <input type="number" id="szoftver_id" name="szoftver_id" min="1" max="999" value=""><br>
                    <label for="nev">Név*:</label>
                    <input type="text" id="nev" name="nev" maxlength="33" value="" require><br>
                    <label for="kategoria">Kategória*:</label>
                    <input type="text" id="kategoria" name="kategoria" maxlength="26" value="" require><br>
                </fieldset>
                <fieldset>
                    <legend>Telepítés</legend>
                    <label for="id">Id:</label>
                    <input type="text" id="id" name="id" readonly value="NULL"><br>
                    <label for="gepid">Gép id*:</label>
                    <input type="number" id="gepid" name="gepid" min="1" max="99" value="" require><br>
                    <label for="szoftverid">Szoftver id*:</label>
                    <input type="number" id="szoftverid" name="szoftverid" min="1" max="999" value="" require><br>
                    <label for="verzio">Verzió:</label>
                    <input type="text" id="verzio" name="verzio" value="" maxlength="17"><br>
                    <label for="datum">Dátum:</label>
                    <input type="date" id="datum" name="datum" value=""><br>
                </fieldset>
                <input type="submit" id="megnez" name="megnez" value="Megnéz">
                <input type="submit" id="felvesz" name="felvesz" value="Felvesz">
                <input type="submit" id="torol" name="torol" value="Töröl">
            </form>
        </fieldset>
        <?php 

        $kapcs = mysqli_connect('localhost', 'root', "", 'szoftverleltar');
        mysqli_set_charset($kapcs, "UTF8");

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
// lista
        if (isset($_POST['megnez'])) {
            lista();

//Felvétel 
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
            //Törlés 
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
        <br>
    </div>

</body>

</html> 