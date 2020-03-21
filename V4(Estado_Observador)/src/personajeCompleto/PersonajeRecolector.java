package personajeCompleto;

import java.awt.Image;
import java.util.ArrayList;

import PersonajeObervadoresRecolectores.ObservadorRecolector;
import controlador.EventoTeclado;
import partesPersonaje.CodigoElemtoJuego;
import personajeEstados.PersonajeEstadoVisual;
import personajeOrdenarConstruccion.BuilderRecolector;
import personajeOrdenarConstruccion.Director;
import vistas.PanelBosque;

public class PersonajeRecolector extends PersonajeAnimado{
	//Atributos
	private String laberinto[][];
	private ArrayList<CodigoElemtoJuego> listaCodigos;
	private PersonajeEstadoVisual imgEstadoVisual = null;
	private ArrayList<ObservadorRecolector> listObservadores = new ArrayList<ObservadorRecolector>();
	private PersonajeAnimado perSonajeRey;
	
	public void PersonajeRecolector() {	
	}
	
	//-------------------------------------------------------------------
	//Metodos
	public void asignarEstadoImg(PersonajeEstadoVisual imgEstadoVisual) {
		this.imgEstadoVisual = imgEstadoVisual;
	}
	public void registrarObservadores(ObservadorRecolector obServador) {
		listObservadores.add(obServador);
	}
	public void ejecutarAccion(PersonajeAnimado rey, CodigoElemtoJuego codigo) {
		if(PanelBosque.retornarTurno()) {
			listObservadores.get(0).notificar(rey, codigo);
			perSonajeRey =  listObservadores.get(0).retornarNuevoEstado();
		}else if(PanelBosque.retornarTurno() == false){
			listObservadores.get(1).notificar(rey, codigo);
			perSonajeRey = listObservadores.get(1).retornarNuevoEstado();
		}
	}
	
	
	//-------------------------------------------------------------------
	//Metodos Heredaos
	
	@Override
	public void asignarDesplazamiento() {
		if(EventoTeclado.DERECHA) {
			if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] == "0") {
				posicionX = posicionX + desPlazamiento;
			}
		}
		if(EventoTeclado.IZQUIERDA) {
			if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] == "0") {
				posicionX = posicionX - desPlazamiento;
			}
		}
		if(EventoTeclado.ABAJO) {
			if(laberinto[(posicionY/desPlazamiento)+1][(posicionX/desPlazamiento)] == "0") {
				posicionY = posicionY + desPlazamiento;
			}
			
		}
		if(EventoTeclado.ARRIBA) {
			if(laberinto[(posicionY/desPlazamiento)-1][(posicionX/desPlazamiento)] == "0") {
				posicionY = posicionY - desPlazamiento;
			}
		}
		
	}

	@Override
	public PersonajeAnimado clonarPersonaje() {
		PersonajeAnimado miClonRecolector;
        
        //Se Determinan las partes del Mago
        Director miDirector = new Director();
        BuilderRecolector miBuilderRecolector = new BuilderRecolector();
        
        miDirector.construir(miBuilderRecolector);
        
        //Se instancia el objeto para que sea Mago
        miClonRecolector = miBuilderRecolector.obtenerPerAnimado();
        //Metodos que reciben parametros
		return miClonRecolector;
	}
	

	@Override
	public Image imgPersonaje() {
		return imgEstadoVisual.asignarImagen();
	}

	@Override
	public void asignarDatos() {
		this.oficio = "Recolector";
	}

	@Override
	public void realizarAccion() {
		
	}
	
	public PersonajeAnimado realizarAccion(PersonajeAnimado rey) {
		perSonajeRey = rey;
		int acumulador = 0;
		if(EventoTeclado.TOMARobjA || EventoTeclado.TOMAobjS) {
			if((laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] != "0" ) && (laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-1] != "1")) {
				acumulador = 1;
			}else if((laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] != "0" ) && (laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)+1] != "1")) {
				acumulador = -1;
			}
			for(int i=0; i<listaCodigos.size(); i++) {
				if(laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-acumulador] == listaCodigos.get(i).retornarCodigo()){
					this.ejecutarAccion(rey, listaCodigos.get(i));
					listaCodigos.remove(i);
				}
			
			}
			laberinto[posicionY/desPlazamiento][(posicionX/desPlazamiento)-acumulador] = "0"; 
			PanelBosque.asignarTurno(!PanelBosque.retornarTurno());
		}
		return perSonajeRey;
	}	
	
	
	
	
	
	//Metodos(Getter and setter)------------------------------------------------------
	public String[][] getLaberinto() {
		return laberinto;
	}

	public void setLaberinto(String[][] laberinto) {
		this.laberinto = laberinto;
	}

	public ArrayList<CodigoElemtoJuego> getListaCodigos() {
		return listaCodigos;
	}

	public void setListaCodigos(ArrayList<CodigoElemtoJuego> listaCodigos) {
		this.listaCodigos = listaCodigos;
	}
	
	public PersonajeAnimado getReyActual() {
		return listObservadores.get(0).retornarNuevoEstado();
	}

}
