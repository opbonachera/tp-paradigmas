package Personajes;

public class Profesor extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 30.0;
	private static final int NIVEL_DE_MAGIA = 5;
	
	protected Profesor(String nombre) {
		super(nombre, NIVEL_DE_MAGIA, PUNTOS_DE_VIDA_MAXIMOS);
	}

}
