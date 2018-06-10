/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.EstacaoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class EstacaoDAO 
{
    private EstacaoModelo estacao;
    private PreparedStatement preparedStatement;

    public EstacaoDAO() { }

    public EstacaoDAO(EstacaoModelo estacao)
    {
        this.estacao = estacao;
    }
      
    public ArrayList<EstacaoModelo> listar()
    {
        ArrayList<EstacaoModelo> lista = new ArrayList<EstacaoModelo>();
        
        String query ="SELECT pk_estacao, nome, fk_tipoestacao, fk_endereco FROM estacao";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                estacao = new EstacaoModelo();

                estacao.setPk_estacao(rs.getInt("pk_estacao"));
                estacao.setNome(rs.getString("nome"));
                estacao.setTipoEstacao(
                        new TipoEstacaoDAO().getByID(rs.getInt("fk_tipoestacao"))                        
                );
                estacao.setEndereco(
                        new EnderecoDAO().getByID(rs.getInt("fk_endereco"))                        
                );
                
                lista.add(estacao);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public EstacaoModelo getByID(int id)
    {
        
        String query ="SELECT * FROM estacao WHERE pk_estacao = ?";
        
        try
        {
            estacao.setPk_estacao(id);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, estacao.getPk_estacao());
                        
            estacao = new EstacaoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            estacao.setPk_estacao(rs.getInt("pk_estacao"));
            estacao.setNome(rs.getString("nome"));
            estacao.setTipoEstacao(
                    new TipoEstacaoDAO().getByID(rs.getInt("fk_tipoestacao"))                        
            );
            estacao.setEndereco(
                    new EnderecoDAO().getByID(rs.getInt("fk_endereco"))                        
            );
         
            Conexao.fecharConexao();
        
            return estacao;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(EstacaoModelo estacao)
    {
        if ( estacaoNaoExiste())
        {
            String query = "INSERT INTO estacao(nome, fk_tipoestacao, fk_endereco) VALUES(?, ?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);                
                preparedStatement.setInt(1, estacao.getTipoEstacao().getPk_tipoestacao());
                preparedStatement.setInt(2, estacao.getTipoEstacao().getPk_tipoestacao());
                preparedStatement.setInt(3, estacao.getEndereco().getPk_endereco());
                

                preparedStatement.execute();

                Conexao.fecharConexao();
                return true;
            }

            catch (SQLException excepcao)
            {
                System.out.println("Erro de SQL: " + excepcao.getMessage());
            }
        }
        
        return false;
    
    }
     
    public Boolean editar(EstacaoModelo estacao)
    {
        String query = "UPDATE estacao SET fk_tipoestacao = ?, fk_endereco = ? WHERE pk_estacao = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);                
            preparedStatement.setString(1, estacao.getNome());
            preparedStatement.setInt(2, estacao.getTipoEstacao().getPk_tipoestacao());
            preparedStatement.setInt(3, estacao.getEndereco().getPk_endereco());
            preparedStatement.setInt(4, estacao.getPk_estacao());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (EstacaoModelo estacao)
    {
        String query = "DELETE FROM estacao WHERE pk_estacao = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, estacao.getPk_estacao());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean estacaoNaoExiste ()
    {
        String query = "SELECT pk_estacao FROM estacao WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, estacao.getNome());
            
            ResultSet resultados = preparedStatement.executeQuery();
            
            resultados.next ();
            
            return (resultados.getInt(1) == 0);
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }
        
        return true;
    }
    
    public int getIdEstacao( String nome )
    {
        try
        {
            
            String query = "SELECT pk_estacao FROM estacao WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (estacao == null)
                estacao = new EstacaoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                estacao.setPk_estacao(resultados.getInt(1) );
            }
            
            return estacao.getPk_estacao();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getNome( int codigo )
    {
        try
        {
            
            String query = "SELECT nome FROM estacao WHERE pk_estacao = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (estacao == null)
                estacao = new EstacaoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                //estacao.setNome(resultados.getString(1) );
            }
            
            return estacao.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }   
    
}
