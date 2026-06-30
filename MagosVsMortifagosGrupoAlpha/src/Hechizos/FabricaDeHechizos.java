package Hechizos;

import java.util.Random;

public class FabricaDeHechizos {
	
	Random rand = new Random();
	
	public Hechizo crearHechizo() {
		int tipoAleatorio = rand.nextInt(4);
		
        switch (tipoAleatorio) {
            case 0:    return new AvadaKedavra(); // avadakedavra
            case 1: return new ExpectoPatronum(); // expectopatronum
            case 2:    return new Expelliarmus(); // expelliarmus
            case 3:         return new Protego(); // protego
	        default: throw new IllegalStateException("No se pudo crear el Hechizo!!!");
        }
    }
	
}
