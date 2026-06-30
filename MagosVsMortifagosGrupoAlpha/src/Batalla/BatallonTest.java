package Batalla;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hechizos.*;
import Personajes.*;

class BatallonTest {

	@Test
	void Test_BatallonVivo() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		Batallon magos = new Batallon();
		
		
		magos.agregarPersonaje(gandalf);
		magos.agregarPersonaje(harry);
		harry.setPuntosDeVida(0d);
		
		assertTrue(magos.hayPersonajesVivos());
		
		gandalf.setPuntosDeVida(0d);
		
		assertFalse(magos.hayPersonajesVivos());
	}

	
	@Test
	void Test_Atacar() {
		Personaje gandalf = new Profesor("Gandalf");
		Batallon magos = new Batallon();
		Personaje snape = new Comandante("Severious Snape");
		Batallon mortifagos = new Batallon();
		
		magos.agregarPersonaje(gandalf);
		mortifagos.agregarPersonaje(snape);
		
		gandalf.vaciarHechizos();
		gandalf.agregarHechizo(new AvadaKedavra());
		
		snape.vaciarHechizos();
		snape.agregarHechizo(new AvadaKedavra());
		
		magos.atacar(mortifagos);
		
		assertFalse(mortifagos.hayPersonajesVivos());
		
	}
}
