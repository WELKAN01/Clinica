let select=document.getElementById("Select_Area")
const $form=document.getElementById("form_api")
const body=document.getElementById("body_table")
const inputfile=document.getElementById("file");
const cargardatos=async()=>{
    const res=await fetch("http://localhost:8081/doctor/lista")
    let data=await res.json();
    console.log(data);
    data.forEach(element => {
        body.innerHTML+=`<tr>
        <td>${element.id}</td>
        <td>${element.nombre}</td>
        <td>${element.apellido}</td>
        <td>${element.fecha_funcion}</td>
        <td>${element.dni}</td>
        <td><img class='img-thumbnail w-50 h-50' src='../IMG/FOTOS/Doctores/${element.foto}'/></td>
        </tr>`
    });
}

cargardatos()

document.addEventListener("submit",async (e)=>{
    if (e.target===$form) {
        e.preventDefault();
        try {
            const formData=new FormData(e.target);
            formData.append("nombre",e.target.nombres.value);
            formData.append("apellido", e.target.apellidos.value);
            formData.append("DNI", e.target.dni.value);
            formData.append("fecha_funcion", e.target.funcion.value);
            formData.append("file",inputfile.files[0])
            formData.append("areas", e.target.Select_Area.value);
            var options={
                method:'POST',
                body:formData,
            }
            let res=await fetch("http://localhost:8081/doctor/guardardoctor",options),
            data=await res.text();
            debugger
            window.location.reload();
        } catch (error) {
            console.log(error);
        }
    }
})

const Areaoption=async()=>{
    let res= await fetch("http://localhost:8081/listaArea");
    let data=await res.json();
    data.forEach(element => {
        select.insertAdjacentHTML("afterbegin",`<option value=${element.area_id}>${element.nombre_Area}</option>`)
    });
    // var a=function(data){
    //     for (const index in data) {
    //         console.log(index)
    //         console.log(data[index])
    //     }
    // }
    // a(data)
}

Areaoption()