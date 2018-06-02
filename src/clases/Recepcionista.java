package clases;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
	
	public int buscarReservaDNI(int dni, Hotel h)
	{
		int rta=-1;
		
		Reserva r;
		Iterator it = h.getReservas().entrySet().iterator();
        while(it.hasNext() && rta==-1) {
            Map.Entry ent = (Map.Entry)it.next();
            r = (Reserva)ent.getValue();
            
            
            for (Pasajero aux:r.getPasajeros())
            {
            	if (aux.getDNI()==dni)
            	{
            		rta=dni;
            		int flag=r.getPasajeros().size();
            		aux=r.getPasajeros().get(flag-1);//esto es para que no siga iterando si no es necesario
            	}
            }
            		
            
        }
		
		return rta;
	}
	
	public boolean checkIn (int idOdni, Hotel h)
	{
		Reserva aux;
		Pasajero auxp;
		ArrayList <Habitacion> auxH=new ArrayList<>();
		boolean rta=false;
		if (!h.getReservas().containsKey(idOdni))//significa que no mandaron una id, sino un dni
		{
			idOdni= buscarReservaDNI(idOdni,h);
		}
		if (idOdni==-1)
		{
			return rta;
		}
		else
		{
			aux=h.getReservas().get(idOdni);
			aux.usar();
			auxp=aux.getPasajeros().get(0);
			auxH=auxp.getUltimoRegistro().getHabitaciones();
			for (Habitacion aux2:auxH)
			{
				aux2.getDisponible().ocupar("usada");
			}
			rta=true;
			return rta;
		}	
	}
	
}
