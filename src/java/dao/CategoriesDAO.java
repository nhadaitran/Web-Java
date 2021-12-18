/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import model.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class CategoriesDAO {

  public void saveBook(Category cat) {
    Transaction transaction = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    session.save(cat);
    transaction.commit();
    session.close();
  }

  public List<Category> getAll() {
    List<Category> catList = new ArrayList();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query query = session.createQuery("From Category");
    catList = query.list();
    session.beginTransaction().commit();
    return catList;
  }

  public void updateCategory(Category cat) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.update(cat);
    transaction.commit();
    session.close();
  }

  public void deleteCategory(Category cat) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    session.delete(cat);
    transaction.commit();
    session.close();
  }

  public Category getCategory(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = session.beginTransaction();
    Category cat = null;
    cat = (Category) session.get(Category.class, id);
    transaction.commit();
    session.close();
    return cat;
  }
}
