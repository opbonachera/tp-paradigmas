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
		gandalf.vaciarHechizos();
		gandalf.agregarHechizo(avada);
		gandalf.lanzarHechizo(avada, snape);
		
		assertFalse(snape.estaVivo());
	}

	@Test
	void Test_ExpectoPatronum() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		harry.setPuntosDeVida(1.00);
		Hechizo expecto = new ExpectoPatronum();
		gandalf.vaciarHechizos();
		gandalf.agregarHechizo(expecto);
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
		gandalf.vaciarHechizos();
		gandalf.agregarHechizo(expelliarmus);
		gandalf.lanzarHechizo(expelliarmus, snape);

		assertEquals(25, snape.getPuntosDeVida());

		snape.procesarEstadosInicioDelTurno();
		assertEquals(24.5, snape.getPuntosDeVida());
	}
	
	@Test
	void Test_Protego() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje snape = new Comandante("Severius Snape");
		Hechizo protego = new Protego();
		Hechizo expelliarmus = new Expelliarmus();
		gandalf.vaciarHechizos();
		gandalf.agregarHechizo(protego);
		gandalf.agregarHechizo(expelliarmus);
		gandalf.lanzarHechizo(protego, snape);
		
		assertTrue(snape.getEscudo());
		assertEquals(10, snape.getEscudoPuntosDeVida());
		
		gandalf.lanzarHechizo(expelliarmus, snape);

		assertFalse(snape.getEscudo());
		assertEquals(0, snape.getEscudoPuntosDeVida());
		assertEquals(35, snape.getPuntosDeVida());
	}
}
