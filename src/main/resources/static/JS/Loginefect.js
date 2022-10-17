function activausuario(){
	var correo=document.querySelector('.correo');
	var inputcorreo=document.getElementById('username');
		correo.classList.add('correo-active');
	if(inputcorreo.value===""){
		correo.classList.remove('correo-active');
	}else{
		correo.classList.add('correo-active');
	}
}

function activacontraseña(){
	var password=document.querySelector('.password');
	var passwordinput=document.getElementById('password');
	password.classList.add('password-active');
	if(inputcorreo.value===""){
		correo.classList.remove('correo-active');
	}else{
		correo.classList.add('correo-active');
	}
	var inputcorreo=document.getElementById('username');
		password.classList.add('password-active');
}

function boton(){
	var password=document.querySelector('.password');
	var passwordinput=document.getElementById('password');
	if(passwordinput.value===""){
		password.classList.remove('password-active');
	}else{
		password.classList.add('password-active');
	}
}