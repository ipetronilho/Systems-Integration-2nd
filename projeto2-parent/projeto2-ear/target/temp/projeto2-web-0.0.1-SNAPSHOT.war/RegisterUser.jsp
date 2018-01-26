<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Register User</title>
  <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
    integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
    crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <link href="layout/admin.css" rel="stylesheet">
  <link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <script type="text/javascript" src="layout/users.js"></script>

</head>

<body>
  <div>
    <ul class="nav navbar-nav side-nav">
      <li><a href="Welcome.jsp"><i class="fa fa-home"></i> Home</a></li>
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
            Register <small> User </small>
          </h1>           
          <div class="login-form-1">
            <form id="register-form" class="text-left" action="Register" method="GET">
              <div class="login-form-main-message"></div>
              <div class="main-login-form">
                <div class="login-group">
                  <div class="form-group">
                    <input type="text" class="form-control" name="username" placeholder="Insert your username..." required>
                  </div>
                  <div class="form-group"> 
                    <input type="text" class="form-control" name="email" placeholder="Insert your email..." required>
                  </div>
                  <div class="form-group"> 
                    <input type="password" class="form-control" name="password" placeholder="Insert your password..." required>
                  </div>
                </div>
              </div>
              <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>   
            </form>
          </div>
        </div>
      </div>
    </div> 
  </div>
</body>
</html>