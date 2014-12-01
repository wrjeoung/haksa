<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>�����낫�����/title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- 遺���ㅽ���-->
    <link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">
    
    <!-- Custom styles for this template -->
    <link href="dist/customcss/starter-template.css" rel="stylesheet">
    
    <script type="text/javascript">
    	function isLogin() {
    		alert("濡�렇�����ъ� 媛�� �⑸���")
    	}
    </script>
  </head>
  <body>
              
  	 
  	
     <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Univ.</a>
        </div>
        	
		        <div class="collapse navbar-collapse">
		        <c:if test="${memId != null}">
		          <ul class="nav navbar-nav">
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">My��<b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">�����낫</li>
		                <li><a href="#">媛����낫蹂�꼍</a></li>
		                <li><a href="#">鍮��踰��蹂�꼍</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">�깆�議고� / 議몄��ъ�議고�</li>
		                <li><a href="hakgi.do">��린蹂��깆�議고�</a></li>
		                <li><a href="#">議몄��ъ� 議고�</a></li>
		                <li><a href="#">���怨쇰ぉ�댁�議고�</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">�깅��ν�</li>
		                <li><a href="#">�깅�湲����議고�</a></li>
		                <li><a href="#">�ν�湲�������議고�</a></li>
		              </ul>
		            </li>
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">��� <b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">援��怨쇱� 議고�</li>
		                <li><a href="#">援�낵紐�議고�</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">媛�� ���</li>
		                <li><a href="#">媛�� �곗�媛�� 議고�</a></li>
		              </ul>
		            </li>
		            <li class="dropdown">
		              <a href="#" class="dropdown-toggle" data-toggle="dropdown">��껌 <b class="caret"></b></a>
		              <ul class="dropdown-menu">
		                <li class="dropdown-header">���蹂��</li>
		                <li><a href="#">�댄���껌</a></li>
		                <li><a href="#">蹂듯���껌</a></li>
		                <li><a href="#">��낵��껌</a></li>
		                <li><a href="#">�����껌</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">��났愿�━</li>
		                <li><a href="#">二쇱�怨듬같���泥�/a></li>
		                <li><a href="#">��났��껌/�ш린</a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">�깅��ν�</li>
		                <li><a href="#">援���ν�湲��泥�/a></li>
		                <li class="divider"></li>
		                <li class="dropdown-header">����몄�/�ш린��껌</li>
		                <li><a href="#">����ш린��껌</a></li>
		              </ul>
		            </li>            
		            <li><a href="registerclass.do">�����껌</a></li>
		            <li><a href="#contact">���怨쇰ぉ泥��</a></li>
		            <li><a href="noticeList.do">怨듭��ы�</a></li>
		          </ul>
	          </c:if>
	          
	          <form class="navbar-form navbar-right" action="loginOutPro.do" method="post">
	          	<c:if test="${memId == null}">
		            <div class="form-group">
		              <input type="text" placeholder="���" class="form-control" name="studentNumber">
		            </div>
		            <div class="form-group">
		              <input type="password" placeholder="鍮��踰��" class="form-control" name="password">
		            </div>
	            </c:if>
	            <c:choose>
	            	<c:when test="${memId == null }">
	            		<button type="submit" class="btn btn-success">Sign in</button>
	            	</c:when>
	            	<c:otherwise>
	            		<button type="submit" class="btn btn-success">Sign out</button>
	            	</c:otherwise>
	            </c:choose>
	          </form>
	       
	      </div><!--/.nav-collapse -->
      </div>
    </div>

    <div class="container">
      <div class="starter-template">
        <h1>Bootstrap starter template</h1>
        <p class="lead">Use this document as a way to quickly start any new project.<br> All you get is this text and a mostly barebones HTML document.</p>
      </div>
    </div><!-- /.container -->
 
    <!-- jQuery (遺���ㅽ��⑹� ����ㅽ�由쏀� ���洹몄������ ����� -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- 紐⑤� �⑹�吏����洹몄����ы���굅��(���) �����媛��������ㅼ� �ы������-->
    <script src="dist/js/bootstrap.min.js"></script>
    
    <!-- Respond.js �쇰� IE8 ��� 諛����湲곕����������몄� (https://github.com/scottjehl/Respond) -->
    <!-- <script src="js/respond.js"></script> -->
    
  </body>
</html>