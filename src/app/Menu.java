package app;

import java.util.Date;
import java.util.Scanner;
import clases.Administrador;
import clases.Cliente;
import clases.Loguin;
import clases.Pasajero;

public class Menu {

	private String us,pas,nombre,apellido,direc,telefono;
	private int dni;
	private static int variable =0;
    private char x;
    private Loguin logueo=new Loguin();
    Pasajero p=new Pasajero("carlos","montiel",23223223,"montana 581","4810202");
    private Cliente asd =new Cliente("asd","asd",p);
    private Administrador maxi=new Administrador("admin","admin");
    private Scanner scan=new Scanner(System.in);
    
    public Menu()
    {
    	
    }
    public void harcodeados()
    {
    	 logueo.addUsuario(maxi);
    	 logueo.addUsuario(asd);
    }
    public void registroManual()
    {
    	 System.out.print("Ingrese su nombre de usuario: ");
		 us=null;
    	 us=scan.next();
		  boolean vof=logueo.verificarUsuario(us);
		  if(vof)
		  {
			  System.out.print("El usuario ya existe, intente nuevamente: ");
			  us=scan.nextLine();
			  vof=logueo.verificarUsuario(us);  
		  }
		  else
		  {
			  System.out.print("Ingrese su password: ");
			  pas=scan.next();
			  System.out.print("Ingrese su Nombre: ");
			  nombre=scan.next();
			  System.out.print("Ingrese su Apellido: ");
			  apellido=scan.next();
			  System.out.print("Ingrese su DNI: ");
			  dni=scan.nextInt();
			  System.out.print("Ingrese su direccion: ");
			  direc=scan.next();
			  System.out.print("Ingrese su telefono: ");
			  telefono=scan.next();
			  
			  /*add exceptions*/
			  
			  logueo.registro(us, pas, nombre, apellido, dni, direc,telefono);
			  
			  
			  
		  }
    	
    }
    
    public void ingreso()
    {
    	 System.out.print("Ingrese su usuario: ");
			us=scan.next();
			System.out.print("Ingrese su Contraseña: ");
			pas=scan.next();
			if(logueo.verificarIngreso(us, pas) == true)
			{
				if(logueo.verificarAdm()==true)
				{
					switchAdmin();
					
				}
				System.out.println("{Ingreso al sistema correctamente ACA VA EL MENU DE ACCION DE Hotel}");
			
				
			}
			else
			{
				System.out.println("Error, intente nuevamente");
				
			}
			variable=0;
    }
    public void Switch()
    {   harcodeados();
    	System.out.println("Bienvenido al Hotel Olimpia");
    	System.out.print("1- Registro de usuario.\n2- Ingresar al Sistema.\n3- Salir\n\nIngrese su opcion:");
        variable=scan.nextInt();
    	while(variable!=-1)
    	{   
    	
    		switch(variable)
    		{ 
    		
    		  case 1:
    			 registroManual();
    			  break;
    		  case 2:
    			   ingreso();
    				break;	
    		 case 3: 
    			 System.out.println("Gracias por haber vistado el Hotel Olimpia!");
    			  variable=-1;
    				
    		}
    			
    	}
    }
    
    public void switchAdmin()
    {   int aux=0;
    	System.out.print("\tMENU ADMINISTRADOR\n1- Eliminar un usuario\n2-Menu comun\nElija su opcion: ");
        aux=scan.nextInt();
    	while(aux!=-1)
    	{   
    	
    		switch(aux)
    		{ 
    		
    		  case 1:
    			 admElimina();
    			  break;
    		  case 2:
    			   aux=-1;
    				break;	
    		 case 3: 
    			
    			  variable=-1;
    				
    		}
    			
    	}
    }
    public void admElimina()
    {
    	String nombre;
    	System.out.print("Ingrese el nombre del usuario a eliminar:");
    	nombre=scan.next();
    	maxi.eliminarUsuario(nombre,logueo);
    }
	
    
    
    	
    
	
}
