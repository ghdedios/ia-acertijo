package main.java.ar.edu.utn.frba.ia.acertijo;

import java.util.ArrayList;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Solucion extends Individuo {

	Persona[] posibleSolucion = new Persona[8];
	
	@Override
	public double aptitud() {
		
		double aptitud = 0;
		
		//TODO: Agregar condicion de que esten intercalados con mucho puntaje
		
		//Los numeros se relacionan con las condiciones propuestas por el enunciado presentado a la cátedra
		if(this.uno()){ //1
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.dos()){ //2
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.tres()){ //3
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.cuatro()){ //4
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.cinco()){ //5
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.seis()){ //6
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		if(this.siete()){ //7
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}

		if(this.ocho()){ //8
			aptitud = aptitud + 10;
		}else{
			aptitud = aptitud-2;
		}
		
		return aptitud;
	}

	@Override
	public Individuo generarRandom(){
		Solucion solucion = new Solucion();
//TODO	
		for (int i=0; i<solucion.posibleSolucion.length; i++){
			solucion.posibleSolucion[i] = Persona.generarPersona(); //TODO: ir pasando los posibles estados usados para generar consistencia
		}
//TODO	
		
		return solucion;
	
	}

	
	/****************************Criterios Para Funcion Aptitud***********************************/
	
	
	private boolean uno(){
		if (getMujerPorApellido("Martinez").getOcupacion().equalsIgnoreCase("Actriz")
				&& 
				getPersonaPorNombre("Alfredo").getOcupacion().equalsIgnoreCase("Abogado")){
			return true;
		}
		return false;
	}
	
	private boolean dos(){
		int posicionGomez = this.getPosicion(getHombrePorApellido("Gomez"));
		
		Persona izquierdaGomez = getIzquierdaDe(posicionGomez);
		Persona derechaGomez = getDerechaDe(posicionGomez);
		
		if(izquierdaGomez.getNombre().equalsIgnoreCase("Angela") && derechaGomez.getOcupacion().equalsIgnoreCase("Acuarelista")){
			return true;
		}
		if(derechaGomez.getNombre().equalsIgnoreCase("Angela") && izquierdaGomez.getOcupacion().equalsIgnoreCase("Acuarelista")){
			return true;
		}
		return false;
	}
	
	private boolean tres(){
		Persona ambrosio = getPersonaPorNombre("ambrosio");
		Persona escritora = getPersonaPorProfesion("escritor");
		
		if(ambrosio.getApellido().equalsIgnoreCase(escritora.getApellido())
				&& escritora.esMujer()){
			return true;
		}
		
		return false;
	}
	
	
	private boolean cuatro(){
		
		Persona aurelia = getPersonaPorNombre("Aurelia");
		Persona derecha = getDerechaDe(this.getPosicion(aurelia));
		Persona enFrente = getEnFrente(this.getPosicion(aurelia));
		
		if(derecha.getOcupacion().equalsIgnoreCase("Administrador de correos") 
				&& enFrente.getApellido().equalsIgnoreCase("Gomez")
				&& enFrente.esMujer()){
			return true;
		}
		
		return false;
	}
	
	private boolean cinco(){
		Persona analia = getPersonaPorNombre("Analía");
		if(analia.getApellido().equalsIgnoreCase("Castaño")){
			return true;
		}
		
		return false;
	}
	
	private boolean seis(){
		Persona alfonso = getPersonaPorNombre("Alfonso");
		Persona izquierda = getIzquierdaDe(this.getPosicion(alfonso));
		Persona derecha = getDerechaDe(this.getPosicion(alfonso));
		
		if(izquierda.getOcupacion().equalsIgnoreCase("Apicultor") && derecha.getApellido().equalsIgnoreCase("Alcala")){
			return true;
		}
		if(derecha.getOcupacion().equalsIgnoreCase("Apicultor") && izquierda.getApellido().equalsIgnoreCase("Alcala")){
			return true;
		}				
		
		return false;
	}
	
	private boolean siete(){
		Persona alfredo = getPersonaPorNombre("Alfredo");
		Persona enFrente = getEnFrente(this.getPosicion(alfredo));
		
		if(enFrente.getOcupacion().equalsIgnoreCase("Aduanero")){
			return true;
		}
		return false;
	}
	
	private boolean ocho(){
		Persona castañoHombre = getHombrePorApellido("Castaño");
		Persona derecha = getDerechaDe(this.getPosicion(castañoHombre));
		
		if (derecha.getNombre().equalsIgnoreCase("Alicia")){
			return true;
		}
		return false;
	}
	
	
	/**************************Getters y Setters personalizados***********************/
	private Persona getPersonaPorNombre(String nombre){
		for(int i=0; i<posibleSolucion.length; i++){
			if(posibleSolucion[i].getNombre().equalsIgnoreCase(nombre)){
				return posibleSolucion[i];
			}
		}
		return null;
	}
	
	private Persona getPersonaPorProfesion(String profesion){
		for(int i=0; i<posibleSolucion.length; i++){
			if(posibleSolucion[i].getOcupacion().equalsIgnoreCase(profesion)){
				return posibleSolucion[i];
			}
		}
		return null;
	}
	
	private Persona getPersonaPorPosicion(int posicion){
		/*for(int i=0; i<posibleSolucion.length; i++){
			if(posibleSolucion[i].getPosicion()== posicion){
				return posibleSolucion[i];
			}
		}*/
		if(posibleSolucion[posicion-1] != null){
			return posibleSolucion[posicion-1];
		}
		
		return null;
	}
	
	private Persona getMujerPorApellido(String apellido) {
		for(int i=0; i<posibleSolucion.length; i++){
			if(posibleSolucion[i].getApellido().equalsIgnoreCase(apellido)){
				if(posibleSolucion[i].esMujer()){
					return posibleSolucion[i];	
				}
			}
		}
		
		return null;
	}
	
	private Persona getHombrePorApellido(String apellido) {
		for(int i=0; i<posibleSolucion.length; i++){
			if(posibleSolucion[i].getApellido().equalsIgnoreCase(apellido)){
				if(posibleSolucion[i].esHombre()){
					return posibleSolucion[i];	
				}
			}
		}
		
		return null;
	}
	
	private Persona getDerechaDe(int posicion){
		if(posicion == 1){
			return getPersonaPorPosicion(8);
		}else{
			return getPersonaPorPosicion(posicion-1);
		}
	}
	
	private Persona getIzquierdaDe(int posicion){
		if(posicion == 8){
			return getPersonaPorPosicion(1);
		}else{
			return getPersonaPorPosicion(posicion+1);
		}
	}
	
	
	private Persona getEnFrente(int posicion){
		if(posicion == 5){
			return getPersonaPorPosicion(1);
		}
		if(posicion == 6){
			return getPersonaPorPosicion(2);
		}
		if(posicion == 7){
			return getPersonaPorPosicion(3);
		}
		if(posicion == 8){
			return getPersonaPorPosicion(4);
		}
		return getPersonaPorPosicion(posicion+4);
	}
		
	
	private int getPosicion(Persona persona){
		for(int i=0; i<this.posibleSolucion.length;i++){
			if (this.posibleSolucion[i].equalsPersona(persona)){
				return i;
			}
		}
		return -1;
	}


}
	
