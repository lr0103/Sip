package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dataCriacao;

    @Temporal( TemporalType.TIMESTAMP)
	private Date dataInativacao;

	private String login;

	private String senha;

	//bi-directional many-to-one association to Acessousuario
	@OneToMany(mappedBy="usuario")
	private Set<Acessousuario> acessousuarios;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="usuario")
	private Set<Pessoa> pessoas;

	//bi-directional many-to-one association to Perfilusuario
	@OneToMany(mappedBy="usuario")
	private Set<Perfilusuario> perfilusuarios;

    public Usuario() {
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataInativacao() {
		return this.dataInativacao;
	}

	public void setDataInativacao(Date dataInativacao) {
		this.dataInativacao = dataInativacao;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Acessousuario> getAcessousuarios() {
		return this.acessousuarios;
	}

	public void setAcessousuarios(Set<Acessousuario> acessousuarios) {
		this.acessousuarios = acessousuarios;
	}
	
	public Set<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Set<Perfilusuario> getPerfilusuarios() {
		return this.perfilusuarios;
	}

	public void setPerfilusuarios(Set<Perfilusuario> perfilusuarios) {
		this.perfilusuarios = perfilusuarios;
	}
	
}