/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.user;

import dao.StudentsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Students;

/**
 *
 * @author DELL
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/register"})
public class RegisterController extends HttpServlet {
  private StudentsDAO sDao;  

  public void init() {
    sDao = new StudentsDAO();    
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.getRequestDispatcher("/user/register.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String email = request.getParameter("email");
    String pass = request.getParameter("password");
    String fname = request.getParameter("fullname");
    String phone = request.getParameter("phone");
    Students s = new Students(fname, pass, email, Integer.parseInt(phone));
    sDao.saveStudent(s);
    response.sendRedirect(request.getContextPath() + "/login");
  }

}
