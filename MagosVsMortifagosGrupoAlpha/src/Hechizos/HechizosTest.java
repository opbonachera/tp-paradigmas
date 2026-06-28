package Hechizos;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
		List<Hechizo> hechizos = gandalf.getHechizos();
		Hechizo avadaEncontrado = null;
		for(Hechizo h : hechizos) {
			if(h instanceof AvadaKedavra) {
				avadaEncontrado = h;
				break;
			}
		}
		
		if(avadaEncontrado != null){
			gandalf.lanzarHechizo(avadaEncontrado, snape);
		}
		
		assertFalse(snape.estaVivo());
	}

	@Test
	void Test_ExpectoPatronum() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		List<Hechizo> hechizos = gandalf.getHechizos();
		Hechizo expectoEncontrado = null;
		for(Hechizo h : hechizos) {
			if(h instanceof ExpectoPatronum) {
				expectoEncontrado = h;
				break;
			}
		}
		
		if(expectoEncontrado != null){
			harry.setPuntosDeVida(1.00);
			gandalf.lanzarHechizo(expectoEncontrado, harry);
		}
		
		assertEquals(10, harry.getPuntosDeVida());
	}
	
	@Test
	void Test_Expelliarmus() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje snape = new Comandante("Severus Snape");
		List<Hechizo> hechizos = gandalf.getHechizos();
		Hechizo expelliEncontrado = null;
		for(Hechizo h : hechizos) {
			if(h instanceof Expelliarmus) {
				expelliEncontrado = h;
				break;
			}
		}
		
		if(expelliEncontrado != null){
			gandalf.lanzarHechizo(expelliEncontrado, snape);
		}
		
		assertEquals(42.5, snape.getPuntosDeVida());
	}
	
	@Test
	void Test_Protego() {
		Personaje gandalf = new Profesor("Gandalf");
		Personaje harry = new Estudiante("Harry Potter");
		List<Hechizo> hechizos = gandalf.getHechizos();
		Hechizo protegoEncontrado = null;
		for(Hechizo h : hechizos) {
			if(h instanceof Protego) {
				protegoEncontrado = h;
				break;
			}
		}
		
		if(protegoEncontrado != null){
			gandalf.lanzarHechizo(protegoEncontrado, harry);
		}
		
		assertTrue(harry.getEscudo());
		assertEquals(10, harry.getEscudoPuntosDeVida());
	}
}
