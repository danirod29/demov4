package partesPersonaje;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public abstract class ArmaduraPersonaje extends CodigoElemtoJuego{
	//Atributos
	protected String nombreArmadura;
	protected String categoriaArmadura;
	public int dagno;
	protected boolean estado;
	protected Image imgArmadura;
	protected PlantillaCreacionImagenes miPlanImg;

			
	public ArmaduraPersonaje() {	
	}
			
	public abstract void asignarDatosArmadura();
	public abstract Image retornarImagen();
	public abstract ArmaduraPersonaje clonarArmadura();
	
	//Metodos heredados
	public void asignarCodigo(String codigo) {
		this.codigoElemento = codigo;
	}
	public String retornarCodigo() {
		return codigoElemento;	
	}

}
