package clases;

import java.util.ArrayList;

public class Pasajero {

	private String nombre;
    private String apellido;
    private String DNI;
    private String direccion;
    private String telefono;
    private boolean listNegra;
    private ArrayList<Registro> listaRegistro;
    
    public Pasajero(String nomb,String apell,String dni,String direc,String tel)
    {
    	nombre=nomb;
    	apellido=apell;
    	DNI=dni;
    	direccion=direc;
    	telefono=tel;
    	listaRegistro = new ArrayList<Registro>();
    	listNegra = false;
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}
	
	public void setListNegra(boolean a) {
		listNegra = a;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre+" \nApellido: "+apellido+"\nDNI: "+DNI+"\nDireccion: "+direccion+"\nTelefono: "+telefono;
	}
    
}

