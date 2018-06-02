package clases;

import java.util.ArrayList;

public class Administrador extends Usuario{

	public Administrador(String usuario, String contaseña) 
	{
		super(usuario, contaseña);
		
	}
    
	public void eliminarUsuario(String name,Loguin log)
	{
	  Usuario aux=log.buscarUser(name);
	  if(aux!=null )
	  { 	 if(aux instanceof Recepcionista)
		  	  {
			  	log.eliminar(aux);
				 System.out.println("El empleado fue eliminado");
		  	  }
			  else if(aux instanceof Cliente)
			  {	
				  log.eliminar(aux);
				  System.out.println("El Cliente fue eliminado");	  
			  }
	  }
	  else if(aux==null)
	  {
		  System.out.println("El usuario no existe");
	  }
	 
	}
	
}
