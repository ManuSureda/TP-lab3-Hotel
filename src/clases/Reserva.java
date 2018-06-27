package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Reserva implements Serializable{
	private ArrayList<Pasajero> pasajeros;
	private double costo; 
	private boolean usada; 
	private int id;//tambien puede ser por dni
	private static int cantId;
	private HashMap <Integer,Fechas> fechas=new HashMap();
	private HashMap <Integer,ArrayList>hab=new HashMap();
	
	public Reserva(ArrayList<Pasajero> pasajeros, double costo) 
	{
		this.pasajeros = pasajeros;
		this.costo = costo;
		usada = false;
		id = cantId+1;
		cantId++;
	}
	public Fechas devolverFecha(int a)
	{
		return fechas.get(a);
	}
	public ArrayList devolverHab(int a)
	{	
		
		ArrayList<Integer>num;
		num=hab.get(a);
				
		return num;
	}
	public void agregarHyF(int key,Fechas fecha,ArrayList habi)
	{
		fechas.put(key,fecha);
		hab.put(key,habi);
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
	
	

	
	public void mostrarReserva() {
		System.out.println("Reserva: "+id);
		System.out.println("Costo: "+costo);
		if (usada==true)
			System.out.println("Esta reserva ya fue utilizada");
		else
			System.out.println("Esta reserva aun no fue utilizada");
		for (Pasajero aux:pasajeros)
		{
			System.out.println(aux.toString());
		}
	}
	
	
	
//	public void mostrarReserva()
//	{
//		//System.out.println("-----------------");
//		for (Pasajero aux:pasajeros)
//		{
//			aux.toString();
//		}
//	}
//	
	
}
