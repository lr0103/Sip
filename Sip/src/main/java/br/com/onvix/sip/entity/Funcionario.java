package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@Table(name="funcionario")
@PrimaryKeyJoinColumn(name="id")
public class Funcionario extends Pessoafisica implements Serializable {
	private static final long serialVersionUID = 1L;

	private String matricula;
	
	@Temporal( TemporalType.DATE)
	private Date dataAdmissao;

	private String cbo;
	
	private double salario;

	//bi-directional many-to-one association to Dependente
	@OneToMany(mappedBy="funcionario")
	private Set<Dependente> dependentes;

	//bi-directional many-to-one association to Cargo
    @ManyToOne
	@JoinColumn(name="idCargo")
	private Cargo cargo;

	//bi-directional one-to-one association to Pessoafisica
	@OneToOne
	@JoinColumn(name="id")
	private Pessoafisica pessoafisica;

    public Funcionario() {
    }

	public String getCbo() {
		return this.cbo;
	}

	public void setCbo(String cbo) {
		this.cbo = cbo;
	}

	
	public String getMatricula() {
		return this.matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Set<Dependente> getDependentes() {
		return this.dependentes;
	}

	public void setDependentes(Set<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
	public Cargo getCargo() {
		return this.cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	
	public Pessoafisica getPessoafisica() {
		return this.pessoafisica;
	}

	public void setPessoafisica(Pessoafisica pessoafisica) {
		this.pessoafisica = pessoafisica;
	}
	public Date getDataAdmissao() {
		return this.dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}	
}