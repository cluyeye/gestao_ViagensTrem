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
import modelo.TipoEstacaoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class TipoEstacaoDAO 
{
    private TipoEstacaoModelo tipoestacao;
    private PreparedStatement preparedStatement;

    public TipoEstacaoDAO() { }

    public TipoEstacaoDAO(TipoEstacaoModelo tipoestacao)
    {
        this.tipoestacao = tipoestacao;
    }
      
    public ArrayList<TipoEstacaoModelo> listar()
    {
        ArrayList<TipoEstacaoModelo> lista = new ArrayList<TipoEstacaoModelo>();
        TipoEstacaoModelo tipoestacao;
        
        String query ="SELECT * FROM tipoestacao";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            tipoestacao = new TipoEstacaoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                tipoestacao.setPk_tipoestacao(rs.getInt("pk_tipoestacao"));
                tipoestacao.setNome(rs.getString("nome"));
                lista.add(tipoestacao);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public TipoEstacaoModelo getByID(int id)
    {
        
        String query ="SELECT * FROM tipoestacao WHERE pk_tipoestacao = ?";
        
        try
        {
            tipoestacao.setPk_tipoestacao(id);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tipoestacao.getPk_tipoestacao());
                        
            tipoestacao = new TipoEstacaoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            tipoestacao.setPk_tipoestacao(rs.getInt("pk_tipoestacao"));
            tipoestacao.setNome(rs.getString("nome"));
         
            Conexao.fecharConexao();
        
            return tipoestacao;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(TipoEstacaoModelo tipoestacao)
    {
        if ( tipoestacaoNaoExiste())
        {
            String query = "INSERT INTO tipoestacao(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, tipoestacao.getNome());

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
     
    public Boolean editar(TipoEstacaoModelo tipoestacao)
    {
        String query = "UPDATE tipoestacao SET nome = ? WHERE pk_tipoestacao = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipoestacao.getNome());
            preparedStatement.setInt(2, tipoestacao.getPk_tipoestacao());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (TipoEstacaoModelo tipoestacao)
    {
        String query = "DELETE FROM tipoestacao WHERE pk_tipoestacao = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tipoestacao.getPk_tipoestacao());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean tipoestacaoNaoExiste ()
    {
        String query = "SELECT pk_tipoestacao FROM tipoestacao WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipoestacao.getNome());
            
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
    
    public int getIdTipoestacao( String nome )
    {
        try
        {
            
            String query = "SELECT pk_tipoestacao FROM tipoestacao WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipoestacao == null)
                tipoestacao = new TipoEstacaoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                tipoestacao.setPk_tipoestacao(resultados.getInt(1) );
            }
            
            return tipoestacao.getPk_tipoestacao();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getDesignacao( int codigo )
    {
        try
        {
            
            String query = "SELECT nome FROM tipoestacao WHERE pk_tipoestacao = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipoestacao == null)
                tipoestacao = new TipoEstacaoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                tipoestacao.setNome(resultados.getString(1) );
            }
            
            return tipoestacao.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }    
}
