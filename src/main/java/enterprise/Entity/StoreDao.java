package enterprise.Entity;

import com.nyp.microdelivery.posting.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import javax.naming.NamingException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StoreDao {
    private static SessionFactory sessionFactory= HibernateUtil.getSessionFactory();
    //company items
    public static Item getItem(int id){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Item.class).add(Restrictions.eq("id",id));
        Object result = criteria.uniqueResult();

        session.close();

        return (Item) result;

    }
    public static List<Item> getAllItem(int id){

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        String query="select * from storeItem where storeId="+id;


        List<Item> list = session.createNativeQuery(query).addEntity(Item.class).list();

        session.close();
        return list;

    }

    public static void update(Item i){

        Session session=sessionFactory.openSession();
        Transaction traction=session.beginTransaction();
        session.update(i);
        traction.commit();
        session.close();


    }
    public static void deleteItem(Item i){



        Session session=sessionFactory.openSession();
        Query query=session.createQuery("delete Item where id=:itemId");
        query.setParameter("itemId",i.getId());
        session.beginTransaction();
        query.executeUpdate();

        session.close();

    }
    public static void save(Item i){


        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.save(i);
        session.getTransaction().commit();
        session.close();
    }

    //  company
    public static List<Store> getAllComany(){
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<Store> list = session.createNativeQuery("SELECT * FROM store").addEntity(Store.class).list();
        session.close();
        return list;

    }


}
