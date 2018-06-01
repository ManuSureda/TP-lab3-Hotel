package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hotel {
	private String nombre;
	private String direccion; 
	private Empleado recepcionista;
	private ArrayList<Reserva> reservasNuevas;
	private ArrayList<Reserva> reservasViejas;  
	private HashMap<Integer,Habitacion> habitaciones; 
	private ArrayList<Pasajero> registroPasajeros; 
	
	
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Hotel() 
	{
		
	}

	public void addHabitacion(Habitacion h)
	{
		habitaciones.put(h.getNumero(), h);
	}
	
	public void mostrarHotel()
	{
		System.out.println("--------------");
		System.out.println("Nombre: "+nombre);
		System.out.println("Direccion: "+direccion);
		System.out.println("--------------");
	}
	
	public void mostrarDisponibles()
	{
		for (Entry<Integer, Habitacion> entry : habitaciones.entrySet()) {
		    if (entry.getValue().getDispo())
		    {
		    	entry.getValue().mostrarHabitacion();
		    }
		}
	}

	public void mostrarNoDisponibles()
	{
		for (Entry<Integer, Habitacion> entry : habitaciones.entrySet()) {
		    if (!entry.getValue().getDispo())
		    {
		    	entry.getValue().mostrarHabitacion();
		    }
		}
	}

	public boolean revisarListaNegra(Pasajero p)
	{
		return p.getListaNegra();
	}

	public int cambiarCostos(int numHabitacion, double nuevoCosto)
	{
		int rta=1;
		if (habitaciones.containsKey(numHabitacion))
		{
			habitaciones.get(numHabitacion).setCosto(nuevoCosto);
		}
		else
		{
			rta=0;//si devuelve 0 quiere decir que el num de habitacion ingresado es incorrecto y deven ingresar otro numero
		}
		return rta;
		
	}

	public void verReservaNueva(Pasajero p)
	{
		
		for (Reserva aux:reservasNuevas)
		{
			if (aux.buscarPasajero(p))
			{
				aux.mostrarReserva();
			}
		}
	}
	
	public void verReservaVieja(Pasajero p)
	{
		for (Reserva aux:reservasViejas)
		{
			if (aux.buscarPasajero(p))
			{
				aux.mostrarReserva();
			}
		}
	}
	
	public HashMap getMapHabitacion()
	{
		return habitaciones;
	}


}
