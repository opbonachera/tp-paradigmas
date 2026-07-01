package Estados;

import FormatoDeTexto.Formateo;
import Personajes.Personaje;

public class EstadoInmune extends Estado {
    
	public EstadoInmune(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public boolean bloqueaDanio() {
        return true;
    }

    @Override
    public void alCaducar(Personaje objetivo) {
    	System.out.println(Formateo.GRIS_CLARITO_CURSIVA          +
				           "\t  --->  "                           +
				           "El estado " 						  + 
				           Formateo.RESET                   	  +
				           Formateo.CURSIVA                   	  +
				           objetivo.getNombre()                   +
				           Formateo.RESET                   	  +
				           Formateo.GRIS_CLARITO_CURSIVA          +
				           " perdió la inmunidad."                +
				           Formateo.RESET);
    }
    
    @Override
    public String toString() {
        return "Inmunidad";
    }
    
}