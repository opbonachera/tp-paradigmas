package Personajes;

import Batalla.Combatiente;
import Estados.Estado;
import Hechizos.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public abstract class Personaje implements Combatiente {
	protected String nombre;
	protected int nivelDeMagiaOcura;
	protected int nivelDeMagiaPatronus;
	protected int nivelDeMagiaDefensiva;
	protected double puntosDeVida;
	private final double maxPuntosDeVida;
	private final Set<Estado> estados;
	protected Set<Hechizo> hechizos;
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
		this.hechizos = new LinkedHashSet<>();
		this.estados = new LinkedHashSet<>();
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
	
	public Set<Hechizo> getHechizos()
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

	public void agregarEstado(Estado estado)
	{
		this.estados.add(estado);
		System.out.println("El personaje " + this.getNombre() +
							" ha quedado en estado " + estado.toString());
	}

	public boolean estaInmune()
	{
		for(Estado estado : this.estados)
		{
			if(estado.bloqueaDanio())
			{
				return true;
			}
		}

		return false;
	}

	public void procesarEstadosInicioDelTurno()
	{
		for(Estado estado : this.estados)
		{
			estado.aplicarAlInicioDelTurno(this);
		}
	}

	public void procesarEstadosFinDelTurno()
	{
		for(Estado estado : this.estados)
		{
			estado.aplicarAlFinalDelTurno(this);
			estado.consumirTurno();
		}

		for(Estado estado : this.estados)
		{
			if(estado.estaObsoleto())
			{
				estado.alCaducar(this);
			}
		}

		this.estados.removeIf(Estado::estaObsoleto);
	}

	public boolean estaVivo()
	{
		return puntosDeVida > 0d;
	}
	
	public void lanzarHechizo(Hechizo hechizo, Personaje objetivo) {
        hechizo.ejecutar(this, objetivo);
    }

    @Override
    public boolean hayPersonajesVivos() {
        return estaVivo();
    }

    @Override
    public void atacar(Combatiente enemigo) {
        if (!estaVivo() || !enemigo.hayPersonajesVivos()) return;
        Hechizo hechizo = hechizos.get(new Random().nextInt(hechizos.size()));
        lanzarHechizo(hechizo, (Personaje) enemigo);
    }
}
