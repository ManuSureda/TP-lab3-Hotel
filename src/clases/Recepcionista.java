package clases;

import java.util.ArrayList;

public class Recepcionista extends Usuario {

	public Recepcionista(String usuario, String contaseña) 
	{
		super(usuario, contaseña);
	}

	public Reserva buscarReservaId(int id, Hotel h)
	{
		if (!h.getReservas().containsKey(id))
		{
			return null;
		}
		else
		return h.getReservas().get(id);
	}
	
	public Reserva buscarReservaDNI(int dni, Hotel h)
	{
		if (!h.getReservas().containsKey(dni))
		{
			return null;
		}
		else
		return h.getReservas().get(dni);
	}
	
	public void checkIn (int dni, Hotel h)
	{
		Reserva aux;
		Pasajero auxp;
		ArrayList <Habitacion> auxH=new ArrayList<>();
		if (h.getReservas().containsKey(dni))
		{
			aux=buscarReservaDNI(dni,h);
			aux.setUsada();
			auxp=aux.getPasajeros().get(0);
			auxH=auxp.getUltimoRegistro().getHabitaciones();
			for (Habitacion aux2:auxH)
			{
				aux2.getDisponible().ocupar("usada");
			}
		}
		
	}
	
}
