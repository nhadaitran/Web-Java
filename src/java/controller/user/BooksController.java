/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.BooksDAO;
import dao.CategoriesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Books;
import model.Category;

/**
 *
 * @author DELL
 */
public class BooksController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private BooksDAO bookDao;
  private CategoriesDAO catDao;

  public void init() {
    bookDao = new BooksDAO();
    catDao = new CategoriesDAO();
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String action = request.getRequestURI();

    try {
      switch (action) {
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
    HttpSession session = request.getSession(true);
    String sid = session.getAttribute("sid").toString();
    String cid = request.getParameter("catBook");
    List<Books> listBook = bookDao.getAll();
    List<Books> listBookI = bookDao.getBookIssue(Integer.parseInt(sid));
    List<Books> listBookR = bookDao.getBookReturns(Integer.parseInt(sid));
    if (cid != null && cid.equals("0") == false) {
      listBook = bookDao.getByCategory(Integer.parseInt(cid));
      request.setAttribute("idCat", cid);
    }
    List<Category> listCat = catDao.getAll();
    request.setAttribute("listBookI", listBookI);
    request.setAttribute("listBookR", listBookR);
    request.setAttribute("listBook", listBook);
    request.setAttribute("listCat", listCat);
    request.getRequestDispatcher("/user/home.jsp").forward(request, response);
  }

//    private void updateBook(HttpServletRequest request, HttpServletResponse response)
//          throws SQLException, IOException {
//    int id = Integer.parseInt(request.getParameter("id"));
//    String name = request.getParameter("name");
//    String email = request.getParameter("email");
//    String country = request.getParameter("country");
//
//    Books user = new Books(id, name, email, country);
//    userDao.updateUser(user);
//    response.sendRedirect("list");
//  }
}
