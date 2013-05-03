package br.com.onvix.sip.dao;

import java.util.List;

import br.com.onvix.sip.commons.jpa.GenericsDao;
import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;
import br.com.onvix.sip.commons.util.Criptografia;
import br.com.onvix.sip.entity.Funcionario;
import br.com.onvix.sip.entity.Usuario;

public class FuncionarioDao extends GenericsDao<Funcionario, Integer> {


	public Usuario consultar(String login, String senha){
		DefaultGenericsQuery query = getQuery();
		query.find("Usuario");
		query.equals("login", login).equals("senha",Criptografia.criptografaMD5(senha));
		return (Usuario) query.uniqueResult();
	}

	public Funcionario inserir(Funcionario funcionario) throws Exception{
		return super.insert(funcionario);
	}
	
	public Funcionario alterar(Funcionario  funcionario) throws Exception{
		return super.update(funcionario);
	}
	
	public void excluir(Funcionario  funcionario) throws Exception{
		super.delete(funcionario);
	}
	
	public Funcionario consultar(int id){
		return super.findByID(id);
	}

	public List<Funcionario> listarTodos() {
		return super.findAll();
	}
	
	
}
