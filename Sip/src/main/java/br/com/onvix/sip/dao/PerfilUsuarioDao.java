package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.entity.Perfilusuario;
import br.com.onvix.sip.entity.PerfilusuarioPK;

public class PerfilUsuarioDao extends GenericsDao<Perfilusuario, PerfilusuarioPK> {

	public Perfilusuario inserir(Perfilusuario perfil) throws Exception{
		return super.insert(perfil);	
	}
	
	public Perfilusuario alterar(Perfilusuario perfil) throws Exception{
		return super.update(perfil);		
	}
	
	public void excluir(Perfilusuario perfil) throws Exception{
		super.delete(perfil);
	}

	public Perfilusuario consultar(PerfilusuarioPK perfilPK){
		return super.findByID(perfilPK);
	}

	@SuppressWarnings("unchecked")
	public List<Perfilusuario> listarPorUsuario(int idusuario){
		DefaultGenericsQuery query = getQuery();
		query.find("Perfilusuario perfil");
		query.equals("perfil.id.idusuario", idusuario);
		return query.list();
	}
	
}
