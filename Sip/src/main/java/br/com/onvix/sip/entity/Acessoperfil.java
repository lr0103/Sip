package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the acessoperfil database table.
 * 
 */
@Entity
@Table(name="acessoperfil")
public class Acessoperfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Menusistema
    @ManyToOne
	@JoinColumn(name="idMenuSistema")
	private Menusistema menusistema;

	//bi-directional many-to-one association to Perfilacesso
    @ManyToOne
	@JoinColumn(name="idperfilAcesso")
	private Perfilacesso perfilacesso;

	//bi-directional many-to-one association to Funcaoacessoperfil
	@OneToMany(mappedBy="acessoperfil")
	private Set<Funcaoacessoperfil> funcaoacessoperfils;

    public Acessoperfil() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Menusistema getMenusistema() {
		return this.menusistema;
	}

	public void setMenusistema(Menusistema menusistema) {
		this.menusistema = menusistema;
	}
	
	public Perfilacesso getPerfilacesso() {
		return this.perfilacesso;
	}

	public void setPerfilacesso(Perfilacesso perfilacesso) {
		this.perfilacesso = perfilacesso;
	}
	
	public Set<Funcaoacessoperfil> getFuncaoacessoperfils() {
		return this.funcaoacessoperfils;
	}

	public void setFuncaoacessoperfils(Set<Funcaoacessoperfil> funcaoacessoperfils) {
		this.funcaoacessoperfils = funcaoacessoperfils;
	}
	
}