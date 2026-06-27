package Fabrica;

import Personajes.*;
import Hechizos.*;

public class FabricaMagos implements FabricaBando {

	@Override
	public Personaje crearPersonaje(String tipo, String nombre) {
		switch (tipo.toLowerCase()) {
	        case "estudiante": return new Estudiante(nombre);
	        case "profesor":   return new Profesor(nombre);
	        case "auror":      return new Auror(nombre);
	        default:           throw new IllegalArgumentException("Tipo de mago desconocido: " + tipo);
		}
	}

	@Override
	public Hechizo crearHechizo(String tipo) {
		switch (tipo.toLowerCase()) {
//	        case "avadakedavra":    return new AvadaKedavra();
	        case "expectopatronum": return new ExpectoPatronum();
	        case "expelliarmus":    return new Expelliarmus();
	        case "protego":         return new Protego();
	        default:                throw new IllegalArgumentException("Tipo de hechizo desconocido o no disponible para Magos: " + tipo);
		}
	}

}
