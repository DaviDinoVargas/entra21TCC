package equoterapia.equo.entidades;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "escala2")
public class TBEscala2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_escala2;

    @Column(length = 10)
    private int op2_21;

    @Column(length = 10)
    private int op2_22;

    @Column(length = 10)
    private int op2_23;

    @Column(length = 10)
    private int op2_24;

    @Column(length = 10)
    private int op2_25;

    @Column(length = 10)
    private int op2_26;

    @Column(length = 10)
    private int op2_27;

    @Column(length = 10)
    private int op2_28;

    @Column(length = 100)
    private String comentarioDM2;

    @Column(length = 20)
    private int somaDM2;

    @OneToOne
    private EscalaAvaliacao escalaAvaliacao2_id;

    @ManyToOne
    private Usuario usuario_id;

	public int getId_escala2() {
		return id_escala2;
	}

	public void setId_escala2(int id_escala2) {
		this.id_escala2 = id_escala2;
	}

	public int getOp2_21() {
		return op2_21;
	}

	public void setOp2_21(int op2_21) {
		this.op2_21 = op2_21;
	}

	public int getOp2_22() {
		return op2_22;
	}

	public void setOp2_22(int op2_22) {
		this.op2_22 = op2_22;
	}

	public int getOp2_23() {
		return op2_23;
	}

	public void setOp2_23(int op2_23) {
		this.op2_23 = op2_23;
	}

	public int getOp2_24() {
		return op2_24;
	}

	public void setOp2_24(int op2_24) {
		this.op2_24 = op2_24;
	}

	public int getOp2_25() {
		return op2_25;
	}

	public void setOp2_25(int op2_25) {
		this.op2_25 = op2_25;
	}

	public int getOp2_26() {
		return op2_26;
	}

	public void setOp2_26(int op2_26) {
		this.op2_26 = op2_26;
	}

	public int getOp2_27() {
		return op2_27;
	}

	public void setOp2_27(int op2_27) {
		this.op2_27 = op2_27;
	}

	public int getOp2_28() {
		return op2_28;
	}

	public void setOp2_28(int op2_28) {
		this.op2_28 = op2_28;
	}

	public String getComentarioDM2() {
		return comentarioDM2;
	}

	public void setComentarioDM2(String comentarioDM2) {
		this.comentarioDM2 = comentarioDM2;
	}

	public int getSomaDM2() {
		return somaDM2;
	}

	public void setSomaDM2(int somaDM2) {
		this.somaDM2 = somaDM2;
	}

	public EscalaAvaliacao getEscalaAvaliacao2_id() {
		return escalaAvaliacao2_id;
	}

	public void setEscalaAvaliacao2_id(EscalaAvaliacao escalaAvaliacao2_id) {
		this.escalaAvaliacao2_id = escalaAvaliacao2_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

}