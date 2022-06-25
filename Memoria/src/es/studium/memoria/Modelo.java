package es.studium.memoria;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;



//este se va a encargar de repartir las cartas en la matriz
//enviará las posiciones de cada carta
public class Modelo
{
	//Conexión base de Datos
	//Debemos de cambiar el usuario, no usar root
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/juego";
	String login = "root";
	String password = "Studium2020.,";
	String sentencia = "" ;
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;
	int[] cartas = {0,1,1,2,2,3,3,4,4,5,5,6,6};
	int[] existe= {0,1,1,2,2,3,3,4,4,5,5,6,6};
	int[] marcador = new int[2];
	int index=0;
	Random rnd = new Random();
	
	
	public Modelo()
	{
		
	}
	public void reinicioModelo()
	{
		int[] cartasRepuesto = {0,1,1,2,2,3,3,4,4,5,5,6,6};
		for (int i=0;i<=12;i++)
		{
			cartas[i]=cartasRepuesto[i];
			existe[i]=cartasRepuesto[i];
		}
		
	}
	
	//Conexión Base de Datos
	public void conectar()
	{
		try
		{
			// Cargar los controladores para el acceso a la BD
			Class.forName(driver);
			// Establecer la conexión con la BD Empresa
			connection = DriverManager.getConnection(url, login, password);
			System.out.println("Conexión establecida");
			
		}
		catch (ClassNotFoundException cnfe)
		{
			
		}
		catch (SQLException sqle)
		{
		
		}
			
	}
	
	//Función donde enviaremos la sentencia de inserción
	public void  altaBaseDatos(String s)
	{
		
		try
		{
			// Usa un objeto de la clase Connection el cual hemos llamado connection
			statement = connection.createStatement();
			//ejecutamos un INSERT
			statement.executeUpdate(s);
			
		}
		catch (SQLException sqle)
		{
		
		}
	
		
	
	}
	////Baja Base de Datos
	public void desconectar()
	{
		try
		{
			if(connection!=null)
			{
				connection.close();
				System.out.println("Desconectado correctamente");
			}
		}
		catch (SQLException e)
		{
		
		}	
	}
	
	//Función para realizar la consulta Top10
	public String consultarTop10()
	{
		int i=1;
		String contenido="-Puesto-Nombre-Puntos";
		try
		{
			// Usa un objeto de la clase Connection el cual hemos llamado connection
			statement = connection.createStatement();
			// Crear un objeto ResultSet para guardar lo obtenido
			// y ejecutar la sentencia SQL
			// variable especial para guardar las consultas a nuestra base de datos
			// el método next nos permite pasar de elemento a elemento de nuestro RedultSet
			rs = statement.executeQuery("SELECT * FROM jugadores ORDER BY puntosJugador DESC LIMIT 10;");
			while (rs.next())
			{
				
				contenido=contenido +"\n" +"***"+(i++)+"\t"+ (rs.getString("nombreJugador")+ "\t" +
						rs.getInt("puntosJugador"));
				
			}
		}
			catch (SQLException sqle)
			{
				System.out.println("Error 4-"+sqle.getMessage());
			}
			return contenido;
	}
	
	
	//Función para barajar las cartas
	
	public void barajar ()
	{
	//intercambio de forma aleatoria la posiciones de las cartas
	for (int i=1;i<13;i++)
	{
			//a través del do-while asigno un índice válido para asignar una nueva posición
			do
			{
			index= rnd.nextInt(12)+1;
			}while (existe[index]==0);
		//con ese índice asigno la carta y borro la carta del vector existe para saber que ya ha sido asignada a otro lugar	
		cartas[i]=existe[index];
		existe[index]=0;	
	}
	//para pruebas	
	//int[] cartas= {0,2,4,5,2,3,4,3,6,5,1,1,6};
	
	}
	public int cartaAsignada (int pos)
	{
		return cartas[pos];
	}
	
	public void espera ()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void aumentarMarcador (int turno)
	{
		turno--;
		marcador[turno]++;
	}
	
	
	//devuelve el ganador
	public int ganador()
	{
		
		
		if (marcador[0]<marcador[1])
		{
			
			return(1);
		}else
		if (marcador[0]>marcador[1])
		{
			return(0);
		}else
		{
			return(-1);
		}	
		
		
	}
	
	//devuelve la cantidad de puntos del jugador ganador
	public int maximaPuntuacion()
	{
		int puntos=marcador[(ganador())];
		return puntos;
	}
	
	
	
	public void enviarGanador(String ganador)
	{
		conectar();
		altaBaseDatos(ganador);
		desconectar();
	}
	
	public void ayuda()
	{
		try 
		{
			Runtime.getRuntime().exec("hh.exe ayuda.chm");
		}
		catch (IOException e)
		{
		 e.printStackTrace();	
		}	
	}
	
	
	
	
}

