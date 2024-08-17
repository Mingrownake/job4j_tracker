package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class HibernateRun {
    public static void main(String[] args) {
        final StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sessionFactory = new MetadataSources(serviceRegistry).buildMetadata().buildSessionFactory();
            var item = new Item();
            item.setName("Learn Hibernate");
            create(item, sessionFactory);
            System.out.println(item);
            item.setName("Learn Hibernate 5");
            update(item, sessionFactory);
            System.out.println(item);
            Item rsl = findById(item.getId(), sessionFactory);
            System.out.println(rsl);
            delete(item.getId(), sessionFactory);
            List<Item> items = findAll(sessionFactory);
            for (Item item1 : items) {
                System.out.println(item1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(serviceRegistry);
        }

    }

    public static Item create(Item item, SessionFactory sessionFactory) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return item;
    }

    public static void update(Item item, SessionFactory sessionFactory) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
    }

    public static void delete(int id, SessionFactory sessionFactory) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = new Item();
        item.setId(id);
        session.delete(item);
        session.getTransaction().commit();
        session.close();
    }

    public static List<Item> findAll(SessionFactory sessionFactory) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        List<Item> items = session.createQuery("from ru.job4j.tracker.Item", Item.class).list();
        session.getTransaction().commit();
        session.close();
        return items;
    }

    public static Item findById(int id, SessionFactory sessionFactory) {
        var session = sessionFactory.openSession();
        session.beginTransaction();
        Item item = session.get(Item.class, id);
        session.getTransaction().commit();
        session.close();
        return item;
    }
}
