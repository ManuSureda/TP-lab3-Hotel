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
	  if(aux!=null)
	  {
		 log.eliminar(aux);
		 System.out.println("El ususario ha sido eliminado");
	  }
	  else if(aux==null)
	  {
		  System.out.println("El usuario no existe");
	  }
	 
	}
	
}
