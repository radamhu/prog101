// lámpa kpacsolása
function kapcsol(s) {
    // lampa azonosítójú elem "src" attributumának módosítása
    document.getElementById("lampa").src = s;
}
document.getElementById("fel").onclick = function() {
    kapcsol("bulbon.gif");
}

document.getElementById("le").onclick = function() {
    kapcsol("bulboff.gif");
}

// betűméret
var meret = 16;
function nagyit(n) {
    meret += n;
    document.getElementById("szoveg").style.fontSize = meret+"px";
}

document.getElementById("nagyobb").onclick = function() {
    nagyit(2);
}

document.getElementById("kisebb").onclick = function() {
    nagyit(-2);
}

// háttér
function hatter(szin) {
    document.getElementById("oldal").style.backgroundColor = szin;
}

document.getElementById("hatterbe").onclick = function() {
    hatter("#777");
    kapcsol("bulboff.gif");
}

document.getElementById("hatterki").onclick = function() {
    hatter("#fff");
    kapcsol("bulbon.gif");
}