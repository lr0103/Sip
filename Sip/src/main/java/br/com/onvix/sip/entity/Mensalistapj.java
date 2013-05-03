package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.onvix.sip.entity.interfaces.IMensalista;


/**
 * The persistent class for the mensalistapj database table.
 * 
 */
@Entity
@Table(name="mensalistapj")
@PrimaryKeyJoinColumn(name="id")
public class Mensalistapj extends Pessoajuridica implements IMensalista,Serializable {
	private static final long serialVersionUID = 1L;



	private Double saldo;

	
    public Mensalistapj() {
    }


	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}