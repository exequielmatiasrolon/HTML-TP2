function Tarea (titulo,fecha) {
    this.titulo = titulo;
    this.fecha = fecha;
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

//metodo eliminar tarea

//definicion de una variable global para almacenar una agenda.
var globalAgenda;

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
	var prioridad = document.getElementById("prioridad");
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
		var t = new Tarea(inputTareaTitulo,fecha); 
		//alert("entra" + inputTareaTitulo.value);
		globalAgenda.addTarea(t);
	//	alert("entra" + t.titulo);
		var li = document.createElement("li");
  		li.appendChild(document.createTextNode(t.titulo+" - "+t.fecha));
		listaTareas.appendChild(li);
  		inputTareaTitulo.value='';
		inputTareaHorario.value='';
		prioridad.value='';
		categoria.value='';
  		
		// agregar el resto
  	});
}