package br.com.onvix.sip.commons.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Xml {
	
	public static List<String> getAttributeValueByTagName(String arquivoXml, String tagName, String attribute){
		try {
			File fXmlFile = new File(arquivoXml);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder;
			
				dBuilder = dbFactory.newDocumentBuilder();
			
			Document doc = dBuilder.parse(fXmlFile);
		 
			doc.getDocumentElement().normalize();
		 
			NodeList nList = doc.getElementsByTagName(tagName);
			List<String> result = null; 
			for (int temp = 0; temp < nList.getLength(); temp++) {
		 
				Node nNode = nList.item(temp);
		 
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
					if(result == null){
						result = new ArrayList<String>();
					}
					Element eElement = (Element) nNode;
		 
					result.add(eElement.getAttribute(attribute));
				}
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	  }

}
