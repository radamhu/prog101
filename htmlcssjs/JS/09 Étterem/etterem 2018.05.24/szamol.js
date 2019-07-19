function szamol() {
    var osszeg = +document.getElementById("szamla").value;
    var szazalek = +document.getElementById("kiszolgalas").value/100;
    var hany = +document.getElementById("fo").value;

    if (osszeg<=0 || hany<=0) {
        alert("Hibás adatok!");
        return;
    }

    var fiz = Math.round( osszeg * (1 + szazalek) / hany);
    document.getElementById("fizetendo").innerHTML = fiz + " Ft / fő";
}

document.getElementById("gomb").onclick = szamol;