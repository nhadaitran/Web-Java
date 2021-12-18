<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane" id="issue"><div class="container-fluid">
    <div class="col-lg-12">
      <div class="card">
        <div class="table-responsive">
          <table class="table table-hover">
            <thead>
              <tr>           
                <th scope="col">Ngày mượn</th>
                <th scope="col">Tiêu đề sách</th>
                <th scope="col">Nhà xuất bản</th>
                <th scope="col">Trạng Thái</th>            
              </tr>
            </thead>
            <tbody>

            <c:forEach var="bookI" items="${listBookI}">
              <c:if test="${bookI.status!=1}">
                <tr role="row">
                  <td><c:out value="${bookI.date}" /></td>                              
                <td><a href="${pageContext.request.contextPath}/book?id=${bookI.books.id}&iis=${bookI.id}"><c:out value="${bookI.books.name}" /></a></td>
                <td><c:out value="${bookI.books.publisher.name}" /></td>
                <td>
                  <a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/book/return?id=${bookI.books.id}&iis=${bookI.id}">Trả sách</a>                  
                </td>
                </tr>
              </c:if>
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