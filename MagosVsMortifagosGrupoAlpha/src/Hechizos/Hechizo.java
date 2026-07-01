package Hechizos;

import Personajes.Personaje;

public abstract class Hechizo {
	
	public abstract void ejecutar(Personaje lanzador, Personaje objetivo);
	
    public boolean esHechizoDeCuracion() { 
    	return false; 
    }
	
	@Override
    public int hashCode() {
		return getClass().hashCode();
	}
    
    @Override
    public boolean equals(Object o) { 
    	return (o != null) && (o.getClass() == this.getClass()); 
    }
    
}
