package ru.job4j.tracker;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.hibernate.Session;

public class HQLUsage {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try (SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory()) {
            var session = sessionFactory.openSession();
            selectAll(session);
            update(session, 6);
            selectAll(session);
            session.close();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    private static void selectAll(Session session) {
        Query<Item> items = session.createQuery("from Item", Item.class);
        items.list().forEach(System.out::println);
    }

    private static void unique(Session session, int id) {
        Query<Item> query = session.createQuery("from Item where id = :fid", Item.class);
        query.setParameter("fid", id);
        for (Object object : query.list()) {
            System.out.println(object);
        }
    }

    private static void update(Session session, int id) {
        try {
            session.beginTransaction();
            session.createQuery("UPDATE Item set name = :fname where id = :fid")
                    .setParameter("fname", "Item 100")
                    .setParameter("fid", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
}
