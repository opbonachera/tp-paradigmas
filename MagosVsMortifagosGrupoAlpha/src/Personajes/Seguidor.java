package Personajes;

public class Seguidor extends Mortifago {
	
	private static final double PUNTOS_DE_VIDA_MAXIMOS = 25.0;
	private static final int NIVEL_DE_MAGIA = 3;
	
	protected Seguidor(String nombre) {
		super(nombre, NIVEL_DE_MAGIA, PUNTOS_DE_VIDA_MAXIMOS);
	}

	@Override
	public double getMaxPuntosDeVida() {
		return PUNTOS_DE_VIDA_MAXIMOS;
	}

}
