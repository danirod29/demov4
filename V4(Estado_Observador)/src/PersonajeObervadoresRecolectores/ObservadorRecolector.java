package PersonajeObervadoresRecolectores;

import partesPersonaje.CodigoElemtoJuego;
import personajeCompleto.PersonajeAnimado;

public interface ObservadorRecolector {
	public void notificar(PersonajeAnimado personajeActual, CodigoElemtoJuego codigoAgrega);
	public PersonajeAnimado retornarNuevoEstado();
}
