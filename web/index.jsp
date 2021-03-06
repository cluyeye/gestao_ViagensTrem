<%-- 
    Document   : index
    Created on : 29/mai/2018, 0:13:09
    Author     : coxe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>TremTravel</title>
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/datepicker3.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">

        <!--Custom Font-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
    </head>

    <body>
        <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span></button>
                    <a class="navbar-brand" href="index.jsp"><span>TREM</span><small>TRAVEL</small></a>
                      
                    <ul class="nav navbar-top-links navbar-left">
                        
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="#">
                                <em class="fa fa-cogs"></em>&nbsp;Gestão<em class="fa fa-arrow-down"></em>
                            </a> 
                            
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="item">
                                    <a href="endereco.jsp">
                                        <em class="fa fa-address-card"></em>&nbsp;Endereço
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li class="item">
                                    <a href="engenheiro.jsp">
                                        <em class="fa fa-user-circle-o"></em>&nbsp;Engenheiro
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="estacao.jsp">
                                        <em class="fa fa-star"></em>&nbsp;Estação
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li class="item">
                                    <a href="trem.jsp">
                                        <em class="fa fa-train"></em>&nbsp;Trem
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li class="item">
                                    <a href="viagem.jsp">
                                        <em class="fa fa-send-o"></em>&nbsp;Viagem
                                    </a>
                                </li>
                            </ul>
                            
                        </li>
                                                
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="#">
                                <em class="fa fa-table"></em>&nbsp;Tabelas<em class="fa fa-arrow-down"></em>
                            </a>                 
                        
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="item">
                                    <a href="pais.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Países
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="provincia.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Províncias
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="municipio.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Munícipios
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="estadocivil.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Estados Cívis
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="sexo.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Sexos
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="tipoestacao.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Tipo de Estação
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="tipotrem.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Tipos de Trem
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="tipoviagem.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Tipos de Viagens
                                    </a>
                                </li>
                                
                            </ul>
                        </li>
                        
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="#">
                                <em class="fa fa-fort-awesome"></em>&nbsp;Defesa<em class="fa fa-arrow-down"></em>
                            </a>                 
                        
                            <ul class="dropdown-menu dropdown-messages">
                                <li class="item">
                                    <a href="defesa.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Consulta
                                    </a>
                                </li>
                                
                            </ul>
                        </li>
                    </ul>
                    
                    
                    <ul class="nav navbar-top-links navbar-right">
                        <!--<li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-envelope"></em><span class="label label-danger">15</span>
                            </a>
                            <ul class="dropdown-menu dropdown-messages">
                                <li>
                                    <div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
                                        </a>
                                        <div class="message-body"><small class="pull-right">3 mins ago</small>
                                            <a href="#"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>
                                            <br /><small class="text-muted">1:24 pm - 25/03/2015</small></div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="dropdown-messages-box"><a href="profile.html" class="pull-left">
                                            <img alt="image" class="img-circle" src="http://placehold.it/40/30a5ff/fff">
                                        </a>
                                        <div class="message-body"><small class="pull-right">1 hour ago</small>
                                            <a href="#">New message from <strong>Jane Doe</strong>.</a>
                                            <br /><small class="text-muted">12:27 pm - 25/03/2015</small></div>
                                    </div>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <div class="all-button"><a href="#">
                                            <em class="fa fa-inbox"></em> <strong>All Messages</strong>
                                        </a></div>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-bell"></em><span class="label label-info">5</span>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li><a href="#">
                                        <div><em class="fa fa-envelope"></em> 1 New Message
                                            <span class="pull-right text-muted small">3 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li><a href="#">
                                        <div><em class="fa fa-heart"></em> 12 New Likes
                                            <span class="pull-right text-muted small">4 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li><a href="#">
                                        <div><em class="fa fa-user"></em> 5 New Followers
                                            <span class="pull-right text-muted small">4 mins ago</span></div>
                                    </a></li>
                            </ul>
                        </li>-->

                        <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-user"></em>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li><a href="#">
                                        <div><em class="fa fa-envelope"></em> Perfil
                                            <span class="pull-right text-muted small">3 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li><a href="#">
                                        <div><em class="fa fa-power-off"></em> Terminar Sessão</div>
                                    </a></li>
                                
                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>
        <!--<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
            <div class="profile-sidebar">
                <div class="profile-userpic">
                    <img src="http://placehold.it/50/30a5ff/fff" class="img-responsive" alt="">
                </div>
                <div class="profile-usertitle">
                    <div class="profile-usertitle-name">Username</div>
                    <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
                </div>
                <div class="clear"></div>
            </div>
            <div class="divider"></div>
            <form role="search">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                </div>
            </form>
            <ul class="nav menu">
                
                <li><a href="login.html"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
            </ul>
        </div>/.sidebar-->

        <div class="col-sm-12 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="#">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Página Inicial</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Horários de Viagens</h1>
                </div>
            </div><!--/.row-->
            
        </div>	<!--/.main-->

        <script src="js/jquery-1.11.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/chart.min.js"></script>
        <script src="js/chart-data.js"></script>
        <script src="js/easypiechart.js"></script>
        <script src="js/easypiechart-data.js"></script>
        <script src="js/bootstrap-datepicker.js"></script>
        <script src="js/custom.js"></script>
        <script>
            window.onload = function() {
                var chart1 = document.getElementById("line-chart").getContext("2d");
                window.myLine = new Chart(chart1).Line(lineChartData, {
                    responsive: true,
                    scaleLineColor: "rgba(0,0,0,.2)",
                    scaleGridLineColor: "rgba(0,0,0,.05)",
                    scaleFontColor: "#c5c7cc"
                });
            };
        </script>

    </body>
</html>
