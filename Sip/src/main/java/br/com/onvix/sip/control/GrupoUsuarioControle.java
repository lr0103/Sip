package br.com.onvix.sip.control;



public class GrupoUsuarioControle{

//	private GrupoUsuarioDao grupoUsuarioDao = new GrupoUsuarioDao();
//		
//	public Grupousuario incluir(Grupousuario grupo) throws SipException {
//		validarAcao("INCLUIR", grupo);
//		try{
//			return grupoUsuarioDao.inserir(grupo);
//		}catch(Exception ex){
//			throw new SipException("Erro ao incluir Grupo de  Usuarios",this.getClass(),ex);
//		}
//	}
//
//	public Grupousuario alterar(Grupousuario grupo) throws SipException {
//		validarAcao("ALTERAR", grupo);
//		try{
//			return grupoUsuarioDao.alterar(grupo);
//		}catch(Exception ex){
//			throw new SipException("Erro ao Alterar Grupo de Usuarios",this.getClass(),ex);
//		}
//	}
//
//	public Grupousuario consultar(int idGrupousuario) throws SipException {
//		try{
//			Grupousuario retorno =  grupoUsuarioDao.consultar(idGrupousuario);
//			if(retorno == null){
//				throw new SipException("Nenhum Grupo de Usuarios Encontrado");
//			}
//			
//			return retorno;
//		}catch(Exception ex){
//			throw new SipException("Erro ao Consultar Grupo de Usuarios",this.getClass(),ex);
//		}
//	}
//
//	public List<Grupousuario> listarTodos() throws SipException {
//		try{
//			List<Grupousuario> retorno =  grupoUsuarioDao.listarTodos();
//			if(retorno == null || retorno.isEmpty()){
//				throw new SipException("Nenhum Grupo de Usuarios Encontrado");
//			}
//				
//			return retorno;
//		}catch(Exception ex){
//			throw new SipException("Erro ao Listar Todos Grupos de Usuarios",this.getClass(),ex);
//		}
//	}
//
//	public List<Grupousuario> filtrarPorDescricao(String descricao) throws SipException {
//		try{
//			List<Grupousuario> retorno =  grupoUsuarioDao.filtrarPorDescricao(descricao);
//			if(retorno == null || retorno.isEmpty()){
//				throw new SipException("Nenhum Grupo de Usuarios Encontrado");
//			}
//			
//			return retorno;
//		}catch(Exception ex){
//			throw new SipException("Erro ao Consultar Grupo de Usuarios pela Descricao",this.getClass(),ex);
//		}
//	}
//
//	
//	public void excluir(Grupousuario grupo) throws SipException {
//		validarAcao("EXCLUIR",grupo);
//		try{
//			grupoUsuarioDao.excluir(grupo);
//		}catch(Exception ex){
//			throw new SipException("Erro ao Excluir Grupo de Usuarios",this.getClass(),ex);
//		}	
//	}
//
//	
//	public List<Grupousuario> listarPorUsuario(Usuario usuario) throws SipException {
//		try{
//			List<Grupousuario> retorno = grupoUsuarioDao.filtrarPorUsuario(usuario);
//			if (retorno == null || retorno.isEmpty()) {
//				throw new SipException("Nenhum Grupo de Usuarios Encontrado");
//			}
//			
//			return retorno;
//		}catch(Exception ex){
//			throw new SipException("Erro ao Consultar Grupo de Usuarios por Usu�rio",this.getClass(),ex);
//		}
//	}
//
//	private void validarAcao(String acao,Grupousuario grupo) throws SipException {
//		try{
//			if(acao.equalsIgnoreCase("INCLUIR")){
//				List<Grupousuario> confere = grupoUsuarioDao.filtrarPorDescricao(grupo.getDescricao());
//				if(confere != null && !confere.isEmpty()){
//						throw new SipException("Grupo de Usuarios Duplicado");
//				}
//			}else
//			if(acao.equalsIgnoreCase("ALTERAR")){
//				List<Grupousuario> confere = grupoUsuarioDao.filtrarPorDescricao(grupo.getDescricao());
//				for (Grupousuario gr : confere) {
//					if(gr.getIdgrupousuario() != grupo.getIdgrupousuario()){
//						throw new SipException("Grupo de Usuarios Duplicado");
//					}
//				}
//			}else
//			if(acao.equalsIgnoreCase("EXCLUIR")){
//				//Verificar se existe alguma regra na hora de excluir um grupo
//			}
//			
//		}catch (Exception ex){
//			throw new SipException("Erro ao Validar o Grupo de Usu�rios");
//		}
//	}
	

}
