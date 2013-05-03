package br.com.onvix.sip.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;


@Embeddable
public class PerfilusuarioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private int idusuario;

	private int idmenu;

    public PerfilusuarioPK() {
    }
    
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdmenu() {
		return idmenu;
	}

	public void setIdmenu(int idmenu) {
		this.idmenu = idmenu;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PerfilusuarioPK)) {
			return false;
		}
		PerfilusuarioPK castOther = (PerfilusuarioPK)other;
		return 
			(this.idusuario == castOther.idusuario)
			&& (this.idmenu == castOther.idmenu);

    }
    
	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idusuario;
		hash = hash * prime + this.idmenu;
		
		return hash;
    }
}