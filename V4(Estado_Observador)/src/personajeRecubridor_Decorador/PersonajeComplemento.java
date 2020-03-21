package personajeRecubridor_Decorador;

import personajeCompleto.PersonajeAnimado;
import personajeOrdenarConstruccion.Director;

public abstract class PersonajeComplemento extends PersonajeAnimado{
	//Atributos
	protected Director directorPersonaje = new Director();
	protected PersonajeAnimado miREY;
	protected PersonajeAnimado miPerTran;
	
	public PersonajeComplemento(PersonajeAnimado miREY) {
		this.miREY = miREY;
	}
	
	public abstract void complementarPersonaje();
}
