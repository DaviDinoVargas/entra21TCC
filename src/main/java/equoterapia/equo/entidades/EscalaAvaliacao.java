package equoterapia.equo.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "escalaavaliacao")
public class EscalaAvaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_escala_avaliacao;

    @Column(length = 20)
    private int soma_total;

    @ManyToOne
    private Usuario usuario_id;


	public int getId_escala_avaliacao() {
		return id_escala_avaliacao;
	}

	public void setId_escala_avaliacao(int id_escala_avaliacao) {
		this.id_escala_avaliacao = id_escala_avaliacao;
	}

	public int getSoma_total() {
		return soma_total;
	}

	public void setSoma_total(int soma_total) {
		this.soma_total = soma_total;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}
    
}