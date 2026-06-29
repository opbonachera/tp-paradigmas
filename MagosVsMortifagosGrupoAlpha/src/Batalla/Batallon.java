package Batalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import Hechizos.Hechizo;
import Personajes.Personaje;

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
	
	@Override
	public void atacar(Combatiente enemigo) {
	    if (!(enemigo instanceof Batallon enemigoB)) return;

	    Random random = new Random();
	    this.procesarEstadosInicioDelTurno();

	    List<Personaje> vivosEnemigos = enemigoB.personajes.stream()
	        .filter(Personaje::estaVivo).toList();

	    for (Personaje p : this.personajes) {
	        if (!p.estaVivo()) continue;
	        if (vivosEnemigos.isEmpty()) break;

	        List<Hechizo> hechizos = p.getHechizos();
	       
	        Hechizo hechizoElegido = hechizos.stream()
	            .filter(h -> !hechizosEnOrden.contains(h))
	            .findFirst()
	            .orElse(hechizos.get(random.nextInt(hechizos.size())));

	        Personaje objetivo = vivosEnemigos.get(random.nextInt(vivosEnemigos.size()));

	        p.lanzarHechizo(hechizoElegido, objetivo);
	        hechizosEnOrden.add(hechizoElegido);
	        movimientosPartida.put(p, hechizoElegido);
	    }

	    hechizosEnOrden.clear();
	    this.procesarEstadosFinDelTurno();
	}

}
