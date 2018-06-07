package clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Usuario implements Serializable{

	private String user;
	private String pass;


	public Usuario(String usuario,String contaseņa)
	{
		user=usuario;
		pass=contaseņa;

	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void habitacionesDisponibles(Date inicio, Date fin,Hotel hotel)
	{
		HashMap <Integer,Habitacion> habitaciones= hotel.getMapHabitacion();
		Habitacion aux;
		Iterator it = habitaciones.entrySet().iterator();
		System.out.println("Habitaciones disponibles");
		while(it.hasNext())
		{
			Map.Entry entry=(Map.Entry)it.next();
			aux=(Habitacion)entry.getValue();
			if(aux.getDispo() && aux.revisarFechas(inicio,fin))
			{
				aux.mostrarHabitacion();

			}
		}

	}

	public Pasajero buscarPorDni(Hotel hotel,int dni)
	{
		Pasajero aux=null;
		ArrayList <Pasajero>pasajeros=hotel.getRegistroPasajeros();
		Iterator it=pasajeros.iterator();
		while(it.hasNext())
		{
			aux=(Pasajero) it.next();
			if(dni==aux.getDNI())
			{
				return aux;
			}
		}
		return null;
	}

	public ArrayList<Pasajero> cargarPasajero(int cantPasajeros, Hotel h,Loguin l)
	{
		ArrayList<Pasajero> rta=new ArrayList<>();
		int i=0;
		char flag='s';
		Scanner sc= new Scanner(System.in);
		System.out.println("Algun pasajero ya se encuentra registrado? (s/n): ");

		// agregar un exeption, para que no meta cualquier cosa como un int
		flag=sc.next().charAt(0);
		Pasajero p;

		char flag2='n';

		while (i<cantPasajeros)
		{
			if (flag=='s')
			{
				System.out.println("Ingrese el DNI del usuario: ");
				int dni=sc.nextInt();
				p=buscarPorDni(h,dni);
			}
			else 
			{
				System.out.println("Ingrese su nombre: ");
				String n=sc.next();
				System.out.println("Ingrese su apellido: ");
				String apellido= sc.next();
				System.out.println("Ingrese su DNI: ");
				int DNI= sc.nextInt();// crear un metodo para ver que no meta un dni incorrecto
				System.out.println("Ingrese su direccion: "); 
				String direccion=sc.next();
				System.out.println("Ingrese su telefono: ");
				String telefono=sc.next();
				p= new Pasajero(n,apellido,DNI,direccion,telefono);

				System.out.println("Desea registrarse como usuario? (s/n): ");
				flag2=sc.next().charAt(0);
				if (flag2=='s' || flag2=='S')
				{
					System.out.println("Ingrese un nombre de usuario: ");
					String name=sc.next();
					System.out.println("Ingrese su contraseņa: ");
					String pass=sc.next();

					Usuario u= new Cliente(name, pass, p);
					l.addUsuario(u);
				}
			}


			rta.add(p);

			System.out.println("Existe otro pasajero ya registrado? (s/n): ");
			flag=sc.next().charAt(0);

			i++;
		}

		System.out.println("Gracias por elegirnos :) ");
		
		return rta;
	}

//	public double calcularCosto(ArrayList<Integer> hab,Hotel h)
//	{
//		double rta=0;
//
//		if (hab!=null)
//		{
//			int i=0;
//			while (i<hab.size())//revisar si no tiene que tener un -1
//			{
//				rta+=h.getHabitaciones().get(i).getCosto();
//			}
//		}
//		return rta;
//	}
	
	
	public double calcularCostoTotal(ArrayList<Integer> hab,Hotel h,Date ini,Date fin)
    {   double rta=0;
        if (hab!=null)
        {
          
            for (int i:hab)//revisar si no tiene que tener un -1
            {
                rta+=h.getHabitaciones().get(i).getCosto();
                
            }
        }
        long startTime = ini.getTime();
        long endTime = fin.getTime();
        long diffTime = endTime - startTime;
        return (double)(TimeUnit.DAYS.convert(diffTime, TimeUnit.MILLISECONDS) * rta);
   }
	public void ingresoFechasEstadia(Fechas f,int din,int dout,int min,int mout,int yin,int yout)
    {
       
        int dia,mes,anio=0;
        Date preFecha;
        preFecha=new Date(yin,min,din);
        f.setFechaIn(preFecha);
        preFecha=new Date(yout,mout,dout);
        f.setFechaOut(preFecha);
    }

	public void reservar(Hotel h, Loguin l)
	{
		Reserva r;
		Scanner sc= new Scanner(System.in);
		System.out.println("Ingrese la cantidad de pasajeros: ");
		int cantPas=sc.nextInt();
		ArrayList<Pasajero> listaPasajeros=new ArrayList<>();
		listaPasajeros=cargarPasajero(cantPas, h, l);
		
		Fechas f = new Fechas();
		
		ingresoFechasEstadia(f,1,4,5,5,2018,2018);

		System.out.println("Habitaciones disponibles: ");
		ArrayList<Integer> listaDeHabitaciones=new ArrayList<>();
		listaDeHabitaciones=h.mostrarHabitacionDisponibles(f,cantPas);

		double costo=0;
		char confirmacion='n';
		ArrayList<Integer> listaDeHabitaciones2=new ArrayList<>();
		if (listaDeHabitaciones!=null)
		{

			char control;
			System.out.println("Elija las habitaciones que desea ocupar (una por una): ");
			int cantAux=0;
			Integer hab;
			hab=sc.nextInt();
			cantAux+=h.getHabitaciones().get(hab).getCapacidad();
			listaDeHabitaciones2.add(hab);
			System.out.println("Desea contratar otra habitacion? (s/n): ");
			control=sc.next().charAt(0);
			boolean flag =false;
			while (control=='s' && flag!=true)
			{
				if (control=='n' && cantAux<cantPas)
				{
					System.out.println("La capacidad de las habitaciones seleccionadas no es suficiente para la cantidad de pasajeros.");
					System.out.println("Por favor, seleccione otra habitacion o anule la reserva");
					System.out.println("\nDesea contratar otra habitacion? (s/n): ");
					control=sc.next().charAt(0);
					if (control=='n')
					{
						return;
					}
				}
				if (control=='s')
				{
					hab=sc.nextInt();
					listaDeHabitaciones2.add(hab);
					System.out.println("Desea contratar otra habitacion? (s/n): ");
					control=sc.next().charAt(0);
				}

				if (cantAux>=cantPas)
				{
					flag=true;
				}


			}

		}
		if (listaDeHabitaciones2!=null)
		{
			costo=calcularCostoTotal(listaDeHabitaciones2,h,f.getFechaInDate(),f.getFechaOutDate());
			System.out.println("El costo total seria de unos $: "+costo);


		}
		System.out.println("Desea confirmar la operacion? (s/n): ");
		confirmacion=sc.next().charAt(0);
		//sc.close();
		if (confirmacion=='s')
		{
			r= new Reserva(listaPasajeros,costo);
			h.addReserva(r);
		}
		
	}


	//	
	//	
	//	
	//	public void reservar(Hotel h, Loguin l)
	//	{
	//		Reserva r;
	//		Scanner sc= new Scanner(System.in);
	//		System.out.println("Ingrese la cantidad de pasajeros: ");
	//		int cantPas=sc.nextInt();
	//		ArrayList<Pasajero> listaPasajeros=new ArrayList<>();
	//		listaPasajeros=cargarPasajero(cantPas, h, l);
	//		Date in,out;
	//		int dayIn,monthIn,yearIn;
	//		int dayOut,monthOut,yearOut;
	//		Scanner scan = new Scanner(System.in);
	//		
	//		System.out.print("Dia de ingreso: ");
	//		dayIn = scan.nextInt();
	//		System.out.print("Mes de ingreso: ");
	//		monthIn = scan.nextInt();
	//		System.out.print("Year de ingreso: ");
	//		yearIn = scan.nextInt();
	//		 in = new Date(dayIn,monthIn,yearIn);
	//		
	//		System.out.print("Dia de salida: ");
	//		dayOut = scan.nextInt();
	//		System.out.print("Mes de salida: ");
	//		monthOut = scan.nextInt();
	//		System.out.print("Year de salida: ");
	//		yearOut = scan.nextInt();
	//		out = new Date(dayOut,monthOut,yearOut);
	//		
	//		Fechas f = new Fechas(in,out);
	//		
	//		System.out.println("Habitaciones disponibles: ");
	//		ArrayList<Integer> listaDeHabitaciones=new ArrayList<>();
	//		listaDeHabitaciones=h.mostrarHabitacionDisponibles(f,cantPas);
	//		
	//		double costo=0;
	//		char confirmacion='n';
	//		if (listaDeHabitaciones!=null)
	//		{
	//			ArrayList<Integer> listaDeHabitaciones2=new ArrayList<>();
	//			char control;
	//			System.out.println("Elija las habitaciones que desea ocupar (una por una): ");
	//			int cantAux=0;
	//			Integer hab;
	//			while (cantAux<cantPas)
	//			{
	//				hab=sc.nextInt();
	//				cantAux+=h.getHabitaciones().get(hab).getCapacidad();
	//				listaDeHabitaciones2.add(hab);
	//			}
	//			System.out.println("Desea contratar otra habitacion? (s/n): ");
	//			control=sc.next().charAt(0);
	//			while (control=='s')
	//			{
	//				hab=sc.nextInt();
	//				
	//				listaDeHabitaciones2.add(hab);
	//				System.out.println("Desea contratar otra habitacion? (s/n): ");
	//				control=sc.next().charAt(0);
	//			}
	//			
	//			if (listaDeHabitaciones2!=null)
	//			{
	//				costo=calcularCosto(listaDeHabitaciones2,h);
	//				System.out.println("El costo total seria de: $ "+costo);
	//				System.out.println("Desea confirmar la operacion? (s/n): ");
	//				confirmacion=sc.next().charAt(0);
	//			}
	//			
	//			
	//		}
	//		
	//		if (confirmacion=='s')
	//		{
	//			r= new Reserva(listaPasajeros,costo);
	//			h.addReserva(r);
	//		}
	//		
	//		
	//		
	//	}

}
