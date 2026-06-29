package Estados;

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
        System.out.println("El estado " + this + " de " + objetivo.getNombre() + " caducó.");
    }
    
    @Override
    public int hashCode() {return getClass().hashCode();}
    
    @Override
    public boolean equals(Object o) { return (o != null) && (o.getClass() == this.getClass()); }
}