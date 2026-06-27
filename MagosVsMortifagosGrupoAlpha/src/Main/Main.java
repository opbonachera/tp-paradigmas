package Main;

import Personajes.*;

public class Main {

	public static void main(String[] args) {
		Batallon batallon1 = new Batallon();
		Batallon batallon2 = new Batallon();
		
		batallon1.agegarPersonaje(FabricaDePersonajes);
		batallon1.agegarPersonaje();
		batallon1.agegarPersonaje(new Auror("Auror"));
		batallon1.agegarPersonaje(new Estudiante("Ron"));
	}

}
