package br.com.onvix.sip.entity;

import java.io.Serializable;
import javax.persistence.*;

import br.com.onvix.sip.entity.interfaces.IMensalista;


/**
 * The persistent class for the mensalistapf database table.
 * 
 */
@Entity
@Table(name="mensalistapf")
@PrimaryKeyJoinColumn(name="id")
public class Mensalistapf extends Pessoafisica implements IMensalista,Serializable {
	private static final long serialVersionUID = 1L;

	private Double saldo;

	
	public Double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	
}