package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.commons.util.Criptografia;
import br.com.onvix.sip.entity.Usuario;

public class UsuarioDao extends GenericsDao<Usuario, Integer> {


	public Usuario consultar(String login, String senha){
		//DefaultGenericsQuery query = getQuery();
		//query.find("Usuario");
		//query.equals("login", login).equals("senha",Criptografia.criptografaMD5(senha));
		//return (Usuario) query.uniqueResult();
		
		Usuario u = new Usuario();
		u.setLogin("asdasd");
		u.setSenha("asd");
		return u;
	}

	public Usuario inserir(Usuario usuario) throws Exception{
		return super.insert(usuario);
	}
	
	public Usuario alterar(Usuario usuario) throws Exception{
		return super.update(usuario);
	}
	
	public void excluir(Usuario usuario) throws Exception{
		super.delete(usuario);
	}
	
	public Usuario consultar(int idUsuario){
		return super.findByID(idUsuario);
	}

	public List<Usuario> listarTodos() {
		return super.findAll();
	}

	@SuppressWarnings("unchecked")
	public List<Usuario> filtrarPorNome(String nome) {
		DefaultGenericsQuery query = getQuery();
		query.find("Usuario");
		query.like("nome", nome+"%");
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> filtrarPorLogin(String login) {
		DefaultGenericsQuery query = getQuery();
		query.find("Usuario");
		query.like("login", login+"%");
		return query.list();
	}
	
	
}
