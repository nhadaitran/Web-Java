/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.BooksDAO;
import dao.IssuesDAO;
import dao.ReturnDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Books;

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

  public void init() {
    bookDao = new BooksDAO();
    returnDao = new ReturnDAO();
    issueDao = new IssuesDAO();
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
}
