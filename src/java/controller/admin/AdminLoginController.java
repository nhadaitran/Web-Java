/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.admin;

import dao.AdminDAO;
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
public class AdminLoginController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  private AdminDAO loginDao;

  public void init() {
    loginDao = new AdminDAO();
  }

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet LoginController</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet LoginController at " + request.getContextPath() + "</h1>");
      out.println("</body>");
      out.println("</html>");
    }
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    authenticate(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

  private void authenticate(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String id = request.getParameter("id");
    String password = request.getParameter("password");

    if (loginDao.validate(id, password) != null) {
      HttpSession session = request.getSession(true);
      session.setAttribute("name", loginDao.validate(id, password).getFullname());
      session.setAttribute("email", loginDao.validate(id, password).getEmail());
      RequestDispatcher rd = request.getRequestDispatcher("/admin/home.jsp");
      rd.forward(request, response);
    } else {
      request.setAttribute("error", "T??i kho???n ????ng nh???p ho???c m???t kh???u sai !!!");
      RequestDispatcher rd = request.getRequestDispatcher("/admin/index.jsp");
      rd.forward(request, response);
    }

  }
}
