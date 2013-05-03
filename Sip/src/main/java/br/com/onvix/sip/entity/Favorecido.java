package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the favorecido database table.
 * 
 */
@Entity
@Table(name="favorecido")
public class Favorecido implements Serializable {
	private static final long serialVersionUID = 1L;
	private int idpessoa;
	private Pessoa pessoa;

    public Favorecido() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdpessoa() {
		return this.idpessoa;
	}

	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}


	//bi-directional one-to-one association to Pessoa
	@OneToOne
	@JoinColumn(name="idpessoa")
	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}