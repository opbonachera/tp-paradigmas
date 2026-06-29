package Hechizos;

import Estados.EstadoInmune;
import Personajes.Personaje;

public class Protego implements Hechizo {
	private static final double PUNTOS_DE_VIDA_ESCUDO = 10.0;
	private static final int TURNOS_INMUNE = 2;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo)
	{
		objetivo.setEscudo(true);
		objetivo.setEscudoPuntosDeVida(PUNTOS_DE_VIDA_ESCUDO); // Yo haría objetivo.getEscudoPuntosDeVida + PUNTOS_DE_VIDA_ESCUDO.
		objetivo.agregarEstado(new EstadoInmune(TURNOS_INMUNE));
		
		System.out.println(lanzador.getNombre() + 
				           " alzó su varita y exclamó ¡Protego! El escudo está activo.");
	}
}
