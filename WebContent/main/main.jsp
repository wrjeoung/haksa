<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
  <head>
    <title>�л������ý���</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- ��Ʈ��Ʈ�� -->
    <link href="dist/css/bootstrap.css" rel="stylesheet" media="screen">
    
    <!-- Custom styles for this template -->
    <link href="dist/customcss/starter-template.css" rel="stylesheet">
    
    <script type="text/javascript">
    	function isLogin() {
    		alert("�α��� �� ��� ���� �մϴ�.")
    	}
    </script>
  </head>
  <body>
              ####
  	${loginCheck } ###
  	${memId }
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
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">MyȨ <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">�л�����</li>
                <li><a href="#">������������</a></li>
                <li><a href="#">��й�ȣ����</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">������ȸ / ����������ȸ</li>
                <li><a href="#">�б⺰ ������ȸ</a></li>
                <li><a href="#">�������� ��ȸ</a></li>
                <li><a href="#">�ʼ������̼���ȸ</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">�������</li>
                <li><a href="#">��ϱݳ��� ��ȸ</a></li>
                <li><a href="#">���бݼ������� ��ȸ</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">���� <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">�������� ��ȸ</li>
                <li><a href="#">������ ��ȸ</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">���� ��</li>
                <li><a href="#">���� ������� ��ȸ</a></li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">��û <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li class="dropdown-header">��������</li>
                <li><a href="#">���н�û</a></li>
                <li><a href="#">���н�û</a></li>
                <li><a href="#">������û</a></li>
                <li><a href="#">�����û</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">��������</li>
                <li><a href="#">������������û</a></li>
                <li><a href="#">������û/����</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">�������</li>
                <li><a href="#">�������бݽ�û</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">��������/���⼱û</li>
                <li><a href="#">���������û</a></li>
              </ul>
            </li>            
            <li><a href="#contact">������û</a></li>
            <li><a href="#contact">��������öȸ</a></li>
            <li><a href="#contact">��������</a></li>
          </ul>
          <form class="navbar-form navbar-right" action="loginPro.do" method="post">
            <div class="form-group">
              <input type="text" placeholder="�й�" class="form-control" name="studentNumber">
            </div>
            <div class="form-group">
              <input type="password" placeholder="��й�ȣ" class="form-control" name="password">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
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
 
    <!-- jQuery (��Ʈ��Ʈ���� �ڹٽ�ũ��Ʈ �÷������� ���� �ʿ���) -->
    <script src="//code.jquery.com/jquery.js"></script>
    <!-- ��� ������ �÷������� �����ϰų� (�Ʒ�) �ʿ��� ������ ���ϵ��� �����ϼ��� -->
    <script src="dist/js/bootstrap.min.js"></script>
    
    <!-- Respond.js ���� IE8 ���� ������ ����� Ȱ��ȭ�ϼ��� (https://github.com/scottjehl/Respond) -->
    <!-- <script src="js/respond.js"></script> -->
    
  </body>
</html>