package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the perfilacesso database table.
 * 
 */
@Entity
@Table(name="perfilacesso")
public class Perfilacesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Acessoperfil
	@OneToMany(mappedBy="perfilacesso")
	private Set<Acessoperfil> acessoperfils;

	//bi-directional many-to-one association to Perfilusuario
	@OneToMany(mappedBy="perfilacesso")
	private Set<Perfilusuario> perfilusuarios;

    public Perfilacesso() {
    }

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

	public Set<Acessoperfil> getAcessoperfils() {
		return this.acessoperfils;
	}

	public void setAcessoperfils(Set<Acessoperfil> acessoperfils) {
		this.acessoperfils = acessoperfils;
	}
	
	public Set<Perfilusuario> getPerfilusuarios() {
		return this.perfilusuarios;
	}

	public void setPerfilusuarios(Set<Perfilusuario> perfilusuarios) {
		this.perfilusuarios = perfilusuarios;
	}
	
}