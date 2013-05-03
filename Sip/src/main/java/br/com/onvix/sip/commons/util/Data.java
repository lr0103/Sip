package br.com.onvix.sip.commons.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Data {

	 /**
     * Formata a data removendo os segundos
     * @param data
     * @return Date sem os segundos
     */
    public static Date removeSegundos(Date data){
    	Calendar now = new GregorianCalendar();
    	now.setTime(data);
    	int year = now.get(Calendar.YEAR);
    	int month = now.get(Calendar.MONTH);
    	int date = now.get(Calendar.DATE);  
    	int h = now.get(Calendar.HOUR_OF_DAY);  
    	int m = now.get(Calendar.MINUTE);  
    	int s = 0; 
    	now.set(year, month, date, h, m, s);

    	return new Date(now.getTimeInMillis());
    }
    
    /**
     * Formata a data por extenso
     * @param data
     * @return string com a data em extenso
     */
    public static String formataDataPorExtenso(Date data){
    	int dia = Integer.valueOf(formataData(data, "dd/MM/yyyy").split("/")[0].trim());
    	int mes = Integer.valueOf(formataData(data, "dd/MM/yyyy").split("/")[1].trim());
    	int ano = Integer.valueOf(formataData(data, "dd/MM/yyyy").split("/")[2].trim());
    	switch (mes) {
    		case 01: return dia +" de Janeiro de "+ano;
    		case 02: return dia +" de Fevereiro de "+ano;
    		case 03: return dia +" de Março de "+ano;
        	case 04: return dia +" de Abril de "+ano;
        	case 05: return dia +" de Maio de "+ano;
            case 06: return dia +" de Junho de "+ano;
    		case 07: return dia +" de Julho de "+ano;
        	case 8:  return dia +" de Agosto de "+ano;
        	case 9:  return dia +" de Setembro de "+ano;
           	case 10: return dia +" de Outubro de "+ano;
           	case 11: return dia +" de Novembro de "+ano;
           	case 12: return dia +" de Dezembro de "+ano;
    	}
    	return null;
    }
    
    /**
     * Formata a data com um determinado formato
     * </br></br>
     * @param data
     * @param formato (ex: dd/MM/yyyy HH:mm:ss)
     * @return string com a data formatada
     */
    public static String formataData(Date data, String formato) {
        java.text.DateFormat dateFmt =  new java.text.SimpleDateFormat(formato);
        String strData = dateFmt.format(data).toString();
        return strData;
    }
}
