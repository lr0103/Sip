package br.com.onvix.sip.form;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;

import br.com.onvix.sip.commons.exception.SipException;
import br.com.onvix.sip.commons.jsf.Form;
import br.com.onvix.sip.control.UsuarioControle;
import br.com.onvix.sip.entity.Usuario;

@ManagedBean
@SessionScoped
public class PrincipalForm extends Form{

	private static final long serialVersionUID = 1L;

	private boolean sessaoAtiva = false;
	
	private Usuario usuario;
	
	public PrincipalForm(){
		usuario = new Usuario();
	}
	/**
	 * Logar
	 * @param actionEvent
	 */
	public void login(ActionEvent actionEvent){
	//public void login(){
		UsuarioControle usuarioControle = new UsuarioControle();
		try {
			usuario = usuarioControle.logar(usuario.getLogin(), usuario.getSenha());
			msgErro("asd");
			sessaoAtiva = true;
		} catch (SipException e) {
			msgErro(e.getMessage());
			sessaoAtiva = false;
		}
		getContext().addCallbackParam("logado", sessaoAtiva);
	}
	
	//Logoff do Sistema
	public void logoff(){
		((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate(); 
	}
	
	public boolean isSessaoAtiva() {
		return sessaoAtiva;
	}

	public void setSessaoAtiva(boolean sessaoAtiva) {
		this.sessaoAtiva = sessaoAtiva;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
}