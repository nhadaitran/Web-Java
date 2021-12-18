<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page import="model.Books"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane active" id="find">
  <div class="container-fluid">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body">
          <div class="accordion" id="accordionOne">
            <div class="col-lg d-flex justify-content-center">
              <button class="btn btn-light mb-5" type="button" data-toggle="collapse" data-target="#collapseOne"
                      aria-expanded="true" aria-controls="collapseOne">
                + Yêu Cầu Sách
              </button>
              <div class="form-row col-md-2">
                <form action="${pageContext.request.contextPath}/home" method="POST">
                  <select name="catBook" class="form-control" required onchange="this.form.submit();">
                    <option value="0">Danh Mục</option>                       
                    <c:forEach var="cat" items="${listCat}">
                      <option value="${cat.cid}"
                    <c:if test="${not empty idCat}">
                      <c:if test="${cat.cid==idCat}">
                        <% out.println("selected"); %>
                      </c:if>
                    </c:if> 
                   >${cat.cname}</option>
                  </c:forEach>  
                </select>
              </form>
            </div>
            <div class="form-row col-md" >
              <form class="form-row col-md">
                <div class="col-md">
                  <input class="form-control" type="search" placeholder="Tìm kiếm bằng tiêu đề sách hoặc tác giả...">
                </div>
                <div class="col-md-0">
                  <button class="btn btn-light" type="submit">Tìm Kiếm</button>
                </div>
              </form>
            </div>
            <div id="collapseOne" class="collapse hide" aria-labelledby="headingOne" data-parent="#accordionOne ">
              <form class="form-row col-md">
                <div class="col-md">
                  <input class="form-control" type="text" placeholder=" Tiêu Đề Sách..." required="required">
                </div>
                <div class="col-md">
                  <input class="form-control" type="text" placeholder=" Tác Giả..." required="required">
                </div>
                <div class="col-md-2">
                  <button class="btn btn-light" type="submit">Gửi</button>
                </div>
              </form>
            </div>
          </div>
        </div> 
      </div>
                  ${date}
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

              <td><a href="${pageContext.request.contextPath}/book?id=${book.id}"><c:out value="${book.name}" /></a></td>
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

