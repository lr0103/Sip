package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


/**
 * The persistent class for the pessoajuridica database table.
 * 
 */
@Entity
@Table(name="pessoajuridica")
@PrimaryKeyJoinColumn(name="id")
public class Pessoajuridica extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cnpj;
	private String nomeFantasia;
	private String razaoSocial;
	private Serventia serventia;
 
    public Pessoajuridica() {
    }


	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}


	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}
	
	//bi-directional one-to-one association to Serventia
	@OneToOne(mappedBy="pessoajuridica")
	public Serventia getServentia() {
		return this.serventia;
	}

	public void setServentia(Serventia serventia) {
		this.serventia = serventia;
	}
	
}