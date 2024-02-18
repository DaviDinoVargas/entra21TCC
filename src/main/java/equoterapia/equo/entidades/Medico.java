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
@Table(name = "tb_medico")
public class Medico {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_medico;

    @Column(length = 50)
    private String nome_medico;
    
    @Temporal(TemporalType.DATE)
    private Date data_nascimento_med;
    
    @Column(length = 15)
    private String sexo;

    @Column(length = 14)
    private String cpf;
    
    @Column(length = 50)
    private String email_medico;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_medico_id", referencedColumnName = "id_endereco")
    private Endereco endereco_Medico_id;
    
    @ManyToOne
    private Usuario usuario_id;
    
    public int getId_medico() {
		return id_medico;
	}

	public void setId_medico(int id_medico) {
		this.id_medico = id_medico;
	}

	public String getNome_medico() {
		return nome_medico;
	}

	public void setNome_medico(String nome_medico) {
		this.nome_medico = nome_medico;
	}

	public Date getData_nascimento() {
		return data_nascimento_med;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento_med = data_nascimento;
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


	public String getEmail_medico() {
		return email_medico;
	}

	public void setEmail_medico(String email_medico) {
		this.email_medico = email_medico;
	}

	public Date getData_nascimento_med() {
		return data_nascimento_med;
	}

	public void setData_nascimento_med(Date data_nascimento_med) {
		this.data_nascimento_med = data_nascimento_med;
	}

	public Endereco getEndereco_Medico_id() {
		return endereco_Medico_id;
	}

	public void setEndereco_Medico_id(Endereco endereco_Medico_id) {
		this.endereco_Medico_id = endereco_Medico_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	
}