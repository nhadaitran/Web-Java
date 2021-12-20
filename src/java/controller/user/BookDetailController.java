/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.BooksDAO;
import dao.CategoriesDAO;
import dao.IssuesDAO;
import dao.PublishersDAO;
import dao.ReturnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Books;
import model.Category;
import model.Publisher;

/**
 *
 * @author DELL
 */
@WebServlet("/book/*")
public class BookDetailController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private BooksDAO bookDao;
  private ReturnDAO returnDao;
  private IssuesDAO issueDao;
  private CategoriesDAO catDao;
  private PublishersDAO pubDao;

  public void init() {
    bookDao = new BooksDAO();
    returnDao = new ReturnDAO();
    issueDao = new IssuesDAO();
    catDao = new CategoriesDAO();
    pubDao = new PublishersDAO();
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
        case "/LibSystem/book/save":
          updateSaveBook(request, response);
          break;
        case "/LibSystem/book/update":
          updateBook(request, response);
          break;
        case "/LibSystem/book/delete":
          deleteBook(request, response);
          break;
        case "/LibSystem/book/issue":
          updateBookI(request, response);
          break;
        case "/LibSystem/book/return":
          updateBookR(request, response);
          break;
        default:
          bookDetail(request, response);
          break;
      }
    } catch (SQLException ex) {
      throw new ServletException(ex);
    }
  }

  private void updateBookR(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    HttpSession session = request.getSession(true);
    String sid = session.getAttribute("sid").toString();
    String id = request.getParameter("id");
    String iis = request.getParameter("iis");
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int year = localDate.getYear();
    int month = localDate.getMonthValue() * 10000;
    int day = localDate.getDayOfMonth() * 1000000;
    int dateR = day + month + year;
    returnDao.saveReturn(Integer.parseInt(iis), Integer.parseInt(sid), dateR);
    bookDao.updateBooksI(Integer.parseInt(id));
    issueDao.updateIssues(Integer.parseInt(iis));
    response.sendRedirect(request.getContextPath() + "/home");
  }

  private void updateBookI(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    HttpSession session = request.getSession(true);
    String sid = session.getAttribute("sid").toString();
    String id = request.getParameter("id");
    Date date = new Date();
    LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    int year = localDate.getYear();
    int month = localDate.getMonthValue() * 10000;
    int day = localDate.getDayOfMonth() * 1000000;
    int dateI = day + month + year;
    issueDao.saveIssue(Integer.parseInt(id), Integer.parseInt(sid), dateI);
    bookDao.updateBooksR(Integer.parseInt(id));
    response.sendRedirect(request.getContextPath() + "/home");
  }

  private void updateBook(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    String id = request.getParameter("id");
    Books detail = bookDao.getBook(Integer.parseInt(id));
    List<Category> listCat = catDao.getAll();
    List<Publisher> listPub = pubDao.getAll();
    request.setAttribute("detail", detail);
    request.setAttribute("publishers", listPub);
    request.setAttribute("categories", listCat);
    RequestDispatcher rd = request.getRequestDispatcher("/user/bookUpdate.jsp");
    rd.forward(request, response);
  }

  private void bookDetail(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    String id = request.getParameter("id");
    String iis = request.getParameter("iis");
    Books detail = bookDao.getBook(Integer.parseInt(id));
    request.setAttribute("detail", detail);
    request.setAttribute("iis", iis);
    RequestDispatcher rd = request.getRequestDispatcher("/user/book.jsp");
    rd.forward(request, response);
  }

  private void deleteBook(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException, ServletException {
    String id = request.getParameter("id");
    bookDao.deleteBooks(Integer.parseInt(id));
    response.sendRedirect(request.getContextPath() + "/home");
  }

  private void updateSaveBook(HttpServletRequest request, HttpServletResponse response)
          throws SQLException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    String name = request.getParameter("name");
    String category = request.getParameter("category");
    String publisher = request.getParameter("publisher");
    int cid = Integer.parseInt(category);
    int pid = Integer.parseInt(publisher);
    String description = request.getParameter("description");
    if (request.getParameter("new") != null) {
      bookDao.saveBook(name, pid, cid, description);
    } else if (request.getParameter("update") != null) {
      int id = Integer.parseInt(request.getParameter("update"));
      bookDao.updateBooks(id, name, pid, cid, description);
    }
    response.sendRedirect(request.getContextPath() + "/home");
  }
}
