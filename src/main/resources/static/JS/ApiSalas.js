const head=document.querySelector(".h_table")
let body_table=document.querySelector(".body_table")
let select=document.getElementById("Select_Area")
fragment=document.createDocumentFragment()

const Areaoption=async()=>{
    let res= await fetch("http://localhost:8081/listaArea");
    let data=await res.json();
    console.log(data)
    data.forEach(element => {
        select.insertAdjacentHTML("afterbegin",`<option value=${element.id}>${element.nombre_Area}</option>`)
    });
}

Areaoption()

const getSalas=async ()=>{
    let res= await fetch("http://localhost:8081/Sala/lista");
    let data=await res.json();
    console.log(data)
    columns=head.querySelectorAll("td").length;
    data.forEach(element => {
    body_table.innerHTML+=
    `<tr>
        <td>${element.idsala}</td>
        <td>${element.nombresala}</td>
        <td>${element.descripcionsala}</td>
        <td>${element.areasala.nombre_Area}</td>
        <td data-id='${element.idsala}' data-descripcion='${element.descripcionsala}'
        data-categoria=${element.areasala.nombre_Area}' data-nombre='${element.nombresala}'>
        <button class='btn btn-warning'>editar</button>
        </td>
        <td data-id='${element.idsala}'>
        <button class='btn btn-danger'>eliminar</button>
        </td>
    </tr>`
    debugger
    })
    // body_table.appendChild(frag);
}

getSalas()
