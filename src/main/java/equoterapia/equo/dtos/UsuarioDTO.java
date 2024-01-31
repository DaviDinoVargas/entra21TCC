package equoterapia.equo.dtos;

import equoterapia.equo.entidades.Usuario;

public class UsuarioDTO {
	private int idUsuario;
	private String Usuario;
	private String Empresa;
	
	public UsuarioDTO(int id, String nome, String email) {
		this.idUsuario = id;
		this.Usuario = nome;
		this.Empresa = email;
	}
	
	public UsuarioDTO(Usuario usuario) {
		this.idUsuario = usuario.getId_usuario();
		this.Usuario = usuario.getUsuario();
		this.Empresa = usuario.getEmpresa();
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}
}
