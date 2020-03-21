package personajeEstados;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class PersonajeEstadoVisualRecolectorA implements PersonajeEstadoVisual{
	private PlantillaCreacionImagenes plantillaImg = new PlantillaCreacionImagenes();
	
	@Override
	public Image asignarImagen() {
		plantillaImg.setNombreImg("RecolectorA");
		return plantillaImg.getImagenMov2();
	}

}
