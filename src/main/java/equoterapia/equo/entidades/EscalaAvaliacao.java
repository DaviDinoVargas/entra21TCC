package equoterapia.equo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_escalaavaliacao")
public class EscalaAvaliacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEscalaAvaliacao;

    @Column(length = 20)
    private int somaTotal;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Consulta consulta;

    public int getIdEscalaAvaliacao() {
        return idEscalaAvaliacao;
    }

    public void setIdEscalaAvaliacao(int idEscalaAvaliacao) {
        this.idEscalaAvaliacao = idEscalaAvaliacao;
    }

    public int getSomaTotal() {
        return somaTotal;
    }

    public void setSomaTotal(int somaTotal) {
        this.somaTotal = somaTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}