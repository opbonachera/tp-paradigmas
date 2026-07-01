package Personajes;

public class Auror extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 100.0;
	private static final int NIVEL_DE_MAGIA_OSCURA = 7;
	private static final int NIVEL_DE_MAGIA_PATRONUS = 25;
	private static final int NIVEL_DE_MAGIA_DEFENSIVA = 30;
	
	public Auror(String nombre) {
		super(nombre, PUNTOS_DE_VIDA_MAXIMOS, NIVEL_DE_MAGIA_OSCURA,
			  NIVEL_DE_MAGIA_PATRONUS, NIVEL_DE_MAGIA_DEFENSIVA);
	}

}
