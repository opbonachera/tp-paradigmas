package Personajes;

import Hechizos.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
	protected String nombre;
	protected int nivelDeMagia;
	protected double puntosDeVida;
	private final double maxPuntosDeVida;
	protected List<Hechizo> hechizos;
	protected double escudoPuntosDeVida;
	protected boolean escudoActivo;
	private FabricaDeHechizos fabricaHechizos = new FabricaDeHechizos();
	
	public Personaje(String nombre, int nivelDeMagia, double puntosDeVida)
	{
		this.nombre = nombre;
		this.nivelDeMagia = nivelDeMagia;
		this.puntosDeVida = puntosDeVida;
		this.maxPuntosDeVida = puntosDeVida;
		this.hechizos = new ArrayList<>();
		this.escudoActivo = false;
		this.escudoPuntosDeVida = 0.0;
		
		for(int i = 0; i < 3; i++) // CAMBIAR EL 3 POR UNA CONSTANTE O VARIABLE Y ANALIZAR SI SE CREAN HECHIZOS POR CATEGORIAS
		{
			hechizos.add(fabricaHechizos.crearHechizo()); // revisar que no sean repetidos
		}
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
	
	public double getMaxPuntosDeVida()
	{
		return this.maxPuntosDeVida;
	}
	
	public void setEscudo(boolean activo)
	{
		this.escudoActivo = activo;
	}
	
	public void setEscudoPuntosDeVida(double puntosDeVidaEscudo)
	{
		this.escudoPuntosDeVida = puntosDeVidaEscudo;
	}

	public boolean estaVivo()
	{
		return puntosDeVida > 0;
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
        hechizo.ejecutar(this, objetivo);
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
