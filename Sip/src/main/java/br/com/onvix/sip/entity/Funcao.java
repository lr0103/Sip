package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the funcao database table.
 * 
 */
@Entity
@Table(name="funcao")
public class Funcao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private byte dasabilitada;

	private String descricao;

	//bi-directional many-to-one association to Funcaoacessoperfil
	@OneToMany(mappedBy="funcao")
	private Set<Funcaoacessoperfil> funcaoacessoperfils;

	//bi-directional many-to-one association to Funcaousuarioacesso
	@OneToMany(mappedBy="funcao")
	private Set<Funcaousuarioacesso> funcaousuarioacessos;

    public Funcao() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDasabilitada() {
		return this.dasabilitada;
	}

	public void setDasabilitada(byte dasabilitada) {
		this.dasabilitada = dasabilitada;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Funcaoacessoperfil> getFuncaoacessoperfils() {
		return this.funcaoacessoperfils;
	}

	public void setFuncaoacessoperfils(Set<Funcaoacessoperfil> funcaoacessoperfils) {
		this.funcaoacessoperfils = funcaoacessoperfils;
	}
	
	public Set<Funcaousuarioacesso> getFuncaousuarioacessos() {
		return this.funcaousuarioacessos;
	}

	public void setFuncaousuarioacessos(Set<Funcaousuarioacesso> funcaousuarioacessos) {
		this.funcaousuarioacessos = funcaousuarioacessos;
	}
	
}