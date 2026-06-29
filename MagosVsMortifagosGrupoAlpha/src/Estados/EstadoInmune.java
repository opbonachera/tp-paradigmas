package Estados;

import Personajes.Personaje;

public class EstadoInmune extends Estado {
    public EstadoInmune(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public boolean bloqueaDanio() {
        return true;
    }
}