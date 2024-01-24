package equoterapia.equo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_escala3")
public class TBEscala3 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int idTBEscala3;
	@Column( length = 10)
    private int op3_1;
	@Column( length = 10)
    private int op3_2;
	@Column( length = 10)
    private int op3_3;
	@Column( length = 10)
    private int op3_4;
	@Column( length = 10)
    private int op3_5;
	@Column( length = 10)
    private int op3_6;
	@Column( length = 10)
    private int op3_7;
	@Column( length = 100)
    private String comentarioDM3;
	@Column( length = 20)
    private int somaDM3;
	@Column( length = 10)
    private int idEscalaAvaliacao;
    @OneToOne
    private Usuario usuario;
   
    
	public int getIdTBEscala3() {
		return idTBEscala3;
	}
	public void setIdTBEscala3(int idTBEscala3) {
		this.idTBEscala3 = idTBEscala3;
	}
	public int getOp3_1() {
		return op3_1;
	}
	public void setOp3_1(int op3_1) {
		this.op3_1 = op3_1;
	}
	public int getOp3_2() {
		return op3_2;
	}
	public void setOp3_2(int op3_2) {
		this.op3_2 = op3_2;
	}
	public int getOp3_3() {
		return op3_3;
	}
	public void setOp3_3(int op3_3) {
		this.op3_3 = op3_3;
	}
	public int getOp3_4() {
		return op3_4;
	}
	public void setOp3_4(int op3_4) {
		this.op3_4 = op3_4;
	}
	public int getOp3_5() {
		return op3_5;
	}
	public void setOp3_5(int op3_5) {
		this.op3_5 = op3_5;
	}
	public int getOp3_6() {
		return op3_6;
	}
	public void setOp3_6(int op3_6) {
		this.op3_6 = op3_6;
	}
	public int getOp3_7() {
		return op3_7;
	}
	public void setOp3_7(int op3_7) {
		this.op3_7 = op3_7;
	}
	public String getComentarioDM3() {
		return comentarioDM3;
	}
	public void setComentarioDM3(String comentarioDM3) {
		this.comentarioDM3 = comentarioDM3;
	}
	public int getSomaDM3() {
		return somaDM3;
	}
	public void setSomaDM3(int somaDM3) {
		this.somaDM3 = somaDM3;
	}
	public int getIdEscalaAvaliacao() {
		return idEscalaAvaliacao;
	}
	public void setIdEscalaAvaliacao(int idEscalaAvaliacao) {
		this.idEscalaAvaliacao = idEscalaAvaliacao;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

    
}