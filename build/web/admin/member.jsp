<%-- 
    Document   : home
    Created on : Nov 5, 2021, 3:35:43 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <%@ include file="masterpageAdmin/header.jsp" %>
    <body class="bg-theme bg-theme2">
        <!-- Start wrapper-->
        <div id="wrapper">

            <!--Start sidebar-wrapper-->
            <%@ include file="masterpageAdmin/menuleft.jsp" %>
            <!--End sidebar-wrapper-->

            <!--Start topbar header-->
            <%@ include file="masterpageAdmin/menutop.jsp" %>

            <!--End topbar header-->

            <div class="clearfix"></div>

            <div class="content-wrapper">
                <div class="container-fluid">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <ul class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
                                    <li class="nav-item">
                                        <a href="javascript:void();" data-target="#member" data-toggle="pill" class="nav-link active"><i class="zmdi zmdi-assignment-account"></i> <span class="hidden-xs">Danh sách thành viên</span></a>
                                    </li>
                                    <li class="nav-item">
                                        <a href="javascript:void();" data-target="#editmem" data-toggle="pill" class="nav-link"><i class="zmdi zmdi-edit"></i> <span class="hidden-xs">Chỉnh sửa thành viên</span></a>
                                    </li>
                                </ul>
                                <div class="tab-content p-3">

                                    <%@include file="masterpageAdmin/member.jsp" %>

                                    <%@include file="masterpageAdmin/memberedit.jsp" %>

                                </div>
                            </div>
                        </div>
                    </div>

                </div>

                <!--start overlay-->
                <div class="overlay toggle-menu"></div>
                <!--end overlay-->

            </div>
            <!-- End container-fluid-->
        </div><!--End content-wrapper-->
        <!--Start Back To Top Button-->
        <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
        <!--End Back To Top Button-->

        <!-- TOAST -->
        <%@ include file="masterpageAdmin/toast_confirm.jsp" %>
        <!-- TOAST END -->
        <!--Start footer-->
        <%@ include file="masterpageAdmin/footer.jsp" %>
        <!--End footer-->

    </div><!--End wrapper-->


</body>
</html>
