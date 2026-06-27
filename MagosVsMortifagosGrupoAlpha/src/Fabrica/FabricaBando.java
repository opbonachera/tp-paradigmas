package Fabrica;

import Personajes.Personaje;
import Hechizos.Hechizo;

public interface FabricaBando {
	Personaje crearPersonaje(String tipo, String nombre);
	Hechizo crearHechizo(String tipo);
}
