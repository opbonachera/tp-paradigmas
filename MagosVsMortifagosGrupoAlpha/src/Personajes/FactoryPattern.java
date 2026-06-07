package Personajes;

public class FactoryPattern {
	
	public Mago crearMago(String tipo, String nombre) {
        switch (tipo.toLowerCase()) {
            case "estudiante": return new Estudiante(nombre);
            case "profesor":   return new Profesor(nombre);
            case "auror":      return new Auror(nombre);
            default:           throw new IllegalArgumentException("Tipo de mago desconocido: " + tipo);
        }
    }
	
	public Mortifago crearMortifago(String tipo, String nombre) {
        switch (tipo.toLowerCase()) {
            case "seguidor":     return new Seguidor(nombre);
            case "comandante":   return new Comandante(nombre);
            default:             throw new IllegalArgumentException("Tipo de mortifago desconocido: " + tipo);
        }
    }
	
}
