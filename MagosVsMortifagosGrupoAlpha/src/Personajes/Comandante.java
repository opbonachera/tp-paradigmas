package Personajes;

public class Comandante extends Mortifago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 60.0;
	private static final int NIVEL_DE_MAGIA = 6;
	
	protected Comandante(String nombre) {
		super(nombre, NIVEL_DE_MAGIA, PUNTOS_DE_VIDA_MAXIMOS);
	}

}
