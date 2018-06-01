package clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hotel {
	private String nombre;
	private String direccion; 
	private Recepcionista recepcionista;
	private HashMap<Integer,Reserva> reservas;
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

	

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	public HashMap<Integer,Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(HashMap<Integer,Reserva> reservas) {
		this.reservas = reservas;
	}

	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(HashMap<Integer, Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public ArrayList<Pasajero> getRegistroPasajeros() {
		return registroPasajeros;
	}

	public void setRegistroPasajeros(ArrayList<Pasajero> registroPasajeros) {
		this.registroPasajeros = registroPasajeros;
	}

	public Hotel(String nombre, String direccion, Recepcionista recepcionista, HashMap<Integer,Reserva> reservas,
			HashMap<Integer, Habitacion> habitaciones, ArrayList<Pasajero> registroPasajeros) {
		
		this.nombre = nombre;
		this.direccion = direccion;
		this.recepcionista = recepcionista;
		this.reservas = reservas;
		this.habitaciones = habitaciones;
		this.registroPasajeros = registroPasajeros;
	}

	public void addHabitacion(Habitacion h)
	{
		habitaciones.put(h.getNumero(), h);
	}
	
	public String mostrarHotel()
	{
		return nombre+"\nDireccion: "+direccion;
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

	

}
