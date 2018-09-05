
					function oneClic(boton){

						var nombre, dni , texto, div
						nombre= document.getElementById('nombre').value;
						dni = document.getElementById('dni').value;

						texto = "Los valores Ingresados en el Formaulario son : <hr>  nombre:"  + nombre + " <hr> DNI:" + dni ;

						div=document.getElementById('info')
						div.innerHTML =texto
						

						boton.disabled=true;

					}
		