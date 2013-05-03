package br.com.onvix.sip.commons.jpa.generics;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Emiliano de Souza PEssoa
 * Uma solu��o parecida com Criteria por�m gerando puro HQL. 
 * Exemplo de uma consulta de usuarios com nome come�ando com Emiliano, ordenado pelo nome:
 * <br />
 * GenericsQuery query = new GenericsQuery();
 * query.find("Usuario").like("nome", "Emiliano").orderBy("nome").list();
 * <br />
 * Ir� retornar uma lista de usu�rios com nome Emiliano e ordenada pelo nome.
 * 
 */
@SuppressWarnings({"rawtypes","unchecked"}) 
public abstract class DefaultGenericsQuery {

    protected EntityManager entityManager;
    private StringBuilder where = new StringBuilder();
    private StringBuilder from = new StringBuilder();
    private StringBuilder joinfetch = new StringBuilder();
    private String orderProp = new String("");
    private int limitFrom = 0;
    private int limitMax = 0;
    private boolean or =false;
    private HashMap<String, Object> parameters = new HashMap<String, Object>();

    public DefaultGenericsQuery(EntityManager entityManager){
    	this.entityManager = entityManager;
    }
    
    public DefaultGenericsQuery find(String classe) {
        entityManager.clear();
        from = new StringBuilder();
        joinfetch = new StringBuilder();
        where = new StringBuilder();
        limitFrom = 0;
        limitMax = 0;
        orderProp = new String("");
        parameters.clear();
        from.append("from ").append(classe);
        return this;
    }
    
    public DefaultGenericsQuery find(Class classe) {
       return find(classe.getSimpleName());
    }

    public DefaultGenericsQuery innerJoin(String classe) {
        joinfetch.append(" inner join fetch ").append(classe);
        return this;
    }
    
    public DefaultGenericsQuery leftJoin(String classe) {
        joinfetch.append(" left outer join fetch ").append(classe);
        return this;
    }

    public DefaultGenericsQuery like(String attribute, Object value) {
        if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(or?" or ":" and "); or = false;
        }
        where.append(attribute).append(" like ").append(":").append(attribute.replaceAll(Pattern.quote("."), ""));
        parameters.put("(L)" + attribute, value);
        return this;
    }

    public DefaultGenericsQuery inElements(String attribute, Object value) {
        if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(" and ");
        }
        where.append(":").append(attribute.replaceAll(Pattern.quote("."), "")).append(" IN ELEMENTS(").append(attribute).append(")");
        parameters.put("(L)" + attribute, value);
        return this;
    }
    
    public DefaultGenericsQuery notEquals(String attribute, Object value) {
        if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(or?" or ":" and "); or = false;
        }
        where.append(attribute).append(" <> ").append(":").append(attribute.replaceAll(Pattern.quote("."), ""));
        parameters.put(attribute, value);
        return this;
    }
    
    public DefaultGenericsQuery equals(String attribute, Object value) {
        if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(or?" or ":" and "); or = false;
        }
        where.append(attribute).append(" = ").append(":").append(attribute.replaceAll(Pattern.quote("."), ""));
        parameters.put(attribute, value);
        return this;
    }
    
    public DefaultGenericsQuery or() {
        or = true;return this;
    }

    public DefaultGenericsQuery between(String attribute, Object value1, Object value2) {
        if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(or?" or ":" and "); or = false;
        }
        where.append(attribute).append(" between ").append(":").append("bet1_").append(attribute.replaceAll(Pattern.quote("."), ""));
        where.append(" and :").append("bet2_").append(attribute.replaceAll(Pattern.quote("."), ""));
        parameters.put("bet1_"+attribute, value1);
        parameters.put("bet2_"+attribute, value2);
        return this;
    }

    public DefaultGenericsQuery greaterThan(String attribute, Object value) {
    	 if (where.toString().trim().length() <= 0) {
             where.append(" where ");
         } else {
             where.append(or?" or ":" and "); or = false;
         }
         where.append(attribute).append(" > ").append(":").append(attribute.replaceAll(Pattern.quote("."), ""));
         parameters.put(attribute, value);
         return this;
    }
    
    public DefaultGenericsQuery isNull(String attribute) {
   	 if (where.toString().trim().length() <= 0) {
            where.append(" where ");
        } else {
            where.append(or?" or ":" and "); or = false;
        }
        where.append(attribute).append(" is null ");

        return this;
    }
    
    public DefaultGenericsQuery isNotNull(String attribute) {
      	 if (where.toString().trim().length() <= 0) {
               where.append(" where ");
           } else {
               where.append(or?" or ":" and "); or = false;
           }
           where.append(attribute).append(" is not null ");

           return this;
      }
    
    public DefaultGenericsQuery limit(int from, int to) {
        this.limitFrom = from;
        this.limitMax = to;
        return this;
    }

    public DefaultGenericsQuery maxResults(int max) {
        this.limitFrom = 0;
        this.limitMax = max;
        return this;
    }

    public DefaultGenericsQuery orderBy(String orderProp){
    	this.orderProp = orderProp == null?"":orderProp;
    	return this;
    }

    public boolean existsParameter(){
        return (where.toString().trim().length() > 0); 
    }
        
	public List list() {
        StringBuilder query = new StringBuilder();
        query.append(from.toString());
        if (joinfetch.toString().trim().length() > 0) {
            query.append(joinfetch.toString());
        }
        if (where.toString().trim().length() > 0) {
            query.append(where.toString());
        }

        
        if(!orderProp.equals("")){
        	query.append("order by").append(orderProp); 
        }
        
        
        Query q;
        if (limitMax > 0) {
            q = entityManager.createQuery(query.toString()).setFirstResult(limitFrom).setMaxResults(limitMax);
        } else {
            q = entityManager.createQuery(query.toString());
        }

        Iterator<Entry<String, Object>> it = parameters.entrySet().iterator();
        while (it.hasNext()) {
            Entry<String, Object> parametro = it.next();
            if (parametro.getKey().toString().substring(0, 3).equals("(L)")) {
                q.setParameter(parametro.getKey().toString().replaceAll(Pattern.quote("."), "").substring(3), "%" + parametro.getValue() + "%");
            } else {
                q.setParameter(parametro.getKey().toString().replaceAll(Pattern.quote("."), ""), parametro.getValue());
            }
        }
        List lista =  q.getResultList();
        finnalyQuery();
        return lista;
    }
	
	public List distinctList(){
		List lista = list();
		if(lista != null && !lista.isEmpty()){
			Set set = new HashSet(lista);
			return new ArrayList(set);
		}else{
			return null;
		}
	}
	
	public Object uniqueResult() {
        List list = list();
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        } else {
            return null;
        }
    }
	
	protected abstract void finnalyQuery();
}
