package clases;

public class Disponible {
	
	private boolean disponibilidad;
	private String detalle;
	
	public Disponible() {
		disponibilidad = true;
		detalle = null;
	}

	public void ocupar(String detalleParam) {
		disponibilidad = false;
		detalle = detalleParam;		
	}
	
	public void desocupar() {
		disponibilidad = true;
		detalle = null;
	}
	
	public void setDetalle(String detalleParam){
		detalle = detalleParam;
	}
	
	public String getDetalle() {
		return detalle;
	}
	
	public String getDisponibilidad() {
		if(disponibilidad) {
			return "Disponible";
		}
		else {
			return "Ocupada";
		}
	}
	
	public boolean getDisponi()
	{
		boolean rta=false;
		if (disponibilidad)
		{
			rta=true;
		}
		return rta;
	}
}
