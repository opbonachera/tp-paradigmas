package Estados;

import Personajes.Personaje;

public class EstadoSangrando extends Estado {
    private static final double PUNTOS_DE_DANIO = 0.5;

    public EstadoSangrando(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public void aplicarAlInicioDelTurno(Personaje objetivo) {
        double vidaPrevia = objetivo.getPuntosDeVida();
        double nuevaVida = vidaPrevia - PUNTOS_DE_DANIO;

        if (nuevaVida < 0.0) {
            nuevaVida = 0.0;
            return;
        }

        objetivo.setPuntosDeVida(nuevaVida);
        System.out.println("Estado " + this.toString() + ": " + objetivo.getNombre()
            + " sufrió " + (vidaPrevia - nuevaVida) + " de daño (vida: " + nuevaVida + ").");
    }

    @Override
    public void aplicarAlFinalDelTurno(Personaje objetivo) {}
    
    @Override
    public String toString() {
        return "Sangrando";
    }
}
