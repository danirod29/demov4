package vistas;



import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.EventoTeclado;
import reproductorCadenaRes.Reproductor;
import reproductorCadenaRes.ReproductorMp3;
import reproductorCadenaRes.ReproductorWav;
import reproductorCadenaRes.Reproductordefault;

public class VentanaBosque extends JFrame{
	//Atributos
	PanelBosque jpBosque;
	private Hilo hiloBosque;

	
	public VentanaBosque() {
		//Disposicion de la ventana	
		this.setTitle("Bosque_Pequeño");
		this.setSize(600, 600);
		
		jpBosque = new PanelBosque();
		jpBosque.setBackground(Color.white);
		this.add(jpBosque);
		//La ventana estara a la escucha
		this.addKeyListener(new EventoTeclado());
		//Se inicializa el hilo
		hiloBosque = new Hilo(jpBosque);
		//El hilo inicia (Actualiza el estado de la pantalla)
		hiloBosque.start();
		
	}
}

