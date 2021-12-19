/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.BooksDAO;
import dao.CategoriesDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Books;
import model.Category;

/**
 *
 * @author DELL
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

  private BooksDAO bookDao;
  private CategoriesDAO catDao;

  public void init() {
    bookDao = new BooksDAO();
    catDao = new CategoriesDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    String data = request.getParameter("data");
    String query;
    if (data != null) {
      query = "From Books Where name like '%" + data + "%'";
    } else {
      query = "From Books";
    }
    List<Books> listBook = bookDao.findBooks(query);
    request.setAttribute("value", data);
    String cid = request.getParameter("catBook");
    if (cid != null && cid.equals("0") == false) {
      listBook = bookDao.getByCategory(Integer.parseInt(cid));
      request.setAttribute("idCat", cid);
    }
    List<Category> listCat = catDao.getAll();
    request.setAttribute("listCat", listCat);
    request.setAttribute("listBook", listBook);
    List<Books> listBookI = new ArrayList<>();
    List<Books> listBookR = new ArrayList<>();
    HttpSession session = request.getSession(true);
    if (session.getAttribute("sid") != null) {
      String sid = session.getAttribute("sid").toString();
      listBookI = bookDao.getBookIssue(Integer.parseInt(sid));
      listBookR = bookDao.getBookReturns(Integer.parseInt(sid));
      request.setAttribute("listBookI", listBookI);
      request.setAttribute("listBookR", listBookR);
      request.getRequestDispatcher("/user/home.jsp").forward(request, response);
    }else{
      request.getRequestDispatcher("/homepage.jsp").forward(request, response);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    doGet(request, response);
  }

}
