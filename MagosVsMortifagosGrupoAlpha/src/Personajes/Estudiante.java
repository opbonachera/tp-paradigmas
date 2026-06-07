package Personajes;

public class Estudiante extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 10.0;
	private static final int NIVEL_DE_MAGIA = 2;
	
	protected Estudiante(String nombre) {
		super(nombre, NIVEL_DE_MAGIA, PUNTOS_DE_VIDA_MAXIMOS);
	}

}
