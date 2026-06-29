package Estados;

import Personajes.Personaje;

public class EstadoSangrando extends Estado {
    private static final double PUNTOS_DE_DANIO = 0.5;

    public EstadoSangrando(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public void aplicarAlInicioDelTurno(Personaje objetivo) {
        double nuevaVida = objetivo.getPuntosDeVida() - PUNTOS_DE_DANIO;
        if (nuevaVida < 0.0) {
            nuevaVida = 0.0;
        }
        objetivo.setPuntosDeVida(nuevaVida);
    }

    @Override
    public void aplicarAlFinalDelTurno(Personaje objetivo) {}
    
    @Override
    public String toString() {
        return "Sangrando";
    }
}
