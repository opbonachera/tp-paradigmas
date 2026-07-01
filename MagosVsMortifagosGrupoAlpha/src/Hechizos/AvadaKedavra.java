package Hechizos;

import FormatoDeTexto.Formateo;
import Personajes.Personaje;

public class AvadaKedavra extends Hechizo {
	
	private static final double SIN_VIDA = 0.0;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		if(objetivo.estaInmune()) {
			System.out.println("¡Un destello de luz verde! "                  + 
	                           Formateo.ROJO_NEGRITA                          +
	                           lanzador.getNombre()                           +
	                           Formateo.RESET                                 +
	                           " usó la maldición asesina sobre "             + 
	                           Formateo.ROJO_NEGRITA                          +
	                           objetivo.getNombre()                           + 
	                           Formateo.RESET                                 +
							   " pero fallo ya que tenia inmunidad!");
		} else {
			objetivo.setPuntosDeVida(SIN_VIDA);
			System.out.println("¡Un destello de luz verde! "                  + 
	                           Formateo.ROJO_NEGRITA                          +
	                           lanzador.getNombre()                           +
	                           Formateo.RESET                                 +
	                           " usó la maldición asesina sobre "             + 
	                           Formateo.ROJO_NEGRITA                          +
	                           objetivo.getNombre()                           + 
	                           Formateo.RESET                                 +
							   ".");
		}
	}
	
}
