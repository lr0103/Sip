package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the dependente database table.
 * 
 */
@Entity
@Table(name="dependente")
public class Dependente implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private Date dataNacimento;
	private String nome;
	private String parentesco;
	private Funcionario funcionario;

    public Dependente() {
    }


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


    @Temporal( TemporalType.DATE)
	public Date getDataNacimento() {
		return this.dataNacimento;
	}

	public void setDataNacimento(Date dataNacimento) {
		this.dataNacimento = dataNacimento;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getParentesco() {
		return this.parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}


	//bi-directional many-to-one association to Funcionario
    @ManyToOne
	@JoinColumn(name="idfuncionario")
	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
}