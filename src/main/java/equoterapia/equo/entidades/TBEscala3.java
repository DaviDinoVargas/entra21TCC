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
@Table(name = "escala3")
public class TBEscala3 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_escala3;

    @Column(length = 10)
    private int op3_31;

    @Column(length = 10)
    private int op3_32;

    @Column(length = 10)
    private int op3_33;

    @Column(length = 10)
    private int op3_34;

    @Column(length = 10)
    private int op3_35;

    @Column(length = 10)
    private int op3_36;

    @Column(length = 10)
    private int op3_37;

    @Column(length = 100)
    private String comentarioDM3;

    @Column(length = 20)
    private int somaDM3;

    @OneToOne
    private EscalaAvaliacao escalaAvaliacao3_id;

    @ManyToOne
    private Usuario usuario_id;

	public int getId_escala3() {
		return id_escala3;
	}

	public void setId_escala3(int id_escala3) {
		this.id_escala3 = id_escala3;
	}

	public int getOp3_31() {
		return op3_31;
	}

	public void setOp3_31(int op3_31) {
		this.op3_31 = op3_31;
	}

	public int getOp3_32() {
		return op3_32;
	}

	public void setOp3_32(int op3_32) {
		this.op3_32 = op3_32;
	}

	public int getOp3_33() {
		return op3_33;
	}

	public void setOp3_33(int op3_33) {
		this.op3_33 = op3_33;
	}

	public int getOp3_34() {
		return op3_34;
	}

	public void setOp3_34(int op3_34) {
		this.op3_34 = op3_34;
	}

	public int getOp3_35() {
		return op3_35;
	}

	public void setOp3_35(int op3_35) {
		this.op3_35 = op3_35;
	}

	public int getOp3_36() {
		return op3_36;
	}

	public void setOp3_36(int op3_36) {
		this.op3_36 = op3_36;
	}

	public int getOp3_37() {
		return op3_37;
	}

	public void setOp3_37(int op3_37) {
		this.op3_37 = op3_37;
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

	public EscalaAvaliacao getEscalaAvaliacao3_id() {
		return escalaAvaliacao3_id;
	}

	public void setEscalaAvaliacao3_id(EscalaAvaliacao escalaAvaliacao3_id) {
		this.escalaAvaliacao3_id = escalaAvaliacao3_id;
	}

	public Usuario getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Usuario usuario_id) {
		this.usuario_id = usuario_id;
	}

}