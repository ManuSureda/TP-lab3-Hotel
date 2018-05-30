package clases;

import java.util.ArrayList;
import java.util.Iterator;

public class Loguin {
     
     private ArrayList<Usuario>listaUsuario=new ArrayList<Usuario>();
     private boolean admin=false;
     
	public Loguin()
	{
		
	}
	
	public boolean verificarIngreso(String us,String pas)
	{
       Iterator<Usuario> it = listaUsuario.iterator();
		Usuario aux;
		while(it.hasNext())
		{   aux=it.next();
		   
			if(us.equals(aux.getUser()) && pas.equals(aux.getPass()))
			{   if(aux instanceof Administrador)
				{
			       admin=true;
				}	
				
			
				return true;
			}
		}
		

		return false;
	}
    public void addUsuario(Usuario user)
    {
    	listaUsuario.add(user);
    }
	public void verUsuarioRegistrados()
	{
		Iterator<Usuario> it = listaUsuario.iterator();
		Usuario aux;
		while(it.hasNext())
		{   aux=it.next();
			System.out.println(aux.getUser());
		}
	}
	
	public void registro(String usuario,String pas,String nombre,String apellido,String direc,String tel,String dni)
	{
		Cliente aux=new Cliente(usuario,pas,nombre,apellido,dni,direc,tel);
		addUsuario(aux);
	}
	public boolean verificarUsuario(String use)
	{
		Iterator<Usuario> it = listaUsuario.iterator();
		Usuario aux;
		while(it.hasNext())
		{   aux=it.next();
			if(use.equals(aux.getUser()))
				
				return true;
		}
		return false;
	}
	
	public boolean verificarAdm()
	{
		if(admin == true)
		{
			return true;
		}
		return false;
	}
	public void eliminar(Usuario user)
	{
		listaUsuario.remove(user);
	}
	
	public Usuario buscarUser(String nombre)
	{
		Iterator<Usuario> it = listaUsuario.iterator();
		Usuario aux=null;
		while(it.hasNext())
		{   aux=it.next();
			if(nombre.equals(aux.getUser()))
				return aux;
			else
			{
				aux=null;
			}
		}
		return aux;
	}
}
