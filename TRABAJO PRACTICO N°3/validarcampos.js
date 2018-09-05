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

	
function diasemana(){

		field= "input";
		valor=document.getElementById(field).value;

		var date2= new Date(valor);

		if (date2.getDay()==4) {
			alert('keko')
		}
	
/* var dias = ["El dia es lununes","El dia es martes","El dia es miercoles","El dia es jueves","El dia es viernes","El dia es sabado","El dia es domingo"];
alert(dias[date2.getDay()]);
**/


}