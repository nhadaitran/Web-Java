/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class AdminDAO {

  public void saveAdmin(Admin admin) {
    Transaction transaction = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    session.save(admin);
    transaction.commit();
    session.close();
  }

  public Admin validate(String id, String password) {
    Transaction transaction = null;
    Admin admin = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    admin = (Admin) session.createQuery("FROM Admin a WHERE a.aid = :aid").setParameter("aid",id )
            .uniqueResult();
    if (admin != null && admin.getPassword().equals(password)) {
      session.close();
      return admin;
    }
    transaction.commit();
    session.close();
    return null;
  }
}
