/*
function udvozlet() {
    alert("Késleltetett üdvözlet!");
}

setTimeout(udvozlet, 3000);
*/

/*
function csillag() {  
    document.getElementById("kiir").innerHTML += "*";
}
*/

function ora() {  
    document.getElementById("kiir").innerHTML = new Date().toLocaleTimeString();
}

var idozito;
var elinditva = false;

document.getElementById("start").onclick = function () { 
    if (!elinditva) {
        idozito = setInterval(ora, 500);
        elinditva = true;    
    } 
}

document.getElementById("stop").onclick = function() {
    clearInterval(idozito);
    elinditva = false;
}
