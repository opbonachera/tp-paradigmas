package Hechizos;

import Personajes.Personaje;

public class ExpectoPatronum implements Hechizo {
	private static final double MULTIPLICADOR_DE_CURACION = 4.5;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo)
	{
		double curacion = lanzador.getNivelDeMagia() * MULTIPLICADOR_DE_CURACION;
		
		if( (objetivo.getPuntosDeVida() + curacion) <= objetivo.getMaxPuntosDeVida())
		{
			objetivo.setEscudoPuntosDeVida(objetivo.getPuntosDeVida() + curacion);
		} else
		{
			objetivo.setEscudoPuntosDeVida(objetivo.getMaxPuntosDeVida());
		}
		
		System.out.println(lanzador.getNombre()       + 
				           " conjuró un Patronum. "   + 
				           objetivo.getNombre()       + 
				           " recuperó "               + 
				           curacion                   + 
				           " Puntos de Vida.");
	}
}
