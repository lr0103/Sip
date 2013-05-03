package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.entity.Menusistema;

public class MenuSistemaDao extends GenericsDao<Menusistema, Integer> {

	
	public Menusistema inserir(Menusistema menusistema) throws Exception{
		return super.insert(menusistema);
	}
	public Menusistema alterar(Menusistema menusistema) throws Exception{
		return super.update(menusistema);
	}
	public void excluir(Menusistema menusistema) throws Exception{
		super.delete(menusistema);
	}
	public Menusistema consultar(int idMenusistema){
		return super.findByID(idMenusistema);
	}

	public List<Menusistema> listarTodos() {
		return super.findAll();
	}
	
	@SuppressWarnings("unchecked")
	public List<Menusistema> listarPorSistema(int idSistema){
		DefaultGenericsQuery query = getQuery();
		query.find("Menusistema menu");
		query.equals("menu.sistema.idsistema", idSistema);
		query.isNotNull("menu.modulosistema");
		query.orderBy("menu.idmenu");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Menusistema> filtrarPorDescricao(String descricao) {
		DefaultGenericsQuery query = getQuery();
		query.find("Menusistema");
		query.like("dscMenu", descricao+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Menusistema> filtrarPorMenu(Menusistema menusistema) {
		DefaultGenericsQuery query = getQuery();
		query.find("Menusistema menu");
		query.inElements("menu.menuItens", menusistema);
		return query.list();
	}
	
	
}
