package Fabrica;

import Personajes.*;
import Hechizos.*;

public class FabricaMortifagos implements FabricaBando {

	@Override
	public Personaje crearPersonaje(String tipo, String nombre) {
		switch (tipo.toLowerCase()) {
	        case "seguidor":     return new Seguidor(nombre);
	        case "comandante":   return new Comandante(nombre);
	        default:             throw new IllegalArgumentException("Tipo de mortifago desconocido: " + tipo);
	    }
	}

	@Override
	public Hechizo crearHechizo(String tipo) {
		switch (tipo.toLowerCase()) {
	        case "avadakedavra":    return new AvadaKedavra();
  	        case "expectopatronum": return new ExpectoPatronum();
	        case "expelliarmus":    return new Expelliarmus();
  	        case "protego":         return new Protego();
	        default:                throw new IllegalArgumentException("Tipo de hechizo desconocido o no disponible para Mortifagos: " + tipo);
	    }
	}

}
