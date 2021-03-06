<%-- 
    Document   : index
    Created on : 29/mai/2018, 0:13:09
    Author     : coxe
--%>

<%@page import="dao.TipoTremDAO"%>
<%@page import="dao.EngenheiroDAO"%>
<%@page import="modelo.TipoTremModelo"%>
<%@page import="modelo.EngenheiroModelo"%>
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
                    <a class="navbar-brand" href="index.jsp"><span>TREM</span><small>TRAVEL</small></a>

                                      
                    
                    <ul class="nav navbar-top-links navbar-left">
                        <li class="dropdown">
                            <!--<ul class="dropdown-menu dropdown-messages">
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
                            </ul>-->
                        </li>
                        
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
                        
                    </ul>
                    
                    <ul class="nav navbar-top-links navbar-right">
                        <!--
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
                        -->
                        <li class="dropdown">
                            <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
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
            </div>
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
                    <h1 class="page-header"><em class="fa fa-train text-primary"></em>&nbsp;Gestão de Trens</h1>
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

                <% 
                    ArrayList<TremModelo> trens = new TremDAO().listar();
                    ArrayList<EngenheiroModelo> engenheiros = new EngenheiroDAO().listar();
                    ArrayList<TipoTremModelo> tiposTrem = new TipoTremDAO().listar();

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
                                <th>Matricula</th>
                                <th>Tipo</th>
                                <th>Engenheiro</th>
                                <th>Sexo</th>
                                <th>Telefone</th>
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
                                                <a data-toggle="modal" data-target="#newTremModal">&nbsp;<i class="fa fa-edit"></i>&nbsp;Editar</a>
                                                <a data-toggle="modal" data-target="#deleteTremModal">&nbsp;<i class="fa fa-trash"></i>&nbsp;Eliminar</a>
                                            </li>


                                        </ul>
                                    </div>
                                </td>
                                <td><%=t.getPk_trem()%></td>
                                <td><%=t.getMatricula() %></td>
                                <td><%=t.getEngenheiro().getPessoa().getNome()%>&nbsp;<%=t.getEngenheiro().getPessoa().getSobrenome()%></td>
                                <td><%=t.getEngenheiro().getPessoa().getSexo().getNome() %></td>
                                <td><%=t.getEngenheiro().getPessoa().getTelefone() %></td>
                                <td><%=t.getTipoTrem().getNome()%></td>

                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>

                    </table>
                </div> 


                <form name="newTrem" method="post" action="TremServlet">

                    <div class="modal fade" id="newTremModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-train"></i>&nbsp;Trem</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    
                                    <div class="form-group row">
                                        <div class="col-sm-12 text-left">
                                            <label class="col-form-label">Matricula</label>
                                        </div>
                                        <div class="col-sm-12">
                                            <input type="text" name="matricula" class="form-control" maxlength="100" required placeholder="Matrícula">
                                        </div>
                                    </div>
                                    
                                    <div class="form-group row">
                                        <div class="col-sm-12 text-left">
                                            <label class="col-form-label">Engenheiro</label>
                                        </div>
                                        <div class="col-sm-12">
                                            <select class="form-control" required name="engenheiro" >
                                                <option value="-1">Seleccione uma opção</option>
                                                <%
                                                    for (EngenheiroModelo e : engenheiros) {
                                                %>
                                                <option value=<%=e.getPk_engenheiro() %>>
                                                    <%=e.getPessoa().getNome() %>&nbsp;<%=e.getPessoa().getSobrenome() %>
                                                </option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-12 text-left">
                                            <label class="col-form-label">Tipo de Trem</label>
                                        </div>
                                        <div class="col-sm-12">
                                            <select class="form-control" required name="tipotrem" >
                                            <option value="-1">Seleccione uma opção</option>
                                            <%
                                                for (TipoTremModelo tt : tiposTrem) {
                                            %>
                                            <option value=<%=tt.getPk_tipotrem() %>><%=tt.getNome() %></option>
                                            <%
                                                }
                                            %>
                                            </select>
                                        </div>
                                    </div>

                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-outline-danger" data-dismiss="modal"><i class="fa fa-times fa-fw"></i>&nbsp;Cancelar</button>
                                    <button type="submit" class="btn btn-success" ><i class="fa fa-save fa-fw"></i>&nbsp;Guardar</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>

                                            
                <form name="deleteTrem" method="post" action="TremServlet">
                    <div class="modal fade" id="deleteTremModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-train"></i>&nbsp;Eliminar Trem</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <sup aria-hidden="true">&times;</sup>
                                    </button>
                                </div>
                                <div class="modal-body">
                                     <%
                                                
                                     %>
                                    <h4>Tem a certeza que pretende eliminar o Trem</h4>

                                </div>
                                <div class="modal-footer">
                                    <button type="reset" class="btn btn-outline-danger" data-dismiss="modal"><i class="fa fa-times fa-fw"></i>&nbsp;Cancelar</button>
                                    <button type="submit" class="btn btn-success" ><i class="fa fa-trash"></i>&nbsp;Guardar</button>
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
