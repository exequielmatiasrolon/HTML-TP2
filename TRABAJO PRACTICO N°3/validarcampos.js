function validacion(){
	field= "input";
	valor=document.getElementById(field).value;

	var today= new Date();
	var date2= new Date(valor);

		if (date2<today){
			
			alert('[ERROR] Error gil de goma');
			document.getElementById(fied).focus()
			return false;
		}

		return true;

}