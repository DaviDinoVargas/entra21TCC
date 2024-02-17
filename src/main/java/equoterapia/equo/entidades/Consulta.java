package equoterapia.equo.entidades;

import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private LocalTime hora;

    @Column(length = 70)
    private String condicaoSaude;

   /* @Column(length = 50)
    private String mediador;

    @Column(length = 50)
    private String guia;*/

    @Column(length = 50)
    private String encilhamento;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "local_consulta_id", referencedColumnName = "id_local")
    private Local local;

    @ManyToOne
    private Usuario usuario;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paciente_consulta_id", referencedColumnName = "id_paciente")
    private Paciente paciente;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medico_consulta_id", referencedColumnName = "id_medico")
    private Medico medico;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cavalo_consulta_id", referencedColumnName = "id_cavalo")
    private Cavalo cavalo;

    
    
    public Paciente getPaciente() {
		return paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void setPacientes(Paciente paciente) {
		this.paciente = paciente;
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

   /* public String getMediador() {
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
    }*/

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
}	