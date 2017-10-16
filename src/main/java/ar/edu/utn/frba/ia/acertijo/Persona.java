package main.java.ar.edu.utn.frba.ia.acertijo;

import java.util.ArrayList;
import java.util.Random;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.UTgeNesUtils;
import main.java.ar.edu.utn.frba.ia.ag.ejemplos.maximo.X;

public class Persona{
	
	String nombre;
	String apellido;
	String pareja; //TODO: Con definir el apellido de dos personas ya se sabe quien es su pareja (y por puntuacion si no es consistente resta 1000)
	String ocupacion; 
	//int posicion; //TODO: la posicion va a definirse en funcion de que lugar tiene de la solución
	
	String nombres [] = {"Alberto","Angela","Ambrosio","Aurelia","Analia","Alfonso","Alfredo","Alicia" };
	String apellidos [] = {"Martinez","Gomez","Castaño","Alcala"};
	String parejas [] = {"Alberto","Angela","Ambrosio","Aurelia","Analia","Alfonso","Alfredo","Alicia" };
	String ocupaciones [] = {"Actriz","Abogado","Acuarelista","Escritor","Administrador de correos","Apicultor","Aduanero","Arquitecto"};
	//int posiciones [] = {1,2,3,4,5,6,7,8};
	
	
	public static Persona generarPersona(){
		Persona unaPersona = new Persona ();
		
		unaPersona.nombre = (String) UTgeNesUtils.alguno(unaPersona.nombres);
		unaPersona.apellido = (String) UTgeNesUtils.alguno(unaPersona.apellidos);
		unaPersona.pareja = (String) UTgeNesUtils.alguno(unaPersona.parejas);
		unaPersona.ocupacion = (String) UTgeNesUtils.alguno(unaPersona.ocupaciones);
		//unaPersona.posicion = 	(int)Math.random()*8;
		
		
		return unaPersona;
		}
	
	public static Persona generarPersona(String nombresDisponibles[], String apellidosDisponibles[], String parejasDisponibles[],
										String ocupacionesDisponibles[], int posicionesDisponibles[]){
		Persona unaPersona = new Persona ();
		
		unaPersona.nombre = (String) UTgeNesUtils.alguno(nombresDisponibles);
		unaPersona.apellido = (String) UTgeNesUtils.alguno(apellidosDisponibles);
		unaPersona.pareja = (String) UTgeNesUtils.alguno(parejasDisponibles);
		unaPersona.ocupacion = (String) UTgeNesUtils.alguno(ocupacionesDisponibles);
		/*Random rn = new Random();
		int posicion = rn.nextInt(posicionesDisponibles.length - 1);
		unaPersona.posicion = posicionesDisponibles[posicion];*/
		
		
		return unaPersona;
	}
	

	public String getNombre(){
		return nombre;
	}
	
	public String getApellido(){
		return apellido;	
	}
		
	public String getPareja(){
		return pareja;
	}
		
	public String getOcupacion() {
		return ocupacion;
	}
	
/*	public int getPosicion() {
		return posicion;
	}*/
	
	public boolean esMujer(){
		return this.nombre.equalsIgnoreCase("Angela") ||
			this.nombre.equalsIgnoreCase("Aurelia") ||
			this.nombre.equalsIgnoreCase("Analia") ||
			this.nombre.equalsIgnoreCase("Alicia");
	}
	
	public boolean esHombre(){
		return this.nombre.equalsIgnoreCase("Alberto") ||
				this.nombre.equalsIgnoreCase("Ambrosio") ||
				this.nombre.equalsIgnoreCase("Alfonso") ||
				this.nombre.equalsIgnoreCase("Alfredo");
	}

	public boolean equalsPersona(Persona otraPersona){
		if(this.nombre.equalsIgnoreCase(otraPersona.getNombre())
				&& this.apellido.equalsIgnoreCase(otraPersona.getApellido())
				&& this.ocupacion.equalsIgnoreCase(otraPersona.getOcupacion())){
			return true;
		}
		return false;
	}

}
