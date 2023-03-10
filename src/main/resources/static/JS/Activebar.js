const nav = document.querySelector(".nav");
let comparate
window.addEventListener('load',()=>{
    nav.querySelectorAll("li").forEach(element=>{
    comparate=element.querySelector("a").getAttribute("href");
    if (window.location.pathname==comparate) {
        element.querySelector(".navs").classList.add("nav-activo")
    }
})
})