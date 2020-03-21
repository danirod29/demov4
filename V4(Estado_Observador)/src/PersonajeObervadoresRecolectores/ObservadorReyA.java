package PersonajeObervadoresRecolectores;

import partesPersonaje.CodigoElemtoJuego;
import personajeCompleto.PersonajeAnimado;
import personajeRecubridor_Decorador.ReyMago;

public class ObservadorReyA implements ObservadorRecolector{
	//Atributos
	PersonajeAnimado personajeActual;
	
	@Override
	public void notificar(PersonajeAnimado per, CodigoElemtoJuego codigoAgrega) {
		this.personajeActual = per;
		personajeActual = new ReyMago(personajeActual);
	}

	@Override
	public PersonajeAnimado retornarNuevoEstado() {
		return personajeActual;
	}

}
