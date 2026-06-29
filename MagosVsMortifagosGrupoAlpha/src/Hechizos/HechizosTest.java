package Hechizos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Personajes.Comandante;
import Personajes.Personaje;
import Personajes.Profesor;
import Personajes.Estudiante;

class HechizosTest {

	@Test
	void Test_AvadaKedavra() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje snape = new Comandante("Severus Snape");
		Hechizo avada = new AvadaKedavra();
		gandalf.lanzarHechizo(avada, snape);
		
		assertFalse(snape.estaVivo());
	}

	@Test
	void Test_ExpectoPatronum() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		harry.setPuntosDeVida(1.00);
		Hechizo expecto = new ExpectoPatronum();
		gandalf.lanzarHechizo(expecto, harry);

		assertEquals(10, harry.getPuntosDeVida());

		harry.setPuntosDeVida(7.0);
		harry.procesarEstadosFinDelTurno();
		assertEquals(8.0, harry.getPuntosDeVida());
	}
	
	@Test
	void Test_Expelliarmus() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje snape = new Comandante("Severus Snape");
		Hechizo expelliarmus = new Expelliarmus();
		gandalf.lanzarHechizo(expelliarmus, snape);

		assertEquals(42.5, snape.getPuntosDeVida());

		snape.procesarEstadosInicioDelTurno();
		assertEquals(42.0, snape.getPuntosDeVida());
	}
	
	@Test
	void Test_Protego() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		Hechizo protego = new Protego();
		Hechizo expelliarmus = new Expelliarmus();
		gandalf.lanzarHechizo(protego, harry);
		gandalf.lanzarHechizo(expelliarmus, harry);

		assertTrue(harry.getEscudo());
		assertEquals(10, harry.getEscudoPuntosDeVida());
		assertEquals(10.0, harry.getPuntosDeVida());
	}
}
