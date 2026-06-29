package Main;

import java.util.Random;

import Batalla.Batallon;
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
				batallonDeMagos.atacar(batallonDeMortifagos);//	BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS
				if(batallonDeMortifagos.hayPersonajesVivos()){//SI EL BATALLON DE MORTIFAGOS TIENE PERSONAJES VIVOS --->
					batallonDeMortifagos.atacar(batallonDeMagos);//BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
				}
			} 
			else{
				batallonDeMortifagos.atacar(batallonDeMagos);//BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
				if(batallonDeMagos.hayPersonajesVivos()) { //SI EL BATALLON DE MAGOS TIENE PERSONAJES VIVOS --->
					batallonDeMagos.atacar(batallonDeMortifagos); //BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS	
				}


			
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
