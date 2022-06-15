xhttp=new XMLHttpRequest();
document.getElementById("btn").addEventListener("click",function (e) {
    e.preventDefault();
    txt=document.getElementById("txt").value
    element=document.createElement("li");
    element.classList.add('todo');
    element.textContent=txt;
    document.getElementById("lista").appendChild(element);
    xhttp.open("POST", "/dodaj");
    xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhttp.send("txt="+txt);
});
window.addEventListener('click',function (e){
    txt=e.target.textContent;
    if(e.target.className=='done'){
        e.target.remove();
        console.log(txt);
       xhttp.open("POST", "/zmienstatus");
       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xhttp.send("txt="+txt);
    }
   if(e.target.className=='todo'){
       e.target.className='done';
       xhttp.open("POST","/zmienstatus");
       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xhttp.send("txt="+txt);
   }
});
window.addEventListener("contextmenu",function (e){
    if(e.target.className=='todo'){
        e.preventDefault();
        let nowa =prompt("Proszę podać nową nazwę");
        if(nowa!=null){
            stare=e.target.textContent;
            e.target.textContent=nowa;
            xhttp.open("POST","/zmiennazwe");
            xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
            xhttp.send("stare="+stare+"&nowe="+nowa);
        }
    }
    if(e.target.className=='done'){
        e.preventDefault();
        txt=e.target.textContent;
        e.target.className='todo';
        xhttp.open("POST","/przywroc");
        xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhttp.send("txt="+txt);
    }
});