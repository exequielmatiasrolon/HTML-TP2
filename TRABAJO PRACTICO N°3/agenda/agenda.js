function Tarea (titulo,fecha,idd) {
    this.titulo = titulo;
    this.fecha = fecha;
	this.id=idd;
//	this.categoria = categoria;
//	this.prioridad = prioridad;
	// agregar las otras propiedades
}


function Agenda (propietario) {
    this.propietario = propietario;
    this.tareas = [];
}

// modifica el contructor y agrega el metodo para cada objeto
Agenda.prototype.addTarea = function(t) {
	this.tareas.push(t);
};

Agenda.prototype.delTarea = function(i){
    this.tareas.splice(i,1);
//	for(x in this.tareas){alert("nombre " + this.tareas.)}
};

//metodo eliminar tarea

//definicion de una variable global para almacenar una agenda.
var globalAgenda;
var serie=0;
//var s = function()    { return  serie += 1;}
//var x = function(a,b) { return a + b;   } 
//var globalSerie =function(){ Serie +=1}

// body iniciaar en on load
function iniciar(){
	var seccionCreacionAgenda = document.getElementById("creacionAgenda");
	var duenioAgenda= document.getElementById("duenioAgenda");
	var btnCrearAgenda= document.getElementById("btnCrearAgenda");

	var seccionDatoAgenda  = document.getElementById("datoAgenda");
	var nombreDuenioAgenda = document.getElementById("nombreDuenioAgenda");

	var bloqueGestionTareas= document.getElementById("bloqueGestionTareas");

	var listaTareas =document.getElementById("listaTareas");
	var btnAddTarea = document.getElementById("btnAddTarea");

	var inputTareaTitulo = document.getElementById("tareaNombre");
	var inputTareaHorario = document.getElementById("hora");
	var fecha = document.getElementById("fecha");
	var categoria = document.getElementById("categoria");
	var prioridad1 = document.getElementById("prioridad1");
	var prioridad2 = document.getElementById("prioridad2");
	var prioridad3 = document.getElementById("prioridad3");
	// agregar mas variables

	seccionDatoAgenda.style.display="none";
	bloqueGestionTareas.style.display="none";
	seccionCreacionAgenda.style.display="";

	
	//cuando hace click en el boton crear agenda se crea la agenda del duenio en la variable global
	btnCrearAgenda.addEventListener('click',function(){
		globalAgenda = new Agenda(duenioAgenda.value);
		seccionDatoAgenda.style.display="";
		bloqueGestionTareas.style.display="";
		seccionCreacionAgenda.style.display="none";
		nombreDuenioAgenda.innerHTML=duenioAgenda.value;
	});

//cuando hace click en el boton crear agenda se crea la agenda del duenio en la variable global
	btnAddTarea.addEventListener('click',function(){
		
		//var t = new Tarea(inputTareaTitulo.value,fecha.value,categoria.value,prioridad.value);
	 	
	/*	var prio = document.getElementById("priorid");
		var seleccion;
		if(prio == "1"){
			seleccion = document.getElementById("prioridad1").value
		}*/
		serie +=1;
		var t = new Tarea(inputTareaTitulo.value,fecha.value,serie); 
		
		//alert("entra " + serie);
		
		globalAgenda.addTarea(t);
		//alert("entra" + t.titulo);
		var li = document.createElement("li");
		
		var boton = document.createElement("input");
			boton.setAttribute("id","unico");
			boton.setAttribute("type","button");
			boton.setAttribute("value","Eliminar");	    
     		boton.addEventListener("click",function(){
					this.parentNode.parentNode.removeChild(this.parentNode); //globalAgenda.delTarea()
					});
		
  		li.appendChild(document.createTextNode(t.titulo+" - "+t.fecha + " - "+ t.id + "  -  "));
		li.appendChild(boton);
		listaTareas.appendChild(li);
  		inputTareaTitulo.value='';
		inputTareaHorario.value='';
		prioridad.value='';
		categoria.value='';
  		
		// agregar el resto
  	});
}