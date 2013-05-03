package br.com.onvix.sip.commons.exception;

import java.util.Date;

public class SipException extends Throwable {

	private static final long serialVersionUID = 4445396810504899402L;

	public SipException(String msg){
		super(msg);
	}
	
	//Vai ser usado pra gerar um arquivo de LOG ou algo parecido
	public SipException(String msg,  Class<?> classe,  Exception ex){
		super(msg);
		String log = new String(new Date().toString()+" | "+classe.getCanonicalName()+" | "+msg+" | "+ex.getMessage());
		System.out.println(log);
	}

	
	
}
