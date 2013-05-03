package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the modulosistema database table.
 * 
 */
@Entity
@Table(name="modulosistema")
public class Modulosistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idmodulo")
	private int idmodulo;

	@Column(name="descricao")
	private String descricao;

	//bi-directional many-to-one association to Sistema
    @ManyToOne
	@JoinColumn(name="idsistema")
	private Sistema sistema;
	
	//bi-directional many-to-one association to Menusistema
	@OneToMany(mappedBy="modulosistema")
	private List<Menusistema> menusistemas;

    public Modulosistema() {
    }

	public int getIdmodulo() {
		return idmodulo;
	}

	public void setIdmodulo(int idmodulo) {
		this.idmodulo = idmodulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Menusistema> getMenusistemas() {
		return this.menusistemas;
	}

	public void setMenusistemas(List<Menusistema> menusistemas) {
		this.menusistemas = menusistemas;
	}

	public Sistema getSistema() {
		return sistema;
	}

	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
}