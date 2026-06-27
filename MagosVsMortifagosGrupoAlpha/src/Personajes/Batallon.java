package Personajes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Hechizos.Hechizo;

public class Batallon {
	
	List<Personaje> unidades = new ArrayList<>();
	List<Hechizo> hechizosEnOrden = new LinkedList<>();
	Map<String, Integer> XXXXXXX = new HashMap<>(); //CAMBIAR
	Set<String> XXXXX = HashSet<String>(); //CAMBIAR
	
	public void agegarPersonaje(Personaje p) // hay que pasarlo a boolean?
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

}
