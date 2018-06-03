package clases;

import java.util.ArrayList;

public class Pasajero {

	private String nombre;
    private String apellido;
    private int DNI;
    private String direccion;
    private String telefono;
    private boolean listNegra;
    private ArrayList<Registro> listaRegistro;

    
    public Pasajero(String nomb,String apell,int dni,String direc,String tel)
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

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}
	
	public void setListNegra(boolean a) {
		listNegra = a;
	}
	
	
	
	public ArrayList<Registro> getListaRegistro() {
		return listaRegistro;
	}
	
	public Registro getUltimoRegistro()
	{
		int i=listaRegistro.size();
		return listaRegistro.get(i-1);
	}

	public void setListaRegistro(ArrayList<Registro> listaRegistro) {
		this.listaRegistro = listaRegistro;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Nombre: "+nombre+" \nApellido: "+apellido+"\nDNI: "+DNI+"\nDireccion: "+direccion+"\nTelefono: "+telefono+"\nLista Negra: "+listNegra;
	}
    
	public boolean getListaNegra()
	{
		return listNegra;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + DNI;
//		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
//		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
//		result = prime * result + (listNegra ? 1231 : 1237);
//		result = prime * result + ((listaRegistro == null) ? 0 : listaRegistro.hashCode());
//		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		if (DNI != other.DNI)
			return false;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (listNegra != other.listNegra)
			return false;
		if (listaRegistro == null) {
			if (other.listaRegistro != null)
				return false;
		} else if (!listaRegistro.equals(other.listaRegistro))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
//		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
//		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
//		result = prime * result + (listNegra ? 1231 : 1237);
//		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
//		return result;
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Pasajero other = (Pasajero) obj;
//		if (DNI == null) {
//			if (other.DNI != null)
//				return false;
//		} else if (!DNI.equals(other.DNI))
//			return false;
//		if (apellido == null) {
//			if (other.apellido != null)
//				return false;
//		} else if (!apellido.equals(other.apellido))
//			return false;
//		if (direccion == null) {
//			if (other.direccion != null)
//				return false;
//		} else if (!direccion.equals(other.direccion))
//			return false;
//		if (listNegra != other.listNegra)
//			return false;
//		if (nombre == null) {
//			if (other.nombre != null)
//				return false;
//		} else if (!nombre.equals(other.nombre))
//			return false;
//		if (telefono == null) {
//			if (other.telefono != null)
//				return false;
//		} else if (!telefono.equals(other.telefono))
//			return false;
//		return true;
//	}
	
	


	
}

