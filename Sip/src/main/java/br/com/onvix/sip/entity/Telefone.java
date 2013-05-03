package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
@Table(name="telefone")
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int codigoPais;
	private int ddd;
	private int numero;
	private String tipo;
	private Set<Referenciapessoal> refenrenciapessoals;
	private Set<Telefonepessoa> telefonepessoas;

    public Telefone() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public int getCodigoPais() {
		return this.codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}


	public int getDdd() {
		return this.ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}


	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	//bi-directional many-to-one association to Refenrenciapessoal
	@OneToMany(mappedBy="telefone")
	public Set<Referenciapessoal> getRefenrenciapessoals() {
		return this.refenrenciapessoals;
	}

	public void setRefenrenciapessoals(Set<Referenciapessoal> refenrenciapessoals) {
		this.refenrenciapessoals = refenrenciapessoals;
	}
	

	//bi-directional many-to-one association to Telefonepessoa
	@OneToMany(mappedBy="telefone")
	public Set<Telefonepessoa> getTelefonepessoas() {
		return this.telefonepessoas;
	}

	public void setTelefonepessoas(Set<Telefonepessoa> telefonepessoas) {
		this.telefonepessoas = telefonepessoas;
	}
	
}