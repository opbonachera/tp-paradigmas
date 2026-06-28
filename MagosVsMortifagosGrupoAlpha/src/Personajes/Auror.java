package Personajes;

public class Auror extends Mago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 50.0;
	private static final int NIVEL_DE_MAGIA_OSCURA = 10;
	private static final int NIVEL_DE_MAGIA_PATRONUS = 10;
	private static final int NIVEL_DE_MAGIA_DEFENSIVA = 10;
	
	public Auror(String nombre) {
		super(nombre, PUNTOS_DE_VIDA_MAXIMOS, NIVEL_DE_MAGIA_OSCURA,
				NIVEL_DE_MAGIA_PATRONUS, NIVEL_DE_MAGIA_DEFENSIVA);
	}

}
