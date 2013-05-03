package br.com.onvix.sip.control;

import java.util.List;

import br.com.onvix.sip.commons.exception.SipException;
import br.com.onvix.sip.dao.SistemaDao;
import br.com.onvix.sip.entity.Sistema;

public class SistemaControle{

	private SistemaDao sistemaDao = new SistemaDao();
		
	public Sistema incluir(Sistema sistema) throws SipException {
		validarAcao("INCLUIR", sistema);
		try{
			return sistemaDao.inserir(sistema);
		}catch(Exception ex){
			throw new SipException("Erro ao incluir o Sistema",this.getClass(),ex);
		}
	}
	
	
	
	public Sistema alterar(Sistema sistema) throws SipException {
		validarAcao("ALTERAR", sistema);
		try{
			return sistemaDao.alterar(sistema);
		}catch(Exception ex){
			throw new SipException("Erro ao Alterar o Sistema",this.getClass(),ex);
		}
	}
	
	

	
	public Sistema consultar(int idSistema) throws SipException {
		try{
			Sistema retorno =  sistemaDao.consultar(idSistema);
			if(retorno == null){
				throw new SipException("Nenhum Sistema Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar o Sistema",this.getClass(),ex);
		}
	}

	
	public List<Sistema> listarTodos() throws SipException {
		try{
			List<Sistema> retorno =  sistemaDao.listarTodos();
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Sistema Encontrado");
			}
				
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Listar os Sistemas",this.getClass(),ex);
		}
	}
	
	
	public List<Sistema> filtrarPorDescricao(String descricao) throws SipException {
		try{
			List<Sistema> retorno =  sistemaDao.filtrarPorDescricao(descricao);
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Sistema Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar o Sistema pela Descricao",this.getClass(),ex);
		}
	}

	
	
	public void excluir(Sistema sistema) throws SipException {
		validarAcao("EXCLUIR",sistema);
		try{
			sistemaDao.excluir(sistema);
		}catch(Exception ex){
			throw new SipException("Erro ao Excluir o Sistema",this.getClass(),ex);
		}	
	}
	
	
	private void validarAcao(String acao,Sistema sistema) throws SipException {
		try{
			if(acao.equalsIgnoreCase("INCLUIR")){
				List<Sistema> confere = sistemaDao.filtrarPorDescricao(sistema.getDescricao());
				if(confere != null && !confere.isEmpty()){
						throw new SipException("Menu do Sistema em Duplicidade");
				}
			}else
			if(acao.equalsIgnoreCase("ALTERAR")){
				List<Sistema> confere = sistemaDao.filtrarPorDescricao(sistema.getDescricao());
				for (Sistema sis : confere) {
					if( sis.getIdsistema()!= sis.getIdsistema()){
						throw new SipException("Sistema em Duplicidade");
					}
				}
			}else
			if(acao.equalsIgnoreCase("EXCLUIR")){
				//Verificar se existe alguma regra na hora de excluir o Sistema
			}
			
		}catch (Exception ex){
			throw new SipException("Erro ao Validar o Sistema");
		}
	}

}
