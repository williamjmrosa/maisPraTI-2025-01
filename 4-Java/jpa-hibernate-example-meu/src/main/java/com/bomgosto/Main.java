package com.bomgosto;

import com.bomgosto.model.Cardapio;
import com.bomgosto.model.Comanda;
import com.bomgosto.model.Item_comanda;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Cardapio.class)
                .addAnnotatedClass(Comanda.class)
                .addAnnotatedClass(Item_comanda.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Cardapio cafe1 = new Cardapio();
            cafe1.setNome("Pizza");
            cafe1.setDescricao("Pizza de calabresa");
            cafe1.setPreco_unitario(10.0);

            session.save(cafe1);
            session.getTransaction().commit();
            
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (factory != null) {
                factory.close();
            }
        }
    }
}