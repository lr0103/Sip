package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the funcaousuarioacesso database table.
 * 
 */
@Entity
@Table(name="funcaousuarioacesso")
public class Funcaousuarioacesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	//bi-directional many-to-one association to Acessousuario
    @ManyToOne
	@JoinColumn(name="idAcessoUsuario")
	private Acessousuario acessousuario;

	//bi-directional many-to-one association to Funcao
    @ManyToOne
	@JoinColumn(name="idFuncao")
	private Funcao funcao;

    public Funcaousuarioacesso() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Acessousuario getAcessousuario() {
		return this.acessousuario;
	}

	public void setAcessousuario(Acessousuario acessousuario) {
		this.acessousuario = acessousuario;
	}
	
	public Funcao getFuncao() {
		return this.funcao;
	}

	public void setFuncao(Funcao funcao) {
		this.funcao = funcao;
	}
	
}