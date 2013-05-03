package br.com.onvix.sip.control;

import br.com.onvix.sip.commons.exception.SipException;


public class PerfilGrupoUsuarioControle {

//	private PerfilGrupoUsuarioDao perfilGrupoUsuarioDao = new PerfilGrupoUsuarioDao();
//	
//	public Perfilgrupousuario consultar(PerfilgrupousuarioPK perfilPK) throws SipException {
//		try{
//			Perfilgrupousuario retorno =  perfilGrupoUsuarioDao.consultar(perfilPK);
//			if(retorno == null){
//				throw new SipException("Nenhum Perfil do Grupo do Usuario Encontrado");
//			}
//			
//			return retorno;
//			
//		}catch(Exception ex){
//			throw new SipException("Erro ao Consultar o Perfil do Grupo de Usuario",this.getClass(),ex);
//		}
//	}
//
//
//	
//	public Perfilgrupousuario incluir(Perfilgrupousuario perfil) throws SipException {
//	//	validarAcao("INCLUIR", perfil);
//		try{
//			return perfilGrupoUsuarioDao.inserir(perfil);
//		}catch(Exception ex){
//			throw new SipException("Erro ao incluir Perfil do Grupo de Usuario",this.getClass(),ex);
//		}
//	}
//	
//	
//	public Perfilgrupousuario alterar(Perfilgrupousuario perfil) throws SipException {
//		//validarAcao("ALTERAR", perfil);
//		try{
//			return perfilGrupoUsuarioDao.alterar(perfil);
//		}catch(Exception ex){
//			throw new SipException("Erro ao Alterar o Perfil do Grupo de Usuario",this.getClass(),ex);
//		}
//	}
//
//	
//	public void excluir(Perfilgrupousuario perfil) throws SipException {
//		//validarAcao("EXCLUIR",perfil);
//		try{
//			perfilGrupoUsuarioDao.excluir(perfil);
//		}catch(Exception ex){
//			throw new SipException("Erro ao Excluir Perfil do Grupo de Usuario",this.getClass(),ex);
//		}	
//	}
//	
//	
//	
//	public Perfilgrupousuario persistir(Perfilgrupousuario perfil) throws SipException {
//		if(perfil!=null){
//			try{
//			if(perfil.getAlterar() == 0 && perfil.getConsultar() == 0 && perfil.getIncluir() == 0 && perfil.getExcluir() == 0 ){
//				if(perfilGrupoUsuarioDao.consultar(perfil.getId())!=null){
//					perfilGrupoUsuarioDao.excluir(consultar(perfil.getId()));
//				}
//			}else{
//				if(perfilGrupoUsuarioDao.consultar(perfil.getId())!=null){
//					perfilGrupoUsuarioDao.alterar(perfil);
//				}else{
//					perfilGrupoUsuarioDao.inserir(perfil);
//				}
//			}
//			}catch(Exception e){
//				throw new SipException("Erro ao persistir o perfil",this.getClass(),e);
//			}
//		}else{
//			throw new SipException("Perfil de Grupo de Usuario Invalido");
//		}
//		return null;
//	}

		
}
