package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the perfilusuario database table.
 * 
 */
@Entity
@Table(name="perfilusuario")
public class Perfilusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Perfilacesso
    @ManyToOne
	@JoinColumn(name="idperfilAcesso")
	private Perfilacesso perfilacesso;

	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;

    public Perfilusuario() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Perfilacesso getPerfilacesso() {
		return this.perfilacesso;
	}

	public void setPerfilacesso(Perfilacesso perfilacesso) {
		this.perfilacesso = perfilacesso;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}