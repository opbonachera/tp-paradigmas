package Estados;

import Personajes.Personaje;

public class EstadoRegeneracion extends Estado {
    private static final double PUNTOS_A_CURAR = 1.0;

    public EstadoRegeneracion(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public void aplicarAlInicioDelTurno(Personaje objetivo) {}

    @Override
    public void aplicarAlFinalDelTurno(Personaje objetivo) {
        double vidaPrevia = objetivo.getPuntosDeVida();
        double nuevaVida = vidaPrevia + PUNTOS_A_CURAR;
        
        if(objetivo.getPuntosDeVida() >= objetivo.getMaxPuntosDeVida()) return;
        
        if (nuevaVida > objetivo.getMaxPuntosDeVida()) {
            nuevaVida = objetivo.getMaxPuntosDeVida();
        }
        
        objetivo.setPuntosDeVida(nuevaVida);
        System.out.println("Estado " + this.toString() + ": " + objetivo.getNombre()
            + " recuperó " + (nuevaVida - vidaPrevia) + " de vida (vida: " + nuevaVida + ").");
    }
    
    @Override
    public String toString() {
        return "Regeneración";
    }
}
