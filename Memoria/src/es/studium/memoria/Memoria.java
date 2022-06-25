package es.studium.memoria;

public class Memoria {

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Modelo modelo =new Modelo();
		new Controlador (vista, modelo);

	}

}
