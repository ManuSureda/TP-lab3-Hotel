package clases;

public class Pasajero {

	private String nombre;
    private String apellido;
    private String DNI;
    private String direccion;
    private String telefono;
    
    public Pasajero(String nomb,String apell,String dni,String direc,String tel)
    {
    	nombre=nomb;
    	apellido=apell;
    	DNI=dni;
    	direccion=direc;
    	telefono=tel;
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
    
}

