package clases;

public class Usuario {
	
	private String user;
	private String pass;
	
	
	public Usuario(String usuario,String contaseña)
	{
		user=usuario;
		pass=contaseña;
		
	}

	

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
}
