function validar(){
	field="input";
	valor=document.getElementById(field).value;
	var today=new Date();
	var date2=new Date(valor);
	if (date2<today){
		
		alert('[ERROR] error en el campor de fecha');
		document.getElementById(field).focus()
		return false;
	} 
	return true;
}