<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="tab-pane" id="return"><div class="container-fluid">
    <div class="col-lg-12">
      <div class="card">
      <div class="table-responsive">
        <table class="table table-hover">
          <thead>
            <tr>                                             
              <th scope="col">Ngày trả</th>
              <th scope="col">Tiêu đề sách</th>
              <th scope="col">Nhà xuất bản</th>
              <th scope="col">Trạng Thái</th>    
          </tr>
          </thead>
          <tbody>                      
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