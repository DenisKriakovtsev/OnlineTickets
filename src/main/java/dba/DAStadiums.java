package dba;
import hbn.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.persistence.Query;
import model.Stadium; 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAStadiums {
   
    public static List<Stadium> getStadiumsFromDB(){
        List<Stadium> model= new ArrayList<>();
        List results = null;         
        SessionFactory sf = HibernateUtil.getSessionFactory();       
        Session session = null;
        Transaction tx = null;
        Query q = null;        
         try {
            session = sf.openSession();  
            tx = session.beginTransaction();
            q = session.createQuery("FROM Stadium");
            results = q.getResultList();
            if (results != null && !results.isEmpty()) {
                System.out.println("\n\nShow all records from Stadiums");
                for (Object r : results) {
                    System.out.println(r); //(Stadium)
                    model.add((Stadium)r);
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
    
    //Метод добавления, Hibernate формирует Insert
    public static void insert(SessionFactory sf, Stadium newDepartment) {
        //CREATE
        Session session = null;
        Transaction tx = null;
        Query q = null;
        try {
            //Любые действия с БД через Hibernate
            session = sf.openSession();
            System.out.println("Try to ADD with Hibernate");
            tx = session.beginTransaction();
            session.save(newDepartment);
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

    public static void update(SessionFactory sf, long id, Stadium newDepartment) {
        if (id == -1) {
            return;
        }
        //UPDATE
        Session session = null;
        Transaction tx = null;
        Query q = null;
        Stadium departmentUp =null;
        try {
            //Поиск объекта с заданным id через Hibernate
            session = sf.openSession();
            System.out.println("Try to UPDATE with Hibernate");
            tx = session.beginTransaction();
            //Получение объекта по id (передается как параметр)
            departmentUp = (Stadium) session.get(Stadium.class, id);
            //Обновление полей найденной записи
            departmentUp.setName(newDepartment.getName());
            departmentUp.setNumberofseats(newDepartment.getNumberofseats());
            departmentUp.setDatecreate(newDepartment.getDatecreate());
            departmentUp.setCity(newDepartment.getCity());
            //Обновление записи в таблице - Hibernate формирует UPDATE
            session.update(departmentUp);
            tx.commit();
            System.out.println("Запись обновлена");
        } catch (Exception e) {
            System.out.println("Ошибка обновления. Возможно есть запись с такими данными");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
               departmentUp.setName(null);
            }
        }
    }
    

    public static void delete(SessionFactory sf, long id) {
        if (id == -1) {
            return;
        }
        Session session = null;
        Transaction tx = null;
        try {
            //Поиск объекта с заданным id через Hibernate
            session = sf.openSession();
            System.out.println("Try to DELETE with Hibernate (find id)");
            tx = session.beginTransaction();
            //Получение объекта по id (передается как параметр
            Stadium departmentDel = (Stadium) session.get(Stadium.class, id);
            //Удаление записи в таблице - Hibernate формирует DELETE
            session.delete(departmentDel);
            //По каскаду - будут удалены все связанные записи
            tx.commit();
            System.out.println("Запись удалена");
        } catch (Exception e) {
            System.out.println("Ошибка при удалении данных. Возможно запись удалена ранее.");
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            session.close();
        }
    }
}