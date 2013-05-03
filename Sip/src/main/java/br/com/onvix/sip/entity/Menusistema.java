package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the menusistema database table.
 * 
 */
@Entity
@Table(name="menusistema")
public class Menusistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private String label;

	private String link;

	//bi-directional many-to-one association to Acessoperfil
	@OneToMany(mappedBy="menusistema")
	private Set<Acessoperfil> acessoperfils;

	//bi-directional many-to-one association to Acessousuario
	@OneToMany(mappedBy="menusistema")
	private Set<Acessousuario> acessousuarios;

	//bi-directional many-to-one association to Modulosistema
    @ManyToOne
	@JoinColumn(name="idModuloSistema")
	private Modulosistema modulosistema;

    public Menusistema() {
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

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getLink() {
		return this.link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Set<Acessoperfil> getAcessoperfils() {
		return this.acessoperfils;
	}

	public void setAcessoperfils(Set<Acessoperfil> acessoperfils) {
		this.acessoperfils = acessoperfils;
	}
	
	public Set<Acessousuario> getAcessousuarios() {
		return this.acessousuarios;
	}

	public void setAcessousuarios(Set<Acessousuario> acessousuarios) {
		this.acessousuarios = acessousuarios;
	}
	
	public Modulosistema getModulosistema() {
		return this.modulosistema;
	}

	public void setModulosistema(Modulosistema modulosistema) {
		this.modulosistema = modulosistema;
	}
	
}