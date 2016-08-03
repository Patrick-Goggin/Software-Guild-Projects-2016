<%-- 
    Document   : home
    Created on : 21-Jul-2016, 2:26:54 PM
    Author     : apprentice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>DVD&nbsp;&nbsp;|&nbsp;&nbsp;Home</title>
        <!-- Bootstrap core CSS -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/site-styles.css" rel="stylesheet">
        <!-- SWC Icon -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/icon.png">
    </head>
    <body class="georgyZhuikov">
 
        <div class="container" id="c">

            <div id="machine">


                <div class=""row>
                    <div id="header">
                        <h1>DVD&nbsp;&nbsp;&nbsp;Library</h1>
                    </div><br>
                </div><!-- ROW  -->

                <div class="row">
                    <div class="col-sm-2"></div><!-- col sm 2 -->

                    <div class="col-sm-8">
                        <div id="panel">
                            
                            <div id="screenNav" class="sticky">
                                <div class="navbar">
                                    <ul class="nav navbar nav-pills">
                                        <li role="presentation"><a href="${pageContext.request.contextPath}/mainAjaxPage">Home</a></li>
                                        <li role="presentation"><a onClick="loadLibrary();">Library</a></li>
                                        <li role="presentation"><a onclick="showSearchDiv()">Search</a></li>
                                        <li role="presentation"><a onclick="showAddDiv()">Add</a></li>
                                        <li role="presentation"><a onclick="test();">Test</a></li>
                                    </ul>
                                        
                                </div>
                            </div><!--screenNav-->
                       <br> 
                <div id="editDiv" class="formDiv"><%@include file="editDivFragment.jsp" %></div>
                          <div id="addDiv"><%@include file="addDVDFragment.jsp" %></div>
                         <div id="searchDiv" class="formDiv"> <%@include file="search.jsp" %> </div>
                          <div id="notesDiv"> <%@include file="notesDivFragment.jsp" %></div>
                           <div id="editNoteDiv" class="formDiv"><%@include file="editNoteDiv.jsp" %></div>
                           <div id="addNoteDiv" class="formDiv"><%@include file="addNoteForm.jsp" %></div>
                            <%@include file="libraryDivFragment.jsp" %>
                        </div><!-- END DIV ID PANEL -->
                    </div><!-- col sm 8-->

                    <div class="col-sm-2"></div>
                </div><!--row -->
                
            </div> <!-- machine -->
        </div><!--CONTAINER-->



        <!-- Placed at the end of the document so the pages load faster -->
       <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/dvdLibrary.js"></script>

    </body>
</html>
