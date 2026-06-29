package Hechizos;

import Estados.EstadoSangrando;
import Personajes.Personaje;

public class Expelliarmus implements Hechizo {
	private static final double MULTIPLICADOR_DE_DAÑO = 3.5;
	private static final int TURNOS_SANGRANDO = 2;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo)
	{
		double daño = lanzador.getNivelDeMagiaOscura() * MULTIPLICADOR_DE_DAÑO;
		
		if(objetivo.getEscudo() == true)
		{
			double minimo = Math.min(daño, objetivo.getEscudoPuntosDeVida());
			objetivo.setEscudoPuntosDeVida(objetivo.getEscudoPuntosDeVida() - minimo);
			daño -= minimo;
			
			if(objetivo.getEscudoPuntosDeVida() <= 0.0)
			{
				objetivo.setEscudo(false);
			}
		}

		objetivo.agregarEstado(new EstadoSangrando(TURNOS_SANGRANDO));
		
		/*if(daño != 0.0 && daño < objetivo.getPuntosDeVida())
		{
			objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - daño);
		} else
		{
			objetivo.setPuntosDeVida(0.0);
		}*/
		
		if(daño != 0.0)
		{
			if(daño < objetivo.getPuntosDeVida())
			{
				objetivo.setPuntosDeVida(objetivo.getPuntosDeVida() - daño);
			} else
			{
				objetivo.setPuntosDeVida(0.0);
			}
		}
		
		System.out.println(lanzador.getNombre()                           +
				           " lanzó un hechizo de tipo Expelliarmus a "    +
                           objetivo.getNombre()                           + 
                           " causando "                                   + 
                           daño                                           + 
                           " puntos de daño.");
	}
}
