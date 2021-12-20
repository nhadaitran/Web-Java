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
                    <div class="row">
                      <div class="col-md-8">
                        <h3 class=""><c:out value="${detail.name}"/></h3>
                      </div>

                    </div>
                    <div class="row">
                      <div class="col-md-8">
                        <hr>
                        <h6>Thể loại</h6>
                        <span class="badge badge-dark badge-pill"><c:out value="${detail.category.cname}"/></span>                                                    
                        <hr>
                        <h6>Mô tả</h6>
                        <p>
                          <c:out value="${detail.description}"/>
                        </p>
                      </div>
                      <div class="col-md-4">
                        <img class="img-fluid " src="https://via.placeholder.com/400x500" alt="book-image">                                                    
                      </div>                                                
                    </div>
                    <!--/row-->
                    <div class="col-md-4">
                      <a class=" btn btn-light fa fa-long-arrow-left" href="${pageContext.request.contextPath}/home"><span>Quay lại</span></a>
                      <c:if test="${detail.status==0}">
                      <a class="btn btn-primary fa fa-check" href="${pageContext.request.contextPath}/book/issue?id=${detail.id}">Mượn sách</a>                                                    
                      <a class="btn btn-danger fa fa-pencil-square-o" href="${pageContext.request.contextPath}/book/update?id=${detail.id}"></a>
                      </c:if>
                      <c:if test="${detail.status==1}">
                        <a class="btn btn-success fa fa-check" href="${pageContext.request.contextPath}/book/return?id=${detail.id}&iis=${iis}">Trả sách</a>
                      </c:if>
                    </div>
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
