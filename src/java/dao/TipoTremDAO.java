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
import modelo.TipoTremModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class TipoTremDAO 
{
    private TipoTremModelo tipotrem;
    private PreparedStatement preparedStatement;

    public TipoTremDAO() { }

    public TipoTremDAO(TipoTremModelo tipotrem)
    {
        this.tipotrem = tipotrem;
    }
      
    public ArrayList<TipoTremModelo> listar()
    {
        ArrayList<TipoTremModelo> lista = new ArrayList<TipoTremModelo>();
        
        String query ="SELECT * FROM tipotrem";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {   
                tipotrem = new TipoTremModelo();
                
                tipotrem.setPk_tipotrem(rs.getInt("pk_tipotrem"));
                tipotrem.setNome(rs.getString("nome"));
                lista.add(tipotrem);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public TipoTremModelo getByID(int id)
    {
        
        String query ="SELECT * FROM tipotrem WHERE pk_tipotrem = " + id + "";
        
//            JOptionPane.showMessageDialog(null, query);
        
        try
        {                       
            
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);                        
        
            ResultSet rs = preparedStatement.executeQuery();

            tipotrem = new TipoTremModelo();

            tipotrem = new TipoTremModelo();

            while(rs.next())
            {
                tipotrem.setPk_tipotrem(rs.getInt(1));
                tipotrem.setNome(rs.getString(2));
            }
         
//            JOptionPane.showMessageDialog(null, tipotrem.toString());
                    
            return tipotrem;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(TipoTremModelo tipotrem)
    {
        if ( tipotremNaoExiste())
        {
            String query = "INSERT INTO tipotrem(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, tipotrem.getNome());

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
     
    public Boolean editar(TipoTremModelo tipotrem)
    {
        String query = "UPDATE tipotrem SET nome = ? WHERE pk_tipotrem = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipotrem.getNome());
            preparedStatement.setInt(2, tipotrem.getPk_tipotrem());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (TipoTremModelo tipotrem)
    {
        String query = "DELETE FROM tipotrem WHERE pk_tipotrem = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tipotrem.getPk_tipotrem());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean tipotremNaoExiste ()
    {
        String query = "SELECT pk_tipotrem FROM tipotrem WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipotrem.getNome());
            
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
    
    public int getIdTipotrem( String nome )
    {
        try
        {
            
            String query = "SELECT pk_tipotrem FROM tipotrem WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipotrem == null)
                tipotrem = new TipoTremModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                tipotrem.setPk_tipotrem(resultados.getInt(1) );
            }
            
            return tipotrem.getPk_tipotrem();
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
            
            String query = "SELECT nome FROM tipotrem WHERE pk_tipotrem = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipotrem == null)
                tipotrem = new TipoTremModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                tipotrem.setNome(resultados.getString(1) );
            }
            
            return tipotrem.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }
}
