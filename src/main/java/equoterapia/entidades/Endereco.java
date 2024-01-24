package equoterapia.entidades;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int idtb_endereco;
		@Column( length = 10)
		private int numero;
		@Column( length = 9)
		private int cep;
		@Column( length = 50)
		private String cidade;
		@Column( length = 2)
		private String uf;
		@Column( length = 70)
	    private String rua;
	   /* private Usuario usuario;
	    private ArrayList<Paciente> pacientes;*/


		public int getIdtb_endereco() {
			return idtb_endereco;
		}

		public void setIdtb_endereco(int idtb_endereco) {
			this.idtb_endereco = idtb_endereco;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public int getCep() {
			return cep;
		}

		public void setCep(int cep) {
			this.cep = cep;
		}

		public String getCidade() {
			return cidade;
		}

		public void setCidade(String cidade) {
			this.cidade = cidade;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public String getRua() {
			return rua;
		}

		public void setRua(String rua) {
			this.rua = rua;
		}
/*
		public void setPacientes(ArrayList<Paciente> pacientes) {
			this.pacientes = pacientes;
		}

		public void adicionarPaciente(Paciente paciente) {
	        this.pacientes.add(paciente);
	    }

	    public ArrayList<Paciente> getPacientes() {
	        return pacientes;
	    }

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}*/

		public String getCnpj() {
			
			return null;
		}

		public int getIdEndereco() {
			
			return 0;
		}
	    
	}
