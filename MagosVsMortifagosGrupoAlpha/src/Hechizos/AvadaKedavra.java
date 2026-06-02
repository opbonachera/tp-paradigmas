package Hechizos;

import Personajes.Personaje;

public class AvadaKedavra implements Hechizo {
	private static final double SIN_VIDA = 0.0;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo)
	{
		objetivo.setPuntosDeVida(SIN_VIDA);
		
		System.out.println("¡Un destello de luz verde! "        + 
		                   lanzador.getNombre()                 +
                           " usó la maldición asesina sobre "   + 
		                   objetivo.getNombre()                 + 
		                   ".");
	}
}
