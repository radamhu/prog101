<?php
session_start();
require_once("control/header.php");
require_once("control/control.php");

?>

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
       
        <br>
    </div>

</body>

</html> 