package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Hechizos.*;
import Personajes.Auror;
import Personajes.Comandante;
import Personajes.Estudiante;
import Personajes.Personaje;
import Personajes.Profesor;
import Personajes.Seguidor;
import Estados.*;

class PersonajesTest {

	@Test
	void Test_crearMagos() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harryPotter = new Estudiante("Harry Potter");
		Personaje alastor = new Auror("Alastor Moody");
		
		// Testeo iniciar puntos de vida
		assertEquals(60 ,harryPotter.getPuntosDeVida());
		assertEquals(85 ,gandalf.getPuntosDeVida());
		assertEquals(100 ,alastor.getPuntosDeVida());
		
		// Testeo Niveles de magia para Estudiante
		assertEquals(10, harryPotter.getNivelDeMagiaDefensiva());
		assertEquals(1, harryPotter.getNivelDeMagiaOscura());
		assertEquals(5, harryPotter.getNivelDeMagiaPatronus());
		
		// Testeo Niveles de magia para Auror
		assertEquals(30, alastor.getNivelDeMagiaDefensiva());
		assertEquals(7, alastor.getNivelDeMagiaOscura());
		assertEquals(25, alastor.getNivelDeMagiaPatronus());
		
		// Testeo Niveles de magia para Profesor 
		assertEquals(25, gandalf.getNivelDeMagiaDefensiva());
		assertEquals(5, gandalf.getNivelDeMagiaOscura());
		assertEquals(20, gandalf.getNivelDeMagiaPatronus());
	}

	@Test
	void Test_crearMortifagos() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		Personaje snape = new Comandante("Severus Snape");
		
		// Testeo iniciar puntos de vida
		assertEquals(70, malfoy.getPuntosDeVida());
		assertEquals(90, snape.getPuntosDeVida());
		
		// Testeo iniciar nivel de magia para Comandante
		assertEquals(1, malfoy.getNivelDeMagiaDefensiva());
		assertEquals(15, malfoy.getNivelDeMagiaOscura());
		assertEquals(10, malfoy.getNivelDeMagiaPatronus());
				
		// Testeo iniciar nivel de magia para Seguidor
		assertEquals(1, malfoy.getNivelDeMagiaDefensiva());
		assertEquals(15, malfoy.getNivelDeMagiaOscura());
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
	
	@Test
	void Test_EstadoSangrando() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		
		malfoy.agregarEstado(new EstadoSangrando(2));
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(69.5, malfoy.getPuntosDeVida());
		
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(69, malfoy.getPuntosDeVida());
		
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(69, malfoy.getPuntosDeVida());
	}
	
	@Test
	void Test_EstadoRegeneracion() {
		Personaje malfoy = new Seguidor("Lucius Malfoy");
		
		malfoy.setPuntosDeVida(1);
		
		malfoy.agregarEstado(new EstadoRegeneracion(2));
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(2, malfoy.getPuntosDeVida());
		
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(3, malfoy.getPuntosDeVida());
		
		malfoy.procesarEstadosInicioDelTurno();
		malfoy.procesarEstadosFinDelTurno();
		
		assertEquals(3, malfoy.getPuntosDeVida());
	}
	
	@Test
	void Test_EstadoInmune() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje snape = new Comandante("Severus Snape");
		Hechizo avada = new AvadaKedavra();
		snape.agregarEstado(new EstadoInmune(1));
		gandalf.lanzarHechizo(avada, snape);

		assertTrue(snape.estaVivo());

		snape.procesarEstadosFinDelTurno();
		
		assertTrue(snape.estaVivo());

		
		gandalf.lanzarHechizo(avada, snape);
		assertFalse(snape.estaVivo());
	}
	
	
}
