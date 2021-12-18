<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane" id="manage"><div class="container-fluid">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body">
          <div class="col-lg d-flex justify-content-start">
            <form action="${pageContext.request.contextPath}/home" method="POST">
              <select name="manageBook" class="form-control" required onchange="this.form.submit();">                            
                <option value="1">Đang Mượn</option>
                <option value="2"
              <c:if test="${not empty mng}">
                <c:if test="${mng == '2'}">
                  <% out.println("selected");%>
                </c:if>
              </c:if>
              >Đã Trả</option>   
            </select>
          </form>
        </div>    
      </div>      
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>           
          <c:choose>
            <c:when test = "${mng == 2}">
              <th scope="col">Ngày trả</th>
              <th scope="col">Tiêu đề sách</th>
              <th scope="col">Nhà xuất bản</th>
              <th scope="col">Trạng Thái</th>
            </c:when>

            <c:otherwise>
              <th scope="col">Ngày mượn</th>
              <th scope="col">Tiêu đề sách</th>
              <th scope="col">Nhà xuất bản</th>
              <th scope="col">Trạng Thái</th>
            </c:otherwise>
          </c:choose>

          </tr>
          </thead>
          <tbody>

          <c:choose>
            <c:when test = "${mng == 2}">
              <c:forEach var="bookR" items="${listBookR}">
                <tr role="row">
                  <td><c:out value="${bookR.date}" /></td>                              
                <td><a href="${pageContext.request.contextPath}/book?id=${bookR.issue.books.id}"><c:out value="${bookR.issue.books.name}" /></a></td>
                <td><c:out value="${bookR.issue.books.publisher.name}" /></td>
                <td>        
                  <button class="btn btn-success btn-sm" disabled="disable">Đã trả</button>
                </td>
                </tr>
              </c:forEach>
            </c:when>

            <c:otherwise>              
              <c:forEach var="bookI" items="${listBookI}">
                <c:if test="${bookI.status!=1}">
                  <tr role="row">
                    <td><c:out value="${bookI.date}" /></td>                              
                  <td><a href="${pageContext.request.contextPath}/book?id=${bookI.books.id}&iis=${bookI.id}"><c:out value="${bookI.books.name}" /></a></td>
                  <td><c:out value="${bookI.books.publisher.name}" /></td>
                  <td>
                    <button class="btn btn-danger btn-sm fa fa-reply" >Trả sách</button>                  
                  </td>
                  </tr>
                </c:if>
              </c:forEach>
            </c:otherwise>
          </c:choose>

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