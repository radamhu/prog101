function szamol() {
    var m= document.getElementById("magassag").value / 100;
    var kg = +document.getElementById("tomeg").value;
    
    var tti = kg / (m*m);
    var alkat = "";
    if (tti < 20)       { alkat = "alultáplált"; }
    else if ( tti < 25) { alkat = "normális"; }
    else if ( tti < 30) { alkat = "túlsúlyos"; }
    else if ( tti < 35) { alkat = "elhízott"; }
    else                { alkat = "erősen elhízott"; }
    
    document.getElementById("kiiras").innerHTML = tti.toFixed(2) + "<br>" +alkat;
}

document.getElementById("gomb").onclick = function() { szamol(); };