package equoterapia.equo.entidades;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_paciente")
public class Paciente {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    private int idCadastro;
	
	    private int idade;
	    @Column( length = 50)
	    private String nome;
	    private String sexo;
	    @Column( length = 14)
	    private String cpf;
	    @Column( length = 50)
	    private String email;
	    //private Date dataNascimento;
	    @OneToOne
	    private ArrayList<Endereco> enderecos;
	    @OneToOne
	    private Usuario usuario;
	    
	    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    @OneToMany
		private Consulta consulta;

		
		public int getIdCadastro() {
			return idCadastro;
		}

		public void setIdCadastro(int idCadastro) {
			this.idCadastro = idCadastro;
		}

		public int getIdade() {
			return idade;
		}

		public void setIdade(int idade) {
			this.idade = idade;
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		/*public Date getDataNascimento() {
			return dataNascimento;
		}

		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}*/

		public void setEnderecos(ArrayList<Endereco> enderecos) {
			this.enderecos = enderecos;
		}

		/*public void adicionarEndereco(Endereco endereco) {
	        this.enderecos.add(endereco);
	        endereco.adicionarPaciente(this);
	    }*/

	    public ArrayList<Endereco> getEnderecos() {
	        return enderecos;
	    }
	    
	    /*public String getDataNascimentoFormatted() {
	        return dateFormat.format(dataNascimento);
	    }*/
	    
	    public Consulta getConsulta() {
	        return consulta;
	    }

	    public void setConsulta(Consulta consulta) {
	        this.consulta = consulta;
	    }

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public String getNome() {
			// TODO Auto-generated method stub
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
	}