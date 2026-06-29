package Estados;

import Personajes.Personaje;

public abstract class Estado {
    protected int turnosRestantes;

    protected Estado(int turnosRestantes) {
        this.turnosRestantes = turnosRestantes;
    }

    public void aplicarAlFinalDelTurno(Personaje objetivo) {
        // Hook opcional.
    }

    public void aplicarAlInicioDelTurno(Personaje objetivo) {
        // Hook opcional.
    }

    public boolean bloqueaDanio() {
        return false;
    }

    public void consumirTurno() {
        this.turnosRestantes--;
    }

    public boolean estaObsoleto() {
        return this.turnosRestantes < 1;
    }
}