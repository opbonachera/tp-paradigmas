package Personajes;

public class Estudiante extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 60.0;
	private static final int NIVEL_DE_MAGIA_OSCURA = 1;
	private static final int NIVEL_DE_MAGIA_PATRONUS = 5;
	private static final int NIVEL_DE_MAGIA_DEFENSIVA = 10;
	
	public Estudiante(String nombre) {
		super(nombre, PUNTOS_DE_VIDA_MAXIMOS, NIVEL_DE_MAGIA_OSCURA,
			  NIVEL_DE_MAGIA_PATRONUS, NIVEL_DE_MAGIA_DEFENSIVA);
	}
	
}
