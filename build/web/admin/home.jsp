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

            <div class="content-wrapper">
                <div class="container-fluid">

                    <!--Start Dashboard Content-->

                    <div class="card mt-3">
                        <div class="card-content">
                            <div class="row row-group m-0">
                                <div class="col-12 col-lg-6 col-xl-3 border-light">
                                    <div class="card-body">
                                        <h5 class="text-white mb-0">326 <span class="float-right"><i class="fa fa-book"></i></span></h5>
                                        <div class="progress my-3" style="height:3px;">
                                            <div class="progress-bar" style="width:55%"></div>
                                        </div>
                                        <p class="mb-0 text-white small-font">Số lượng sách <span class="float-right">+4.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                                    </div>
                                </div>
                                <div class="col-12 col-lg-6 col-xl-3 border-light">
                                    <div class="card-body">
                                        <h5 class="text-white mb-0">123 <span class="float-right"><i class="fa fa-user"></i></span></h5>
                                        <div class="progress my-3" style="height:3px;">
                                            <div class="progress-bar" style="width:55%"></div>
                                        </div>
                                        <p class="mb-0 text-white small-font">Số lượng sinh viên <span class="float-right">+1.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                                    </div>
                                </div>
                                <div class="col-12 col-lg-6 col-xl-3 border-light">
                                    <div class="card-body">
                                        <h5 class="text-white mb-0">6 <span class="float-right"><i class="fa fa-mail-forward"></i></span></h5>
                                        <div class="progress my-3" style="height:3px;">
                                            <div class="progress-bar" style="width:55%"></div>
                                        </div>
                                        <p class="mb-0 text-white small-font">Số lượng mượn hôm nay <span class="float-right">+5.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                                    </div>
                                </div>
                                <div class="col-12 col-lg-6 col-xl-3 border-light">
                                    <div class="card-body">
                                        <h5 class="text-white mb-0">30 <span class="float-right"><i class="fa fa-mail-reply"></i></span></h5>
                                        <div class="progress my-3" style="height:3px;">
                                            <div class="progress-bar" style="width:55%"></div>
                                        </div>
                                        <p class="mb-0 text-white small-font">Số lượng trả hôm nay <span class="float-right">+2.2% <i class="zmdi zmdi-long-arrow-up"></i></span></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--End Row-->

                    <!--End Dashboard Content-->
                </div>
                <!-- End container-fluid-->

            </div><!--End content-wrapper-->
            <!--Start Back To Top Button-->
            <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
            <!--End Back To Top Button-->

            <!--Start footer-->
            <%@ include file="masterpageAdmin/footer.jsp" %>
            <!--End footer-->

        </div><!--End wrapper-->

    </body>
</html>
