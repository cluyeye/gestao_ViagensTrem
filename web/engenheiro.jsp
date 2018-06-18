<%-- 
    Document   : index
    Created on : 29/mai/2018, 0:13:09
    Author     : coxe
--%>

<%@page import="dao.ProvinciaDAO"%>
<%@page import="dao.SexoDAO"%>
<%@page import="modelo.SexoModelo"%>
<%@page import="modelo.ProvinciaModelo"%>
<%@page import="dao.PaisDAO"%>
<%@page import="modelo.PaisModelo"%>
<%@page import="dao.EnderecoDAO"%>
<%@page import="modelo.EnderecoModelo"%>
<%@page import="dao.EstadoCivilDAO"%>
<%@page import="dao.MunicipioDAO"%>
<%@page import="modelo.EstadoCivilModelo"%>
<%@page import="modelo.MunicipioModelo"%>
<%@page import="dao.EngenheiroDAO" %>
<%@page import="modelo.EngenheiroModelo" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>T-Travel | Engenheiro</title>
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
                    <li class="active">Engenheiro</li>
                </ol>
            </div><!--/.row-->

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header"><em class="fa fa-user-circle-o text-primary"></em>&nbsp;Gestão de Engenheiros</h1>
                </div>

                <div class="col-md-12">
                    <div class="col-md-8">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Pesquisar " v-model="filtroEngenheiro" aria-label="Pesquisar">
                            <span class="input-group-btn">
                                <button class="btn btn-primary" type="button"><i class="fa fa-search"></i>&nbsp; Pesquisar</button>
                            </span>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#newEngenheiroModal">
                            <i class="fa fa-plus fa-fw"></i> Nova Estação
                        </button>
                    </div>
                </div>

                <% 
                    ArrayList<EngenheiroModelo> engenheiros = new EngenheiroDAO().listar();
                    ArrayList<PaisModelo> paises = new PaisDAO().listar();
                    ArrayList<ProvinciaModelo> provincias = new ProvinciaDAO().listar();
                    ArrayList<MunicipioModelo> municipios = new MunicipioDAO().listar();
                    ArrayList<SexoModelo> sexos = new SexoDAO().listar();
                    ArrayList<EnderecoModelo> enderecos = new EnderecoDAO().listar();
                    ArrayList<EstadoCivilModelo> estadoscivis = new EstadoCivilDAO().listar();

                    if (engenheiros == null || engenheiros.size() == 0) {
                %>                            
                <div class="col-md-12" align="center">
                    <h2>Sem Resultados</h2> <%=engenheiros%>
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
                                <th>Nome</th>
                                <th>Telefone</th>
                                <th>Sexo</th>
                                <th>Estado Cívil</th>
                                <th>Data N</th>
                                <th>Pais</th>
                                <th>Província</th>
                                <th>Municipio</th>
                                <th>Cidade</th>
                                <th>Rua</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (EngenheiroModelo eng : engenheiros) {
                            %>
                            <tr>
                                <td>
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-primary btn-sm dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <i class="fa fa-cog">&nbsp;</i> <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu">
                                            <li class="dropdown-item text-left">
                                                <a data-toggle="modal" data-target="#newEngenheiroModal">&nbsp;<i class="fa fa-edit"></i>&nbsp;Editar</a>
                                                <a data-toggle="modal" data-target="#deleteEngenheiroModal">&nbsp;<i class="fa fa-trash"></i>&nbsp;Eliminar</a>
                                            </li>

                                        </ul>
                                    </div>
                                </td>

                                <td><%=eng.getPk_engenheiro()%></td>
                                <td><%=eng.getPessoa().getNome() %>&nbsp;<%=eng.getPessoa().getSobrenome() %></td>
                                <td><%=eng.getPessoa().getTelefone() %></td>
                                <td><%=eng.getPessoa().getSexo().getNome() %></td>
                                <td><%=eng.getPessoa().getEstadoCivil().getNome() %></td>
                                <td><%=eng.getPessoa().getDataNascimento()%></td>
                                <td><%=eng.getPessoa().getEndereco().getMunicipio().getProvincia().getPais().getNome() %></td>
                                <td><%=eng.getPessoa().getEndereco().getMunicipio().getProvincia().getNome() %></td>
                                <td><%=eng.getPessoa().getEndereco().getMunicipio().getNome() %></td>
                                <td><%=eng.getPessoa().getEndereco().getBairro() %></td>
                                <td><%=eng.getPessoa().getEndereco().getRua() %>&nbsp;-&nbsp;<%=eng.getPessoa().getEndereco().getNumeroCasa() %></td>

                            </tr
                            <%
                                    }
                                }
                            %>
                        </tbody>

                    </table>
                </div> 


                <form name="newEngenheiro" method="post" action="EngenheiroServlet">

                    <div class="modal fade" id="newEngenheiroModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog modal-lg" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-user-circle-o"></i>&nbsp;Engenheiro</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Nome</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="nome" class="form-control" maxlength="100" required placeholder="Nome">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Telefone</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="telefone" class="form-control" maxlength="100" required placeholder="Telefone">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Data de Nascimento</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="date" name="datanascimento" class="form-control" maxlength="100" required placeholder="Data de Nascimento">
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Sexo</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="sexo" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                    <%
                                                        for (SexoModelo s : sexos) {
                                                    %>
                                                    <option value=<%=s.getPk_sexo()%>>
                                                        <%=s.getNome()%>
                                                    </option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Estado Cívil</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="estadocivil" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                    <%
                                                        for (EstadoCivilModelo ec : estadoscivis) {
                                                    %>
                                                    <option value=<%=ec.getPk_estadocivil()%>><%=ec.getNome()%></option>
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
                                                <label class="col-form-label">País</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="pais" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                            <%
                                                                for (PaisModelo p : paises) {
                                                            %>
                                                    <option value=<%=p.getPk_pais()%>>
                                                            <%=p.getNome() %>
                                                    </option>
                                                            <%
                                                                }
                                                            %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Província</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="provincia" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                            <%
                                                                for (ProvinciaModelo p : provincias) {
                                                            %>
                                                    <option value=<%=p.getPk_provincia()%>>
                                                            <%=p.getNome() %>
                                                    </option>
                                                            <%
                                                                }
                                                            %>
                                                </select>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Municipio</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <select class="form-control" required name="municipio" >
                                                    <option value="-1">Seleccione uma opção</option>
                                                            <%
                                                                for (MunicipioModelo m : municipios) {
                                                            %>
                                                    <option value=<%=m.getPk_municipio()%>>
                                                            <%=m.getNome() %>
                                                    </option>
                                                            <%
                                                                }
                                                            %>
                                                </select>
                                            </div>
                                        </div>
                                               
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Cidade</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="datanascimento" class="form-control" maxlength="100" required placeholder="Cidade">
                                            </div>
                                        </div>
                                               
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Rua</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="rua" class="form-control" maxlength="100" required placeholder="Rua">
                                            </div>
                                        </div>
                                               
                                        <div class="form-group row">
                                            <div class="col-sm-12 text-left">
                                                <label class="col-form-label">Número da Casa</label>
                                            </div>
                                            <div class="col-sm-12">
                                                <input type="text" name="numerocasa" class="form-control" maxlength="100" required placeholder="Número da Casa">
                                            </div>
                                        </div>

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

                                            
                <form name="deleteEngenheiro" method="post" action="EngenheiroServlet">
                    <div class="modal fade" id="deleteEngenheiroModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" data-keyboard="false" data-backdrop="static">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabel"><i class="titulo fa fa-train"></i>&nbsp;Eliminar Engenheiro</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <sup aria-hidden="true">&times;</sup>
                                    </button>
                                </div>
                                <div class="modal-body">
                                     <%
                                                
                                     %>
                                    <h4>Tem a certeza que pretende eliminar o Engenheiro</h4>

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
