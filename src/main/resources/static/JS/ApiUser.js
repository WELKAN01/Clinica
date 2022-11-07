
(()=>{
    const apps=document.querySelector('#app');
    const URL="http://localhost:8080/api";
    fetch('${URL}/usuariolist').
    then((response)=> response.json()).
    then((usuariolist)=>{
        const List = usuariolist.map((User)=> '<li>${User.nombres}------${User.correo}</li>');
        apps.innerHTML='<ul>${List}</ul>';
        console.log(apps);
    })
})

