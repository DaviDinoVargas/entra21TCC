package equoterapia.equo.entidades;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pagamento")
public class Pagamento {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id_pagamento;
	    
	    @Column(length = 10)
	    private String valor;
	    
	    @Column(length = 40)
	    private String tipo_pagamento;
	    
	    @Temporal(TemporalType.DATE)
	    private String data_vencimento;
	    
	    @Column(length = 40)
	    private String status_pagamento;
	    
	    @OneToOne
	    private Consulta consulta_id;
	    
	    @ManyToOne
	    private Usuario usuario_id;

		public int getId_pagamento() {
			return id_pagamento;
		}

		public void setId_pagamento(int id_pagamento) {
			this.id_pagamento = id_pagamento;
		}

		public String getValor() {
			return valor;
		}

		public void setValor(String valor) {
			this.valor = valor;
		}

		public String getTipo_pagamento() {
			return tipo_pagamento;
		}

		public void setTipo_pagamento(String tipo_pagamento) {
			this.tipo_pagamento = tipo_pagamento;
		}

		public String getData_vencimento() {
			return data_vencimento;
		}

		public void setData_vencimento(String data_vencimento) {
			this.data_vencimento = data_vencimento;
		}

		public String getStatus_pagamento() {
			return status_pagamento;
		}

		public void setStatus_pagamento(String status_pagamento) {
			this.status_pagamento = status_pagamento;
		}

		public Consulta getConsulta_id() {
			return consulta_id;
		}

		public void setConsulta_id(Consulta consulta_id) {
			this.consulta_id = consulta_id;
		}

		public Usuario getUsuario_id() {
			return usuario_id;
		}

		public void setUsuario_id(Usuario usuario_id) {
			this.usuario_id = usuario_id;
		}
	    
}
