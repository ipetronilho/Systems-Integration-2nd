<!DOCTYPE html>
<html lang="en">

<head>
  <title> Welcome </title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default rounded borders and increase the bottom margin */ 
    .navbar {
      margin-bottom: 50px;
      border-radius: 0;
    }
    
    /* Remove the jumbotron's default bottom margin */ 
     .jumbotron {
      margin-bottom: 0;
    }
   
    /* Add a gray background color and some padding to the footer */
    footer {
      background-color: #f2f2f2;
      padding: 25px;
    }
  </style>
</head>
<body>
 <div id="wrapper">
  <div class="jumbotron">
    <div class="container text-center">
      <h1>Welcome!</h1>      
      <p>StandVirtual</p>
    </div>
    <footer class="container-fluid text-center">
     <div class="orw" style="text-align: center; margin:0 auto; width:400px; margin-bottom:40px;">
      <form class="form-inline">
          <a href="Login.jsp" class="tn btn-primary btn-lg btn-block">Login</a>
          <a href="RegisterUser.jsp" class="tn btn-primary btn-lg btn-block">Register</a>
         <input type="hidden" name="tableValue" id="tableTextId" /> 
      </form>
     </div>
    </footer>
  </div>
  </div>
  </body>
</html>