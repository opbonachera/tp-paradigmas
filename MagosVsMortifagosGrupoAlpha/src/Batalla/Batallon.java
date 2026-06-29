package Batalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import Hechizos.Hechizo;
import Personajes.Personaje;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Batallon implements Combatiente{
	
	List<Personaje> personajes = new ArrayList<>();
	List<Hechizo> hechizosEnOrden = new LinkedList<>();
	Map<Personaje, Hechizo> movimientosPartida = new HashMap<>(); //CAMBIAR
//	Set<String> XXXXX = HashSet<String>(); //CAMBIAR
	
	// FALTAN TODAS LAS IMPLEMENTACIONES DE LIST (CREO QUE NO LO IBAMOS A USAR), MAP Y SET
	
	public boolean agregarPersonaje(Personaje p) // hay que pasarlo a boolean?
	{
		return personajes.add(p);
	}
	
	public void sacarPersonaje(Personaje p)
	{
		personajes.remove(p);
	}
	
	public void eliminarBatallon()
	{
		personajes.clear();
	}
	
	public boolean hayPersonajesVivos()
	{
		for(Personaje p : personajes)
		{
			System.out.println("Vida de " + p.getNombre() + ": " + p.getPuntosDeVida());
			if(p.estaVivo())
			{
				return true;
			}
		}
		return false;
	}

	private void procesarEstadosInicioDelTurno()
	{
		for(Personaje personaje : this.personajes)
		{
			personaje.procesarEstadosInicioDelTurno();
		}
	}

	private void procesarEstadosFinDelTurno()
	{
		for(Personaje personaje : this.personajes)
		{
			personaje.procesarEstadosFinDelTurno();
		}
	}
	
	public void atacar(Batallon enemigo) {
	    Random random = new Random();
	    this.procesarEstadosInicioDelTurno();

	    for (Personaje p : this.personajes) {

	        List<Hechizo> hechizos = p.getHechizos();
	        //Elegir un hechizo al azar
	        Hechizo hechizoElegido = hechizos.get(random.nextInt(hechizos.size()));
	        //Si ya fue lanzado en la ronda, elijo otro
	        while (hechizosEnOrden.contains(hechizoElegido)) {
	            hechizoElegido = hechizos.get(random.nextInt(hechizos.size()));
	        }

	        Personaje personajeAleatorio = null;
	        //Elegir un personaje rival al azar
	        if (!enemigo.personajes.isEmpty()) {
	            personajeAleatorio = enemigo.personajes.get(
	                ThreadLocalRandom.current().nextInt(enemigo.personajes.size())
	            );
	        }

	        //Lanzarle el hechizo al rival
	        p.lanzarHechizo(hechizoElegido, personajeAleatorio);
	        
	        //Guardar el hechizo lanzado
	        hechizosEnOrden.add(hechizoElegido);
	        
	        //Guardar el movimiento del personaje
	        movimientosPartida.put(p, hechizoElegido);
	    }
	    
	    //Una vez que todos tiraron sus hechizos, limpiar la lista
	    hechizosEnOrden.clear();
	    this.procesarEstadosFinDelTurno();
	    
	    
	}

}
