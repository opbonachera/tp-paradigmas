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

    @Override
    public void alCaducar(Personaje objetivo) {
        System.out.println(objetivo.getNombre() + " perdió la inmunidad.");
    }
    
    @Override
    public String toString() {
        return "Inmunidad";
    }
}