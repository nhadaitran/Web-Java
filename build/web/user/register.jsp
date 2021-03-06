<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <%@ include file="masterpage/header.jsp" %>
  <body class="bg-theme bg-theme2">

    <!-- start loader -->
    <div id="pageloader-overlay" class="visible incoming"><div class="loader-wrapper-outer"><div class="loader-wrapper-inner" ><div class="loader"></div></div></div></div>
    <!-- end loader -->

    <!-- Start wrapper-->
    <div id="wrapper">

      <div class="card card-authentication1 mx-auto my-4">
        <div class="card-body">
          <div class="card-content p-2">
            <div class="text-center">
              <img src="${pageContext.request.contextPath}/assets/images/logo-icon.png" alt="logo icon">
            </div>
            <div class="card-title text-uppercase text-center py-3">Đăng Ký</div>
            <form action="register" method="POST">                            
              <div class="form-group">
                <label class="sr-only">Email</label>
                <div class="position-relative has-icon-right">
                  <input type="text" name="email" class="form-control input-shadow" placeholder="Nhập Email" required="">
                  <div class="form-control-position">
                    <i class="icon-envelope-open"></i>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="sr-only">Mật Khẩu</label>
                <div class="position-relative has-icon-right">
                  <input type="password" name="password" class="form-control input-shadow" placeholder="Nhập Mật Khẩu" required="">
                  <div class="form-control-position">
                    <i class="icon-lock"></i>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="sr-only">Họ Tên</label>
                <div class="position-relative has-icon-right">
                  <input type="text" name="fullname" class="form-control input-shadow" placeholder="Nhập Họ và Tên" required="">
                  <div class="form-control-position">
                    <i class="icon-user"></i>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="sr-only">Số Điện Thoại</label>
                <div class="position-relative has-icon-right">
                  <input type="text" name="phone" class="form-control input-shadow" placeholder="Nhập SĐT" required="">
                  <div class="form-control-position">
                    <i class="icon-phone"></i>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <div class="icheck-material-white">
                  <input type="checkbox" id="user-checkbox" required=""/>
                  <label for="user-checkbox">Tôi đồng ý với các <a href="#"> điều khoản</a></label>
                </div>
              </div>

              <button type="submit" class="btn btn-light btn-block waves-effect waves-light">Đăng Ký</button>

            </form>
          </div>
        </div>
        <div class="card-footer text-center py-3">
          <p class="text-warning mb-0">Bạn đã có tài khoản? <a href="${pageContext.request.contextPath}/login"> Đăng Nhập</a></p>
        </div>
        <div class="card-footer text-center py-3">
          <a class="btn btn-link" href="${pageContext.request.contextPath}/"> Quay lại</a>
        </div>
      </div>

  </body>
</html>
