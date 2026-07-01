package Hechizos;

import FormatoDeTexto.Formateo;
import Estados.EstadoInmune;
import Personajes.Personaje;

public class Protego extends Hechizo {
	
	private static final double PUNTOS_DE_VIDA_ESCUDO = 10.0;
	private static final int TURNOS_INMUNE = 1;
	
	@Override
	public void ejecutar(Personaje lanzador, Personaje objetivo) {
		objetivo.setEscudo(true);
		objetivo.setEscudoPuntosDeVida(PUNTOS_DE_VIDA_ESCUDO);
		
		System.out.println(Formateo.ROJO_NEGRITA                                               + 
			               lanzador.getNombre()                                                + 
			               Formateo.RESET                                                      +
		                   " alzó su varita y exclamó ¡Protego! El escudo está activo sobre "  +
			               Formateo.ROJO_NEGRITA                                               +
			               objetivo.getNombre()                                                +
			               Formateo.RESET);
		
		objetivo.agregarEstado(new EstadoInmune(TURNOS_INMUNE));
	}

	@Override
	public boolean esHechizoDeCuracion() {
		return true;
	}
	
}
