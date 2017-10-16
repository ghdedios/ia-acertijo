package main.java.ar.edu.utn.frba.ia.acertijo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Solucion extends Individuo {

	private Persona[] posibleSolucion = new Persona[8];
	
	@Override
	public double aptitud() {
		
		double aptitud = 0;
		
		
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

	
	//TODO: Refactorear generarRandom() siguiendo buenas prácticas de programacion. (Extraer logica de intercalado coherente)
	@Override
	public Individuo generarRandom(){
		String[] nombresHombre = {"Alberto","Ambrosio","Alfonso","Alfredo"};
		String[] nombresMujer = {"Angela","Aurelia","Analia","Alicia"};
		String[]  apellidosHombre = {"Martinez","Gomez","Castaño","Alcala"};
		String[]  apellidosMujer = {"Martinez","Gomez","Castaño","Alcala"};
		String[] ocupaciones = {"Actriz","Abogado","Acuarelista","Escritor","Administrador de correos","Apicultor","Aduanero","Arquitecto"};
		
		Solucion solucion = new Solucion();
		
		solucion.posibleSolucion[0] = Persona.generarPersona();
		if(solucion.posibleSolucion[0].esHombre()){ //Si el primero en generarse es hombre, mantengo coherencia de sentar hombre-mujer
			solucion.posibleSolucion[1] = Persona.generarMujer(nombresMujer, apellidosMujer, ocupaciones);
			Persona test = solucion.posibleSolucion[1]; //TODO: TEST
			String apellido = test.getApellido();//TODO: TEST
			for(int i=3; i<solucion.posibleSolucion.length; i=i+2){
				apellido = solucion.posibleSolucion[i-2].getApellido();
				this.removerElemento(apellidosMujer, solucion.posibleSolucion[i-2].getApellido());
				this.removerElemento(nombresMujer, solucion.posibleSolucion[i-2].getNombre());
				this.removerElemento(ocupaciones, solucion.posibleSolucion[i-2].getOcupacion());
				
				solucion.posibleSolucion[i] = Persona.generarMujer(nombresMujer,apellidosMujer, ocupaciones);
			}
			for(int j=2; j<solucion.posibleSolucion.length; j=j+2){
				this.removerElemento(apellidosHombre, solucion.posibleSolucion[j-2].getApellido());
				this.removerElemento(nombresHombre, solucion.posibleSolucion[j-2].getNombre());
				this.removerElemento(ocupaciones, solucion.posibleSolucion[j-2].getOcupacion());
				
				solucion.posibleSolucion[j] = Persona.generarHombre(nombresHombre,apellidosHombre, ocupaciones);
			}
		}
		
		if(solucion.posibleSolucion[0].esMujer()){ //Si el primero en generarse es mujer, mantengo coherencia de sentar mujer-hombre
			solucion.posibleSolucion[1] = Persona.generarHombre(nombresHombre, apellidosHombre, ocupaciones);
			for(int i=3; i<solucion.posibleSolucion.length; i=i+2){	
				this.removerElemento(apellidosHombre, solucion.posibleSolucion[i-2].getApellido());
				this.removerElemento(nombresHombre, solucion.posibleSolucion[i-2].getNombre());
				this.removerElemento(ocupaciones, solucion.posibleSolucion[i-2].getOcupacion());
				
				solucion.posibleSolucion[i] = Persona.generarHombre(nombresHombre,apellidosHombre, ocupaciones);
			}
			for(int j=2; j<solucion.posibleSolucion.length; j=j+2){
				this.removerElemento(apellidosMujer, solucion.posibleSolucion[j-2].getApellido());
				this.removerElemento(nombresMujer, solucion.posibleSolucion[j-2].getNombre());
				this.removerElemento(ocupaciones, solucion.posibleSolucion[j-2].getOcupacion());
				
				solucion.posibleSolucion[j] = Persona.generarMujer(nombresMujer,apellidosMujer, ocupaciones);
			}
		}

		
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
/*
	public String[] removerElemento(String[] array, String elementoABorrar) {
	    List<String> nuevoArray = new LinkedList<String>();

	    for(String item : nuevoArray)
	        if(!elementoABorrar.equals(item))
	            nuevoArray.add(item);

	    return nuevoArray.toArray(array);
	}
	*/
	public void removerElemento(String[] array, String elementoABorrar){
		List<String> list = new ArrayList<String>(Arrays.asList(array));
		list.remove(elementoABorrar);
		String[] nuevoArray = list.toArray(new String[0]);
		array = nuevoArray;
	}
	
	
	/**************************Funciones Overrides de Individuo***********************/
	
	@Override
	public String toString() {
		String solucion = new String();

		for (int i =0; i<8;i++){
			solucion += ("Posicion " + i + " =  Nombre: " + this.posibleSolucion[i].getNombre()
										+ "  Apellido: " + this.posibleSolucion[i].getApellido()
										+ "  Ocupacion: " + this.posibleSolucion[i].getOcupacion());
		}
        
        return "Aptitud = " + this.aptitud() + " || Genes: " + solucion;
		
	}
	
}
	
