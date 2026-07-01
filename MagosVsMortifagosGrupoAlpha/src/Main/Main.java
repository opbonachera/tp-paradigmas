package Main;

import FormatoDeTexto.Formateo;
import java.util.Random;

import Batalla.Batallon;
import Personajes.*;

public class Main {

	public static void main(String[] args) {
		int CANT_PERSONAJES = 6;
		int CANT_RONDAS_PARA_PREDECIR = 10;
		int cantRondasJugadas = 0;
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

		while(batallonDeMagos.hayPersonajesVivos() && batallonDeMortifagos.hayPersonajesVivos()
			  && cantRondasJugadas <= CANT_RONDAS_PARA_PREDECIR)
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
			
			cantRondasJugadas++;
			
			System.out.println(Formateo.AZUL_OSCURO_NEGRITA + "\nRonda Terminada!!! Es hora de ver las estadísticas..." + Formateo.RESET);
			System.out.println(Formateo.VIOLETA_NEGRITA + "Batallon de Magos: " + Formateo.RESET);
			batallonDeMagos.mostrarVidaYEscudoBatallon();
			System.out.println(Formateo.VIOLETA_NEGRITA + "Batallon de Mortifagos: " + Formateo.RESET);
			batallonDeMortifagos.mostrarVidaYEscudoBatallon();
			
		}
		
		if(cantRondasJugadas > CANT_RONDAS_PARA_PREDECIR &&
		   batallonDeMagos.hayPersonajesVivos() &&
		   batallonDeMortifagos.hayPersonajesVivos())
		{
			double puntosDeVidaBatallonMagos = batallonDeMagos.obtenerSumatoriaDeVidaDelBatallon();
			double puntosDeVidaBatallonMortifagos = batallonDeMortifagos.obtenerSumatoriaDeVidaDelBatallon();
			
			System.out.println(Formateo.DORADO_NEGRITA_CURSIVA + "\n\nLa batalla se hace interminable..." + Formateo.RESET);
			System.out.println(Formateo.DORADO_NEGRITA_CURSIVA + "Llevamos " + CANT_RONDAS_PARA_PREDECIR + " rondas de ataques y ambos equipos siguen en pie..." + Formateo.RESET);
			
			System.out.println(Formateo.GRIS_CLARITO_CURSIVA                +
	                           "\t  --->  "                                 +
	                           "Nos pusimos a hacer cuentas"		        + 
	                           Formateo.RESET);
			System.out.println(Formateo.GRIS_CLARITO_CURSIVA                +
						       "\t      --->  "                             +
							   "sumando los puntos de vida y sus escudos");
			System.out.println(Formateo.GRIS_CLARITO_CURSIVA                +
                               "\t          --->  "                         +
                               "sabemos que los "                           +
                               Formateo.RESET                          	    +
                               Formateo.CURSIVA                   	        +
                               "Magos"                                      +
                               Formateo.RESET                           	+
                               Formateo.GRIS_CLARITO_CURSIVA                +
                               " tienen acumulados "                        +
                               Formateo.RESET                               +                        	    
                               Formateo.VERDE_CURSIVA                   	+
                               puntosDeVidaBatallonMagos                    +
                               Formateo.RESET                   	        +
                               Formateo.GRIS_CLARITO_CURSIVA                +
                               " puntos de vida!!!"                         +
                               Formateo.RESET);
			System.out.println(Formateo.GRIS_CLARITO_CURSIVA                +
                               "\t          --->  "                         +
                               "sabemos que los "                           +
                               Formateo.RESET                          	    +
                               Formateo.CURSIVA                   	        +
                               "Mortifagos"                                 +
                               Formateo.RESET                           	+
                               Formateo.GRIS_CLARITO_CURSIVA                +
                               " tienen acumulados "                        +
                               Formateo.RESET                               +                        	    
                               Formateo.VERDE_CURSIVA                   	+
                               puntosDeVidaBatallonMortifagos               +
                               Formateo.RESET                   	        +
                               Formateo.GRIS_CLARITO_CURSIVA                +
                               " puntos de vida!!!"                         +
                               Formateo.RESET);
			
			if(puntosDeVidaBatallonMagos > puntosDeVidaBatallonMortifagos)
			{
				System.out.println(Formateo.DORADO_NEGRITA_CURSIVA + "Por lo que podríamos concluir que estadísticamente, los Magos ganarán la batalla!!!" + Formateo.RESET);
			} else if(puntosDeVidaBatallonMagos < puntosDeVidaBatallonMortifagos)
			{
				System.out.println(Formateo.DORADO_NEGRITA_CURSIVA + "Por lo que podríamos concluir que estadísticamente, los Mortifagos ganarán la batalla!!!" + Formateo.RESET);
			} else
			{
				System.out.println(Formateo.DORADO_NEGRITA_CURSIVA + "Por lo que no podríamos concluir quienes ganarán la batalla!!!" + Formateo.RESET);
			}
		} else
		{
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
	
}
