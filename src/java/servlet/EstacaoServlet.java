/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import dao.EstacaoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.EnderecoEstacaoModelo;
import modelo.EstacaoModelo;
import modelo.MunicipioModelo;
import modelo.TipoEstacaoModelo;

/**
 *
 * @author coxe
 */
public class EstacaoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String nome = request.getParameter ("nome");
        String cidade = request.getParameter ("cidade");
        String numero = request.getParameter ("numero");
        int municipio = Integer.parseInt(request.getParameter ("municipio"));
        int tipoestacao = Integer.parseInt(request.getParameter ("tipoestacao"));
        
        EstacaoModelo estacao = new EstacaoModelo();
        
        MunicipioModelo mun = new MunicipioModelo();
        mun.setPk_municipio(municipio);
        
        EnderecoEstacaoModelo end_e = new EnderecoEstacaoModelo();
        end_e.setMunicipio(mun);
        end_e.setCidade(cidade);
        end_e.setNumero(numero);

        TipoEstacaoModelo tt = new TipoEstacaoModelo();
        tt.setPk_tipoestacao(tipoestacao);

        estacao.setNome(nome);
        estacao.setEnderecoEstacao(end_e);
        estacao.setTipoEstacao(tt);
                        
        EstacaoDAO estacaoDAO = new EstacaoDAO(estacao);
        
        if( estacaoDAO.inserir(estacao))
        {
            JOptionPane.showMessageDialog(null, "Registo efectuado com sucesso");
            response.sendRedirect("estacao.jsp");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Erro ao Registo Estacao, por favor verifique se o Estacao já foi Registado","Erro", JOptionPane.ERROR_MESSAGE);
            response.sendRedirect("estacao.jsp");
        }    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
