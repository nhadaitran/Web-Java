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
    <!-- Start wrapper-->
    <div id="wrapper" class="toggled">           
      <!--Start topbar header-->
      <%@ include file="masterpage/menutop.jsp" %>
      <!--End topbar header-->
      <div class="content-wrapper">
        <div class="container-fluid">


          <div class="col-lg-12">
            <div class="card">
              <div class="card-body">                
                <div class="tab-content p-3">
                  <!--BOOK INFO-->
                  <form action="${pageContext.request.contextPath}/book/save" method="post">
                    <div class="row">
                      <div class="col-md-8">         
                        <h6>Tiêu đề</h6>
                        <input type="text" name="name" class="form-control input-shadow" required="" value="${detail.name}">
                      </div>

                    </div>
                    <div class="row">
                      <div class="col-md-8">
                        <hr>
                        <div class="row">
                          <div class="col-md-4">
                            <h6>Thể loại</h6>
                            <select name="category" class="form-control" required>
                              <c:forEach var="cat" items="${categories}">
                                <option value="${cat.cid}">${cat.cname}</option>
                              </c:forEach>  
                            </select>
                          </div>

                          <div class="col-md-4">
                            <h6>Nhà xuất bản</h6>
                            <select name="publisher" class="form-control" required>
                              <c:forEach var="pub" items="${publishers}">
                                <option value="${pub.id}">${pub.name}</option>
                              </c:forEach>  
                            </select>
                          </div>
                        </div>
                        <hr>
                        <h6>Mô tả</h6>
                        <p>
                          <textarea type="text" name="description" class="form-control input-shadow" required=""rows="10">${detail.description}</textarea>
                        </p>
                      </div>
                      <div class="col-md-4">
                        <img class="img-fluid " src="https://via.placeholder.com/400x500" alt="book-image">                                                    
                      </div>                                                
                    </div>
                    <!--/row-->
                    <div class="col-md-8">
                      <a class=" btn btn-light fa fa-long-arrow-left" href="${pageContext.request.contextPath}/home"><span>Quay lại</span></a>
                      <button type="submit" name="new" value="0" class="btn btn-success fa fa-plus">Lưu mới sách</button>
                      <button type="submit" name="update" value="${detail.id}" class="btn btn-success fa fa-floppy-o">Chỉnh sửa sách</button>
                      <a class="btn btn-danger fa fa-trash" href="${pageContext.request.contextPath}/book/delete?id=${detail.id}">Xóa sách</a>
                    </div>
                  </form>
                  <!--BOOK INFO-->

                </div>
              </div>
            </div>
          </div>

        </div>                
        <!-- End container-fluid-->
      </div><!--End content-wrapper-->
      <!--Start Back To Top Button-->
      <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
      <!--End Back To Top Button-->

      <!--Start footer-->
      <%@ include file="masterpage/footer.jsp" %>
      <!--End footer-->


    </div><!--End wrapper-->


  </body>
</html>