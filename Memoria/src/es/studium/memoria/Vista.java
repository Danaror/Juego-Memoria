package es.studium.memoria;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Vista extends Frame
{

	private static final long serialVersionUID = 1L;
	Toolkit herramientas;
	Image fondo, reverso;
	Image A1, A2, A3, A4, A5, A6;
	String[] jugador =new String[2];
	int[] puntosJugador = new int[2];
	int i;	
	
	int[] eventos = {0,1,2,3,4,5,6};
	int[] cartas= {0,0,0,0,0,0,0,0,0,0,0,0};
	
	
	
	public Vista()
	{
		herramientas = getToolkit();
		fondo = herramientas.getImage("img/fondo.jpg");
		reverso = herramientas.getImage("img/reverso.png");
		//Llamo a cargar cartas para asignar las cartas dinosaurios
		cargarCartas();
		this.setTitle("Memoria");
		this.setSize(1000,800);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
	}
	public void paint(Graphics g)
	{
		System.out.println("ejecuta paint");
		g.drawImage(fondo, 0, 30, this);
		Font fuente = new Font("Ravie", Font.BOLD, 20);
		g.setFont(fuente);
		g.setColor(Color.red);
		g.drawString(jugador[0]+":", 40, 120);
		g.drawString( puntosJugador[0]+ " puntos", 40, 160);
		g.setColor(Color.blue);
		g.drawString(jugador[1]+":", 40, 200);
		g.drawString( puntosJugador[1]+ " puntos", 40, 240);
		g.setColor(Color.blue);
		g.drawString("El turno de:", 40, 600);
		g.drawString( jugador[i], 40,675);
		
		//g.setColor(Color.blue);
		//g.drawString("Jugador 3: ", 40, 280);
		//g.drawString( puntosJugador3+ " puntos", 40, 320);
		//g.setColor(Color.green);
		//g.drawString("Jugador 4: ", 40, 360);
		//g.drawString( puntosJugador4+ " puntos", 40, 400);
		
	for (int pos=0;pos<12;pos++)
	{
	switch(pos)
		{
		case 0:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 200, 120, this);
				break;
			case 1:
				g.drawImage(A1, 200, 120, this);
				break;
			case 2:
				g.drawImage(A2, 200, 120, this);
				break;
			case 3:
				g.drawImage(A3, 200, 120, this);
				break;
			case 4:
				g.drawImage(A4, 200, 120, this);
				break;
			case 5:
				g.drawImage(A5, 200, 120, this);
				break;
			case 6:
				g.drawImage(A6, 200, 120, this);
				break;
			}
			break;	
			
		case 1:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 400, 120, this);
				break;
			case 1:
				g.drawImage(A1, 400, 120, this);
				break;
			case 2:
				g.drawImage(A2, 400, 120, this);
				break;
			case 3:
				g.drawImage(A3, 400, 120, this);
				break;
			case 4:
				g.drawImage(A4, 400, 120, this);
				break;
			case 5:
				g.drawImage(A5, 400, 120, this);
				break;
			case 6:
				g.drawImage(A6, 400, 120, this);
				break;
			}
			break;
			
		case 2:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 600, 120, this);
				break;
			case 1:
				g.drawImage(A1, 600, 120, this);
				break;
			case 2:
				g.drawImage(A2, 600, 120, this);
				break;
			case 3:
				g.drawImage(A3, 600, 120, this);
				break;
			case 4:
				g.drawImage(A4, 600, 120, this);
				break;
			case 5:
				g.drawImage(A5, 600, 120, this);
				break;
			case 6:
				g.drawImage(A6, 600, 120, this);
				break;
			}
			break;	
			
		case 3:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 800, 120, this);
				break;
			case 1:
				g.drawImage(A1, 800, 120, this);
				break;
			case 2:
				g.drawImage(A2, 800, 120, this);
				break;
			case 3:
				g.drawImage(A3, 800, 120, this);
				break;
			case 4:
				g.drawImage(A4, 800, 120, this);
				break;
			case 5:
				g.drawImage(A5, 800, 120, this);
				break;
			case 6:
				g.drawImage(A6, 800, 120, this);
				break;
			}
			break;
			
		case 4:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 200, 340, this);
				break;
			case 1:
				g.drawImage(A1, 200, 340, this);
				break;
			case 2:
				g.drawImage(A2, 200, 340, this);
				break;
			case 3:
				g.drawImage(A3, 200, 340, this);
				break;
			case 4:
				g.drawImage(A4, 200, 340, this);
				break;
			case 5:
				g.drawImage(A5, 200, 340, this);
				break;
			case 6:
				g.drawImage(A6, 200, 340, this);
				break;
			}
			break;	
			
		case 5:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 400, 340, this);
				break;
			case 1:
				g.drawImage(A1, 400, 340, this);
				break;
			case 2:
				g.drawImage(A2, 400, 340, this);
				break;
			case 3:
				g.drawImage(A3, 400, 340, this);
				break;
			case 4:
				g.drawImage(A4, 400, 340, this);
				break;
			case 5:
				g.drawImage(A5, 400, 340, this);
				break;
			case 6:
				g.drawImage(A6, 400, 340, this);
				break;
			}
			break;
			
		case 6:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 600, 340, this);
				break;
			case 1:
				g.drawImage(A1, 600, 340, this);
				break;
			case 2:
				g.drawImage(A2, 600, 340, this);
				break;
			case 3:
				g.drawImage(A3, 600, 340, this);
				break;
			case 4:
				g.drawImage(A4, 600, 340, this);
				break;
			case 5:
				g.drawImage(A5, 600, 340, this);
				break;
			case 6:
				g.drawImage(A6, 600, 340, this);
				break;
			}
			break;
			
		case 7:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 800, 340, this);
				break;
			case 1:
				g.drawImage(A1, 800, 340, this);
				break;
			case 2:
				g.drawImage(A2, 800, 340, this);
				break;
			case 3:
				g.drawImage(A3, 800, 340, this);
				break;
			case 4:
				g.drawImage(A4, 800, 340, this);
				break;
			case 5:
				g.drawImage(A5, 800, 340, this);
				break;
			case 6:
				g.drawImage(A6, 800, 340, this);
				break;
			}
			break;
			
		case 8:
			
				switch (cartas[pos])
				{
				case 0:
					g.drawImage(reverso, 200, 560, this);
					break;
				case 1:
					g.drawImage(A1, 200, 560, this);
					break;
				case 2:
					g.drawImage(A2, 200, 560, this);
					break;
				case 3:
					g.drawImage(A3, 200, 560, this);
					break;
				case 4:
					g.drawImage(A4, 200, 560, this);
					break;
				case 5:
					g.drawImage(A5, 200, 560, this);
					break;
				case 6:
					g.drawImage(A6, 200, 560, this);
					break;
				}
				break;
		case 9:
				switch (cartas[pos])
				{
				case 0:
					g.drawImage(reverso, 400, 560, this);
					break;
				case 1:
					g.drawImage(A1, 400, 560, this);
					break;
				case 2:
					g.drawImage(A2, 400, 560, this);
					break;
				case 3:
					g.drawImage(A3, 400, 560, this);
					break;
				case 4:
					g.drawImage(A4, 400, 560, this);
					break;
				case 5:
					g.drawImage(A5, 400, 560, this);
					break;
				case 6:
					g.drawImage(A6, 400, 560, this);
					break;
				}
				break;
				
		case 10:
				switch (cartas[pos])
				{
				case 0:
					g.drawImage(reverso, 600, 560, this);
					break;
				case 1:
					g.drawImage(A1, 600, 560, this);
					break;
				case 2:
					g.drawImage(A2, 600, 560, this);
					break;
				case 3:
					g.drawImage(A3, 600, 560, this);
					break;
				case 4:
					g.drawImage(A4, 600, 560, this);
					break;
				case 5:
					g.drawImage(A5, 600, 560, this);
					break;
				case 6:
					g.drawImage(A6, 600, 560, this);
					break;
				}
				break;
				
		case 11:
			switch (cartas[pos])
			{
			case 0:
				g.drawImage(reverso, 800, 560, this);
				break;
			case 1:
				g.drawImage(A1, 800, 560, this);
				break;
			case 2:
				g.drawImage(A2, 800, 560, this);
				break;
			case 3:
				g.drawImage(A3, 800, 560, this);
				break;
			case 4:
				g.drawImage(A4, 800, 560, this);
				break;
			case 5:
				g.drawImage(A5, 800, 560, this);
				break;
			case 6:
				g.drawImage(A6, 800, 560, this);
				break;
			}break;
			
		}
	}
	
	
	}
	
		
	public void aumentarMarcador(int jugador)
	{
		
		if (jugador==1)
		{
		puntosJugador[0]++;
		repaint();	
		}else
		if (jugador==2)
		{
		puntosJugador[1]++;
		repaint();	
		}
		//else
		//if (jugador==3)
		//{
		//puntosJugador3++;
		//repaint();	
		//}else
		//if (jugador==4)
		//{
		//puntosJugador4++;
		//repaint();	
		//}
	
	}	
	public void cambiarTurno(int turno)
	{
		System.out.println("cambio turno  "+ turno);
		
		i=turno;
		repaint();
		
	}	
			
	public void mostrarCarta(int evento, int cartapos)
	{
		//recibo la posición 
		cartas[cartapos]=evento;
		repaint();
	}
	
	
	public void cargarCartas()
	{
		A1 = herramientas.getImage("img/A1.png");
		A2 = herramientas.getImage("img/A2.png");
		A3 = herramientas.getImage("img/A3.png");
		A4 = herramientas.getImage("img/A4.png");
		A5 = herramientas.getImage("img/A5.png");
		A6 = herramientas.getImage("img/A6.png");
		
	}
	public void repinto()
	{
		repaint();
	}
	
	public void acierto()
	{
		File sf = new File("./sound/acierto.wav");
		AudioFileFormat aff;
		AudioInputStream ais;
		try {
			aff = AudioSystem.getAudioFileFormat(sf);
			ais = AudioSystem.getAudioInputStream(sf);
			AudioFormat af = aff.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, ais.getFormat(),
					((int) ais.getFrameLength() * af.getFrameSize()));
			Clip ol = (Clip) AudioSystem.getLine(info);
			ol.open(ais);
			ol.loop(Clip.LOOP_CONTINUOUSLY);
			// Damos tiempo para que el sonido sea escuchado
			Thread.sleep(500);
			ol.close();
		} catch (UnsupportedAudioFileException ee) {
			System.out.println(ee.getMessage());
		} catch (IOException ea) {
			System.out.println(ea.getMessage());
		} catch (LineUnavailableException LUE) {
			System.out.println(LUE.getMessage());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

}
