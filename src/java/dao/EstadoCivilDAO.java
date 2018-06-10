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
import modelo.EstadoCivilModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class EstadoCivilDAO 
{
    private EstadoCivilModelo estadocivil;
    private PreparedStatement preparedStatement;

    public EstadoCivilDAO() { }

    public EstadoCivilDAO(EstadoCivilModelo estadocivil)
    {
        this.estadocivil = estadocivil;
    }
      
    public ArrayList<EstadoCivilModelo> listar()
    {
        ArrayList<EstadoCivilModelo> lista = new ArrayList<EstadoCivilModelo>();
        
        String query ="SELECT * FROM estadocivil";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                estadocivil = new EstadoCivilModelo();
                
                estadocivil.setPk_estadocivil(rs.getInt("pk_estadocivil"));
                estadocivil.setNome(rs.getString("nome"));
                lista.add(estadocivil);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public EstadoCivilModelo getByID(int id)
    {
        
        String query ="SELECT * FROM estadocivil WHERE pk_estadocivil = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {  
                estadocivil = new EstadoCivilModelo();       
                
                estadocivil.setPk_estadocivil(rs.getInt(1));
                estadocivil.setNome(rs.getString(2));
            }
         
            Conexao.fecharConexao();
        
            return estadocivil;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(EstadoCivilModelo estadocivil)
    {
        if ( estadocivilNaoExiste())
        {
            String query = "INSERT INTO estadocivil(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, estadocivil.getNome());

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
     
    public Boolean editar(EstadoCivilModelo estadocivil)
    {
        String query = "UPDATE estadocivil SET nome = ? WHERE pk_estadocivil = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, estadocivil.getNome());
            preparedStatement.setInt(2, estadocivil.getPk_estadocivil());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (EstadoCivilModelo estadocivil)
    {
        String query = "DELETE FROM estadocivil WHERE pk_estadocivil = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, estadocivil.getPk_estadocivil());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean estadocivilNaoExiste ()
    {
        String query = "SELECT pk_estadocivil FROM estadocivil WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, estadocivil.getNome());
            
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next ();
            
            return (rs.getInt(1) == 0);
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }
        
        return true;
    }
    
    public int getIdEstadocivil( String nome )
    {
        try
        {
            
            String query = "SELECT pk_estadocivil FROM estadocivil WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (estadocivil == null)
                estadocivil = new EstadoCivilModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getInt(1) != 0)
            {
                estadocivil.setPk_estadocivil(rs.getInt(1) );
            }
            
            return estadocivil.getPk_estadocivil();
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
            
            String query = "SELECT nome FROM estadocivil WHERE pk_estadocivil = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (estadocivil == null)
                estadocivil = new EstadoCivilModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getString(1) != null)
            {
                estadocivil.setNome(rs.getString(1) );
            }
            
            return estadocivil.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    } 
    
}
