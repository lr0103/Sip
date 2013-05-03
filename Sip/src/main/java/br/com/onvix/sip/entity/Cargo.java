package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



/**
 * The persistent class for the cargo database table.
 * 
 */
@Entity
@Table(name="cargo")
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String cargocol;
	private String descricao;
	private Set<Funcionario> funcionarios;

    public Cargo() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getCargocol() {
		return this.cargocol;
	}

	public void setCargocol(String cargocol) {
		this.cargocol = cargocol;
	}


	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	//bi-directional many-to-one association to Funcionario
	@OneToMany(mappedBy="cargo")
	public Set<Funcionario> getFuncionarios() {
		return this.funcionarios;
	}

	public void setFuncionarios(Set<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}