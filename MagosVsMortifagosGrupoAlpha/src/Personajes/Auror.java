package Personajes;

public class Auror extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 50.0;
	private static final int NIVEL_DE_MAGIA = 4;
	
	public Auror(String nombre) {
		super(nombre, NIVEL_DE_MAGIA, PUNTOS_DE_VIDA_MAXIMOS);
	}

}
