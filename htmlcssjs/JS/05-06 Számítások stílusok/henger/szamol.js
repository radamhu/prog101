function szamol() {
    // .value-val kiolvasom es a "+" jel átalakítja számmá, egyébként string-et kapunk vissza 
    var r = +document.getElementById("sugar").value;
    var m = +document.getElementById("magas").value;

    var A = 2 * r * Math.PI * (r + m);
    var V = r * r * Math.PI * m;

    // veszem a pl.: felszin ID-t, annak belső HTML-jét, hozzáadom ...
    document.getElementById("felszin").innerHTML = "Felszin: " + A.toFixed(3);
    document.getElementById("terfogat").innerHTML = "Terfogat: " + V.toFixed(3);
}

document.getElementById("gomb").onclick = szamol;