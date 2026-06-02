package Personajes;

import Hechizos.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected double puntosDeVida;
	protected List<Hechizo> hechizos;
	protected double escudoPuntosDeVida;
	protected boolean escudoActivo;
	
	public Personaje(String nombre, int nivelDeMagia, double puntosDeVida)
	{
		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.hechizos = new ArrayList<>();
		this.escudoActivo = false;
		this.escudoPuntosDeVida = 0.0;
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getNivelDeMagia()
	{
		return this.nivelDeMagia;
	}
	
	public double getPuntosDeVida()
	{
		return this.puntosDeVida;
	}
	
	public List<Hechizo> getHechizos()
	{
		return this.hechizos;
	}
	
	public boolean getEscudo()
	{
		return this.escudoActivo;
	}
	
	public double getEscudoPuntosDeVida()
	{
		return this.escudoPuntosDeVida;
	}
	
	public void setPuntosDeVida(double NewPuntosDeVida)
	{
		this.puntosDeVida = NewPuntosDeVida;
	}
	
	public abstract double getMaxPuntosDeVida();
	
	public void setEscudo(boolean activo)
	{
		this.escudoActivo = activo;
	}
	
	public void setEscudoPuntosDeVida(double puntosDeVidaEscudo)
	{
		this.escudoPuntosDeVida = puntosDeVidaEscudo;
	}
	
	/*protected String getNombre()
	{
		return this.nombre;
	}
	
	protected int getNivelDeMagia()
	{
		return this.nivelDeMagia;
	}
	
	protected double getPuntosDeVida()
	{
		return this.puntosDeVida;
	}
	
	protected List<Hechizo> getHechizos()
	{
		return this.hechizos;
	}
	
	protected void setPuntosDeVida(double puntosDeVida)
	{
		this.puntosDeVida = puntosDeVida;
	}*/
}
