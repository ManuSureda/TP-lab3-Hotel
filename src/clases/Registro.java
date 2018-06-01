package clases;

import java.util.ArrayList;

public class Registro {
	private ArrayList<Habitacion> habitaciones;
	private Fechas fechas; 
	
	public Registro()
	{
	
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Fechas getFechas() {
		return fechas;
	}

	public void setFechas(Fechas fechas) {
		this.fechas = fechas;
	}
	
	
	
}
