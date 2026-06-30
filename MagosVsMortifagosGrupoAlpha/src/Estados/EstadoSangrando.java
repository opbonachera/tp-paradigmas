package Estados;

import FormatoDeTexto.Formateo;
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
		                   " surió "                              +
		                   Formateo.RESET                         +
		                   Formateo.ROJO_CURSIVA             	  +
		                   (vidaPrevia - nuevaVida)               +
		                   Formateo.RESET                         +
		                   Formateo.GRIS_CLARITO_CURSIVA          +
		                   " ptos de daño (vida: "                +
		                   Formateo.RESET                         +
		                   Formateo.VERDE_CURSIVA           	  +
		                   nuevaVida                              +
		                   Formateo.RESET                         +
		                   Formateo.GRIS_CLARITO_CURSIVA          +
		                   ")."                                   +
		                   Formateo.RESET);
    }

    @Override
    public void aplicarAlFinalDelTurno(Personaje objetivo) {}
    
    @Override
    public String toString() {
        return "Sangrando";
    }
}
