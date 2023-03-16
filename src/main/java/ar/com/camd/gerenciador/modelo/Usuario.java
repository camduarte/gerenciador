package ar.com.camd.gerenciador.modelo;

public class Usuario {
	private Integer id;
	private String login;
	private String contrasena;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String cantrasena) {
		this.contrasena = cantrasena;
	}

	public boolean esIgual(String login, String contrasena) {
		if (this.login.equals(login) && this.contrasena.equals(contrasena)) {
			return true;
		}
		return false;
	}
}