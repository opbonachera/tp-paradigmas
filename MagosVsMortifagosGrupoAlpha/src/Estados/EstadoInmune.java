package Estados;

public class EstadoInmune extends Estado {
    public EstadoInmune(int turnosRestantes) {
        super(turnosRestantes);
    }

    @Override
    public boolean bloqueaDanio() {
        return true;
    }
    
    @Override
    public String toString() {
        return "Inmunidad";
    }
}