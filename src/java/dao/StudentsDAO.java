/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Students;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author DELL
 */
public class StudentsDAO {

  public void saveStudent(Students student) {
    Transaction transaction = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    session.save(student);
    transaction.commit();
    session.close();
  }

  public Students validate(String email, String password) {
    Transaction transaction = null;
    Students student = null;
    Session session = HibernateUtil.openSesstion();
    transaction = session.beginTransaction();
    student = (Students) session.createQuery("FROM Students s WHERE s.email = :email").setParameter("email", email)
            .uniqueResult();
    if (student != null && student.getPassword().equals(password)) {
      transaction.commit();
      session.close();
      return student;
    }
    transaction.commit();
    session.close();
    return null;
  }
}
