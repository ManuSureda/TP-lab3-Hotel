package clases;

import java.io.Serializable;

public class Cliente extends Usuario implements Serializable{
	  Pasajero pasajero; 
      public Cliente(String usuario, String pass,Pasajero p)
      {
    	  super(usuario,pass);
    	  pasajero=p;
      }
	
      
	
}
