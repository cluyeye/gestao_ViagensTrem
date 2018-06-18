<%-- 
    Document   : index
    Created on : 29/mai/2018, 0:13:09
    Author     : coxe
--%>

<%@page import="dao.TremDAO"%>
<%@page import="modelo.TremModelo"%>
<%@page import="dao.EstacaoDAO"%>
<%@page import="modelo.EstacaoModelo"%>
<%@page import="dao.TipoViagemDAO"%>
<%@page import="dao.MunicipioDAO"%>
<%@page import="modelo.TipoViagemModelo"%>
<%@page import="modelo.MunicipioModelo"%>
<%@page import="dao.TremEstacaoDAO" %>
<%@page import="modelo.TremEstacaoModelo" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>T-Travel | Viagem</title>
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
                                    <a href="enderecoestacao.jsp">
                                        <em class="fa fa-address-card"></em>&nbsp;Endereço
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li class="item">
                                    <a href="engenheiro.jsp">
                                        <em class="fa fa-user-circle-o"></em>&nbsp;Municipio
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
                                        <em class="fa fa-table"></em>&nbsp;Tipo de Viagem
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="tipotrem.jsp">
                                        <em class="fa fa-table"></em>&nbsp;Tipos de Viagem
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
                    <li class="active">Viagem</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><em class="fa fa-send-o text-primary"></em>&nbsp;Gestão de Viagens</h1>
                </div>

                <div class="col-md-12">
                    <div class="col-md-8">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Pesquisar " v-model="filtroViagem" aria-label="Pesquisar">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button"><i class="fa fa-search"></i>&nbsp; Pesquisar</button>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#newViagemModal">
                            <i class="fa fa-plus fa-fw"></i> Nova Marcação
                        </button>
                    </div>
                </div>

                <% 
                    ArrayList<TremEstacaoModelo> viagens = new TremEstacaoDAO().listar();
                    ArrayList<EstacaoModelo> estacoes = new EstacaoDAO().listar();
                    ArrayList<TremModelo> trens = new TremDAO().listar();
                    
                    ArrayList<TipoViagemModelo> tiposViagem = new TipoViagemDAO().listar();

                    if (viagens == null || viagens.size() == 0) {
                %>                            
                <div class="col-md-12" align="center">
                    <h2>Sem Resultados</h2> <%=viagens %>
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
                                <th>Trem</th>
                                <th>Estação</th>
                                <th>Tipo de Viagem</th>
                                <th>Data</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (TremEstacaoModelo v : viagens) {
                            %>
                            <tr>
                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa fa-cog">&nbsp;</i> <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li class="dropdown-item text-left">
                                                <a data-toggle="modal" data-target="#newViagemModal">&nbsp;<i class="fa fa-edit"></i>&nbsp;Editar</a>
                                                <a data-toggle="modal" data-target="#deleteViagemModal">&nbsp;<i class="fa fa-trash"></i>&nbsp;Eliminar</a>
                                            </li>

                                        </ul>
                                    </div>
                                </td>


                                <td><%=v.getTrem().getMatricula() %></td>
                                <td><%=v.getEstacao().getNome() %></td>
                                <td><%=v.getTipoViagem().getNome()%></td>
                                <td><%=v.getDataViagem() %>&nbsp;<%=v.getHoraViagem() %></td>
                            </tr>
                            <%
                                    }
                                }
                            %>
                        </tbody>

                    </table>
                </div> 


                <form name="newViagem" method="post" action="ViagemServlet">

                    <div class="modal fade" id="newViagemModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-send-o"></i>&nbsp;Viagem</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    
                                <div class="row">
                                    <!--
                                    <div class="col-md-6">  
                                        
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Trem</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="trem" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                            <%
                                                                for (TremModelo t : trens) {
                                                            %>
                                                    <option value=<%=t.getPk_trem()%>>
                                                            <%=t.getMatricula()%>
                                                    </option>
                                                            <%
                                                                }
                                                            %>
                                                </select>
                                            </div>
                                        </div>
                                        
                                        
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Estação</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="estacao" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                    <%
                                                        for (EstacaoModelo e : estacoes) {
                                                    %>
                                                    <option value=<%=e.getPk_estacao()%>><%=e.getNome()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                                
                                        
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Tipo de Viagem</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="tipoviagem">
                                                    <option value="-1">Seleccione uma opção</option>
                                                    <%
                                                        for (TipoViagemModelo tt : tiposViagem) {
                                                    %>
                                                    <option value=<%=tt.getPk_tipoviagem()%>>
                                                        <%=tt.getNome()%>
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>
                                                
                                    </div> 
                                                
                                    <div class="col-md-6">
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Data de Viagem</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="dataviagem" class="form-control" maxlength="100" required placeholder="Data de Viagem">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Hora de Viagem</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="horaviagem" class="form-control" maxlength="100" required placeholder="Hora de Viagem">
                                            </div>
                                        </div>

                                    </div>
                                    -->
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

                                            
                <form name="deleteViagem" method="post" action="ViagemServlet">
                    <div class="modal fade" id="deleteViagemModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog modal-sm" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-train"></i>&nbsp;Eliminar Viagem</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <sup aria-hidden="true">&times;</sup>
                                    </button>
                                </div>
                                <div class="modal-body">
                                     <%
                                                
                                     %>
                                    <h4>Tem a certeza que pretende eliminar o Viagem</h4>

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
