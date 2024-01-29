package equoterapia.equo.entidades;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private LocalTime hora;

    @Column(length = 70)
    private String condicaoSaude;

    @Column(length = 50)
    private String mediador;

    @Column(length = 50)
    private String guia;

    @Column(length = 50)
    private String encilhamento;

    @ManyToOne
    private Local local;

    @ManyToOne
    private Usuario usuario;
    
    @ManyToOne
    private Paciente paciente;
    
    @ManyToOne
    private Cavalo cavalo;

    @OneToMany(mappedBy = "consulta")
    private List<EscalaAvaliacao> escalasAvaliacao;


    public Paciente getPaciente() {
		return paciente;
	}

	public void setPacientes(Paciente pacientes) {
		this.paciente = pacientes;
	}

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

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    

    public Cavalo getCavalo() {
		return cavalo;
	}

	public void setCavalo(Cavalo cavalo) {
		this.cavalo = cavalo;
	}

	public List<EscalaAvaliacao> getEscalasAvaliacao() {
        return escalasAvaliacao;
    }

    public void setEscalasAvaliacao(List<EscalaAvaliacao> escalasAvaliacao) {
        this.escalasAvaliacao = escalasAvaliacao;
    }
}	