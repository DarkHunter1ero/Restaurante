/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package DataBase;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public abstract class DBGenericClass<T>{
    
    private Session session;
    private Transaction trans;
    private Class<T> entityClass;
    
    public DBGenericClass(Class<T> entityClass) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.getCurrentSession();
        this.entityClass = entityClass;
    }
    
    public void create(T entity){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.save(entity);
            trans.commit();
        }catch(Exception e){
            trans.rollback();
            throw e;
        }finally{
            session.close();
        }
    }
    
    public void update(T entity){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.update(entity);
            trans.commit();
        }catch(Exception e){
            trans.rollback();
            throw e;
        }finally{
            session.close();
        }
    }
    
    public void delete(T entity){
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            trans = session.beginTransaction();
            session.delete(entity);
            trans.commit();
        }catch(Exception e){
            trans.rollback();
            throw e;
        }finally{
            session.close();
        }
    }
    
    public T findById(int id){
        return (T)session.get(entityClass, id);
    }
    
    public List<T> findAll() {
        List<T> mozoList = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria cri = session.createCriteria(entityClass);
            mozoList = cri.list();
        }catch(Exception e){
            throw e;
        }finally{
            session.close();
        }
        return mozoList;
    }
}