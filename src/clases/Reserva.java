package clases;

import java.util.ArrayList;

public class Reserva {
	private ArrayList<Pasajero> pasajeros;
	private double costo; 
	private boolean usada; 
	
	public Reserva()
	{
		
	}
	
	public boolean buscarPasajero(Pasajero p)
	{
		boolean rta=false;
		for (Pasajero aux:pasajeros)
		{
			if (aux.equals(p))
			{
				rta=true;
			}
		}
		return rta;
	}
	
	public void mostrarReserva()
	{
		System.out.println("-----------------");
		for (Pasajero aux:pasajeros)
		{
			aux.toString();
		}
	}
}
