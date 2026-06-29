package Estados;

import Personajes.Personaje;

public class EstadoRegeneracion extends Estado {
    private static final double PUNTOS_A_CURAR = 1.0;

    public EstadoRegeneracion(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public void aplicarAlInicioDelTurno(Personaje objetivo) {
        // Este estado aplica su efecto al final del turno.
    }

    @Override
    public void aplicarAlFinalDelTurno(Personaje objetivo) {
        double nuevaVida = objetivo.getPuntosDeVida() + PUNTOS_A_CURAR;
        if (nuevaVida > objetivo.getMaxPuntosDeVida()) {
            nuevaVida = objetivo.getMaxPuntosDeVida();
        }
        objetivo.setPuntosDeVida(nuevaVida);
    }
}
