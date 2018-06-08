package app;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

import clases.Administrador;
import clases.Habitacion;
import clases.Hotel;
import clases.Loguin;
import clases.Pasajero;
import clases.Recepcionista;
import clases.Reserva;

public class Main {

	public static void main(String[] args) {

		HashMap <Integer,Habitacion>habitaciones=new HashMap<>();
		HashMap <Integer,Reserva>reserva=new HashMap();
		ArrayList<Pasajero>pasajeros=new ArrayList();
		Habitacion h1=new Habitacion(1,4,1500);
		Habitacion h2=new Habitacion(2,3,1300);
		Habitacion h3=new Habitacion(3,2,1200);
		Date f1=new Date(2018,5,1);
		Date f2=new Date(2018,5,5);
		Recepcionista aux=new Recepcionista("aux","asd");
		Pasajero p1=new Pasajero("maxi","morales",41669179,"manita123","tuvieja");
		Loguin log=new Loguin();
		Hotel hotelin=new Hotel("Hotel","Asd 123",aux,reserva,habitaciones,pasajeros);
		habitaciones.put(h1.getNumero(), h1);
		habitaciones.put(h2.getNumero(), h2);
		habitaciones.put(h3.getNumero(), h3);
		pasajeros.add(p1);
		aux.reservar(hotelin,log);
		hotelin.mostrarReservas();
        aux.habitacionesDisponibles(f1, f2, hotelin);
		Scanner sc=new Scanner(System.in);
		sc.close();
		


	}

}
