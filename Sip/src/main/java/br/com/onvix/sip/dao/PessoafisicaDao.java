package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.commons.util.Criptografia;
import br.com.onvix.sip.entity.Pessoafisica;
import br.com.onvix.sip.entity.Usuario;

public class PessoafisicaDao extends GenericsDao<Pessoafisica, Integer> {


	public Usuario consultar(String login, String senha){
		DefaultGenericsQuery query = getQuery();
		query.find("Usuario");
		query.equals("login", login).equals("senha",Criptografia.criptografaMD5(senha));
		return (Usuario) query.uniqueResult();
	}

	public Pessoafisica inserir(Pessoafisica pessoaFisica) throws Exception{
		return super.insert(pessoaFisica);
	}
	
	public Pessoafisica alterar(Pessoafisica  pessoaFisica) throws Exception{
		return super.update(pessoaFisica);
	}
	
	public void excluir(Pessoafisica  pessoaFisica) throws Exception{
		super.delete(pessoaFisica);
	}
	
	public Pessoafisica consultar(int id){
		return super.findByID(id);
	}

	public List<Pessoafisica> listarTodos() {
		return super.findAll();
	}
	
	
}
