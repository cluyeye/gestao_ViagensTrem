<%-- 
    Document   : index
    Created on : 29/mai/2018, 0:13:09
    Author     : coxe
--%>

<%@page import="dao.TremDAO" %>
<%@page import="modelo.TremModelo" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>T-Travel | Trem</title>
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
                    <a class="navbar-brand" href="#"><span>TREM</span><small>TRAVEL</small></a>



                    <ul class="nav navbar-top-links navbar-right">


                        <li class="dropdown"><a data-toggle="dropdown" href="#">

                                <div class="profile-sidebar" style="margin: 0; padding: 0;">

                                    <div class="profile-usertitle" style="margin: 0; padding: 0;">
                                        <div class="profile-usertitle-name"><small>Username</small></div>
                                        <div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
                                    </div>
                                    <div class="clear"></div>
                                </div>
                            </a>
                        </li>
                        <li class="dropdown"><a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                                <em class="fa fa-user"></em>
                            </a>
                            <ul class="dropdown-menu dropdown-alerts">
                                <li><a href="#">
                                        <div><em class="fa fa-envelope"></em> Perfil
                                            <span class="pull-right text-muted small">3 mins ago</span></div>
                                    </a></li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">
                                        <div><em class="fa fa-power-off bg-danger"></em> Terminar Sessão</div>
                                    </a>
                                </li>

                            </ul>
                        </li>
                    </ul>
                </div>
            </div><!-- /.container-fluid -->
        </nav>


        <div class="col-sm-12 main">
            <div class="row">
                <ol class="breadcrumb">
                    <li><a href="index.jsp">
                            <em class="fa fa-home"></em>
                        </a></li>
                    <li class="active">Trem</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><em class="fa fa-train"></em>&nbspGestão de Trens</h1>
                </div>

                <div class="col-md-12">
                    <div class="col-md-8">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Pesquisar " v-model="filtroTrem" aria-label="Pesquisar">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button"><i class="fa fa-search"></i>&nbsp; Pesquisar</button>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#newTremModal">
                            <i class="fa fa-plus fa-fw"></i> Novo Trem
                        </button>
                    </div>
                </div>

                <% ArrayList<TremModelo> trens = new TremDAO().listar();

                    if (trens == null) {
                %>                            
                <div class="col-md-12" align="center">
                    <h2>Sem Resultados</h2> <%=trens%>
                </div> 
                <%
                } else {
                %>
                <div class="col-md-12" style="margin: 25px 0px" >

                    <table align='center' class="table table-condensed table-hover" >
                        <thead>
                            <tr>
                                <th></th>
                                <th>ID</th>
                                <th>Engenheiro</th>
                                <th>Tipo</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (TremModelo t : trens) {
                            %>
                            <tr>
                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa fa-cog">&nbsp;</i> <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li class="dropdown-item text-left">
                                                <a >&nbsp;<i class="fa fa-edit" data-toggle="modal" data-target="#newTremModal"></i>&nbsp;Editar</a>
                                                <a >&nbsp;<i class="fa fa-trash" data-toggle="modal" data-target="#newTremModal"></i>&nbsp;Eliminar</a>
                                            </li>


                                        </ul>
                                    </div>
                                </td>
                                <td><%=t.getPk_trem()%></td>
                                <td><%=t.getEngenheiro().getPessoa().getNome()%>&nbsp;<%=t.getEngenheiro().getPessoa().getSobrenome()%></td>
                                <td><%=t.getTipoTrem().getNome()%></td>

                            </tr
                            <%
                                    }
                                }
                            %>
                        </tbody>

                    </table>
                </div> 


                <form name="newTrem" method="post" action="TremServlet.jsp">

                    <div class="modal fade" id="newTremModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-train"></i>&nbsp;Trem</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <!--
                                    <div class="form-group row">
                                        <div class="col-sm-12 text-left">
                                            <label class="col-form-label">Nome</label>
                                        </div>
                                        <div class="col-sm-12">
                                            <input type="text" class="form-control" maxlength="100" required placeholder="Nome" v-model="servico.Nome">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-12 text-left">
                                            <label class="col-form-label">Shortcode</label>
                                        </div>
                                        <div class="col-sm-12">
                                            <input type="text" class="form-control" maxlength="100" required placeholder="Shortcode" v-model="servico.Shortcode">
                                        </div>
                                    </div>
                                    
                                    -->

                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-outline-danger" data-dismiss="modal"><i class="fa fa-times fa-fw"></i>&nbsp;Cancelar</button>
                                    <button type="submit" class="btn btn-success" ><i class="fa fa-save fa-fw"></i>&nbsp;Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>


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
