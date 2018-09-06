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


function eliminarelementoslista(){
	var x = document.getElementById("input22");
    x.remove;
}

function agregarelementoslista(hora){

	var x = document.getElementById("input22");
    var option = document.createElement("option");
    option.text = hora
    x.add(option)     

}

	
function diasemana(){

		field= "input";
		valor=document.getElementById(field).value;
		var hora1 = "22:00"
		var hora2 = "22:30"

		var date2= new Date(valor);

		if (date2.getDay()==4) {
			alert('El dia que selecciono es VIERNES por lo tanto tendra 2 horarios mas')
		 agregarelementoslista(hora1)
		 agregarelementoslista(hora2)

    

		}
	
/* var dias = ["El dia es lununes","El dia es martes","El dia es miercoles","El dia es jueves","El dia es viernes","El dia es sabado","El dia es domingo"];
alert(dias[date2.getDay()]);
**/


}