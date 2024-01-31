package equoterapia.equo.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "escala1")
public class TBEscala1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_escala1;

    @Column(length = 10)
    private int op1_11;

    @Column(length = 10)
    private int op1_12;

    @Column(length = 10)
    private int op1_13;

    @Column(length = 10)
    private int op1_14;

    @Column(length = 100)
    private String comentarioDM1;

    @Column(length = 20)
    private int somaDM1;

    @OneToOne
    private EscalaAvaliacao escalaAvaliacao1_id;

    @ManyToOne
    private Usuario usuario_id;

	public int getId_escala1() {
		return id_escala1;
	}

	public void setId_escala1(int id_escala1) {
		this.id_escala1 = id_escala1;
	}

	public int getOp1_11() {
		return op1_11;
	}

	public void setOp1_11(int op1_11) {
		this.op1_11 = op1_11;
	}

	public int getOp1_12() {
		return op1_12;
	}

	public void setOp1_12(int op1_12) {
		this.op1_12 = op1_12;
	}

	public int getOp1_13() {
		return op1_13;
	}

	public void setOp1_13(int op1_13) {
		this.op1_13 = op1_13;
	}

	public int getOp1_14() {
		return op1_14;
	}

	public void setOp1_14(int op1_14) {
		this.op1_14 = op1_14;
	}

	public String getComentarioDM1() {
		return comentarioDM1;
	}

	public void setComentarioDM1(String comentarioDM1) {
		this.comentarioDM1 = comentarioDM1;
	}

	public int getSomaDM1() {
		return somaDM1;
	}

	public void setSomaDM1(int somaDM1) {
		this.somaDM1 = somaDM1;
	}

	public EscalaAvaliacao getEscalaAvaliacao1_id() {
		return escalaAvaliacao1_id;
	}

	public void setEscalaAvaliacao1_id(EscalaAvaliacao escalaAvaliacao1_id) {
		this.escalaAvaliacao1_id = escalaAvaliacao1_id;
	}

	public Usuario getUsuario() {
		return usuario_id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario_id = usuario;
	}
}