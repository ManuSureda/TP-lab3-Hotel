package clases;

public class Cliente extends Usuario {
      String nombre,apellido,dni,telefono,direccion;
	  Pasajero pasajero=new Pasajero(nombre,apellido,dni,direccion,telefono);
	        
      
      
      public Cliente(String usuario,String pass,String nombre,String apellido,String dni,String direccion,String telefono)
      {
    	  super(usuario,pass);
    	  this.nombre=nombre;
    	  this.apellido=apellido;
    	  this.dni=dni;
    	  this.telefono=telefono;
      }
	
}
