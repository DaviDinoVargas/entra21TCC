package equoterapia.equo.entidades;
import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_paciente;

    @Temporal(TemporalType.DATE)
    private Date data_nascimento;

    @Column(length = 50)
    private String nome_paciente;

    @Column(length = 15)
    private String sexo;

    @Column(length = 14)
    private String cpf;

    @Column(length = 50)
    private String email_paciente;
    
    @Column(length = 50)
    private String nome_responsavel;
    

	@ManyToOne
    private Usuario usuario_id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_paciente_id", referencedColumnName = "id_endereco")
    private Endereco endereco_paciente_id;

	public Long getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(Long id_paciente) {
		this.id_paciente = id_paciente;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getNome_paciente() {
		return nome_paciente;
	}

	public void setNome_paciente(String nome_paciente) {
		this.nome_paciente = nome_paciente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail_paciente() {
		return email_paciente;
	}

	public void setEmail_paciente(String email_paciente) {
		this.email_paciente = email_paciente;
	}
	public String getNome_responsavel() {
		return nome_responsavel;
	}
	
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public Endereco getEndereco_paciente_id() {
		return endereco_paciente_id;
	}

	public void setEndereco_paciente_id(Endereco endereco_paciente_id) {
		this.endereco_paciente_id = endereco_paciente_id;
	}

}