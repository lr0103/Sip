package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the acessousuario database table.
 * 
 */
@Entity
@Table(name="acessousuario")
public class Acessousuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Menusistema
    @ManyToOne
	@JoinColumn(name="idMenuSistema")
	private Menusistema menusistema;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

	//bi-directional many-to-one association to Funcaousuarioacesso
	@OneToMany(mappedBy="acessousuario")
	private Set<Funcaousuarioacesso> funcaousuarioacessos;

    public Acessousuario() {
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
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<Funcaousuarioacesso> getFuncaousuarioacessos() {
		return this.funcaousuarioacessos;
	}

	public void setFuncaousuarioacessos(Set<Funcaousuarioacesso> funcaousuarioacessos) {
		this.funcaousuarioacessos = funcaousuarioacessos;
	}
	
}