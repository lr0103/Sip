package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the pessoa database table.
 * 
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String email;
	
		
	
	
	//bi-directional many-to-one association to Usuario
    @ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
    //bi-directional many-to-one association to Telefonepessoa
  	@OneToMany(mappedBy="pessoa")  	
    private Set<Telefonepessoa> telefonepessoas;

    public Pessoa() {
    }
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


		

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Set<Telefonepessoa> getTelefonepessoas() {
		return this.telefonepessoas;
	}

	public void setTelefonepessoas(Set<Telefonepessoa> telefonepessoas) {
		this.telefonepessoas = telefonepessoas;
	}
	
	

	
}