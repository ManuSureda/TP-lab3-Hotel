package clases;

import java.util.Date;

public class Fechas {
	
	private Date fechaIn;
	private Date fechaOut;
	
	public Fechas(Date fechaInParam, Date fechaOutParam) {
		fechaIn = fechaInParam;
		fechaOut = fechaOutParam;
	}
	
	
	
	public String getFechaIn() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("");
		stringBuilder.append(fechaIn.getDate());
		stringBuilder.append("/");
		stringBuilder.append(fechaIn.getMonth());
		return stringBuilder.toString();
	}


	public void setFechaIn(Date fechaIn) {
		this.fechaIn = fechaIn;
	}


	public String getFechaOut() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("");
		stringBuilder.append(fechaOut.getDate());
		stringBuilder.append("/");
		stringBuilder.append(fechaOut.getMonth());
		return stringBuilder.toString();
	}


	public void setFechaOut(Date fechaOut) {
		this.fechaOut = fechaOut;
	}


}

