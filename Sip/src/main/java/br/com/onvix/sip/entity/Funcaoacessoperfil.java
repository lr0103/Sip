package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcaoacessoperfil database table.
 * 
 */
@Entity
@Table(name="funcaoacessoperfil")
public class Funcaoacessoperfil implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Acessoperfil
    @ManyToOne
	@JoinColumn(name="idAcessoPerfil")
	private Acessoperfil acessoperfil;

	//bi-directional many-to-one association to Funcao
    @ManyToOne
	@JoinColumn(name="idFuncao")
	private Funcao funcao;

    public Funcaoacessoperfil() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Acessoperfil getAcessoperfil() {
		return this.acessoperfil;
	}

	public void setAcessoperfil(Acessoperfil acessoperfil) {
		this.acessoperfil = acessoperfil;
	}
	
	public Funcao getFuncao() {
		return this.funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}