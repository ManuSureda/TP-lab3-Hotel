package clases;

import java.util.ArrayList;

public class Reserva {
	private ArrayList<Pasajero> pasajeros;
	private double costo; 
	private boolean usada; 
	private int id;
	private static int cantId;
	
	public Reserva(ArrayList<Pasajero> pasajeros, double costo, boolean usada) 
	{
		this.pasajeros = pasajeros;
		this.costo = costo;
		this.usada = usada;
		this.id = cantId+1;
		cantId++;
	}

	
	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}



	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}



	public double getCosto() {
		return costo;
	}



	public void setCosto(double costo) {
		this.costo = costo;
	}



	public boolean isUsada() {
		return usada;
	}



	public void setUsada() {
		usada=true;
	}



	public int getId() {
		return id;
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
