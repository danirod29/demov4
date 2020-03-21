package personajeCompleto;

import java.awt.Image;

public class PersonajeMago extends PersonajeAnimado {
	public PersonajeMago() {
		
	}
	
	
	@Override
	public void realizarAccion() {
		if(acumulador == 1) {
			imgPerAni.numImg = "1";
			System.out.print(acumulador);
		}else {
			imgPerAni.numImg = "2";
			acumulador = 0;
		}
		acumulador ++;
	}

	@Override
	public void asignarDesplazamiento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PersonajeAnimado clonarPersonaje() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Image imgPersonaje() {
		this.realizarAccion();
		return imgPerAni.getImagenMov2();
	}

	@Override
	public void asignarDatos() {
		this.oficio = "Mago";
		this.imgPerAni.setNombreImg(oficio);
	}

}
