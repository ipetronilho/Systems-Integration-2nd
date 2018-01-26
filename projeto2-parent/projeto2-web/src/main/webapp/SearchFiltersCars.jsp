<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title> Search Filters Cars</title>
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
    </a>
  </div>
  <div>
    <ul class="nav navbar-nav side-nav">
      <li><a href="Cars.jsp"><i class="glyphicon glyphicon-hand-left"></i> Back</a></li>
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
            Search Filters <small> Car </small>
          </h1>           
          <div class="login-form-1">
            <form id="register-form" class="text-left" action="SearchFiltersCars">
              <div class="login-form-main-message"></div>
              <div class="main-login-form">
                <div class="login-group">
                  <div class="form-group">
                    <input type="text" class="form-control" id="price" name="price" placeholder="Price (0-100)">
                  </div>
                  <div class="form-group"> 
                    <input type="text" class="form-control" id="kilometers" name="kilometers" placeholder="Kilometers (0-100)">
                  </div>
                  <div class="form-group"> 
                    <input type="text" class="form-control" id="registeredDate" name="registeredDate" placeholder="Date (1990-12-12)">
                  </div>
                  <div class="form-group"> 
                    <input type="text" class="form-control" id="brand" name="brand" placeholder="Brand (BMW)">
                  </div>
                  <div class="form-group"> 
                    <input type="text" class="form-control" id="brandAndModel" name="brandAndModel" placeholder="Brand and Model (BMW-CE)">
                  </div>
                  <a href="Cars.jsp" class="tn btn-success btn-lg">Submit</a>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div> 
  </div>
</body>
</html>