// JS oktatás
// F12 developer
// document.getElementById("szoveg").innerHTML="mod";
// function modosit() {document.getElementById("szoveg").innerHTML="mod";}
// modosit
// modosit();
// user megnyom egy gombot az esemény
// hozzálehet rendelni függvényt
// gomb elemt meghívjuk + ha kattintanak rá mi legyen = anonim function 
// ... kapcsos zárójelben hogy mit csináljon
document.getElementById("gomb").onclick = function() {
    document.getElementById("szoveg").innerHTML = "Valami más";
}

document.getElementById("torol").onclick = function() {
    document.getElementById("szoveg").innerHTML = "&nbsp";
}