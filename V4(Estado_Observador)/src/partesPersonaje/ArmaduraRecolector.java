package partesPersonaje;

import java.awt.Image;

public class ArmaduraRecolector extends ArmaduraPersonaje{

	public ArmaduraRecolector() {
		this.asignarDatosArmadura();
	}
	
	@Override
	public void asignarDatosArmadura() {
		nombreArmadura = "Tunica";
		categoriaArmadura = "Recolector";
		dagno = 3;		
	}

	@Override
	public Image retornarImagen(){
		return null;
	}

	@Override
	public ArmaduraPersonaje clonarArmadura() {
		ArmaduraPersonaje miClo = new ArmaduraRecolector();
		return miClo;
	}

}
