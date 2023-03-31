
const $form=document.getElementById("postcita");
inputcliente=document.getElementById("nombre_cliente")
inputdoctor=document.getElementById("nombre_doctor")
inputarea=document.getElementById("area_Atencion")
textareadescripcion=document.getElementById("contexto")
let idcliente;


document.getElementById("pdf").addEventListener("click",()=>{
    window.location.href="http://localhost:8081/citasapi/pdf";
})
//carga de cita a la BD
document.addEventListener("submit",async(e)=>{

    if(e.target === $form){
        e.preventDefault();
        let pdfdata={
              "cita_cliente": idcliente,
              "cita_area":  idArea,
              "cita_doctor": idDoctor,
              "fecha_programacion": e.target.fecha_hora.value,
              "descripcion": e.target.contexto.value
            }
        let bodydata={
            "cita_cliente": {
              "id": parseInt(idcliente)
            },
            "cita_area": {
              "area_id": parseInt(idArea)
            },
            "cita_doctor": {
              "id": parseInt(idDoctor)
            },
            "fecha_programacion": e.target.fecha_hora.value,
            "descripcion": e.target.contexto.value
          }
        try {
            let options={
                method:'POST',
                headers:{"Content-type": "application/json;charset=utf-8",
                        "Accept": "application/json"},
                body:JSON.stringify(bodydata)
            }
            let res=await fetch("http://localhost:8081/citasapi/send",options);
            data=await res.text();
            console.log(bodydata)
            debugger
            window.open(`http://localhost:8081/citasapi/pdf/${pdfdata.cita_area}/${pdfdata.cita_cliente}/${pdfdata.cita_doctor}/${pdfdata.descripcion}/${pdfdata.fecha_programacion}`,'_blank');
        } catch (error) {
            debugger
            console.error(error);
        }
    }
})

//carga de los datos dentro del contenedor 
window.addEventListener("DOMContentLoaded",async()=>{
    document.getElementById("nombre_cliente").insertAdjacentHTML("afterend",`<div class="list_name"></div>`);
    inputcliente.insertAdjacentHTML("afterend","<p class='ayuda my-1'></p>");
    let res=await fetch("http://localhost:8081/clienteapi/clienteDTO")
    let data=await res.json();
    //se agrega todos los datos de la data al owner, ya que es publica y permitira ayudarme con la busqueda del nombre del cliente
    owner=data;
})


let owner=[];
inputcliente.addEventListener("keyup",(e)=>{
    let nombre_cliente=e.target.value;
    //con el filtrado podemos acceder al data con filter y obtener el nombre que buscamos mediante escribamos por ello se incluye
    //la clase funcion includes(tipeamos mediante que lo transforma a minusculas en caso escribamos en mayusculas)
    
    let filtrado=owner.filter((nombre)=> nombre=`${nombre.nombre_apellido.toLowerCase()}`.includes(e.target.value.toLowerCase()));
    console.log(filtrado)
    if(filtrado.length>=2 || filtrado.length===0){
        document.querySelector(".ayuda").innerHTML="quisiste decir";
        render_cliente(filtrado);
        idcliente=0;
        filtrado.forEach(element=>{
            console.log(element.id)
        })
        console.log(idcliente);
    }
    if(filtrado.length===1){
        idcliente=filtrado[0].id;
        document.querySelector(".ayuda").innerHTML="quisiste decir";
        console.log(idcliente)
        render_cliente(filtrado);
    }
    console.log(filtrado)
})

//carga de la data para que se visualice dentro del template
function render_cliente(data) {
    //el parametro data tiene que ser un array, en el cual cada elemento que se creara en base al map, button en cada fila del array, siguiendo despues no de un espacio
    // const list_cliente=data.map((dataux)=>{
    //         `<button class='btn btn-link' id='btn_cliente'">${dataux.nombre_apellido}</button>`;       
    //     }
    //     ).join(" ")
        let list_cliente="";
        for (let index = 0; index < data.length; index++) {
            if (index<3) {
                list_cliente+=`<button class='btn btn-link' id='btn_cliente'">${data[index].nombre_apellido}</button> `;
                debugger
            }else{
                list_cliente+=`<button class='btn btn-link' disabled>....</button>`;
                break;
            }
            
        }
    //dentro del list_name, me mostrara todos los button que reconozca
        document.querySelector(".list_name").innerHTML=list_cliente   
    
}


//mediante cada button con el id btn_cliente nos introducira dentro del input el texto del button, es el nombre del cliente
document.addEventListener("click", e=>{
    if(e.target.matches("#btn_cliente")){
        console.log(e.target.textContent)
        inputcliente.value=e.target.textContent;
        //buscaremos el nombre dentro del owner, usando filter, luego agregamos el includes. 
        //dentro del valor owneraux el cual nos señalara la letra
        //que se encuentre dentro del nombre, de ahi obtendremos el array con el valor de ello
        gettingclienteid=owner.filter(owneraux => owneraux = `${owneraux.nombre_apellido.toLowerCase()}`.includes(inputcliente.value.toLowerCase()));
        //luego obtendremos el unico valor dentro del array, sacando el id
        idcliente=gettingclienteid[0].id;
        //removeremos las clases que ya no se usara porque encontramos el texto que buscamos
        document.querySelector(".ayuda").remove()
        document.querySelector(".list_name").remove()
    }
})

//obtener dentro del select los datos de los doctores el cual nos atendera

window.addEventListener("DOMContentLoaded",async()=>{
    let res= await fetch("http://localhost:8081/listaArea");
    let data=await res.json();
    Area=data;
    console.log(Area)
    data.forEach(element => {
        element.doctores.forEach(aux=>{
        inputdoctor.insertAdjacentHTML("afterbegin",`<option value=${aux.id}>${aux.nombre} ${aux.apellido}</option>`)
    })
    });
})
let Area=[];
let idDoctor=0;
let idArea=0;
inputdoctor.addEventListener("change",(e)=>{
    idDoctor=parseInt(e.target.value);
    let filtrado=Area.filter(area => area.doctores.find(doctor => doctor.id === parseInt(e.target.value)));
    inputarea.value=filtrado[0].nombre_Area;
    idArea=filtrado[0].area_id;
    // debugger
    console.log(idDoctor)
    console.log(idArea)
})