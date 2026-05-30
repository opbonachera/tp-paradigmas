package Personajes;

import Hechizos.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected double puntosDeVida;
	protected List<Hechizo> hechizos;
	
	public Personaje(String nombre, int nivelDeMagia, double puntosDeVida)
	{
		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.hechizos = new ArrayList<>();
	}
}
