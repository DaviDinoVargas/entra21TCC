package equoterapia.equo.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_paciente;

    @Column(length = 2)
    private int idade_paciente;

    @Column(length = 50)
    private String nome_paciente;

    @Column(length = 15)
    private String sexo;

    @Column(length = 14)
    private String cpf;

    @Column(length = 50)
    private String email_paciente;
    
    @ManyToOne
    private Usuario usuario_id;
    
    @ManyToOne
    private Endereco endereco_paciente_id;

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public int getIdade_paciente() {
		return idade_paciente;
	}

	public void setIdade_paciente(int idade_paciente) {
		this.idade_paciente = idade_paciente;
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