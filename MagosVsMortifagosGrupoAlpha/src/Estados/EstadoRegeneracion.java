package Estados;

import FormatoDeTexto.Formateo;
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
        
        if (nuevaVida > objetivo.getMaxPuntosDeVida()) {
            nuevaVida = objetivo.getMaxPuntosDeVida();
        }
        
        if(nuevaVida - vidaPrevia == 0.0) return;
        
        objetivo.setPuntosDeVida(nuevaVida);
        
        System.out.println(Formateo.GRIS_CLARITO_CURSIVA          +
				           "\t  --->  "                           +
				           "Estado " 						      + 
				           Formateo.RESET                   	  +
				           Formateo.AMARILLO_CURSIVA          	  +
				           this.toString()                        +
				           Formateo.RESET                     	  +
				           Formateo.GRIS_CLARITO_CURSIVA          +
				           ": "                                   + 
				           Formateo.RESET                   	  +
				           Formateo.CURSIVA                   	  +
				           objetivo.getNombre()                   +
				           Formateo.RESET                   	  +
				           Formateo.GRIS_CLARITO_CURSIVA          +
				           " recuperó "                           +
				           Formateo.RESET                         +
				           Formateo.VERDE_CURSIVA             	  +
				           (nuevaVida - vidaPrevia)               +
				           Formateo.RESET                         +
				           Formateo.GRIS_CLARITO_CURSIVA          +
				           " ptos de vida (vida: "                +
				           Formateo.RESET                         +
				           Formateo.VERDE_CURSIVA           	  +
				           nuevaVida                              +
				           Formateo.RESET                         +
				           Formateo.GRIS_CLARITO_CURSIVA          +
				           ")."                                   +
				           Formateo.RESET);
    }
    
    @Override
    public String toString() {
        return "Regeneración";
    }
    
}
