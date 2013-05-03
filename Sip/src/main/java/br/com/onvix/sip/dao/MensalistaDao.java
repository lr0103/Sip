package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.commons.util.Criptografia;
import br.com.onvix.sip.entity.Usuario;
import br.com.onvix.sip.entity.interfaces.IMensalista;

public class MensalistaDao extends GenericsDao<IMensalista, Integer> {


	public IMensalista inserir(IMensalista mensalista) throws Exception{
		return super.insert(mensalista);
	}
	
	public IMensalista alterar(IMensalista  mensalista) throws Exception{
		return super.update(mensalista);
	}
	
	public void excluir(IMensalista  mensalista) throws Exception{
		super.delete(mensalista);
	}
	
	public IMensalista consultar(int id){
		return super.findByID(id);
	}

	public List<IMensalista> listarTodos() {
		return super.findAll();
	}
	
	
}
