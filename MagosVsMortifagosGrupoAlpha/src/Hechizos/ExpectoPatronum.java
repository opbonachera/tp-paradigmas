package Hechizos;

import Personajes.Personaje;

public class ExpectoPatronum implements Hechizo {
	private static final double MULTIPLICADOR_DE_CURACION = 4.5;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo)
	{
		double curacion = lanzador.getNivelDeMagiaPatronus() * MULTIPLICADOR_DE_CURACION;
		
		if( (objetivo.getPuntosDeVida() + curacion) <= objetivo.getMaxPuntosDeVida())
		{
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() + curacion);
		} else
		{
			objetivo.setPuntosDeVida(objetivo.getMaxPuntosDeVida());
		}
		
		System.out.println(lanzador.getNombre()       + 
				           " conjuró un Patronum. "   + 
				           objetivo.getNombre()       + 
				           " recuperó "               + 
				           curacion                   + 
				           " Puntos de Vida.");
	}
}
