package Main;

import java.util.Random;

import Personajes.*;

public class Main {

	public static void main(String[] args) {
		FabricaDePersonajes fabrica = new FabricaDePersonajes();
		Batallon batallonDeMagos = new Batallon();
		Batallon batallonDeMortifagos = new Batallon();
		Random rand = new Random();
		
		for(int i = 0; i < 5; i++)
		{
			batallonDeMagos.agregarPersonaje(fabrica.crearMago());
			batallonDeMortifagos.agregarPersonaje(fabrica.crearMortifago());
		}

		while(batallonDeMagos.hayPersonajesVivos() && batallonDeMortifagos.hayPersonajesVivos())
		{
			
			if(rand.nextBoolean())
			{
//				BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS
//				SI EL BATALLON DE MORTIFAGOS TIENE PERSONAJES VIVOS --->
//					BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
			} else
			{
//				BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
//				SI EL BATALLON DE MAGOS TIENE PERSONAJES VIVOS --->
//					BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS				
			}
			
		}
		
		if(batallonDeMagos.hayPersonajesVivos())
		{
			System.out.println("-------------------------------------------------");
			System.out.println("|                                               |");
			System.out.println("|       ¡Los magos han ganado la batalla!       |");
			System.out.println("|                                               |");
			System.out.println("-------------------------------------------------");
		} else
		{
			System.out.println("--------------------------------------------------");
			System.out.println("|                                                |");
			System.out.println("|     ¡Los mortifagps han ganado la batalla!     |");
			System.out.println("|                                                |");
			System.out.println("--------------------------------------------------");
		}
		
		
		
	}

}
