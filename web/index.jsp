<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" class="h-100">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="keywords" content="">
        <meta name="author" content="">
        <meta name="robots" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template">
        <meta property="og:title" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template">
        <meta property="og:description" content="Fillow : Fillow Saas Admin  Bootstrap 5 Template">
        <meta property="og:image" content="">
        <meta name="format-detection" content="telephone=no">

        <!-- PAGE TITLE HERE -->
        <title>Admin Dashboard</title>

        <!-- FAVICONS ICON -->
        <link rel="shortcut icon" type="image/png" href="images/favicon.png">
        <link href="css/style.css" rel="stylesheet">

    </head>

    <body class="vh-100">
        <div class="authincation h-100">
            <div class="container h-100">
                <div class="row justify-content-center h-100 align-items-center">
                    <div class="col-md-6">
                        <div class="authincation-content">
                            <div class="row no-gutters">
                                <div class="col-xl-12">
                                    <div class="auth-form">
                                        <div class="text-center mb-3">
                                            <a href="index.html"><img src=" " alt=""></a>
                                        </div>
                                        <h4 class="text-center mb-4">Ingresar</h4>
                                        <form class="row g-3" method="post" action="Login">
                                            <div class="col-12">
                                                <div class="col-12">
                                                    <label class="form-label">Usuario</label>
                                                    <input type="text" name="resUsuario" class="form-control" required>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <label for="yourPassword" class="form-label">Clave</label>
                                                <input type="password" name="resClave" class="form-control"required>
                                            </div>
                                            <div class="col-12">
                                                <input class="btn btn-primary w-100" style="border: none; height: 50px" type="submit" value="INGRESAR" name="btn-login">
                                                <!--<a href="Controlador?accion=reporte" class="btn btn-primary w-100" style="border: none; height: 50px">INGRESAR</a>-->
                                            </div>
                                            <center>
                                                <h5 style="color: #007bb6;">${errorSesion}</h5>
                                            </center>
                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!--**********************************
            Scripts
        ***********************************-->
        <!-- Required vendors -->
        <script src="vendor/global/global.min.js"></script>
        <script src="js/custom.min.js"></script>
        <script src="js/dlabnav-init.js"></script>
        <script src="js/styleSwitcher.js"></script>
    </body>
</html>