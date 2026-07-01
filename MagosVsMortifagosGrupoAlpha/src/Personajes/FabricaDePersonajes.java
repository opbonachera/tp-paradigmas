package Personajes;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class FabricaDePersonajes {
	
	private static final List<String> nombresGenericosMagos = new ArrayList<>();
	private static final List<String> nombresGenericosMortifagos = new ArrayList<>();
	private final Random random = new Random();
	
	public FabricaDePersonajes() { // Cuando creo la fabrica de personajes, cargo en los ArrayLists correspondientes, nombres genericos para los personajes
		cargarListaNombresGenericosMagos(nombresGenericosMagos);
		cargarListaNombresGenericosMortifagos(nombresGenericosMortifagos);
	}

    public Personaje crearMago() {
    	
    	while (nombresGenericosMagos.size() > 0) {
            int posNombreAleatorio = random.nextInt(nombresGenericosMagos.size());
            String nombreAleatorio = nombresGenericosMagos.get(posNombreAleatorio);
            nombresGenericosMagos.remove(posNombreAleatorio);
            
            int tipoAleatorio = random.nextInt(3); 
            
            switch (tipoAleatorio) {
                case 0:  return new Estudiante(nombreAleatorio);
                case 1:  return new Profesor(nombreAleatorio);
                case 2:  return new Auror(nombreAleatorio);
                default: throw new IllegalStateException("No se pudo crear el Mago!!!"); 
            }
        }
    	
        throw new IllegalStateException("¡No se pueden crear más Magos únicos! Todos los nombres disponibles ya están en uso.");
    
    }
    
    public Personaje crearMortifago() {
    	
    	while (nombresGenericosMortifagos.size() > 0) {
            int posNombreAleatorio = random.nextInt(nombresGenericosMortifagos.size());
            String nombreAleatorio = nombresGenericosMortifagos.get(posNombreAleatorio);
            nombresGenericosMortifagos.remove(posNombreAleatorio);
            
            int tipoAleatorio = random.nextInt(3); 
            
            switch (tipoAleatorio) {
                case 0:  return new Estudiante(nombreAleatorio);
                case 1:  return new Profesor(nombreAleatorio);
                case 2:  return new Auror(nombreAleatorio);
                default: throw new IllegalStateException("No se pudo crear el Mortifago!!!"); 
            }
        }
    	
        throw new IllegalStateException("¡No se pueden crear más Mortifagos únicos! Todos los nombres disponibles ya están en uso.");
    
    }
    
    private void cargarListaNombresGenericosMagos(List<String> nombresGenericosMagos) {
    	nombresGenericosMagos.add("Albus Shacklebolt");
    	nombresGenericosMagos.add("Garrick Ollivander");
    	nombresGenericosMagos.add("Minerva Flitwick");
    	nombresGenericosMagos.add("Remus Diggory");
    	nombresGenericosMagos.add("Sybill Vector");
    	nombresGenericosMagos.add("Pomona Sprout");
    	nombresGenericosMagos.add("Phineas Black");
    	nombresGenericosMagos.add("Celestina Warbeck");
    	nombresGenericosMagos.add("Gideon Prewett");
    	nombresGenericosMagos.add("Dorcas Meadowes");
    }
    
    private void cargarListaNombresGenericosMortifagos(List<String> nombresGenericosMortifagos) {
    	nombresGenericosMortifagos.add("Lucius Malfoy");
    	nombresGenericosMortifagos.add("Bellatrix Lestrange");
    	nombresGenericosMortifagos.add("Antonin Dolohov");
    	nombresGenericosMortifagos.add("Corban Yaxley");
    	nombresGenericosMortifagos.add("Thorfinn Rowle");
    	nombresGenericosMortifagos.add("Bartemius Crouch Jr");
    	nombresGenericosMortifagos.add("Regulus Black");
    	nombresGenericosMortifagos.add("Evan Rosier");
    	nombresGenericosMortifagos.add("Walden Macnair");
    	nombresGenericosMortifagos.add("Augustus Rookwood");
    }
    
}



