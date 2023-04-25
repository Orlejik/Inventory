let eye_icon = document.getElementsByClassName("eye_icon");

for (let i = 0; i <eye_icon.length ; i++) {
    console.log(eye_icon);
}
//
let change_class = (event,  changeClass)=>{

    event.target.classList.toggle("changeClass");
    console.log(event.target);
}

for (let i=0; i<eye_icon.length; i++) {
    eye_icon[i].addEventListener("click", (event)=>{
        let eventTarget = event.target;
        let thisEventTarget = this.event.target;
        eventTarget.style.zIndex = -1000;
        thisEventTarget.parentElement.classList.replace("pass-hidden", "pass_open");
    });
}

let isActive_tds = document.getElementsByClassName("isActive");
for (let i = 0; i <isActive_tds.length ; i++) {
    if(isActive_tds[i].innerText === "Not Active"){
        isActive_tds[i].style.color = "darkred"
    }
}

// reduce the length of text in password cell
let pass_hidden = document.getElementsByClassName("pass-hidden");
for(let i=0; i<pass_hidden.length; i++){
    pass_hidden[i].innerText = pass_hidden[i].innerText.substring(0,10);
}



