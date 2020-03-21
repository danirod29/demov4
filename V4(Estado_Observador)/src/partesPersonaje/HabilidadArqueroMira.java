package partesPersonaje;

import java.awt.Image;

import elementosEscenario_Composite.DibujoEspecifico;
import elementosEscenario_Composite.DibujoEspecificoArbol;
import plantillas.PlantillaCreacionImagenes;

public class HabilidadArqueroMira extends HabilidadPersonaje{
	public HabilidadArqueroMira() {
		miPlanImg = new PlantillaCreacionImagenes();
		this.asignarDatosHabilidad();
	}
	@Override
	public void asignarDatosHabilidad() {
		nombreHabilidad = "HabilidadMira";
		categoriaHabilidad = "Arquero";
		dagno = 16;
		miPlanImg.setNombreImg(nombreHabilidad);;
	}

	@Override
	public Image retornarImagen(){
		return miPlanImg.getImagenMov2();
	}
	@Override
	public HabilidadPersonaje clonarHabilidad() {
		HabilidadPersonaje miClo = new HabilidadArqueroMira();
		return miClo;
	}

}
