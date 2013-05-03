package br.com.onvix.sip.commons.jpa;


import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.onvix.sip.commons.jpa.generics.DefaultGenericsQuery;


/**
 * Classe que "ajuda" as DAOS. Atravs dela  possivel fazer toda persitencia dos objetos.
 *
 * @author Emiliano de Souza Pessoa
 *
 * @param <T> Entidade a ser persistida
 * @param <PK> Tipo da Primary Key da entidade (Geralmente um Integer)
 *
 * @see br.com.onvix.sip.commons.jpa.generics.autorizacao.commons.jpa.generics.generics.DefaultGenericsQuery
 */
@SuppressWarnings("unchecked")
public abstract class DefaultGenericsDao<T,PK extends Serializable> {

    protected Class<T> persistentClass = null;

    public static EntityManagerFactory entityManagerFactoryDesk = null;

    private EntityManagerFactory entityManagerFactoryWeb = null;

    public DefaultGenericsDao(String persistenceUnit){
        persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

        //WEB
        if(FacesContext.getCurrentInstance() != null){
            entityManagerFactoryWeb = (EntityManagerFactory) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("EntityManagerFactory");
            if(entityManagerFactoryWeb==null || !entityManagerFactoryWeb.isOpen()){
                entityManagerFactoryWeb = Persistence.createEntityManagerFactory(persistenceUnit);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("EntityManagerFactory",entityManagerFactoryWeb);
            }
        }else if(DefaultGenericsDao.entityManagerFactoryDesk == null || !DefaultGenericsDao.entityManagerFactoryDesk.isOpen()){
            DefaultGenericsDao.entityManagerFactoryDesk = Persistence.createEntityManagerFactory(persistenceUnit);
        }

    }


    private  EntityManager getEntitymanager(){
        if(FacesContext.getCurrentInstance() != null)
            return entityManagerFactoryWeb.createEntityManager();
        else
            return DefaultGenericsDao.entityManagerFactoryDesk.createEntityManager();
    }

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
    protected DefaultGenericsQuery getQuery(){
        return new DefaultGenericsQuery(getEntitymanager()){
            @Override
            protected void finnalyQuery() {
                this.entityManager.close();
            }
        };
    }

    protected List<T> findAll(String orderProp) {
        return getQuery().find(persistentClass).orderBy(orderProp).list();
    }

    protected List<T> findAll() {
        List<T> lista =  findAll(null);
        return lista;
    }

    protected T findByID(PK pk) {
        EntityManager entityManager = getEntitymanager();
        T entity =  entityManager.find(persistentClass, pk);
        entityManager.close();
        return entity;
    }

    protected T insert(T entity) throws Exception {
        EntityManager entityManager = getEntitymanager();
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao Inserir a entidade "+persistentClass.getSimpleName());
        }finally{
            entityManager.close();
        }
        return entity;
    }

    protected T update(T entity)  throws Exception {
        EntityManager entityManager = getEntitymanager();
        try{
            entityManager.getTransaction().begin();
            entity = entityManager.merge(entity);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao Alterar a entidade "+persistentClass.getSimpleName());
        }finally{
            entityManager.close();
        }
        return entity;
    }

    protected void delete(T entity)  throws Exception {
        EntityManager entityManager = getEntitymanager();
        try{
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            throw new Exception("Erro ao Alterar a entidade "+persistentClass.getSimpleName());
        }finally{
            entityManager.close();
        }
    }

    public abstract T inserir(T entidade) throws Exception;

    public abstract T alterar(T entidade) throws Exception;

    public abstract void excluir(T entidade) throws Exception;

}