package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cavalo")
public class Cavalo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column( length = 50)
	private String nome;
	@Column( length = 2)
	private int idade;
	@Column( length = 50)
	private String raca;
	@OneToMany
	private Consulta consulta;
	@OneToMany
	private Usuario usuario;
	
	
	public Cavalo() {
		}
	
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public int getIdade() {
			return idade;
		}
		public void setIdade(int idade) {
			this.idade = idade;
		}
		public String getRaca() {
			return raca;
		}
		public void setRaca(String raca) {
			this.raca = raca;
		}
		
		public String toString() {
			return id + nome + idade + raca;
		}
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
		}