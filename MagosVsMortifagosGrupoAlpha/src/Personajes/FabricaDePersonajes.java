package Personajes;

import java.util.Random;

public class FabricaDePersonajes {
	private static final String[] nombresGenericosMagos = {
		    "Albus Shacklebolt", 
		    "Garrick Ollivander", 
		    "Minerva Flitwick", 
		    "Remus Diggory", 
		    "Sybill Vector", 
		    "Pomona Sprout", 
		    "Phineas Black", 
		    "Celestina Warbeck", 
		    "Gideon Prewett", 
		    "Dorcas Meadowes"
		}; 
	private static final String[] nombresGenericosMortifagos = {
		    "Lucius Malfoy", 
		    "Bellatrix Lestrange", 
		    "Antonin Dolohov", 
		    "Corban Yaxley", 
		    "Thorfinn Rowle", 
		    "Bartemius Crouch Jr", 
		    "Regulus Black", 
		    "Evan Rosier", 
		    "Walden Macnair", 
		    "Augustus Rookwood"
		};
	Random rand1 = new Random();
	Random rand2 = new Random();
	
	
	public Personaje crearMago() {
		int nombreAleatorio = rand1.nextInt(nombresGenericosMagos.length);
		int tipoAleatorio = rand2.nextInt(3) + 1; // no se si hay que hacerlo constante
		
		switch (tipoAleatorio) {
	        case 1: return new Estudiante(nombresGenericosMagos[nombreAleatorio]); // estudiante
	        case 2: return new Profesor(nombresGenericosMagos[nombreAleatorio]); // profesor
	        case 3: return new Auror(nombresGenericosMagos[nombreAleatorio]); // auror
	        default: throw new IllegalStateException("No se pudo crear el Mago!!!"); // hay que revisar porque no es IllegalArgumentException
	    }
	}
	
	public Personaje crearMortifago() {
		int nombreAleatorio = rand1.nextInt(nombresGenericosMortifagos.length);
		int tipoAleatorio = rand2.nextInt(2); // no se si hay que hacerlo constante
		
		switch (tipoAleatorio) {
	        case 1: return new Seguidor(nombresGenericosMortifagos[nombreAleatorio]); // seguidor
	        case 2: return new Comandante(nombresGenericosMortifagos[nombreAleatorio]); // comandante
	        default: throw new IllegalArgumentException("No se pudo crear el Mortifago!!!"); // hay que revisar porque no es IllegalArgumentException
		}
	}
	
}
