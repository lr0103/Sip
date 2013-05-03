package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the sistema database table.
 * 
 */
@Entity
@Table(name="sistema")
public class Sistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idsistema;

	private String descricao;
	
	
	//bi-directional many-to-one association to Menusistema
	@OneToMany(mappedBy="sistema",cascade=CascadeType.REMOVE)
	private List<Modulosistema> modulosistemas;

    public Sistema() {
    }

	public int getIdsistema() {
		return this.idsistema;
	}

	public void setIdsistema(int idsistema) {
		this.idsistema = idsistema;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Modulosistema> getModulosistemas() {
		return modulosistemas;
	}

	public void setModulosistemas(List<Modulosistema> modulosistemas) {
		this.modulosistemas = modulosistemas;
	}

}