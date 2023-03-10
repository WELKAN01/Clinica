const urlListaArea="http://localhost:8081/listaArea"
const urlGuardarArea="http://localhost:8081/guardarArea"
const tabla=document.getElementById("table-api").content;
const principaltabla=document.querySelector(".table");
let par=0;
let selectrow;
const $form=document.querySelector(".form-api");
const frag=document.createDocumentFragment();
const getAreas= async() =>{
    try {
        let res= await fetch("http://localhost:8081/listaArea");
        let data = await res.json();
        console.log(tabla)
        console.log(principaltabla.querySelector("tbody"));
        data.forEach(Element => {
            tabla.querySelector(".id").textContent = Element.area_id;
            tabla.querySelector(".name").textContent= Element.nombre_Area;
            tabla.querySelector(".description").textContent=Element.descripcion;
            tabla.querySelector(".editar").dataset.id=Element.id;
            tabla.querySelector(".editar").dataset.nombre_Area=Element.nombre_Area;
            tabla.querySelector(".editar").dataset.descripcion=Element.descripcion;
            tabla.querySelector(".eliminar").dataset.id=Element.id;
            let clone = document.importNode(tabla,true);
            frag.appendChild(clone);
        })
        principaltabla.querySelector("tbody").appendChild(frag);
    } catch (error) {
        console.log(error);

    }
}
document.addEventListener("DOMContentLoaded",getAreas);

document.addEventListener("submit",async (e)=>{
 
    if (e.target === $form) {
        e.preventDefault()
        if(par==0){
                if (document.getElementById("nombre").value=="" || document.getElementById("descripcion").value=="") {
                    document.getElementById("nombre").insertAdjacentHTML("afterend","<strong class='mx-auto'>falta nombre</strong>")
                    document.getElementById("descripcion").insertAdjacentHTML("afterend","<strong class='left-50'>falta descripcion</strong>")
                } else {
                    try {
                        let options={
                        method:'POST',
                        headers:{"Content-type": "application/json;charset=utf-8"},
                        body:JSON.stringify({
                            "descripcion":e.target.descripcion.value,
                            "nombre_Area":e.target.nombre.value,
                        })
                        }
                        let res=await fetch("http://localhost:8081/guardarArea",options),
                        data = await res.json();
                        tabla.querySelector(".id").textContent = data.area_id;
                        tabla.querySelector(".name").textContent= data.nombre_Area;
                        tabla.querySelector(".description").textContent=data.descripcion;
                        tabla.querySelector(".editar").dataset.id=data.area_id;
                        tabla.querySelector(".editar").dataset.nombre_Area=data.nombre_Area;
                        tabla.querySelector(".editar").dataset.descripcion=data.descripcion;
                        tabla.querySelector(".eliminar").dataset.id=data.id;
                        let clone = document.importNode(tabla,true);
                        frag.appendChild(clone);
                        principaltabla.querySelector("tbody").appendChild(frag);
                        var last=principaltabla.rows.length-1;
                        let ulti=principaltabla.rows[last].classList;
                        ulti.add("row-add");
                        e.target.descripcion.value="";
                        e.target.nombre.value="";
                        } catch (error) {
                        let mensaje= err.statusText || "ocurrio un error";
                        console.log(mensaje);
                        }
                }
        }else{
            try {
                let options={
                    method:'PUT',
                    headers:{"Content-type": "application/json; charset=utf-8"},
                    body:JSON.stringify({
                        "descripcion":e.target.descripcion.value,
                        "nombre_Area":e.target.nombre.value,
                    })
                    }
                let res=await fetch("http://localhost:8081/ActualizarArea/"+par,options);
                let data=await res.json();
                selectrow.querySelector(".name").textContent=e.target.nombre.value
                selectrow.querySelector(".description").textContent=e.target.descripcion.value
                selectrow.querySelector(".editar").dataset.nombre_Area=data.nombre_Area;
                selectrow.querySelector(".editar").dataset.descripcion=data.descripcion;
                selectrow.classList.add("row-update")
                e.target.descripcion.value="";
                e.target.nombre.value="";
                setTimeout(()=>selectrow.classList.remove("row-update"),1500)
                } catch (error) {
                console.log(error);
                }
        }
    }

    }
)

document.addEventListener("click", e=>{
    if(e.target.matches(".editar")){
        par=e.target.dataset.id;
        $form.nombre.value=e.target.dataset.nombre_Area;
        $form.descripcion.value=e.target.dataset.descripcion;
        selectrow=e.target.parentElement.parentElement;
        console.log(selectrow)
    }
    if(e.target.matches(".eliminar")){
        par=e.target.dataset.id;
        eliminar();
        e.target.parentElement.parentElement.classList.add("row-delete")
        e.target.parentElement.parentElement.querySelector(".editar").setAttribute("disabled","")
        e.target.setAttribute("disabled","")
        setTimeout(()=>e.target.parentElement.parentElement.remove(),700)
        
        par=0;
    }
}
)

const eliminar = async()=>{
    try {
        options={
            method:"DELETE",
            headers:{"Content-Type":"application/json; charset=utf-8"}
            }
        const res=await fetch("http://localhost:8081/EliminarArea/"+par, options);
        const json = await res.json();
    } catch (error) {
        console.log(error)
    }
}



