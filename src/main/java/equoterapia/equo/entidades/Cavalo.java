package equoterapia.equo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cavalo")
public class Cavalo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cavalo;

    @Column(length = 50)
    private String nome_cavalo;

    @Column
    private Integer idade_cavalo; 

    @Column(length = 50)
    private String raca;

    @ManyToOne
    private Usuario usuario_id;


    
    public Long getId_cavalo() {
		return id_cavalo;
	}

	public void setId_cavalo(Long id_cavalo) {
	}

	public String getNome_cavalo() {
		return nome_cavalo;
	}

	public void setNome_cavalo(String nome_cavalo) {
		this.nome_cavalo = nome_cavalo;
	}

	public Integer getIdade_cavalo() {
		return idade_cavalo;
	}

	public void setIdade_cavalo(Integer idade_cavalo) {
		this.idade_cavalo = idade_cavalo;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getNome() {
        return nome_cavalo;
    }

    public void setNome(String nome_cavalo) {
        this.nome_cavalo = nome_cavalo;
    }

    public Integer getIdade() {
        return idade_cavalo;
    }

    public void setIdade(Integer idade_cavalo) {
        this.idade_cavalo = idade_cavalo;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public Usuario getUsuario() {
        return usuario_id;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario_id = usuario;
    }

}