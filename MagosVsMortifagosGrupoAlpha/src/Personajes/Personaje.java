package Personajes;

import Hechizos.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {
	protected String nombre;
//	protected int nivelDeMagia;
	protected int nivelDeMagiaOcura;
	protected int nivelDeMagiaPatronus;
	protected int nivelDeMagiaDefensiva;
	protected double puntosDeVida;
	private final double maxPuntosDeVida;
	protected List<Hechizo> hechizos;
	protected double escudoPuntosDeVida;
	protected boolean escudoActivo;
	private FabricaDeHechizos fabricaHechizos = new FabricaDeHechizos();

	public Personaje(String nombre, double puntosDeVida, int nivelDeMagiaOscura, int nivelDeMagiaPatronus,
			int nivelDeMagiaDefensiva) {
		this.nombre = nombre;
		this.nivelDeMagiaOcura = nivelDeMagiaOscura;
		this.nivelDeMagiaPatronus = nivelDeMagiaPatronus;
		this.nivelDeMagiaDefensiva = nivelDeMagiaDefensiva;
		this.puntosDeVida = puntosDeVida;
		this.maxPuntosDeVida = puntosDeVida;
		this.hechizos = new ArrayList<>();
		this.escudoActivo = false;
		this.escudoPuntosDeVida = 0.0;
		
		for(int i = 0; i < 3; i++) // CAMBIAR EL 3 POR UNA CONSTANTE O VARIABLE Y ANALIZAR SI SE CREAN HECHIZOS POR CATEGORIAS
		{
			hechizos.add(fabricaHechizos.crearHechizo()); // revisar que no sean repetidos. Podemos usar un hashSet en vez de un ArrayList
		}
	}

	public String getNombre()
	{
		return this.nombre;
	}
	
	public int getNivelDeMagiaOscura()
	{
		return this.nivelDeMagiaOcura;
	}
	
	public int getNivelDeMagiaPatronus()
	{
		return this.nivelDeMagiaPatronus;
	}
	
	public int getNivelDeMagiaDefensiva()
	{
		return this.nivelDeMagiaDefensiva;
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
		return puntosDeVida > 0d;
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
