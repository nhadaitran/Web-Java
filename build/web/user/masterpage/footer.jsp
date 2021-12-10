<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Start footer-->
<footer class="footer">
  <div class="container">
    <div class="text-center">
      Copyright © 2021
    </div>
  </div>
</footer>
<!--End footer-->
<!-- Bootstrap core JavaScript-->
<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="${pageContext.request.contextPath}/assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="${pageContext.request.contextPath}/assets/js/sidebar-menu.js"></script>

<!-- Custom scripts -->
<script src="${pageContext.request.contextPath}/assets/js/app-script.js"></script>

<!-- Toast -->
<script>
  $(document).ready(function () {
    $("#applyBtn").click(function () {
      $('.toast').toast('show');
    });
  });
</script>