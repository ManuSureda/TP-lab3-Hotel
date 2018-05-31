package clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import clases.Disponible;
import clases.Fechas;

public class Habitacion {
	private int numero;
	private int capacidad;
	private Disponible disponible;
	private ArrayList<Fechas> fechasOcupacion;
	private double costo;
	
	
	public Habitacion(int numeroParam, int capacidadParam, double costoParam) {
		
		numero = numeroParam;
		capacidad = capacidadParam;
		costo = costoParam;
		disponible = new Disponible();
		fechasOcupacion = new ArrayList<Fechas>();
	}
	
	public void mostrarHabitacion() {
		
		System.out.println("Numero de habitacion: "+numero);
		System.out.println("Capacidad de la habitacion: "+capacidad);
		System.out.println("Estado: "+disponible.getDisponibilidad());
		System.out.println("Costo por noche: $"+costo);
		System.out.println("Fechas ocupadas: ");
		
		Iterator<Fechas> it = fechasOcupacion.iterator();
		while(it.hasNext()) {
			Fechas fechita = it.next();
			System.out.println("                "+fechita.getFechaIn()+" al " +fechita.getFechaOut());			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void addOcupacion(int diaIn, int mesIn, int diaOut, int mesOut) {
		
		Date in = new Date(2018,mesIn, diaIn);
		Date out = new Date(2018,mesOut,diaOut);
		Fechas fechita = new Fechas(in, out);
		fechasOcupacion.add(fechita);
	}
	
	public boolean revisarFechas (Date e) {
		
		
		return false;
		
	}

}