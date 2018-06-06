package clases;

import java.io.Serializable;
import java.util.ArrayList;

public class Reserva implements Serializable{
	private ArrayList<Pasajero> pasajeros;
	private double costo; 
	private boolean usada; 
	private int id;//tambien puede ser por dni
	private static int cantId;
	
	public Reserva(ArrayList<Pasajero> pasajeros, double costo) 
	{
		this.pasajeros = pasajeros;
		this.costo = costo;
		usada = false;
		id = cantId+1;
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



	public void usar() {
		usada=true;
	}

	public boolean getUsada()
	{
		return usada;
	}

	public static int getCantId() {
		return cantId;
	}

	public static void setCantId(int cantId) {
		Reserva.cantId = cantId;
	}

	public void setUsada(boolean usada) {
		this.usada = usada;
	}

	public void setId(int id) {
		this.id = id;
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
		//System.out.println("-----------------");
		for (Pasajero aux:pasajeros)
		{
			aux.toString();
		}
	}
	
	
}
