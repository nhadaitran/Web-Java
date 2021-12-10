/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.BooksDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import model.Admin;
import model.Books;

/**
 *
 * @author DELL
 */
public class BooksController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private BooksDAO bookDao;

  public void init() {
    bookDao = new BooksDAO();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String action = request.getServletPath();

    try {
      switch (action) {
//        case "/new":
//          showNewForm(request, response);
//          break;
//        case "/edit":
//          showEditForm(request, response);
//          break;
//        case "/insert":
//          insertBook(request, response);
//          break;
//        case "/delete":
//          deleteBook(request, response);
//          break;
//        case "/update":
//          updateBook(request, response);
//          break;
        default:
          listBook(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void listBook(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    List<Books> listBook = bookDao.getAll();
    request.setAttribute("listBook", listBook);   
    RequestDispatcher rd = request.getRequestDispatcher( request.getContextPath() + "/user/home.jsp");
    rd.forward(request, response);
  }

//    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//        dispatcher.forward(request, response);
//    }
//  private void showEditForm(HttpServletRequest request, HttpServletResponse response)
//          throws SQLException, ServletException, IOException {
//    int id = Integer.parseInt(request.getParameter("id"));
//    User existingUser = userDao.getUser(id);
//    RequestDispatcher dispatcher = request.getRequestDispatcher("user-form.jsp");
//    request.setAttribute("user", existingUser);
//    dispatcher.forward(request, response);
//
//  }
//  private void insertBook(HttpServletRequest request, HttpServletResponse response)
//          throws SQLException, IOException {  
//    
//    String name = request.getParameter("name");
//    String author = request.getParameter("author");
//    int status = 0;
//    String desc = request.getParameter("desc");
//    String image = request.getParameter("image");
//    Books newBook = new Books(null, name, author, status, desc, image);
//    bookDao.saveBook(newBook);
//    response.sendRedirect("/admin/book.jsp");
//  }
//
//  private void updateUser(HttpServletRequest request, HttpServletResponse response)
//          throws SQLException, IOException {
//    int id = Integer.parseInt(request.getParameter("id"));
//    String name = request.getParameter("name");
//    String email = request.getParameter("email");
//    String country = request.getParameter("country");
//
//    User user = new User(id, name, email, country);
//    userDao.updateUser(user);
//    response.sendRedirect("list");
//  }
//
//  private void deleteUser(HttpServletRequest request, HttpServletResponse response)
//          throws SQLException, IOException {
//    int id = Integer.parseInt(request.getParameter("id"));
//    userDao.deleteUser(id);
//    response.sendRedirect("list");
//  }
}
