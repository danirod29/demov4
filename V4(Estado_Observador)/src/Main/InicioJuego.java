package Main;

import vistas.VentanaBosque;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import reproductorCadenaRes.Reproductor;
import reproductorCadenaRes.ReproductorMp3;
import reproductorCadenaRes.ReproductorWav;
import reproductorCadenaRes.Reproductordefault;
import vistas.*;

import javax.swing.JComponent;


/**
 *
 * @author Cristian
 */
public class InicioJuego {
    public static void main(String[] args) {
    	//Para ventana
		VentanaBosque jfInicio = new VentanaBosque();
		jfInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jfInicio.setVisible(true);
		
		
		
		
		Reproductor rep[] = new Reproductor[3];
		
		rep[0] = new ReproductorMp3();
		rep[1] = new ReproductorWav();
		rep[2] = new Reproductordefault();
				
		for (int i = 0; i < rep.length - 1; i++) {
			rep[i].setSiguiente(rep[i + 1]);
		}
		
		long cont = System.nanoTime();
		
		while (true) {	
			if (System.nanoTime() >= cont) {
				rep[0].reproducir(1);
				cont=System.nanoTime()+cont;
				
			}
			else {
				rep[0].reproducir(2);
				cont=System.nanoTime();
			}
			
		}

    }
}