/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Books;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class BooksDAO {

  public void saveBook(String name, int pid, int cid, String desc) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createSQLQuery("INSERT INTO Books (id, name, idpublisher, idcategory, status, description, image) VALUES ( ?, ?, ?, ?, ?, ?, ?)")
            .setParameter(0, null)
            .setParameter(1, name)
            .setParameter(2, pid)
            .setParameter(3, cid)
            .setParameter(4, 0)
            .setParameter(5, desc)
            .setParameter(6, null);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }

  public void updateBooks(int id, String name, int pid, int cid, String desc) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createSQLQuery("Update Books set name = ?, idpublisher = ?, idcategory = ?, description = ? Where id = ?")
            .setParameter(0, name)
            .setParameter(1, pid)
            .setParameter(2, cid)
            .setParameter(3, desc)
            .setParameter(4, id);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }

  public void deleteBooks(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("DELETE FROM Books WHERE id = :id").setParameter("id", id);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }

  public void updateBooksI(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("UPDATE Books Set status = 0 WHERE id = :id").setParameter("id", id);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }

  public void updateBooksR(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Query query = session.createQuery("UPDATE Books Set status = 1 WHERE id = :id").setParameter("id", id);
    query.executeUpdate();
    transaction.commit();
    session.close();
  }

  public List<Books> getAll() {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Books");
    books = query.list();
    session.beginTransaction().commit();
    return books;
  }

  public List<Books> findBooks(String sql) {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery(sql);
    books = query.list();
    session.beginTransaction().commit();
    return books;
  }

  public Books getBook(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Books book = null;
    book = (Books) session.get(Books.class, id);
    transaction.commit();
    return book;
  }

  public List<Books> getBookReturns(int sid) {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Returns Where sid = :sid ").setParameter("sid", sid);
    books = query.list();
    session.beginTransaction().commit();
    return books;
  }

  public List<Books> getBookIssue(int sid) {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Issue Where sid = :sid ").setParameter("sid", sid);
    books = query.list();
    session.beginTransaction().commit();
    return books;
  }

  public List<Books> getByCategory(int cid) {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Books Where idcategory = :cid").setParameter("cid", cid);
    books = query.list();
    session.beginTransaction().commit();
    return books;
  }
}
