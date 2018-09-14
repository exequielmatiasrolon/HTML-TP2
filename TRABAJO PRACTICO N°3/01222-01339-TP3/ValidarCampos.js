var semanacompleta=document.getElementById("horario")
function validarfecha(){

    field="fecha";
    valor=document.getElementById(field).value;
    var today=new Date();
    var date2=new Date(valor);
    var viernes=date2.getDay()

    if(date2<today){

        alert('ERROR --> Fecha de Tickets debe ser mayor o igual a la fecha actual');
        document.getElementById(field).focus();

        return false;
    }
  else if(viernes==4)
    {

 var horarios=document.getElementById("horario")

 horarios[4].style.display="inline"
 horarios[5].style.display="inline"

  /*
  horarios[4].style.visibility="hidden"
  horarios[5].style.visibility="hidden"
  */

      return true;
    }

else if (viernes!=4) {


var horarios=document.getElementById("horario")


horarios[4].style.display="none"
horarios[5].style.display="none"

return true;

  /*
  tercer intento
var node=document.createElement("OPTION")
var textnode1=document.createTextNode("22:00")
var textnode2=document.createTextNode("22:30")
node.appendChild(textnode1)
node.appendChild(textnode2)
document.getElementById("horario").appendChild(node)



/*
tercer intento
var select=document.getElementById("horario")
var arr=["22:00", "22:30"]
for (i=0;i<arr.length;i++)
{
  var option=document.createElement("OPTION")
  txt=document.createTextNode(arr[i])
  option.appendChild(txt)
  option.setAttribute("value",arr[i])
  select.insertBefore(option,select.lastChild)
}


primer intento
semana.appendChild(array[0])
semana.appendChild(array[1])


segundo intento
  var horarios=document.getElementById("horario")


horarios[4].style.visibility="visible"
horarios[5].style.visibility="visible"
*/



     }

    return true;
}

function ocultar()
{
  document.getElementById("tarjetanevada").style.display="none"
  document.getElementById("tarjetario").style.display="none"
  document.getElementById("tarjetapersonal").style.display="none"
  document.getElementById("textopersonal").style.display="none"
  document.getElementById("textonevada").style.display="none"
  document.getElementById("textorio").style.display="none"
}
function validarpago()
{
  if(document.getElementById("cantidadpersonal").value!=0){
document.getElementById("tarjetapersonal").style.display = "inline";
document.getElementById("textopersonal").style.display="inline"
 }
 else{
   document.getElementById("tarjetapersonal").style.display="none"
   document.getElementById("textopersonal").style.display="none"
 }
  if(document.getElementById("cantidadnevada").value!=0){
      document.getElementById("tarjetanevada").style.display = "inline";
      document.getElementById("textonevada").style.display="inline"
    }
    else{
      document.getElementById("tarjetanevada").style.display="none"
      document.getElementById("textonevada").style.display="none"
    }
  if (document.getElementById("cantidadrio").value != 0 ){
      document.getElementById("tarjetario").style.display = "inline";
      document.getElementById("textorio").style.display="inline"
    }

    else {

      document.getElementById("tarjetario").style.display="none"
      document.getElementById("textorio").style.display="none"
         }



       var personal = document.getElementById("cantidadpersonal").value * 75;
       var nevada = document.getElementById("cantidadnevada").value * 75;
       var rio = document.getElementById("cantidadrio").value * 75;
       var dia = document.getElementById("cantidaddia").value * 90;
       var total= personal+nevada+rio+dia
   document.getElementById("subtotaldia").innerHTML = "$"+dia;
   document.getElementById("subtotalrio").innerHTML = "$"+rio;
   document.getElementById("subtotalnevada").innerHTML = "$"+nevada;
   document.getElementById("subtotalpersonal").innerHTML = "$"+personal;
   document.getElementById("preciofinal").innerHTML = "$"+total;
}
