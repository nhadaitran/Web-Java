<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  session = request.getSession(false);
  if (session.getAttribute("email") == null) {
    response.sendRedirect(request.getContextPath() +  "/login");
  }
%>
<!--Start topbar header-->

<header class="topbar-nav">
  <nav class="navbar navbar-expand fixed-top">      
    <ul class="navbar-nav mr-auto align-items-center">
      <li class="nav-item">
        <img src="${pageContext.request.contextPath}/assets/images/logo-icon.png" class="logo-icon" alt="logo icon">
        <h5 class="logo-text">Library</h5>
      </li>
    </ul>

    <ul class="navbar-nav align-items-center right-nav-link ">
      <li class="nav-item">
        <a class="nav-link dropdown-toggle dropdown-toggle-nocaret" data-toggle="dropdown" href="#">
          <span class="user-profile"><img src="https://via.placeholder.com/110x110" class="img-circle"
                                          alt="user avatar"></span>
        </a>
        <ul class="dropdown-menu dropdown-menu-right">
          <li class="dropdown-item user-details">
            <a href="javaScript:void();">
              <div class="media">
                <div class="avatar"><img class="align-self-start mr-3" src="https://via.placeholder.com/110x110"
                                         alt="user avatar"></div>
                <div class="media-body">
                  <h6 class="mt-2 user-title">${sessionScope.name}</h6>
                  <p class="user-subtitle">${sessionScope.email}</p>
                </div>
              </div>
            </a>
          </li>
          <li class="dropdown-divider"></li>
          <li class="dropdown-item"><a href="${pageContext.request.contextPath}/info.jsp"><i class="icon-wallet mr-2"></i>Tài Khoản</a></li>
          <li class="dropdown-divider"></li>
          <li class="dropdown-item"><i class="icon-settings mr-2"></i> Cài Đặt</li>
          <li class="dropdown-divider"></li>
          <li class="dropdown-item"><a href="${pageContext.request.contextPath}/logout"><i class="icon-power mr-2"></i> Đăng Xuất</a></li>
        </ul>
      </li>
    </ul>
  </nav>
</header>
<!--End topbar header-->