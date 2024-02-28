package equoterapia.equo.entidades;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cavalo")
public class Cavalo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_cavalo;

    @Column(length = 50)
    private String nome;

    @Column
    private Integer idade_cavalo; 

    @Column(length = 50)
    private String raca;
    
    @JsonBackReference
    @OneToMany(mappedBy = "cavalo")
    private List<Consulta> tb_consultaList = new ArrayList<>();
    
    
    @ManyToOne
    private Usuario usuario_id;

	public int getId_cavalo() {
		return id_cavalo;
	}

	public void setId_cavalo(int id_cavalo) {
		this.id_cavalo = id_cavalo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade_cavalo() {
		return idade_cavalo;
	}

	public void setIdade_cavalo(Integer idade_cavalo) {
		this.idade_cavalo = idade_cavalo;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public List<Consulta> getTb_consultaList() {
		return tb_consultaList;
	}

	public void setTb_consultaList(List<Consulta> tb_consultaList) {
		this.tb_consultaList = tb_consultaList;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}



}