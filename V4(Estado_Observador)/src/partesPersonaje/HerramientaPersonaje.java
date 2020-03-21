package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public abstract class HerramientaPersonaje extends CodigoElemtoJuego{
	//Atributos
	protected String nombreHerramienta;
	protected String categoriaHerramienta;
	public int dagno;
	protected boolean estado;
	protected Image imgHerramienta;
	protected PlantillaCreacionImagenes miPlanImg;
	
	public HerramientaPersonaje() {	
	}
	
	public abstract void asignarDatorHerramienta();
	public abstract Image retornarImagen();
	public abstract HerramientaPersonaje clonarHerramienta();
	
	//------------------------------------------------------
	//Metodos heredados
	public void asignarCodigo(String codigo) {
		this.codigoElemento = codigo;
	}
	public String retornarCodigo() {
		return codigoElemento;	
	}	

}
