package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Usuario {
	
	private String user;
	private String pass;
	
	
	public Usuario(String usuario,String contaseña)
	{
		user=usuario;
		pass=contaseña;
		
	}

	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void habitacionesDisponibles(Date inicio, Date fin,Hotel hotel)
	{
		HashMap <Integer,Habitacion> habitaciones= hotel.getMapHabitacion();
		Habitacion aux;
		Iterator it = habitaciones.entrySet().iterator();
		System.out.println("Habitaciones disponibles");
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			aux=(Habitacion)entry.getValue();
			if(aux.getDispo() && aux.revisarFechas(inicio,fin))
			{
				aux.mostrarHabitacion();
				
			}
		}
		
	}
	
	
}
