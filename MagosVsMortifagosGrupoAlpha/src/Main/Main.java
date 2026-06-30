package Main;

import FormatoDeTexto.Formateo;
import java.util.Random;

import Batalla.Batallon;
import Personajes.*;

public class Main {

	public static void main(String[] args) {
		int CANT_PERSONAJES = 2;
		FabricaDePersonajes fabrica = new FabricaDePersonajes();
		Batallon batallonDeMagos = new Batallon();
		Batallon batallonDeMortifagos = new Batallon();
		Random rand = new Random();
		
		for(int i = 0; i < CANT_PERSONAJES; i++)
		{
			batallonDeMagos.agregarPersonaje(fabrica.crearMago());
			batallonDeMortifagos.agregarPersonaje(fabrica.crearMortifago());
		}
		
		System.out.println(Formateo.VIOLETA_NEGRITA + "Batallon de Magos creado correctamente!!!");
		System.out.println("Sus integrantes son:" + Formateo.RESET);
		batallonDeMagos.mostrarBatallon();
		
		System.out.println(Formateo.VIOLETA_NEGRITA + "\nBatallon de Mortifagos creado correctamente!!!");
		System.out.println("Sus integrantes son:" + Formateo.RESET);
		batallonDeMortifagos.mostrarBatallon();
		
		System.out.println(Formateo.AMARILLO_NEGRITA + "\nINICIA LA BATALLA!!!\n" + Formateo.RESET);

		while(batallonDeMagos.hayPersonajesVivos() && batallonDeMortifagos.hayPersonajesVivos())
		{
			
			if(rand.nextBoolean())
			{
				System.out.println(Formateo.VERDE_FLUOR + "\nEs hora de que los Magos ataquen..." + Formateo.RESET);
				batallonDeMagos.atacar(batallonDeMortifagos);//	BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS
				if(batallonDeMortifagos.hayPersonajesVivos()){//SI EL BATALLON DE MORTIFAGOS TIENE PERSONAJES VIVOS --->
					System.out.println(Formateo.VERDE_FLUOR + "\nEs hora de que los Mortifagos ataquen..." + Formateo.RESET);
					batallonDeMortifagos.atacar(batallonDeMagos);//BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
				}
			} 
			else{
				System.out.println(Formateo.VERDE_FLUOR + "\nEs hora de que los Mortifagos ataquen..." + Formateo.RESET);
				batallonDeMortifagos.atacar(batallonDeMagos);//BATALLON DE MORTIFAGOS ATACA A BATALLON DE MAGOS
				if(batallonDeMagos.hayPersonajesVivos()) { //SI EL BATALLON DE MAGOS TIENE PERSONAJES VIVOS --->
					System.out.println(Formateo.VERDE_FLUOR + "\nEs hora de que los Magos ataquen..." + Formateo.RESET);
					batallonDeMagos.atacar(batallonDeMortifagos); //BATALLON DE MAGOS ATACA A BATALLON DE MORTIFAGOS	
				}
			}
			
			System.out.println(Formateo.AZUL_OSCURO_NEGRITA + "\nRonda Terminada!!! Es hora de ver las estadísticas..." + Formateo.RESET);
			System.out.println(Formateo.VIOLETA_NEGRITA + "Batallon de Magos: " + Formateo.RESET);
			batallonDeMagos.mostrarVidaYEscudoBatallon();
			System.out.println(Formateo.VIOLETA_NEGRITA + "Batallon de Mortifagos: " + Formateo.RESET);
			batallonDeMortifagos.mostrarVidaYEscudoBatallon();
			
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
			System.out.println("|     ¡Los mortifagos han ganado la batalla!     |");
			System.out.println("|                                                |");
			System.out.println("--------------------------------------------------");
		}
		
		
		
	}

}
