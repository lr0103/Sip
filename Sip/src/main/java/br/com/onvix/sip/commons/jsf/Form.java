package br.com.onvix.sip.commons.jsf;


import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class Form implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	protected String acao;
	
	/** MENSAGENS DO JSF */
	public void msgInformacao(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"",msg));
	}
	public void msgAtencao(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"",msg));
	}
	public void msgErro(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"",msg));
	}
	public void msgErroFatal(String msg){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,"",msg));
	}
	
	public RequestContext getContext(){
		return RequestContext.getCurrentInstance(); 
	}
	
	/** GETS E SETS */
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
		
}

