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
		
		// Testeo Niveles de magia para Estudiante
		assertEquals(10, harryPotter.getNivelDeMagiaDefensiva());
		assertEquals(10, harryPotter.getNivelDeMagiaOscura());
		assertEquals(10, harryPotter.getNivelDeMagiaPatronus());
		
		// Testeo Niveles de magia para Auror
		assertEquals(10, alastor.getNivelDeMagiaDefensiva());
		assertEquals(10, alastor.getNivelDeMagiaOscura());
		assertEquals(10, alastor.getNivelDeMagiaPatronus());
		
		// Testeo Niveles de magia para 
		assertEquals(10, alastor.getNivelDeMagiaDefensiva());
		assertEquals(10, alastor.getNivelDeMagiaOscura());
		assertEquals(10, alastor.getNivelDeMagiaPatronus());
	}

	@Test
	void Test_crearMortifagos() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		Personaje snape = new Comandante("Severus Snape");
		
		// Testeo iniciar puntos de vida
		assertEquals(25, malfoy.getPuntosDeVida());
		assertEquals(60, snape.getPuntosDeVida());
		
		// Testeo iniciar nivel de magia para Comandante
		assertEquals(10, malfoy.getNivelDeMagiaDefensiva());
		assertEquals(10, malfoy.getNivelDeMagiaOscura());
		assertEquals(10, malfoy.getNivelDeMagiaPatronus());
				
		// Testeo iniciar nivel de magia para Seguidor
		assertEquals(10, malfoy.getNivelDeMagiaDefensiva());
		assertEquals(10, malfoy.getNivelDeMagiaOscura());
		assertEquals(10, malfoy.getNivelDeMagiaPatronus());
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
