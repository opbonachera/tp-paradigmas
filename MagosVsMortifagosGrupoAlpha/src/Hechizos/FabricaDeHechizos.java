package Hechizos;

import java.util.Random;

public class FabricaDeHechizos {
	
	Random rand = new Random();

	public Hechizo crearHechizo() {
		int tipoAleatorio = rand.nextInt(4); // no se si hay que hacerlo constante
		
        switch (tipoAleatorio) {
            case 1:    return new AvadaKedavra(); // avadakedavra
            case 2: return new ExpectoPatronum(); // expectopatronum
            case 3:    return new Expelliarmus(); // expelliarmus
            case 4:         return new Protego(); // protego
	        default: throw new IllegalArgumentException("No se pudo crear el Hechizo!!!"); // hay que revisar porque no es IllegalArgumentException
        }
    }
	
}
