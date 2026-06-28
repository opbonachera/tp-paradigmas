package Personajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import Hechizos.Hechizo;

public class Batallon {
	
	List<Personaje> unidades = new ArrayList<>();
	List<Hechizo> hechizosEnOrden = new LinkedList<>();
	Map<String, Integer> XXXXXXX = new HashMap<>(); //CAMBIAR
//	Set<String> XXXXX = HashSet<String>(); //CAMBIAR
	
	// FALTAN TODAS LAS IMPLEMENTACIONES DE LIST (CREO QUE NO LO IBAMOS A USAR), MAP Y SET
	
	public void agregarPersonaje(Personaje p) // hay que pasarlo a boolean?
	{
		unidades.add(p);
	}
	
	public void sacarPersonaje(Personaje p)
	{
		unidades.remove(p);
	}
	
	public void eliminarBatallon()
	{
		unidades.clear();
	}
	
	public boolean hayPersonajesVivos()
	{
		for(Personaje p : unidades)
		{
			System.out.println("Vida de " + p.getNombre() + ": " + p.getPuntosDeVida());
			if(p.estaVivo())
			{
				return true;
			}
		}
		return false;
	}

}
