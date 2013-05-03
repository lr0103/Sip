package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.commons.util.Criptografia;
import br.com.onvix.sip.entity.Pessoa;
import br.com.onvix.sip.entity.Usuario;

public class PessoaDao extends GenericsDao<Pessoa, Integer> {


	public Pessoa inserir(Pessoa pessoa) throws Exception{
		return super.insert(pessoa);
	}
	
	public Pessoa alterar(Pessoa  pessoa) throws Exception{
		return super.update(pessoa);
	}
	
	public void excluir(Pessoa pessoa) throws Exception{
		super.delete(pessoa);
	}
	
	public Pessoa consultar(int id){
		return super.findByID(id);
	}

	public List<Pessoa> listarTodos() {
		return super.findAll();
	}
	
	
}
