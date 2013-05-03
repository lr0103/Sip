package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * The persistent class for the serventia database table.
 * 
 */
@Entity
@Table(name="serventia")
public class Serventia implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Pessoajuridica pessoajuridica;

    public Serventia() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//bi-directional one-to-one association to Pessoajuridica
	@OneToOne
	@JoinColumn(name="id")
	public Pessoajuridica getPessoajuridica() {
		return this.pessoajuridica;
	}

	public void setPessoajuridica(Pessoajuridica pessoajuridica) {
		this.pessoajuridica = pessoajuridica;
	}
	
}