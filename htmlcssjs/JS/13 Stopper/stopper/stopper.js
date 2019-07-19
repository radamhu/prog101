var tized, mp, perc, ora;
var elinditva = false;
var idozito;

function kiir(hova,mit,dupla) {
    if (dupla && mit < 10) {
        mit = "0" + mit;
    } else {
        mit = "" + mit;
    }
    document.getElementById(hova).innerHTML = mit;
}

function nullaz() {
    if (!elinditva) {
        tized = 0;
        mp = 0;
        perc = 0;
        ora = 0;
        kiir("tizedki",tized, false);
        kiir("mpki",mp, false);
        kiir("percki",perc, false);
        kiir("oraki",ora, false);
    }
}

nullaz();
document.getElementById("gomb2").onclick = nullaz;

function tik() {
    tized++;
    if (tized == 10) {
        tized = 0;
        mp++;
        if (mp == 60) {
            mp = 0;
            perc++;
            if (perc == 60) {
                perc = 0;
                ora++;
                if (ora = 24) {
                    ora =0;
                }
                kiir("oraki", ora, true);
            }
            kiir("percki",perc, true);
        }
        kiir("mpki",mp, true);
    }
    kiir("tizedki",tized, false);
}

document.getElementById("gomb1").onclick = function () {
    if (!elinditva) {
        idozito = setInterval(tik,100);
    } else {
        clearInterval(idozito);
    }
    elinditva = !elinditva;
}