package Estados;

import FormatoDeTexto.Formateo;
import Personajes.Personaje;

public abstract class Estado {
    protected int turnosRestantes;

    protected Estado(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    public void aplicarAlFinalDelTurno(Personaje objetivo) {}
    public void aplicarAlInicioDelTurno(Personaje objetivo) {}
    
    public boolean bloqueaDanio() {
        return false;
    }

    public void consumirTurno() {
        this.turnosRestantes--;
    }

    public boolean estaObsoleto() {
        return this.turnosRestantes < 1;
    }

    public void alCaducar(Personaje objetivo) {
		System.out.println(Formateo.GRIS_CLARITO_CURSIVA          +
						   "\t  --->  "                           +
						   "El estado " 						  + 
						   Formateo.RESET                   	  +
						   Formateo.AMARILLO_CURSIVA          	  +
						   this                                   +
						   Formateo.RESET                     	  +
						   Formateo.GRIS_CLARITO_CURSIVA          +
						   " de "                                 + 
						   Formateo.RESET                   	  +
						   Formateo.CURSIVA                   	  +
						   objetivo.getNombre()                   +
						   Formateo.RESET                   	  +
						   Formateo.GRIS_CLARITO_CURSIVA          +
						   " caducó."                             +
						   Formateo.RESET);
    }
    
    @Override
    public int hashCode() {return getClass().hashCode();}
    
    @Override
    public boolean equals(Object o) { return (o != null) && (o.getClass() == this.getClass()); }
}