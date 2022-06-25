package es.studium.memoria;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class MenuPrincipal extends Frame
{

	private static final long serialVersionUID = 1L;
	
	
	Image fondo;
	Toolkit herramientas;
	Button btnJugar = new Button ("    Jugar    ");
	Button btnTop = new Button ("   Top 10   ");
	Button btnComo = new Button (" Instrucciones ");
	Button btnSalir = new Button("   Salir   ");
	
	//Dialogo nombreJugadores
	Dialog dlgNombreJugadores = new Dialog(this, "Introduce Nombres", true);
	Label lblJugador1 = new Label("Nombre Jugador 1");
	TextField txtJugador1 = new TextField (15);
	Label lblJugador2 = new Label("Nombre Jugador 2");
	TextField txtJugador2 = new TextField (15);
	Button btnAceptar = new Button("Aceptar"); 
	
	//Dialogo Top10 
	Dialog dlgTop = new Dialog (this, "Los Top 10", true);
	TextArea txtTop = new TextArea(10,20);
	Button btnVolver = new Button("Volver");
	Button btnSalirTop = new Button("Salir");
	
	//Dialogo Fin de la Partida
	Dialog dlgMensajeFinPartida = new Dialog(this, "Fin Partida", true);
	Label lblMensajeFinPartida = new Label("XXXXXXXXXXXXXXXXX");
	Button btnPartidaNueva = new Button ("Nueva Partida");
	Button btnSalirFin = new Button ("Salir");
	
	//Dialogo Pulsar Salir
		Dialog dlgSalirPartida = new Dialog(this, "Salir?", true);
		Label lblSalirPartida = new Label("¿Quieres salir?");
		Button btnSPartidaNueva = new Button ("Partida Nueva");
		Button btnSalirPartida = new Button ("Salir");
		Button btnVolverPartida = new Button ("Volver");
	
	
	
	public MenuPrincipal()
	{
		herramientas = getToolkit();
		fondo = herramientas.getImage("img/fondo.jpg");		
		this.setLayout(new FlowLayout());
		this.setSize(160,160);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setTitle("Menú Principal");
		this.add(btnJugar);
		this.add(btnTop);
		this.add(btnComo);
		this.add(btnSalir);
		this.setVisible(true);
	}
	public void paint(Graphics g)
	{
		//cargo el fondo
		g.drawImage(fondo, -260, -400, this);
		
	}
	
	public void menuNombres()
	{
		dlgNombreJugadores.setLayout(new FlowLayout());
		dlgNombreJugadores.setSize(200,200);
		dlgNombreJugadores.setLocationRelativeTo(null);
		dlgNombreJugadores.setResizable(false);
		dlgNombreJugadores.add(lblJugador1);
		dlgNombreJugadores.add(txtJugador1);
		dlgNombreJugadores.add(lblJugador2);
		dlgNombreJugadores.add(txtJugador2);
		dlgNombreJugadores.setBackground(Color.CYAN);
		dlgNombreJugadores.add(btnAceptar);
		dlgNombreJugadores.setVisible(true);
		
	}
	
	public void finPartida()
	{
		dlgMensajeFinPartida.setLayout(new FlowLayout());
		dlgMensajeFinPartida.setSize(200,150);
		dlgMensajeFinPartida.setLocationRelativeTo(null);
		dlgMensajeFinPartida.setResizable(false);
		dlgMensajeFinPartida.add(lblMensajeFinPartida);
		dlgMensajeFinPartida.add(btnPartidaNueva);
		dlgMensajeFinPartida.add(btnSalirFin);
		
		dlgMensajeFinPartida.setVisible(true);
	}
	
	public void menuTop()
	{
		dlgTop.setBackground(Color.CYAN);
		dlgTop.setLayout(new FlowLayout());
		dlgTop.setSize(225,275);
		dlgTop.setLocationRelativeTo(null);
		dlgTop.setResizable(false);
		dlgTop.add(txtTop);
		dlgTop.add(btnVolver);
		dlgTop.add(btnSalirTop);
		dlgTop.setVisible(true);
		
	}
	public void salirPartida()
	{
		dlgSalirPartida.setLayout(new FlowLayout());
		dlgSalirPartida.setSize(175,150);
		dlgSalirPartida.setLocationRelativeTo(null);
		dlgSalirPartida.setResizable(false);
		dlgSalirPartida.add(lblSalirPartida);
		dlgSalirPartida.add(btnSPartidaNueva);
		dlgSalirPartida.add(btnSalirPartida);
		dlgSalirPartida.add(btnVolverPartida);
		dlgSalirPartida.setVisible(true);
		
		
		
	}
	

}
