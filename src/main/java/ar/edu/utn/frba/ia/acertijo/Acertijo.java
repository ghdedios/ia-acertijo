package main.java.ar.edu.utn.frba.ia.acertijo;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.ConfiguracionDefault;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;
import main.java.ar.edu.utn.frba.ia.ag.cruzamiento.Simple;
import main.java.ar.edu.utn.frba.ia.ag.mutacion.MutacionSimple;
import main.java.ar.edu.utn.frba.ia.ag.seleccion.Torneo;


public class Acertijo {

public static void main(String[] args) {

	ConfiguracionDefault c = new ConfiguracionDefault();
	
	c.setMetodoDeSeleccion(new Torneo());
	c.setCruzamiento(new Simple());
	c.setMutacion(new MutacionSimple(0.01)); //La mutacion si o si da lugar a resultados invalidos. Analizar sacar mutación
	
	AlgoritmoGenetico acertijo = new AlgoritmoGenetico(c, Solucion.class);
	
	Individuo solucionFinal = acertijo.ejecutar();
	
	Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).severe("Individuo final: " + solucionFinal.toString());
	
	System.out.println("------------------------------------------------------------------------");
	
	}
}
