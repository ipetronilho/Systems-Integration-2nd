<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title> Cars</title>
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
  integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
  crossorigin="anonymous">
<script
  src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<link href="layout/admin.css" rel="stylesheet">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type="text/javascript" src="layout/users.js"></script>
</head>

<body>
  <div id="wrapper">
    <a href="Welcome.jsp" class="btn btn-info btn-md" style="float: right;">
      <span class="glyphicon glyphicon-log-out"></span> Log out
      <form action="${pageContext.request.contextPath}/logout" method="post">
		    <input type="submit" value="Logout" />
		</form>
    </a>
  </div>
  <div>
    <ul class="nav navbar-nav side-nav">
      <li><a href="CheckCars.jsp"><i class="glyphicon glyphicon-hand-left"></i> Back</a></li>
    </ul>
  </div>
  <div>
    <ul class="nav navbar-nav side-nav">
      <li><a href="MyAccount.jsp"><i class="fa fa-user"></i> My account</a></li>
    </ul>
  </div>
  <div class="container text-center">     
    <h4><strong>StandVirtual</strong></h4>
  </div>
  <div id="page-wrapper">
    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <h1 class="page-header" style="margin-top: 10px; padding-top:10px;">
            Cars
          </h1>
          <div class="login-form-1">
            <form id="register-form" class="text-left" action="SearchCars" method="POST">
            
            <c:forEach items="${cars}" var="car">
				<td "${car}"<td>
			</c:forEach>

              <div class="login-form-main-message"></div>
              <div class="main-login-form">
                  ${}
                  <a href="CheckCars.jsp" class="tn btn-success btn-lg">Submit</a>
                </div>
            </form>
            <a href="SearchFiltersCars.jsp" class="tn btn-primary btn-lg">Filters</a>
          </div>
        </div>
      </div>
    </div> 
  </div>
</body>
</html>