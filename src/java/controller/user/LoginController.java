/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DELL
 */
public class LoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private StudentsDAO loginDao;

  public void init() {
    loginDao = new StudentsDAO();
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/user/login.jsp");
    rd.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    authenticate(request, response);
  }

  private void authenticate(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    if (loginDao.validate(email, password) != null) {
      HttpSession session = request.getSession(true);
      session.setAttribute("name", loginDao.validate(email, password).getFullname());
      session.setAttribute("email", loginDao.validate(email, password).getEmail());
      session.setAttribute("sid", loginDao.validate(email, password).getId());
      response.sendRedirect(request.getContextPath() + "/home");
    } else {
      request.setAttribute("error", "Tài khoản đăng nhập hoặc mật khẩu sai !!!");
      RequestDispatcher rd = request.getRequestDispatcher("/user/login.jsp");
      rd.forward(request, response);
    }

  }
}
