var r = 0, g = 0, b = 0;
function hatter() {
    document.getElementById("oldal").style.backgroundColor = "rgb(" + r +"," + g + "," + b + ")";
    document.getElementById("rlabel").innerHTML = r;
    document.getElementById("glabel").innerHTML = g;
    document.getElementById("blabel").innerHTML = b;
}
document.getElementById("red").oninput = function() {
    r = this.value;
    hatter();
}

document.getElementById("green").oninput = function() {
    g = this.value;
    hatter();
}

document.getElementById("blue").oninput = function() {
    b = this.value;
    hatter();
}

document.getElementById("gomb").onclick = function() {
    r = Math.floor(Math.random()*256)
    document.getElementById("red").value = r;
    g = Math.floor(Math.random()*256)
    document.getElementById("green").value = g;
    b = Math.floor(Math.random()*256)
    document.getElementById("blue").value = b;
    hatter();
}