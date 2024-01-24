package equoterapia.entidades;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_consulta")
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idConsulta;
	@Temporal(TemporalType.DATE)
    private Date dataAvaliacao;
	@Temporal(TemporalType.TIME)
	private Time hora;
    @Column( length = 70)
    private String condicaoSaude;
    @Column( length = 50)
    private String mediador;
    @Column( length = 50)
    private String guia;
    @Column( length = 50)
    private String encilhamento;
    @ManyToOne
    private Local local;
    @OneToOne
    private Usuario usuario;
    
    private ArrayList<EscalaAvaliacao> escalasAvaliacao;  

    
	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public String getCondicaoSaude() {
		return condicaoSaude;
	}

	public void setCondicaoSaude(String condicaoSaude) {
		this.condicaoSaude = condicaoSaude;
	}

	public String getMediador() {
		return mediador;
	}

	public void setMediador(String mediador) {
		this.mediador = mediador;
	}

	public String getGuia() {
		return guia;
	}

	public void setGuia(String guia) {
		this.guia = guia;
	}

	public String getEncilhamento() {
		return encilhamento;
	}

	public void setEncilhamento(String encilhamento) {
		this.encilhamento = encilhamento;
	}

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public ArrayList<EscalaAvaliacao> getEscalasAvaliacao() {
		return escalasAvaliacao;
	}

	public void setEscalasAvaliacao(ArrayList<EscalaAvaliacao> escalasAvaliacao) {
		this.escalasAvaliacao = escalasAvaliacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	}