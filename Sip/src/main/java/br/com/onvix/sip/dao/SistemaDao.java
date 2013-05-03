package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.entity.Sistema;

public class SistemaDao extends GenericsDao<Sistema, Integer> {

	public Sistema inserir(Sistema Sistema) throws Exception{
		return super.insert(Sistema);
	}
	
	public Sistema alterar(Sistema Sistema) throws Exception{
		return super.update(Sistema);
	}
	
	public void excluir(Sistema Sistema) throws Exception{
		super.delete(Sistema);
	}
	
	public Sistema consultar(int idSistema){
		return super.findByID(idSistema);
	}
	
	public List<Sistema> listarTodos() {
		return super.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<Sistema> filtrarPorDescricao(String descricao) {
		DefaultGenericsQuery query = getQuery();
		query.find("Sistema");
		query.like("descricao", descricao+"%");
		return query.list();
	}	
}
