package Personajes;

public class Comandante extends Mortifago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 90.0;
	private static final int NIVEL_DE_MAGIA_OSCURA = 30;
	private static final int NIVEL_DE_MAGIA_PATRONUS = 15;
	private static final int NIVEL_DE_MAGIA_DEFENSIVA = 3;
	
	public Comandante(String nombre) {
		super(nombre, PUNTOS_DE_VIDA_MAXIMOS, NIVEL_DE_MAGIA_OSCURA,
			  NIVEL_DE_MAGIA_PATRONUS, NIVEL_DE_MAGIA_DEFENSIVA);
	}

}
