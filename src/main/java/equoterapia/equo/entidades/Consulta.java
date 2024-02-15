package equoterapia.equo.entidades;
import java.sql.Date;
import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_consulta;

    @Temporal(TemporalType.DATE)
    private Date data_avaliacao;

    @Temporal(TemporalType.TIME)
    private LocalTime hora;

    @Column(length = 70)
    private String condicao_saude;

    @Column(length = 50)
    private String encilhamento;
    
    @ManyToOne
    private Paciente paciente_id;

    @ManyToOne
    private Endereco endereco_id;
    
    @ManyToOne
    private Cavalo cavalo_id;

	@ManyToOne
    private Usuario usuario_id;
    
    @ManyToMany
    private List<Medico> medico;
    
    @ManyToMany
    private List<Instrutor> intrutor;


	public List<Medico> getMedico() {
		return medico;
	}

	public void setMedico(List<Medico> medico) {
		this.medico = medico;
	}

	public List<Instrutor> getIntrutor() {
		return intrutor;
	}

	public void setIntrutor(List<Instrutor> intrutor) {
		this.intrutor = intrutor;
	}

	public int getId_consulta() {
		return id_consulta;
	}

	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}

	public Date getData_avaliacao() {
		return data_avaliacao;
	}

	public void setData_avaliacao(Date data_avaliacao) {
		this.data_avaliacao = data_avaliacao;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public String getCondicao_saude() {
		return condicao_saude;
	}

	public void setCondicao_saude(String condicao_saude) {
		this.condicao_saude = condicao_saude;
	}

	public String getEncilhamento() {
		return encilhamento;
	}

	public void setEncilhamento(String encilhamento) {
		this.encilhamento = encilhamento;
	}

	public Paciente getPaciente_id() {
		return paciente_id;
	}

	public void setPaciente_id(Paciente paciente_id) {
		this.paciente_id = paciente_id;
	}

	public Endereco getEndereco_id() {
		return endereco_id;
	}

	public void setEndereco_id(Endereco endereco_id) {
		this.endereco_id = endereco_id;
	}

	public Cavalo getCavalo_id() {
		return cavalo_id;
	}

	public void setCavalo_id(Cavalo cavalo_id) {
		this.cavalo_id = cavalo_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	
}
