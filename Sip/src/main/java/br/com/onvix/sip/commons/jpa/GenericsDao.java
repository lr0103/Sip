package br.com.onvix.sip.commons.jpa;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import br.com.onvix.sip.commons.util.Xml;

public abstract class GenericsDao<T,PK extends Serializable> extends DefaultGenericsDao<T, PK> {

	private static String caminhoPersistence;
	
	static{
		if(FacesContext.getCurrentInstance() != null){
			caminhoPersistence = ((ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext()).getRealPath("/WEB-INF/classes/META-INF/")+"/persistence.xml";
		}else{
			 caminhoPersistence = GenericsDao.class.getResource("/META-INF/persistence.xml").toString().replace("file:", "");
		}
	}
	
	public GenericsDao(){
		super(Xml.getAttributeValueByTagName(caminhoPersistence, "persistence-unit", "name").get(0));
	}

}
