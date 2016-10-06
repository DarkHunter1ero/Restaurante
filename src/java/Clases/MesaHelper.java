/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import DataBase.DBGenericClass;
import DataBase.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Diego
 */
public class MesaHelper extends DBGenericClass<Mesa>{

    private Session session;
    private Transaction trans;
    
    public MesaHelper() {
        super(Mesa.class);
        session=super.getSession();
    }
    
    public List<Mesa> obtenerMesasMozos(){
        List<Mesa> list = null;
        try{
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria cri = session.createCriteria(Mesa.class);
            list = cri.list();
            //Solucion al problema de "could not initialize proxy - no session"!!!!
            for (Mesa mesa : list) {
                Hibernate.initialize(mesa.getMozo());
            }
            ///////
        }catch(Exception e){
            throw e;
        }finally{
            session.close();
        }
        return list;
    }
}
