package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Hotel implements Serializable{
	private String nombre;
	private String direccion; 
	private Recepcionista recepcionista;
	private HashMap<Integer,Reserva> reservas;
	private HashMap<Integer,Habitacion> habitaciones; 
	private ArrayList<Pasajero> registroPasajeros; 	

	
	
	public void eliminarReserva(int a)
	{
		reservas.remove(a);
	}
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
	public void addReserva(Reserva r)
	{
		reservas.put(r.getId(), r);
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


	public HashMap getMapHabitacion()
	{
		return habitaciones;
	}


	public ArrayList<Integer> mostrarHabitacionDisponibles(Fechas f, int cant) //va a devolver los numeros de las habitaciones que esten disponibles
	{
		ArrayList<Integer> rta=new ArrayList<>();
		boolean flag=false;
		int cantAux=0;

		for (Entry<Integer, Habitacion> entry : habitaciones.entrySet()) // deveriamos cambiarlo por un while
		{
			if(entry.getValue().revisarFechas(f.getFechaInDate(), f.getFechaOutDate()) && cantAux<cant) 
			{

				cantAux+=entry.getValue().getCapacidad();

			}
			if (cantAux>=cant)
			{
				flag=true;
			}
		}

		if (flag)
		{
			for (Entry<Integer, Habitacion> entry : habitaciones.entrySet()) 
			{
				if(entry.getValue().revisarFechas(f.getFechaInDate(), f.getFechaOutDate())) 
				{
					entry.getValue().mostrarHabitacion();
					rta.add(entry.getValue().getNumero());
				}
			}
			return rta;
		}
		else
			System.out.println("Lo sentimos, pero no hay suficiente espacio en el hotel.");
			return null;
	}
	
	public void mostrarReservas()
	{
		Iterator it= reservas.entrySet().iterator();
		Reserva aux;
		while (it.hasNext())
		{
			
			Map.Entry entry = (Map.Entry)it.next();
			aux=(Reserva)entry.getValue();
			aux.mostrarReserva();
		}
			
	}
}
