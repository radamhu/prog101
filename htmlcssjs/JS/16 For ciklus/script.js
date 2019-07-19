var kamat = 0.02;
var ft = 100000;
var hossz = 2;

szamol();

function szamol() {
    var osszeg = ft;
    var ho = 0;
    for (var i =1; i <= hossz; i++) {
        osszeg += osszeg * kamat;
    }
    var ado = (osszeg-ft)*0.15;
    document.getElementById("mennyi").innerHTML = osszeg - ado;
}

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
    document.getElementById("klabel").innerHTML = (100 * kamat).toFixed(0);
    szamol();
}
