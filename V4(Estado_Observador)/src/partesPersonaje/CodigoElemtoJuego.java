package partesPersonaje;

import java.awt.Image;

public abstract class CodigoElemtoJuego {
	//Atributos
	protected String codigoElemento;
	
	public abstract void asignarCodigo(String codigo);
	public abstract String retornarCodigo();
	public abstract Image retornarImagen();

}
