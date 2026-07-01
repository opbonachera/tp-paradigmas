package Batalla;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Random;
import Hechizos.Hechizo;
import Personajes.Personaje;

public class Batallon{
	
	List<Personaje> personajes = new ArrayList<>();
	List<Hechizo> hechizosEnOrden = new LinkedList<>();
	Map<Personaje, Hechizo> movimientosPartida = new HashMap<>();
	
	public boolean agregarPersonaje(Personaje p) {
		return personajes.add(p);
	}
	
	public void sacarPersonaje(Personaje p) {
		personajes.remove(p);
	}
	
	public void eliminarBatallon() {
		personajes.clear();
	}
	
	public boolean hayPersonajesVivos() {
		for(Personaje p : personajes) {	
			if(p.estaVivo()) {
				return true;
			}
		}
		return false;
	}

	private void procesarEstadosInicioDelTurno() {
		for(Personaje personaje : this.personajes) {
			personaje.procesarEstadosInicioDelTurno();
		}
	}

	private void procesarEstadosFinDelTurno() {
		for(Personaje personaje : this.personajes) {
			personaje.procesarEstadosFinDelTurno();
		}
	}
	
	public void atacar(Batallon enemigo) {

		Random random = new Random();
		Personaje objetivo;

		this.procesarEstadosInicioDelTurno();

		List<Personaje> vivosEnemigos = enemigo.personajes.stream()
			.filter(Personaje::estaVivo).toList();

		List<Personaje> vivosAliados = this.personajes.stream()
			.filter(Personaje::estaVivo).toList();

		// Set para bloquear hechizos ya usados en este turno
		Set<Hechizo> hechizosUsadosEnEsteTurno = new HashSet<>();

		for (Personaje p : this.personajes) {
			
			if (!p.estaVivo()) continue;
			if (vivosEnemigos.isEmpty()) break;

			Set<Hechizo> hechizosDelPersonaje = p.getHechizos();
			Optional<Hechizo> posibleHechizo = hechizosDelPersonaje.stream()
				    .filter(h -> !hechizosUsadosEnEsteTurno.contains(h))
				    .findFirst();

			if (posibleHechizo.isEmpty()) {
			    System.out.println(p.getNombre() + " no tiene hechizos disponibles este turno.");
			    continue; 
			}

			Hechizo hechizoElegido = posibleHechizo.get();

			if(hechizoElegido.esHechizoDeCuracion()) {
				objetivo = vivosAliados.get(random.nextInt(vivosAliados.size()));
			} else {
				objetivo = vivosEnemigos.get(random.nextInt(vivosEnemigos.size()));
			}
			
			p.lanzarHechizo(hechizoElegido, objetivo);
			movimientosPartida.put(p, hechizoElegido);
		}

		this.procesarEstadosFinDelTurno();
	}
	
	public void mostrarBatallon() {
		for(Personaje p : personajes) {
			System.out.println(p.toString());
		}
	}
	
	public void mostrarVidaYEscudoBatallon() {
		for(Personaje p : personajes) {
			System.out.println(p.mostrarVidaYEscudo());
		}
	}
	
	public double obtenerSumatoriaDeVidaDelBatallon() {
		double vidaYEscudoAcumulado = 0.0;
		for(Personaje p : personajes) {
			vidaYEscudoAcumulado += p.getEscudoPuntosDeVida();
			vidaYEscudoAcumulado += p.getPuntosDeVida();
		}
		return vidaYEscudoAcumulado;
	}

}
