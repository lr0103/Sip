package br.com.onvix.sip.control;

import java.util.List;

import br.com.onvix.sip.commons.exception.SipException;
import br.com.onvix.sip.dao.UsuarioDao;
import br.com.onvix.sip.entity.Usuario;

public class UsuarioControle{

	private UsuarioDao usuarioDao = new UsuarioDao();
	

	public Usuario logar(String login, String senha) throws SipException {
		try{
			Usuario retorno =  usuarioDao.consultar(login,senha);
			if(retorno == null){
				throw new SipException("Nenhum Usuario Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar o Usuario",this.getClass(),ex);
		}
	}
	
	
	
	public Usuario inserir(Usuario usuario) throws SipException {
		validarAcao("inserir", usuario);
		try{
			return usuarioDao.inserir(usuario);
		}catch(Exception ex){
			throw new SipException("Erro ao inserir Usuario",this.getClass(),ex);
		}
	}
	
	
	public Usuario alterar(Usuario usuario) throws SipException {
		validarAcao("ALTERAR", usuario);
		try{
			return usuarioDao.alterar(usuario);
		}catch(Exception ex){
			throw new SipException("Erro ao Alterar o Usuario",this.getClass(),ex);
		}
	}

	
	public void excluir(Usuario usuario) throws SipException {
		validarAcao("EXCLUIR",usuario);
		try{
			usuarioDao.excluir(usuario);
		}catch(Exception ex){
			throw new SipException("Erro ao Excluir o Usuario",this.getClass(),ex);
		}	
	}
	
	
	public Usuario consultarPeloCodigo(Integer codUSUA) throws SipException {
		try{
			Usuario retorno =  usuarioDao.consultar(codUSUA);
			if(retorno == null){
				throw new SipException("Nenhum Usuario Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar o Usuario",this.getClass(),ex);
		}
	}
	
	public List<Usuario> listarPeloNome(String nmeUSUA) throws SipException {
		try{
			List<Usuario> retorno =  usuarioDao.filtrarPorNome(nmeUSUA);
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Usuario Encontrado");
			}
			
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Consultar Usuario pela Descricao",this.getClass(),ex);
		}
	}
	
	public List<Usuario> listarTodos() throws SipException {
		try{
			List<Usuario> retorno =  usuarioDao.listarTodos();
			if(retorno == null || retorno.isEmpty()){
				throw new SipException("Nenhum Usuario Encontrado");
			}
				
			return retorno;
			
		}catch(Exception ex){
			throw new SipException("Erro ao Listar o Usuario",this.getClass(),ex);
		}
	}

	
	private void validarAcao(String acao,Usuario usuario) throws SipException {
		try{
//			if(acao.equalsIgnoreCase("inserir")){
//				List<Usuario> confere = usuarioDao.filtrarPorNome(usuario.getNome());
//				if(confere != null && !confere.isEmpty()){
//						throw new SipException("Usuarios em Duplicidade");
//				}
//			}else
			if(acao.equalsIgnoreCase("ALTERAR")){
//				List<Usuario> confere = usuarioDao.filtrarPorNome(usuario.getNome());
//				for (Usuario usu : confere) {
//					if(usu.getId() != usu.getId() ){
//						throw new SipException("Usuarios em Duplicidade");
//					}
//				}
			}else
			if(acao.equalsIgnoreCase("EXCLUIR")){
				//Verificar se existe alguma regra na hora de excluir um grupo
			}
			
		}catch (Exception ex){
			throw new SipException("Erro ao Validar Usu�rio");
		}
	}
}
