package Personajes;

public abstract class Mago extends Personaje {

	protected Mago(String nombre, int nivelDeMagia, double puntosDeVida) {
		super(nombre, nivelDeMagia, puntosDeVida);
	}
	
	public abstract double getMaxPuntosDeVida();

}
