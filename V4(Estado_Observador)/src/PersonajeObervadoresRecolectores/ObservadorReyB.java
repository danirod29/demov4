package PersonajeObervadoresRecolectores;

import partesPersonaje.CodigoElemtoJuego;
import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.BuilderRey;
import personajeOrdenarConstruccion.Director;

public class ObservadorReyB implements ObservadorRecolector{
	//Atributos
	PersonajeAnimado personajeActual;
	private Director directorRey = new Director();
	private BuilderRey miRey = new BuilderRey();
	
	@Override
	public void notificar(PersonajeAnimado per, CodigoElemtoJuego codigoAgrega) {
		this.personajeActual = per;
		directorRey.construir(miRey);
		personajeActual = miRey.obtenerPerAnimado();
		personajeActual.asignarDatos();
		personajeActual.posicionX = per.posicionX;
		personajeActual.posicionY = per.posicionY;
		personajeActual.experiencia = per.experiencia;
	}

	@Override
	public PersonajeAnimado retornarNuevoEstado() {
		return personajeActual;
	}

}
