package personajeEstados;

import java.awt.Image;

import plantillas.PlantillaCreacionImagenes;

public class PersonajeEstadoVisualRecolectorB implements PersonajeEstadoVisual{
private PlantillaCreacionImagenes plantillaImg = new PlantillaCreacionImagenes();
	@Override
	public Image asignarImagen() {
		plantillaImg.setNombreImg("RecolectorB");
		return plantillaImg.getImagenMov2();
	}
}
