<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Start sidebar-wrapper-->
<div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
    <div class="brand-logo">
        <a href="home.jsp">
            <img src="../assets/images/logo-icon.png" class="logo-icon" alt="logo icon">
            <h5 class="logo-text">Library</h5>
        </a>
    </div>
    <ul class="sidebar-menu do-nicescrol">        
        <li>
            <a href="home.jsp">
                <i class="zmdi zmdi-view-dashboard"></i> <span>Trang Chủ</span>
            </a>
        </li>

        <li>
            <a href="transaction.jsp">
                <i class="zmdi zmdi-assignment-returned"></i> <span>Quản lý giao dịch</span>
            </a>
        </li>
        <li>
            <a href="book.jsp">
                <i class="zmdi zmdi-book"></i> <span>Quản lý sách</span>
            </a>
        </li>
        <li>
            <a href="member.jsp">
                <i class="zmdi zmdi-account"></i> <span>Quản lý thành viên</span>
            </a>
        </li>
        <li>
            <a href="info.jsp">
                <i class="zmdi zmdi-face"></i> <span>Thông tin cá nhân</span>
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/admin/logout">
                <i class="zmdi zmdi-lock"></i> <span>Đăng Xuất</span>
            </a>
        </li>
    </ul>

</div>
<!--End sidebar-wrapper-->