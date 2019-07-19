function szamol() {
    var a = +document.getElementById("a_oldal").value;
    var b = +document.getElementById("b_oldal").value;

    if (isNaN(a) || isNaN(b) || a <= 0 || b <= 0) {
        alert("Hibás adatok");
        return;
    }

    var ker = 2*(a+b);
    var ter = a*b;

    document.getElementById("kerulet").innerHTML = "Kerület: " + ker.toFixed(2);
    document.getElementById("terulet").innerHTML = "Terület: " + ter.toFixed(2);
}

document.getElementById("gomb").onclick = szamol;


