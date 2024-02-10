package equoterapia.equo.entidades;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "tb_instrutor")
public class Instrutor {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_instrutor;
	
	@Column(length = 50)
    private String nome_instrutor;
    
    @Temporal(TemporalType.DATE)
    private Date data_nascimentoins;
    
    @Column(length = 15)
    private String sexo;

    @Column(length = 14)
    private String cpf;
    
    @Column(length = 50)
    private String email_instrutor;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_instrutor_id", referencedColumnName = "id_endereco")
    private Endereco endereco_instrutor_id;

	public String getEmail_instrutor() {
		return email_instrutor;
	}

	public void setEmail_instrutor(String email_instrutor) {
		this.email_instrutor = email_instrutor;
	}

	public int getId_instrutor() {
		return id_instrutor;
	}

	public void setId_instrutor(int id_instrutor) {
		this.id_instrutor = id_instrutor;
	}

	public String getNome_instrutor() {
		return nome_instrutor;
	}

	public void setNome_instrutor(String nome_instrutor) {
		this.nome_instrutor = nome_instrutor;
	}

	public Date getData_nascimentoins() {
		return data_nascimentoins;
	}

	public void setData_nascimentoins(Date data_nascimentoins) {
		this.data_nascimentoins = data_nascimentoins;
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

	public Endereco getEndereco_instrutor_id() {
		return endereco_instrutor_id;
	}

	public void setEndereco_instrutor_id(Endereco endereco_instrutor_id) {
		this.endereco_instrutor_id = endereco_instrutor_id;
	}

    
}