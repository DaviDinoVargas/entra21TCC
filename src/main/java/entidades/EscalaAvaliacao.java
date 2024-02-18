package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_escalaavaliacao")
public class EscalaAvaliacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idEscalaAvaliacao;
	@Column( length = 20)
    private int somaTotal;
	@OneToOne
    private Usuario usuario;
    
    private int idConsulta;

    
    public int getIdEscalaAvaliacao() {
        return idEscalaAvaliacao;
    }

    public void setIdEscalaAvaliacao(int idEscalaAvaliacao) {
        this.idEscalaAvaliacao = idEscalaAvaliacao;
    }

    public int getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(int somaTotal) {
        this.somaTotal = somaTotal;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}