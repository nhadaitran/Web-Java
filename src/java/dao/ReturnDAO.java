/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Returns;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class ReturnDAO {

  public void saveReturn(int iis, int sid, int date) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    String admin = "admin";
    Query query = session.createSQLQuery("INSERT INTO Returns (id, aid, iis, sid, date) VALUES ( ?, ?, ?, ?, ?)")
            .setParameter(0, null)
            .setParameter(1, admin)
            .setParameter(2, iis)
            .setParameter(3, sid)
            .setParameter(4, date);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }
}
