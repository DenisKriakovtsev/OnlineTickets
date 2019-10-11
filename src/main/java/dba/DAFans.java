package dba;
import hbn.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import model.Fans; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAFans {
   
    public static List<Fans> getFansFromDB(){
        List<Fans> model= new ArrayList<>();
        List results = null;         
        SessionFactory sf = HibernateUtil.getSessionFactory();       
        Session session = null;
        Transaction tx = null;
        Query q = null;        
         try {
            session = sf.openSession();  
            tx = session.beginTransaction();
            q = session.createQuery("FROM Fans");
            results = q.getResultList();
            if (results != null && !results.isEmpty()) {
                System.out.println("\n\nShow all records from Fans");
                for (Object r : results) {
                    System.out.println(r); //(Stadium)
                    model.add((Fans)r);
                } 
                System.out.println();
            }
            System.out.println("\n\n");
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return model;
    } 
      
     public static void insert(SessionFactory sf, Fans newFans) {
        //CREATE
        Session session = null;
        Transaction tx = null;
        Query q = null;
        try {
            //Любые действия с БД через Hibernate
            session = sf.openSession();
            System.out.println("Try to ADD with Hibernate");
            tx = session.beginTransaction();
            session.save(newFans);
            tx.commit();
            System.out.println("Запись добавлена");
        } catch (Exception e) {
            System.out.println("Ошибка добавления. Возможно есть запись с такими данными");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}