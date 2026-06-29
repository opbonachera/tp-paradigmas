package Personajes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Batalla.Batallon;

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

}
