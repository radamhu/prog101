var kamat = 0.02;
var ft = 100000;
var hossz = 2;

function szamol() {
    var osszeg = ft;
    for (var i = 1; i <= hossz; i++) {
        osszeg += kamat * osszeg;
    }
    var ado = (osszeg - ft) * 0.15;
    document.getElementById("mennyi").innerHTML = (osszeg - ado).toFixed(0);
}
szamol();

document.getElementById("betet").oninput = function() {
    ft = +this.value;
    document.getElementById("blabel").innerHTML = ft;
    szamol();
}

document.getElementById("hossz").oninput = function() {
    hossz = +this.value;
    document.getElementById("hlabel").innerHTML = hossz;
    szamol();
}

document.getElementById("kamat").oninput = function() {
    kamat = +this.value / 100;
    document.getElementById("klabel").innerHTML = (100 * kamat).toFixed(1);
    szamol();
}