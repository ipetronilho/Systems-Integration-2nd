<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title> Check Cars </title>
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
    <span class="glyphicon glyphicon-log-out"></span> Log out</a>
  </div>
  <div>
    <ul class="nav navbar-nav side-nav">
      <li><a href="MyAccount.jsp"><i class="glyphicon glyphicon-hand-left"></i> Back</a></li>
    </ul>
  </div>
  <div class="container text-center">     
    <h4><strong>StandVirtual</strong></h4>
  </div>
    <footer class="container-fluid text-center">
     <div class="orw" style="text-align: center; margin:0 auto; width:400px; margin-bottom:40px;">
      <form class="form-inline" action="SearchCars" method="POST>
                <h1 class="page-header" style="margin-top: 10px; padding-top:10px;">
            <small> Cars </small>
          </h1>  
          <button class="btn btn-lg btn-primary btn-block" type="submit">Check out all cars</button>
          <a href="MyCars.jsp" class="tn btn-primary btn-lg btn-block">My Cars</a>
          <a href="FollowedCars.jsp" class="tn btn-primary btn-lg btn-block">Followed Cars</a>
         <input type="hidden" name="tableValue" id="tableTextId" />  
      </form>
     </div>
    </footer>
  </body>
</html>