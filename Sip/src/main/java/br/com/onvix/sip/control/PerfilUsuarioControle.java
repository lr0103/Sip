package br.com.onvix.sip.control;

import java.util.List;

import br.com.onvix.sip.commons.exception.SipException;
import br.com.onvix.sip.dao.PerfilUsuarioDao;
import br.com.onvix.sip.entity.Perfilusuario;
import br.com.onvix.sip.entity.PerfilusuarioPK;

public class PerfilUsuarioControle {


	private PerfilUsuarioDao perfilUsuarioDao = new PerfilUsuarioDao();
	
	public Perfilusuario consultar(PerfilusuarioPK perfilPK) throws SipException {
		try{
			Perfilusuario retorno =  perfilUsuarioDao.consultar(perfilPK);
			if(retorno == null){
				throw new SipException("Nenhum Perfil do Usuario Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar o Perfil do Usuario",this.getClass(),ex);
		}
	}


	
	public Perfilusuario incluir(Perfilusuario perfil) throws SipException {
	//	validarAcao("INCLUIR", perfil);
		try{
			return perfilUsuarioDao.inserir(perfil);
		}catch(Exception ex){
			throw new SipException("Erro ao incluir Perfil do Usuario",this.getClass(),ex);
		}
	}
	
	
	public Perfilusuario alterar(Perfilusuario perfil) throws SipException {
		//validarAcao("ALTERAR", perfil);
		try{
			return perfilUsuarioDao.alterar(perfil);
		}catch(Exception ex){
			throw new SipException("Erro ao Alterar o Perfil do Usuario",this.getClass(),ex);
		}
	}

	
	public void excluir(Perfilusuario perfil) throws SipException {
		//validarAcao("EXCLUIR",perfil);
		try{
			perfilUsuarioDao.excluir(perfil);
		}catch(Exception ex){
			throw new SipException("Erro ao Excluir Perfil do Grupo de Usuario",this.getClass(),ex);
		}	
	}
	
//	public Perfilusuario persistir(Perfilusuario perfil) throws SipException {
//		if(perfil!=null){
//			try{
//				if(perfil.getAlterar() == 0 && perfil.getConsultar() == 0 && perfil.getIncluir() == 0 && perfil.getExcluir() == 0 ){
//					if(perfilUsuarioDao.consultar(perfil.getId())!=null){
//						perfilUsuarioDao.excluir(consultar(perfil.getId()));
//					}
//				}else{
//					if(perfilUsuarioDao.consultar(perfil.getId())!=null){
//						perfilUsuarioDao.alterar(perfil);
//					}else{
//						perfilUsuarioDao.inserir(perfil);
//					}
//				}
//			}catch(Exception e){
//				throw new SipException("Erro ao Persistir o Perfil",this.getClass(),e);
//			}
//		}else{
//			throw new SipException("Perfil de  de Usuario Inv�lido");
//		}
//		return null;
//	}


	
	public List<Perfilusuario> listarPorUsuario(int CodUsua) throws SipException {
		try{
			List<Perfilusuario> retorno =  perfilUsuarioDao.listarPorUsuario(CodUsua);
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Perfil de Usuario Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar Perfil do Usuario",this.getClass(),ex);
		}
	}	
	
}
