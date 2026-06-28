package Personajes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Hechizos.*;
import java.util.ArrayList;
import java.util.List;

class PersonajesTest {

	@Test
	void Test_crearMagos() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harryPotter = new Estudiante("Harry Potter");
		Personaje alastor = new Auror("Alastor Moody");
		
		// Testeo iniciar puntos de vida
		assertEquals(10 ,harryPotter.getPuntosDeVida());
		assertEquals(30 ,gandalf.getPuntosDeVida());
		assertEquals(50 ,alastor.getPuntosDeVida());
		
		// Testeo iniciar nivel de magia
		assertEquals(2 ,harryPotter.getNivelDeMagia());
		assertEquals(5 ,gandalf.getNivelDeMagia());
		assertEquals(4 ,alastor.getNivelDeMagia());
	}

	@Test
	void Test_crearMortifagos() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		Personaje snape = new Comandante("Severus Snape");
		
		// Testeo iniciar puntos de vida
		assertEquals(25 ,malfoy.getPuntosDeVida());
		assertEquals(60 ,snape.getPuntosDeVida());
		
		// Testeo iniciar nivel de magia
		assertEquals(3 ,malfoy.getNivelDeMagia());
		assertEquals(6 ,snape.getNivelDeMagia());
	}
	
	@Test
	void Test_EstaVivo() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		Personaje snape = new Comandante("Severus Snape");
		
		snape.setPuntosDeVida(0d);
		
		assertFalse(snape.estaVivo());
		assertTrue(malfoy.estaVivo());
	}
	
}
