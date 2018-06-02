package clases;

public class Cliente extends Usuario {
	  Pasajero pasajero; 
      public Cliente(String usuario, String pass,Pasajero p)
      {
    	  super(usuario,pass);
    	  pasajero=p;
      }
      
	
}
