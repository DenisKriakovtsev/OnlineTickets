package dba;

import hbn.HibernateUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query; 
import model.Matches;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAMatch {

    public static List<Matches> getMatchesFromDB(){
        List<Matches> model= new ArrayList<>();
        List results = null;         
        SessionFactory sf = HibernateUtil.getSessionFactory();       
        Session session = null;
        Transaction tx = null;
        Query q = null;        
         try {
            session = sf.openSession();  
            tx = session.beginTransaction();
            q = session.createQuery("FROM Matches");
            results = q.getResultList();
            if (results != null && !results.isEmpty()) {
                System.out.println("\n\nShow all records from Matches");
                for (Object r : results) {
                    System.out.println(r); //(Department)
                    model.add((Matches)r);
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
    
    public static void insertSql(Connection con, Matches match) {
        PreparedStatement prst = null;
        String SQLTextIns = "INSERT INTO Matches(NameMatch,date,price,stad_id) "
                + "VALUES (?,?,?,?)"; 
        try {
            prst = con.prepareStatement(SQLTextIns);
            prst.setString(1, match.getNamematches());
            prst.setString(2, match.getDate());
            prst.setDouble(3, match.getPrice()); 
            prst.setLong(3, match.getStadium().getId()); 
            prst.execute();
        } catch (SQLException ex) {
            System.out.println("Ошибка добавления. Возможно есть запись с такими данными");
        } finally {
            try {

                if (prst != null) {
                    prst.close();
                }
            } catch (SQLException ex) {
            }
        }
    }
    
    public static void insert(SessionFactory sf, Matches newMatches) {        
         //CREATE
        Session session = null;
        Transaction tx = null;
        Query q = null;
        try {
            //Любые действия с БД через Hibernate
            session = sf.openSession();
            System.out.println("Try to ADD with Hibernate");
            tx = session.beginTransaction();
            session.save(newMatches);
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

    //Метод обновления, Hibernate формирует InsertUpdate
    public static void update(SessionFactory sf, long id, Matches newEmployee) {
        if (id == -1) {
            return;
        }
        //UPDATE
        Session session = null;
        Transaction tx = null;
        Query q = null;
        try {
            //Поиск объекта с заданным id через Hibernate
            session = sf.openSession();
            System.out.println("Try to UPDATE with Hibernate");
            tx = session.beginTransaction();
            //Получение объекта по id (передается как параметр)
            Matches employeeUp = (Matches) session.get(Matches.class, id);
            //Обновление полей найденной записи
            employeeUp.setNamematches(newEmployee.getNamematches());
            employeeUp.setDate(newEmployee.getDate());
            employeeUp.setPrice(newEmployee.getPrice()); 
            //Обновление записи в таблице - Hibernate формирует UPDATE
            session.update(employeeUp);
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
            }

        }

    }

    //Метод для удаления по id, Hibernate формирует Delete 
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
            Matches employeetDel = (Matches) session.get(Matches.class, id);
            //Удаление записи в таблице - Hibernate формирует DELETE
            session.delete(employeetDel);
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
