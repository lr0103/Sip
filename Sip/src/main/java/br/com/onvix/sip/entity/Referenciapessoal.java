package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the refenrenciapessoal database table.
 * 
 */
@Entity
@Table(name="referenciapessoal")
public class Referenciapessoal implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String descricao;
	private String observacao;
	private Telefone telefone;

    public Referenciapessoal() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


    @Lob()
	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	//bi-directional many-to-one association to Telefone
    @ManyToOne
	@JoinColumn(name="idTelefone")
	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
}