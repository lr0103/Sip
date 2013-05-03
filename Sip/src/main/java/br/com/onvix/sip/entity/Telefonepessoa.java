package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * The persistent class for the telefonepessoa database table.
 * 
 */
@Entity
@Table(name="telefonepessoa")
public class Telefonepessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private TelefonepessoaPK id;
	
	//bi-directional many-to-one association to Pessoa
    @ManyToOne
	@JoinColumn(name="idpessoa", insertable=false,updatable=false)
	private Pessoa pessoa;
	
  //bi-directional many-to-one association to Telefone
    @ManyToOne
	@JoinColumn(name="idtelefone", insertable=false,updatable=false)
	private Telefone telefone;

    public Telefonepessoa() {
    }


	
	public TelefonepessoaPK getId() {
		return this.id;
	}

	public void setId(TelefonepessoaPK id) {
		this.id = id;
	}
	

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	

	public Telefone getTelefone() {
		return this.telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	
}