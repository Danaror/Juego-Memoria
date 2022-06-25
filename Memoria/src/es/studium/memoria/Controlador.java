package es.studium.memoria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, MouseListener, ActionListener
{
	Vista vista;
	Modelo modelo;
	MenuPrincipal principal = new MenuPrincipal();
	//vectores para almacenar la posición de la carta girada y saber cual ha sido
	int[] memoriaCarta = new int[2];
	int[] memoriaPosicion = new int[2];
	//12 posiciones---->12 bloqueos, la carta que se gira una vez no velve ha ser girada hasta el siguiente turno
	int[] bloqueo = {0,0,0,0,0,0,0,0,0,0,0,0};
	//cada turno tiene 2 secuencia
	int seq1=0;
	//parejas levantadas
	int pareja=0;
	int turno=0;
	int ganador=0;
	
	public Controlador(Vista v,Modelo m)
	{
		this.vista = v;
		this.modelo = m;
		//Listener de los componentes
		principal.btnComo.addActionListener(this);
		principal.btnJugar.addActionListener(this);
		principal.btnTop.addActionListener(this);
		principal.btnSalir.addActionListener(this);
		principal.dlgMensajeFinPartida.addWindowListener(this);
		principal.dlgNombreJugadores.addWindowListener(this);
		principal.addWindowListener(this);
		principal.btnAceptar.addActionListener(this);
		principal.dlgTop.addWindowListener(this);
		principal.btnPartidaNueva.addActionListener(this);
		principal.btnSalirFin.addActionListener(this);
		principal.dlgSalirPartida.addWindowListener(this);
		principal.btnSalirPartida.addActionListener(this);
		principal.btnSPartidaNueva.addActionListener(this);
		principal.btnVolverPartida.addActionListener(this);
		principal.btnVolver.addActionListener(this);
		principal.btnSalirTop.addActionListener(this);
		vista.addWindowListener(this);
		vista.addMouseListener(this);
		modelo.barajar();
	}
	//cuando está activo el juego, este evento tiene el mayor peso
	@Override
	public void mouseClicked(MouseEvent evento) 
	{
		
		
		//número de turno?
		if (turno==2)
		{
			turno=0;
			
		}
		
		//capturo  la coordenada donde hago click
		int x = evento.getX();
		int y = evento.getY();
		//las cartas son de 175x175 así que añadimos la desviación conociendo la posición
		// desde la esquina superior izquierda
		int des = 175;
		
		//Secuencia de reconocimiento de carta pulsada
			
		//0 carta (0,0)--->pos (200.120)
		if((x>=200)&&(x<=200+des)&&(y>=120)&&(y<=120+des)&&(bloqueo[0]==0))
		{
			System.out.println("Pulsa 0");
			this.vista.mostrarCarta(modelo.cartaAsignada(1),0);
			memoriaCarta[seq1]=modelo.cartaAsignada(1);
			memoriaPosicion[seq1]=0;
			bloqueo[0] = 1;
			seq1++;
		}else
		//1 carta (0,1)--->pos (400.120)	
		if((x>=400)&&(x<=400+des)&&(y>=120)&&(y<=120+des)&&(bloqueo[1]==0))
		{
			System.out.println("Pulsa 1");
			this.vista.mostrarCarta(modelo.cartaAsignada(2),1);
			memoriaCarta[seq1]=modelo.cartaAsignada(2);
			memoriaPosicion[seq1]=1;
			bloqueo[1] = 1;
			seq1++;
		
		}else
		//2 carta (0,2)--->pos (600,120)	
		if((x>=600)&&(x<=600+des)&&(y>=120)&&(y<=120+des)&&(bloqueo[2]==0))
		{
			System.out.println("Pulsa 2");
			this.vista.mostrarCarta(modelo.cartaAsignada(3),2);
			memoriaCarta[seq1]=modelo.cartaAsignada(3);
			memoriaPosicion[seq1]=2;
			bloqueo[2] = 1;
			seq1++;
		}else 
		//3 carta (0,3--->pos (800,120))	
		if((x>=800)&&(x<=800+des)&&(y>=120)&&(y<=120+des)&&(bloqueo[3]==0))
		{
			System.out.println("Pulsa 3");
			this.vista.mostrarCarta(modelo.cartaAsignada(4),3);
			bloqueo[3] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(4);
			memoriaPosicion[seq1]=3;
			seq1++;
		}else
		//4 carta (1,0)--->pos (200,340)
		if((x>=200)&&(x<=200+des)&&(y>=340)&&(y<=340+des)&&(bloqueo[4]==0))
		{
			System.out.println("Pulsa 4");
			this.vista.mostrarCarta(modelo.cartaAsignada(5),4);
			bloqueo[4] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(5);
			memoriaPosicion[seq1]=4;
			seq1++;
		}else
		//5 carta (1,1)--->pos (400,340)	
		if((x>=400)&&(x<=400+des)&&(y>=340)&&(y<=340+des)&&(bloqueo[5]==0))
		{
			System.out.println("Pulsa 5");
			this.vista.mostrarCarta(modelo.cartaAsignada(6),5);
			bloqueo[5] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(6);
			memoriaPosicion[seq1]=5;
			seq1++;
		}else
		//6 carta (1,2)--->pos (600,120)	
		if((x>=600)&&(x<=600+des)&&(y>=340)&&(y<=340+des)&&(bloqueo[6]==0))
		{
			System.out.println("Pulsa 6");
			this.vista.mostrarCarta(modelo.cartaAsignada(7),6);
			bloqueo[6] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(7);
			memoriaPosicion[seq1]=6;
			seq1++;
		}else
		//7 carta (1,3)--->pos (800,120)	
		if((x>=800)&&(x<=800+des)&&(y>=340)&&(y<=340+des)&&(bloqueo[7]==0))
		{
			System.out.println("Pulsa 7");
			this.vista.mostrarCarta(modelo.cartaAsignada(8),7);
			bloqueo[7] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(8);
			memoriaPosicion[seq1]=7;
			seq1++;
		}else
		//8 carta (2,0)--->pos (200,560)
		if((x>=200)&&(x<=200+des)&&(y>=560)&&(y<=560+des)&&(bloqueo[8]==0))
		{
			System.out.println("Pulsa 8");
			this.vista.mostrarCarta(modelo.cartaAsignada(9),8);
			bloqueo[8] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(9);
			memoriaPosicion[seq1]=8;
			seq1++;
		}else
		//9 carta (2,1)--->pos (400,560)	
		if((x>=400)&&(x<=400+des)&&(y>=560)&&(y<=560+des)&&(bloqueo[9]==0))
		{
			System.out.println("Pulsa 9");
			this.vista.mostrarCarta(modelo.cartaAsignada(10),9);
			bloqueo[9] =1;
			memoriaCarta[seq1]=modelo.cartaAsignada(10);
			memoriaPosicion[seq1]=9;
			seq1++;
		}else
		//10 carta (2,2)--->pos (600,560)	
		if((x>=600)&&(x<=600+des)&&(y>=560)&&(y<=560+des)&&(bloqueo[10]==0))
		{
			System.out.println("Pulsa 10");
			this.vista.mostrarCarta(modelo.cartaAsignada(11),10);
			bloqueo[10] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(11);
			memoriaPosicion[seq1]=10;
			seq1++;
		}else
		//11 carta (2,3)--->pos (800,120)	
		if((x>=800)&&(x<=800+des)&&(y>=560)&&(y<=560+des)&&(bloqueo[11]==0))
		{
			System.out.println("Pulsa 11");
			this.vista.mostrarCarta(modelo.cartaAsignada(12),11);
			bloqueo[11] = 1;
			memoriaCarta[seq1]=modelo.cartaAsignada(12);
			memoriaPosicion[seq1]=11;
			seq1++;
		}else
			if((x>=875)&&(x<=1000)&&(y>=735)&&(y<=800))
			{
			principal.salirPartida();	
			}
		
		
		
		//si ya hemos levantado dos cartas
		if (seq1==2)
		{
			//reiniciamos la secuencia
			seq1=0;
			//pasamos de turno
			turno++;
			if (turno==2)
			{
				vista.cambiarTurno(0);
			}else
				vista.cambiarTurno(turno);
				//Comparamos las cartas
			/*try {
					vista.repaint();
					Thread.sleep(700);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			
			
			if (memoriaCarta[0]!=memoriaCarta[1])
			{	//son diferentes
				
				//borramos las cartas
				//this.vista.mostrarCarta(modelo.cartaAsignada(0),memoriaPosicion[1]);
				//this.vista.mostrarCarta(modelo.cartaAsignada(0),memoriaPosicion[0]);
				//quitamos los bloqueos
				bloqueo[memoriaPosicion[0]]=0;
				bloqueo[memoriaPosicion[1]]=0;
				
			}
			else
			{	//son iguales
				//suma marcador
				vista.aumentarMarcador(turno);
				modelo.aumentarMarcador(turno);
				//sumamos a parejas
				pareja++;
				if (pareja==6)
				{
				//tengo el ganador	
				ganador=modelo.ganador();
				//Enviamos sentencia con los datos
				System.out.println("ganador =" +ganador);
				if (ganador==-1)
				{
					principal.lblMensajeFinPartida.setText("EMPATE, ¿una revancha?");
					principal.finPartida();
					pareja=0;
				}
				else
				{
				modelo.enviarGanador("INSERT INTO jugadores VALUES (null,'"+vista.jugador[ganador]+"',"+modelo.maximaPuntuacion()+");");
				principal.lblMensajeFinPartida.setText("Ganado: ¡¡"+vista.jugador[ganador]+"!!");
				pareja=0;
				principal.finPartida();
				}
				
				}
			}
			
		}
		}
		
		
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{	//pulsamos Jugar
		if (e.getSource().equals(principal.btnJugar))
		{
			principal.setVisible(false);
			principal.menuNombres();
		//Aceptar en Dialogo dlgNombreJugador	
		}else
		if (e.getSource().equals(principal.btnAceptar))
		{
		if (!principal.txtJugador1.getText().equals("")&&!principal.txtJugador1.getText().equals(""))
		{
			vista.jugador[0]=principal.txtJugador1.getText();
			vista.jugador[1]=principal.txtJugador2.getText();
			principal.dlgNombreJugadores.setVisible(false);
			vista.setVisible(true);
		}
		}else
		if (e.getSource().equals(principal.btnTop))
		{
			//mostrar Top10
			modelo.conectar();
			principal.txtTop.setText(modelo.consultarTop10());
			modelo.desconectar();
			principal.menuTop();
		}else
		if (e.getSource().equals(principal.btnSalir)||e.getSource().equals(principal.btnSalirFin))
		{
			System.exit(0);
		}else
		if (e.getSource().equals(principal.btnPartidaNueva))
		{
			
			reiniciarPartida();
			
		}else
		if (e.getSource().equals(principal.btnSalirPartida)) 
		{
			System.exit(0);
		}else
		if (e.getSource().equals(principal.btnSPartidaNueva))
		{
			principal.dlgSalirPartida.setVisible(false);
			reiniciarPartida();
		}else
		if (e.getSource().equals(principal.btnVolverPartida))
		{
			
			principal.dlgSalirPartida.setVisible(false);
		}else
		if (e.getSource().equals(principal.btnVolver))
		{
			principal.dlgTop.setVisible(false);
		}else
		if (e.getSource().equals(principal.btnSalirTop))
		{
			System.exit(0);
		}else
		if (e.getSource().equals(principal.btnComo))
		{
			modelo.ayuda();
		}	
		
			
			
		
	}
	public void reiniciarPartida() {
		//reiniciamos todo
		modelo.reinicioModelo();
		//barajamos
		modelo.barajar();
		//Reinicio Controlador y vista
		for (int i=0;i<12;i++)
		{
			//Quito los bloqueos
			bloqueo[i]=0;
			//reinicio las cartas del tablero "todas boca abajo son de valor 0"
			vista.cartas[i]=0;
		}
		//borro los campos de los nombres
		{
			//reinicio los nombres y los marcadores
			vista.jugador[0]="";
			vista.jugador[1]="";
			vista.puntosJugador[0]=0;
			vista.puntosJugador[1]=0;
			principal.txtJugador1.setText("");
			principal.txtJugador2.setText("");
		}
		vista.repinto();
		principal.dlgMensajeFinPartida.setVisible(false);
		vista.setVisible(false);
		principal.dlgNombreJugadores.setVisible(true);
	}
	@Override
	public void windowClosing(WindowEvent e)
	{
		if (principal.isActive())
		{
		principal.setVisible(false);
		}else
		if (principal.dlgTop.isActive())	
		{
		principal.dlgTop.setVisible(false);	
		}else
		if (principal.dlgSalirPartida.isActive())
		{
		principal.dlgSalirPartida.setVisible(false);
		}else
		if (principal.dlgTop.isActive())
		{
		principal.dlgTop.setVisible(false);
		}else
		if (vista.isActive())
		{
			principal.salirPartida();
		
		}if (principal.dlgNombreJugadores.isActive())
		{
			reiniciarPartida();
			principal.dlgNombreJugadores.setVisible(false);
			principal.setVisible(true);
		}else
		{
			System.exit(0);
		}
	}
}
