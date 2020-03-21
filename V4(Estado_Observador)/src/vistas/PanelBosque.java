package vistas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JPanel;

import PersonajeObervadoresRecolectores.ObservadorRecolector;
import PersonajeObervadoresRecolectores.ObservadorReyA;
import PersonajeObervadoresRecolectores.ObservadorReyB;
import elementosEscenario_Composite.DibujoComponente;
import elementosEscenario_Composite.DibujoComposicion;
import elementosEscenario_Composite.DibujoComposicionBosque;
import elementosEscenario_Composite.DibujoEspecifico;
import elementosEscenario_Composite.DibujoEspecificoArbol;
import partesPersonaje.ArmaduraPersonaje;
import partesPersonaje.CodigoElemtoJuego;
import partesPersonaje.HabilidadPersonaje;
import partesPersonaje.HerramientaPersonaje;
import partesPersonaje.ListaObjetosJuego;
import personajeCompleto.PersonajeAnimado;
import personajeCompleto.PersonajeRecolector;
import personajeCompleto.PersonajeRey;
import personajeEstados.PersonajeEstadoVisual;
import personajeEstados.PersonajeEstadoVisualRecolectorA;
import personajeEstados.PersonajeEstadoVisualRecolectorB;
import personajeOrdenarConstruccion.BuilderRecolector;
import personajeOrdenarConstruccion.BuilderRey;
import personajeOrdenarConstruccion.Director;
import personajeRecubridor_Decorador.ReyMago;
import plantillas.PlantillaCreacionImagenes;

public class PanelBosque extends JPanel{
	//Atributos(Laberinto)
	private int fila;
	private int columna;
	private final int numFilas = 9;
	private final int numColumnas = 11;
	private int ancho = 40, alto = 40;
	private ListaObjetosJuego lisObjJuego;
	private ArrayList<DibujoEspecifico> miElementosBosque; 
	private ArrayList<CodigoElemtoJuego> listaCodigos; 
	private int acumuladorLista = 0;
	private int acumuladorLista2 = 0;
	//Elementos necesarios para crear un bosque
	DibujoComposicion miComposicionBosque;
	private static boolean TURNOREY = true;
	
	//---------------------------------------------------------
	//para recolector
	private BuilderRecolector ordenRecolector = new BuilderRecolector();
	private Director directorRecolector = new Director();
	private PersonajeAnimado miPersonajeAnimado = null;
	private String laberinto[][];
	
	private PersonajeAnimado miPerRey = null;
	private PersonajeAnimado miClonRey = null;
	private BuilderRey ordenRey = new BuilderRey();
	private ObservadorRecolector mensajeroReyA;
	private ObservadorRecolector mensajeroReyB;
	

	public PanelBosque() {
		miComposicionBosque = new DibujoComposicionBosque();
		miElementosBosque = miComposicionBosque.getElementosDibujo();
		lisObjJuego = new ListaObjetosJuego();
		
		//--------------------------------------------
		//Para personajes
		//Orden de como se construiran las partes del personaje-animado 
		directorRecolector.construir(ordenRecolector);
		//Retorna el personaje-animado con sus respectivas partes
		miPersonajeAnimado = ordenRecolector.obtenerPerAnimado();
		miPersonajeAnimado.asignarDesplazamiento(250, 250);
		laberinto = obtieneLaberinto();
		listaCodigos = lisObjJuego.getLisHerramientas();
		
		//------------------------------------------------
		directorRecolector.construir(ordenRey);
		miPerRey = ordenRey.obtenerPerAnimado();
		miPerRey.asignarDesplazamiento(250, 50);
		miPerRey.asignarDatos();
		miClonRey = miPerRey.clonarPersonaje();	
		
		//--------------------------------------------------
		mensajeroReyA = new ObservadorReyA();
		mensajeroReyB = new ObservadorReyB();
		((PersonajeRecolector)miPersonajeAnimado).registrarObservadores(mensajeroReyA);
		((PersonajeRecolector)miPersonajeAnimado).registrarObservadores(mensajeroReyB);
		
		//ObservadorReyA a = new ObservadorReyA();
		//a.notificar(miClonRey, null);
		//miClonRey = a.retornarNuevoEstado();
		
		//miClonRey = new ReyMago(miClonRey);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//Escenario---------------------------------------------------------
		for(fila =0; fila<=numFilas-1; fila++) {
			for(columna=0; columna<=numColumnas-1; columna++) {
				if(laberinto[fila][columna] == "1") {	
					g.drawImage(miElementosBosque.get(acumuladorLista).getImagenMov(), columna*DibujoEspecifico.getAncho(),fila*DibujoEspecifico.getAlto(),DibujoEspecifico.getAncho(),DibujoEspecifico.getAlto(),null);
					acumuladorLista++;
				}else if(laberinto[fila][columna] !="0" &&laberinto[fila][columna] !="1" ) {
					g.drawImage(listaCodigos.get(acumuladorLista2).retornarImagen(), columna*PlantillaCreacionImagenes.ANCHO, fila*PlantillaCreacionImagenes.ALTO, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
					listaCodigos.get(acumuladorLista2).asignarCodigo(laberinto[fila][columna]);
					acumuladorLista2 ++;
					
				}
					
			}
		}
		acumuladorLista = acumuladorLista2 = 0;
		
		//MovimientoPersonajes---------------------------------------------
		this.actualizarMovimientoPersonaje(g);
		this.actualizarAccion(g);
		//------------------------------------------------------------------
		this.dibujarReyes(g);
	}
	public String [][] obtieneLaberinto(){
		String laberinto[][]=
		{
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"1","1","1","1","0","0","0","1","1","1","1"},
			{"0","0","0","1","0","0","0","1","0","0","0"},
			{"0","0","0","1","1","1","1","1","0","0","0"},
			{"0","A0","A1","0","0","0","0","0","A2","A3","0"},
			{"B1","A4","A5","0","0","0","0","0","A6","A7","B2"},
			{"C1","A8","A9","0","0","0","0","0","A10","A11","C2"},
			{"0","A12","A13","0","0","0","0","0","A14","0","0"},
			
		};
		return laberinto;
	}
	
	public void actualizarMovimientoPersonaje(Graphics g) {
		((PersonajeRecolector)miPersonajeAnimado).setLaberinto(laberinto);
		miPersonajeAnimado.asignarDesplazamiento();
		this.estadoDelRecolector();
		g.drawImage(miPersonajeAnimado.imgPersonaje(), miPersonajeAnimado.posicionX,miPersonajeAnimado.posicionY,PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
	}
	
	public void actualizarAccion(Graphics g) {
		((PersonajeRecolector)miPersonajeAnimado).setLaberinto(laberinto);
		((PersonajeRecolector)miPersonajeAnimado).setListaCodigos(listaCodigos);
		if(TURNOREY) {
			miPerRey = ((PersonajeRecolector)miPersonajeAnimado).realizarAccion(miPerRey);
		}else if(!TURNOREY) {
			miClonRey = ((PersonajeRecolector)miPersonajeAnimado).realizarAccion(miClonRey);
		}
		laberinto = ((PersonajeRecolector)miPersonajeAnimado).getLaberinto();
		listaCodigos = ((PersonajeRecolector)miPersonajeAnimado).getListaCodigos();
		//miPerRey = ((PersonajeRecolector)miPersonajeAnimado).getReyActual();
	}
	
	//----------------------------------------------------------
	public void dibujarReyes(Graphics g) {
		miPerRey.realizarAccion();
		miClonRey.realizarAccion();
		g.drawImage(miPerRey.imgPersonaje(), miPerRey.posicionX, miPerRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
		g.drawImage(miClonRey.imgPersonaje(), miClonRey.posicionX, miClonRey.posicionY, PlantillaCreacionImagenes.ANCHO, PlantillaCreacionImagenes.ALTO, null);
		System.out.println("--------------"+miPerRey.experiencia);
	
	}
	
	//-------------------------------------------------------
	
	//------------------------------------------------------
	
	public void estadoDelRecolector() {
		if(TURNOREY) {
			((PersonajeRecolector)miPersonajeAnimado).asignarEstadoImg(new PersonajeEstadoVisualRecolectorA());
		}else if(!TURNOREY) {
			((PersonajeRecolector)miPersonajeAnimado).asignarEstadoImg(new PersonajeEstadoVisualRecolectorB());	
		}
	}
	
	
	public static boolean retornarTurno() {
		return TURNOREY;
	}
	
	public static void asignarTurno(Boolean turno) {
		TURNOREY = turno;
	}

}
