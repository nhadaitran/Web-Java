/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Issue;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class IssuesDAO {
   public void saveIssue(Issue issue) {
    Transaction transaction = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    session.save(issue);
    transaction.commit();
    session.close();
  }

  public void updateIssues(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("UPDATE Issue Set status = 1 WHERE id = :id").setParameter("id", id);
    query.executeUpdate();
    transaction.commit();
    session.close(); 
  }

}
