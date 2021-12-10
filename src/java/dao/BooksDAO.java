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

  public void saveBook(Books book) {
    Transaction transaction = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    session.save(book);
    transaction.commit();
    session.close();
  }

  public List<Books> getAll() {
    List<Books> books = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Books");
    books = query.list();
    session.close();
    return books;
  }

  public void updateBooks(Books book) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(book);
    transaction.commit();
    session.close();
  }

  public void deleteBooks(Books book) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(book);
    transaction.commit();
    session.close();
  }

  public Books getBook(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Books book = null;
    book = (Books) session.get(Books.class, id);
    transaction.commit();
    session.close();
    return book;
  }
}
