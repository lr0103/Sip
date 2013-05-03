package br.com.onvix.sip.control;

import java.util.List;

import br.com.onvix.sip.commons.exception.SipException;
import br.com.onvix.sip.dao.MenuSistemaDao;
import br.com.onvix.sip.entity.Menusistema;


public class MenuSistemaControle{

	private MenuSistemaDao menuSistemaDao = new MenuSistemaDao();
	
	public Menusistema incluir(Menusistema menusistema) throws SipException {
		validarAcao("INCLUIR", menusistema);
		try{
			return menuSistemaDao.inserir(menusistema);
		}catch(Exception ex){
			throw new SipException("Erro ao incluir Menu do Sistema",this.getClass(),ex);
		}
	}
	
	
	
	public Menusistema alterar(Menusistema menusistema) throws SipException {
		validarAcao("ALTERAR", menusistema);
		try{
			return menuSistemaDao.alterar(menusistema);
		}catch(Exception ex){
			throw new SipException("Erro ao Alterar Menu do Sistema",this.getClass(),ex);
		}
	}
	
	
	
	public Menusistema consultar(int idMenusistema) throws SipException {
		try{
			Menusistema retorno =  menuSistemaDao.consultar(idMenusistema);
			if(retorno == null){
				throw new SipException("Nenhum Menu Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar Menu do Sistema",this.getClass(),ex);
		}
	}

	
	
	public List<Menusistema> listarTodos() throws SipException {
		try{
			List<Menusistema> retorno =  menuSistemaDao.listarTodos();
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Menu Encontrado");
			}
				
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Listar Todos Grupos de Usuarios",this.getClass(),ex);
		}
	}
	
	
	public List<Menusistema> filtrarPorDescricao(String descricao) throws SipException {
		try{
			List<Menusistema> retorno =  menuSistemaDao.filtrarPorDescricao(descricao);
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Menu de Sistema Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar Menu de Sistema pela Descricao",this.getClass(),ex);
		}
	}

	
	
	public void excluir(Menusistema menusistema) throws SipException {
		validarAcao("EXCLUIR",menusistema);
		try{
			menuSistemaDao.excluir(menusistema);
		}catch(Exception ex){
			throw new SipException("Erro ao Excluir Menu do Sistema",this.getClass(),ex);
		}	
	}
	
	
	
	public List<Menusistema> listarPorSistema(int idSistema) throws SipException {
		List<Menusistema> retorno =  menuSistemaDao.listarPorSistema(idSistema);
		if(retorno == null || retorno.isEmpty()){
			throw new SipException("Nenhum Menu Encontrado");
		}else{
			return retorno;
		}
	}
	
	
	
	public List<Menusistema> listarPorMenuSistema(Menusistema menusistema) throws SipException {
		try{
			List<Menusistema> retorno = menuSistemaDao.filtrarPorMenu(menusistema);
			if (retorno == null || retorno.isEmpty()) {
				throw new SipException("Nenhum Grupo de Usuarios Encontrado");
			}
			
			return retorno;
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar Grupo de Usuarios por Usu�rio",this.getClass(),ex);
		}
	}
	
	private void validarAcao(String acao,Menusistema menusistema) throws SipException {
		try{
			if(acao.equalsIgnoreCase("INCLUIR")){
				List<Menusistema> confere = menuSistemaDao.filtrarPorDescricao(menusistema.getDescricao());
				if(confere != null && !confere.isEmpty()){
						throw new SipException("Menu do Sistema em Duplicidade");
				}
			}else
			if(acao.equalsIgnoreCase("ALTERAR")){
				List<Menusistema> confere = menuSistemaDao.filtrarPorDescricao(menusistema.getDescricao());
				for (Menusistema sis : confere) {
					if( sis.getId()!= sis.getId()){
						throw new SipException("Menu do Sistema em Duplicidade");
					}
				}
			}else
			if(acao.equalsIgnoreCase("EXCLUIR")){
				//Verificar se existe alguma regra na hora de excluir o Menu
			}
			
		}catch (Exception ex){
			throw new SipException("Erro ao Validar o Grupo de Usu�rios");
		}
	}

	
}
