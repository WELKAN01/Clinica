
function activausuario(){
	const inputcorreo=document.querySelector(".correo").classList
	const password=document.querySelector('.password').classList
	inputcorreo.add("correo-active");
	if(document.getElementById("password").value!=""){
		inputcorreo.remove("password-active");	
	}
}

function activacontraseña(){
	const inputcorreo=document.querySelector(".correo").classList
	const password=document.querySelector('.password').classList
	password.add('password-active');
	if(document.getElementById("username").value!=""){
		inputcorreo.add("correo-active");
	}else{
		inputcorreo.remove("correo-active");
	}
}

function boton() {
	const inputcorreo=document.querySelector(".correo").classList
	const password=document.querySelector('.password').classList
	console.log(inputcorreo.textContent)
	if (document.getElementById("username").value=="") {
		inputcorreo.remove("correo-active");
	}
	if(document.getElementById('password').value==""){
		password.remove("password-active")
		password

	}
}

