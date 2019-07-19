function szamol() {
    var m = document.getElementById("magassag").value / 100;
    var kg = document.getElementById("tomeg").value;
    
    if (m<1 || kg<20) {
        alert("HibÃ¡s adatok!");
        return;
    }

    var tti = kg / (m*m);
    var alkat = "";
    if (tti < 20)       { alkat = "alultÃ¡plÃ¡lt"; }
    else if ( tti < 25) { alkat = "normÃ¡lis"; }
    else if ( tti < 30) { alkat = "tÃºlsÃºlyos"; }
    else if ( tti < 35) { alkat = "elhÃ­zott"; }
    else                { alkat = "erÅ‘sen elhÃ­zott"; }
    
    document.getElementById("kiiras").innerHTML = tti.toFixed(2) + "<br>" +alkat;
}
szamol();
document.getElementById("gomb").onclick = szamol;