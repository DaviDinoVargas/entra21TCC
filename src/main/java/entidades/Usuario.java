package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_usuario;
    
    @Column(length = 45)
    private String usuario;
    
    @Column(length = 20)
    private String senha;
    
    @Column(length = 30)
    private String empresa;
    
    @Column(length = 18)
    private String cnpj;
    
    @OneToMany
    private Endereco endereco_usuario_id;

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco_usuario_id() {
		return endereco_usuario_id;
	}

	public void setEndereco_usuario_id(Endereco endereco_usuario_id) {
		this.endereco_usuario_id = endereco_usuario_id;
	}
    
    
}
