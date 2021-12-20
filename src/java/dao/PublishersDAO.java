/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Publisher;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class PublishersDAO {
    public List<Publisher> getAll() {
    List<Publisher> pubList = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Publisher");
    pubList = query.list();
    session.beginTransaction().commit();
    session.close();
    return pubList;
  }
}
