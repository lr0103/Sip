package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * The primary key class for the telefonepessoa database table.
 * 
 */
@Embeddable
public class TelefonepessoaPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private int idpessoa;
	private int idtelefone;

    public TelefonepessoaPK() {
    }

	public int getIdpessoa() {
		return this.idpessoa;
	}
	public void setIdpessoa(int idpessoa) {
		this.idpessoa = idpessoa;
	}

	public int getIdtelefone() {
		return this.idtelefone;
	}
	public void setIdtelefone(int idtelefone) {
		this.idtelefone = idtelefone;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TelefonepessoaPK)) {
			return false;
		}
		TelefonepessoaPK castOther = (TelefonepessoaPK)other;
		return 
			(this.idpessoa == castOther.idpessoa)
			&& (this.idtelefone == castOther.idtelefone);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idpessoa;
		hash = hash * prime + this.idtelefone;
		
		return hash;
    }
}