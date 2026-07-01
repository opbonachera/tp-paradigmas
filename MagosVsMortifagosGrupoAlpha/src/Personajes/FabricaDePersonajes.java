package Personajes;

import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class FabricaDePersonajes {
	
    private static final String[] nombresGenericosMagos = {"Albus Shacklebolt", 
    		                                               "Garrick Ollivander", 
    		                                               "Minerva Flitwick", 
    		                                               "Remus Diggory", 
    		                                               "Sybill Vector", 
    		                                               "Pomona Sprout", 
    		                                               "Phineas Black", 
    		                                               "Celestina Warbeck", 
    		                                               "Gideon Prewett", 
    		                                               "Dorcas Meadowes"}; 
    
    private static final String[] nombresGenericosMortifagos = {"Lucius Malfoy", 
    		                                                    "Bellatrix Lestrange", 
    		                                                    "Antonin Dolohov", 
    		                                                    "Corban Yaxley", 
    		                                                    "Thorfinn Rowle", 
    		                                                    "Bartemius Crouch Jr", 
    		                                                    "Regulus Black", 
    		                                                    "Evan Rosier", 
    		                                                    "Walden Macnair", 
    		                                                    "Augustus Rookwood"};

    private final Set<Personaje> personajesCreados = new HashSet<>();
    private final Random random = new Random();

    public Personaje crearMago() {
    	int cantIntentosCrearMagos = 0;
    	
    	while (cantIntentosCrearMagos < nombresGenericosMagos.length) {
            int nombreAleatorio = random.nextInt(nombresGenericosMagos.length);
            int tipoAleatorio = random.nextInt(3); 
            
            Personaje nuevoMago;
            switch (tipoAleatorio) {
                case 0: 
                    nuevoMago = new Estudiante(nombresGenericosMagos[nombreAleatorio]);
                    break;
                case 1: 
                    nuevoMago = new Profesor(nombresGenericosMagos[nombreAleatorio]);
                    break;
                case 2: 
                    nuevoMago = new Auror(nombresGenericosMagos[nombreAleatorio]);
                    break;
                default: 
                    throw new IllegalStateException("No se pudo crear el Mago!!!"); 
            }

            if (personajesCreados.add(nuevoMago)) {
                return nuevoMago;
            }

            cantIntentosCrearMagos++;
        }

        throw new IllegalStateException("¡No se pueden crear más Magos únicos! Todos los nombres disponibles ya están en uso.");
    }
    
    public Personaje crearMortifago() {
    	int cantIntentosCrearMortifagos = 0;
    	
    	while (cantIntentosCrearMortifagos < nombresGenericosMortifagos.length) {
            int nombreAleatorio = random.nextInt(nombresGenericosMortifagos.length);
            int tipoAleatorio = random.nextInt(2); 
            
            Personaje nuevoMortifago;
            switch (tipoAleatorio) {
                case 0: 
                    nuevoMortifago = new Seguidor(nombresGenericosMortifagos[nombreAleatorio]);
                    break;
                case 1: 
                    nuevoMortifago = new Comandante(nombresGenericosMortifagos[nombreAleatorio]);
                    break;
                default: 
                    throw new IllegalStateException("No se pudo crear el Mortifago!!!"); 
            }

            if (personajesCreados.add(nuevoMortifago)) {
                return nuevoMortifago;
            }

            cantIntentosCrearMortifagos++;
        }

        throw new IllegalStateException("¡No se pueden crear más Mortifagos únicos! Todos los nombres disponibles ya están en uso.");
    }
}