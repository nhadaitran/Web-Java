<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Book Library</title>
    <!-- loader-->
    <link href="assets/css/pace.min.css" rel="stylesheet"/>
    <script src="assets/js/pace.min.js"></script>
    <!--favicon-->
    <link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
    <!-- Vector CSS -->
    <link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet"/>
    <!-- simplebar CSS-->
    <link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet"/>
    <!-- Bootstrap core CSS-->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
    <!-- animate CSS-->
    <link href="assets/css/animate.css" rel="stylesheet" type="text/css"/>
    <!-- Icons CSS-->
    <link href="assets/css/icons.css" rel="stylesheet" type="text/css"/>
    <!-- Sidebar CSS-->
    <link href="assets/css/sidebar-menu.css" rel="stylesheet"/>
    <!-- Custom Style-->
    <link href="assets/css/app-style.css" rel="stylesheet"/>
  </head>
  <body class="bg-theme bg-theme2">

    <!-- Start wrapper-->
    <div id="wrapper" class="toggled">
      <!--Start topbar header-->
      <header class="topbar-nav">
        <nav class="navbar navbar-expand fixed-top">
          <ul class="navbar-nav mr-auto align-items-center">
            <li class="nav-item">
              <img src="${pageContext.request.contextPath}/assets/images/logo-icon.png" class="logo-icon" alt="logo icon">
              <h5 class="logo-text">Library</h5>
            </li>
          </ul>

          <ul class="navbar-nav align-items-center right-nav-link">
            <li class="nav-item">
              <a class="nav-link fa fa-user-circle" href="${pageContext.request.contextPath}/login">
                Đăng nhập
              </a>                           
            </li>
            <li class="nav-item">
              <a class="nav-link fa fa-plus-circle" href="${pageContext.request.contextPath}/register">
                Đăng ký
              </a>                           
            </li>
          </ul>
        </nav>
      </header>
      <!--End topbar header-->

      <div class="clearfix"></div>
      <div class="content-wrapper">
        <div class="container-fluid">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">
                <div class="col-lg d-flex justify-content-center">            

                  <div class="form-row col-md-2">
                    <form action="${pageContext.request.contextPath}/" method="POST">
                      <select name="catBook" class="form-control" required onchange="this.form.submit();">
                        <option value="0">Danh Mục</option>                       
                        <c:forEach var="cat" items="${listCat}">
                          <option value="${cat.cid}"
                                  <c:if test="${not empty idCat}">
                                    <c:if test="${cat.cid==idCat}">
                                      <% out.println("selected");%>
                                    </c:if>
                                  </c:if> 
                                  >${cat.cname}</option>
                        </c:forEach>  
                      </select>
                    </form>
                  </div>

                  <div class="form-row col-md" >
                    <form class="form-row col-md" method="get" action="${pageContext.request.contextPath}/search">
                      <div class="col-md">
                        <input class="form-control" name="data" value="${value}" placeholder="Tìm kiếm bằng tiêu đề sách...">
                      </div>
                      <div class="col-md-0">
                        <button class="btn btn-light" type="submit">Tìm Kiếm</button>
                      </div>
                    </form>
                  </div>

                </div> 
              </div>

              <div class="table-responsive">
                <table class="table table-hover">                    
                  <thead>
                    <tr>                      
                      <th scope="col">Mã sách</th>
                      <th scope="col">Tiêu đề sách</th>
                      <th scope="col">Thể loại</th>
                      <th scope="col">Nhà xuất bản</th>
                      <th scope="col">Trạng Thái</th>
                    </tr>
                  </thead>
                  <tbody>

                    <c:forEach var="book" items="${listBook}">
                      <tr role="row">
                        <td><c:out value="${book.id}" /></td>
                        <c:if test ="${book.status==1}">
                          <td><c:out value="${book.name}" /></td>
                        </c:if>
                        <c:if test ="${book.status==0}">

                          <td><c:out value="${book.name}" /></td>
                          </c:if>        
                        <td><c:out value="${book.category.cname}" /></td>
                        <td><c:out value="${book.publisher.name}" /></td>
                        <td>
                          <c:if test ="${book.status==1}">
                            <button class="btn btn-danger btn-sm" disabled="disable">not available</button>
                          </c:if>
                          <c:if test ="${book.status==0}">
                            <button class="btn btn-success btn-sm" disabled="disable">available</button>
                          </c:if>                
                        </td>
                      </tr>
                    </c:forEach>             

                  </tbody>
                </table>

              </div>
              <nav class="mt-3">
                <ul class="pagination justify-content-center">
                  <li class="page-item">
                    <a class="page-link" href="#" tabindex="-1">Previous</a>
                  </li>
                  <li class="page-item active"><a class="page-link" href="#">1</a></li>
                  <li class="page-item"><a class="page-link" href="#">2</a> </li>
                  <li class="page-item"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                  </li>
                </ul>
              </nav>
            </div>
          </div>
        </div>
      </div>
    </div>            

    <!-- End container-fluid-->

    <!--End content-wrapper-->
    <!--Start Back To Top Button-->
    <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
    <!--End Back To Top Button-->

    <!-- Bootstrap core JavaScript-->
    <script src="assets/js/jquery.min.js"></script>    
    <script src="assets/js/bootstrap.min.js"></script>

    <!-- simplebar js -->
    <script src="assets/plugins/simplebar/js/simplebar.js"></script>
    <!-- sidebar-menu js -->
    <script src="assets/js/sidebar-menu.js"></script>

    <!-- Custom scripts -->
    <script src="assets/js/app-script.js"></script>
  </div>
  <!--End wrapper-->



</body>

</html>
