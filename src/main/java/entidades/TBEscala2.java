package entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_escala2")
public class TBEscala2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idTBEscala2;

    @Column(length = 10)
    private int op2_1;

    @Column(length = 10)
    private int op2_2;

    @Column(length = 10)
    private int op2_3;

    @Column(length = 10)
    private int op2_4;

    @Column(length = 10)
    private int op2_5;

    @Column(length = 10)
    private int op2_6;

    @Column(length = 10)
    private int op2_7;

    @Column(length = 10)
    private int op2_8;

    @Column(length = 100)
    private String comentarioDM2;

    @Column(length = 20)
    private int somaDM2;

    @OneToOne
    private EscalaAvaliacao escalaAvaliacao;

    @ManyToOne
    private Usuario usuario;

    @Column(name = "escalaAvaliacao_id") 
    private int idEscalaAvaliacao;

    public int getIdTBEscala2() {
        return idTBEscala2;
    }

    public void setIdTBEscala2(int idTBEscala2) {
        this.idTBEscala2 = idTBEscala2;
    }

    public int getOp2_1() {
        return op2_1;
    }

    public void setOp2_1(int op2_1) {
        this.op2_1 = op2_1;
    }

    public int getOp2_2() {
        return op2_2;
    }

    public void setOp2_2(int op2_2) {
        this.op2_2 = op2_2;
    }

    public int getOp2_3() {
        return op2_3;
    }

    public void setOp2_3(int op2_3) {
        this.op2_3 = op2_3;
    }

    public int getOp2_4() {
        return op2_4;
    }

    public void setOp2_4(int op2_4) {
        this.op2_4 = op2_4;
    }

    public int getOp2_5() {
        return op2_5;
    }

    public void setOp2_5(int op2_5) {
        this.op2_5 = op2_5;
    }

    public int getOp2_6() {
        return op2_6;
    }

    public void setOp2_6(int op2_6) {
        this.op2_6 = op2_6;
    }

    public int getOp2_7() {
        return op2_7;
    }

    public void setOp2_7(int op2_7) {
        this.op2_7 = op2_7;
    }

    public int getOp2_8() {
        return op2_8;
    }

    public void setOp2_8(int op2_8) {
        this.op2_8 = op2_8;
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

    public EscalaAvaliacao getEscalaAvaliacao() {
        return escalaAvaliacao;
    }

    public void setEscalaAvaliacao(EscalaAvaliacao escalaAvaliacao) {
        this.escalaAvaliacao = escalaAvaliacao;
    }
}
