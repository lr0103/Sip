package br.com.onvix.sip.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



/**
 * The persistent class for the pessoafisica database table.
 * 
 */
@Entity
@Table(name="pessoafisica")
@PrimaryKeyJoinColumn(name="id")
public class Pessoafisica extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cpf;
	private Date dataNascimento;
	private String estadoCivil;
	private int identidade;
	private String nacionalidade;
	private String naturalidade;
	private String nome;
	private String nomeMea;
	private String nomePai;
	private String sexo;
	
	private byte conjugeBrasileiro;

	private String ctpsNumero;

	private String ctpsSerie;

    

	private int grauInstrucao;

	

	private String modeloCarteira;

	private byte naturalizado;

	private byte possuiFilhoBrasileiro;

	private int quantidadeFilhos;

	private String reservistaCaterogia;

	private String reservistaCertificado;

	
	
    public Pessoafisica() {
    }


	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


    @Temporal( TemporalType.DATE)
	public Date getDataNascimento() {
		return this.dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public int getIdentidade() {
		return this.identidade;
	}

	public void setIdentidade(int identidade) {
		this.identidade = identidade;
	}


	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public String getNaturalidade() {
		return this.naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}


	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNomeMea() {
		return this.nomeMea;
	}

	public void setNomeMea(String nomeMea) {
		this.nomeMea = nomeMea;
	}


	public String getNomePai() {
		return this.nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}


	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public byte getConjugeBrasileiro() {
		return this.conjugeBrasileiro;
	}

	public void setConjugeBrasileiro(byte conjugeBrasileiro) {
		this.conjugeBrasileiro = conjugeBrasileiro;
	}

	public String getCtpsNumero() {
		return this.ctpsNumero;
	}

	public void setCtpsNumero(String ctpsNumero) {
		this.ctpsNumero = ctpsNumero;
	}

	public String getCtpsSerie() {
		return this.ctpsSerie;
	}

	public void setCtpsSerie(String ctpsSerie) {
		this.ctpsSerie = ctpsSerie;
	}

	

	public int getGrauInstrucao() {
		return this.grauInstrucao;
	}

	public void setGrauInstrucao(int grauInstrucao) {
		this.grauInstrucao = grauInstrucao;
	}
	public String getModeloCarteira() {
		return this.modeloCarteira;
	}

	public void setModeloCarteira(String modeloCarteira) {
		this.modeloCarteira = modeloCarteira;
	}

	public byte getNaturalizado() {
		return this.naturalizado;
	}

	public void setNaturalizado(byte naturalizado) {
		this.naturalizado = naturalizado;
	}

	public byte getPossuiFilhoBrasileiro() {
		return this.possuiFilhoBrasileiro;
	}

	public void setPossuiFilhoBrasileiro(byte possuiFilhoBrasileiro) {
		this.possuiFilhoBrasileiro = possuiFilhoBrasileiro;
	}

	public int getQuantidadeFilhos() {
		return this.quantidadeFilhos;
	}

	public void setQuantidadeFilhos(int quantidadeFilhos) {
		this.quantidadeFilhos = quantidadeFilhos;
	}

	public String getReservistaCaterogia() {
		return this.reservistaCaterogia;
	}

	public void setReservistaCaterogia(String reservistaCaterogia) {
		this.reservistaCaterogia = reservistaCaterogia;
	}

	public String getReservistaCertificado() {
		return this.reservistaCertificado;
	}

	public void setReservistaCertificado(String reservistaCertificado) {
		this.reservistaCertificado = reservistaCertificado;
	}	
	
}