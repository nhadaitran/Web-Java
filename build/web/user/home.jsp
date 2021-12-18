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
            <!--Start topbar header-->
            <%@ include file="masterpage/menutop.jsp" %>
            <!--End topbar header-->

            <div id="wrapper" class="toggled">
            <div class="content-wrapper">
                <div class="container-fluid">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <ul class="nav nav-tabs nav-tabs-primary top-icon nav-justified">
                                    <li class="nav-item find">
                                        <a href="javascript:void();" data-target="#find" data-toggle="pill" class="nav-link active"><i class="zmdi zmdi-bookmark-outline"></i> <span class="hidden-xs">Tìm kiếm sách</span></a>
                                    </li>
                                    <li class="nav-item manage">
                                        <a href="javascript:void();" data-target="#issue" data-toggle="pill" class="nav-link"><i class="zmdi zmdi-book"></i> <span class="hidden-xs">Quản lý sách mượn</span></a>
                                    </li>
                                    <li class="nav-item info">
                                        <a href="javascript:void();" data-target="#return" data-toggle="pill" class="nav-link"><i class="zmdi zmdi-mail-reply"></i> <span class="hidden-xs">Quản lý sách trả</span></a>
                                    </li>
                                </ul>
                                <div class="tab-content p-3">
                                    
                                    <%@ include file="masterpage/findbook.jsp"%>
                                    
                                    <%@ include file="masterpage/issuebook.jsp"%>
                                    
                                    <%@ include file="masterpage/returnbook.jsp"%>
                                                                        
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <!-- End container-fluid-->        
        <!--Start Back To Top Button-->
        <a href="javaScript:void();" class="back-to-top"><i class="fa fa-angle-double-up"></i> </a>
        <!--End Back To Top Button-->

        <!--Start footer-->
        <%@ include file="masterpage/footer.jsp" %>
        <!--End footer-->
    </div><!--End wrapper-->
</body>
</html>
