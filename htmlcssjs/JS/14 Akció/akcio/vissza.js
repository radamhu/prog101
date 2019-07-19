var mikor = new Date('2018-06-15 23:59').getTime();
kiir();

function kiir() {
    var ido = mikor - new Date().getTime(); 
    if (ido > 0) {
        var nap = Math.floor(ido/(24*60*60*1000));
        var ora = Math.floor(ido/(60*60*1000) % 24);
        var perc = Math.floor(ido/(60*1000) % 60);
        var mp = Math.floor(ido/(1000) % 60);
        document.getElementById("hatra").innerHTML = 
            nap + " nap " + ora + " ora " + perc + " perc " + mp + " mp";
        setTimeout(kiir,1000);
    } else {
        document.getElementById("hatra").innerHTML = "Akció véget ért."
    }
}
