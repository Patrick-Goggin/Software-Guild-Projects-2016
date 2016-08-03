<%-- 
    Document   : home
    Created on : 27-Jul-2016, 9:54:47 AM
    Author     : apprentice
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 
      <script src='//cdn.tinymce.com/4/tinymce.min.js'></script>
   <script type="text/javascript">
  tinymce.init({
    selector: '#myTextarea',
    theme: 'modern',
    width: 600,
    height: 300,
    plugins: [
      'advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker',
      'searchreplace wordcount visualblocks visualchars code fullscreen insertdatetime media nonbreaking',
      'save table contextmenu directionality emoticons template paste textcolor'
    ],
   
    toolbar: 'insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image | print preview media fullpage | forecolor backcolor emoticons'
  });
  </script>
        <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/blogStyles.css" rel="stylesheet">
        <title>Blog</title>
    </head>
    <body>
        <div class="container-fluid" id="contain">


            <nav class="navbar navbar-default navbar-fixed-top" id="blogNav">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#">Project name</a>
                    </div>
                    <div id="navbar" class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Home</a></li>
                            <li><a href="#about">About</a></li>
                            <li><a href="#contact">Contact</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header">Nav header</li>
                                    <li><a href="#">Separated link</a></li>
                                    <li><a href="#">One more separated link</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="../navbar/">Default</a></li>
                            <li><a href="../navbar-static-top/">Static top</a></li>
                            <li class="active"><a href="./">Fixed top <span class="sr-only">(current)</span></a></li>
                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </nav>
            <!-- <div class="navbar-fixed-top">
             </div> -->

            <div class="row" id="bottom">
                <div class="col-sm-3" id="left">
                    <div id="leftInner"><div id="image"></div></div>
                </div><!-- col sm 3 -->


                <div class="col-sm-6" id="middle">
                    <div id="middleInner"><!--posts go in here--><%@include file="inputFormFragment.jsp" %><div id="image"></div></div>
                </div><!-- col-sm-6 -->


                <div class="col-sm-3" id="right">
                    <div id="rightInner"><div id="image"></div></div>
                </div><!-- col sm 3 -->
            </div><!-- row-->


        </div><!-- Container -->
   
  <script src="${pageContext.request.contextPath}/js/myEditor.js"></script>
  <script src='${pageContext.request.contextPath}/js/jquery.tinymce.min.js'></script>
  <script src='${pageContext.request.contextPath}/js/tinymce.min.js'></script>
  <script src='${pageContext.request.contextPath}/js/tinymce.js'></script>
        <script src="${pageContext.request.contextPath}/js/jquery-2.2.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
       <script src="${pageContext.request.contextPath}/js/blog.js"></script>
        
    </body>
</html>
