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
import modelo.PaisModelo;
import modelo.ProvinciaModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class ProvinciaDAO 
{
    private ProvinciaModelo provincia;
    private PreparedStatement preparedStatement;

    public ProvinciaDAO() { }

    public ProvinciaDAO(ProvinciaModelo provincia)
    {
        this.provincia = provincia;
    }
      
    public ArrayList<ProvinciaModelo> listar()
    {
        ArrayList<ProvinciaModelo> lista = new ArrayList<ProvinciaModelo>();
        
        String query ="SELECT * FROM provincia";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                provincia = new ProvinciaModelo();
                
                provincia.setPk_provincia(rs.getInt("pk_provincia"));
                provincia.setPais(
                        new PaisDAO().getByID(rs.getInt("fk_pais"))                        
                );
                provincia.setNome(rs.getString("nome"));
                lista.add(provincia);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public ProvinciaModelo getByID(int id)
    {
        
        String query ="SELECT pk_provincia, fk_pais, nome FROM provincia WHERE pk_provincia = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                provincia = new ProvinciaModelo();
                
                provincia.setPk_provincia(rs.getInt(1));
                provincia.setPais(
                        new PaisDAO().getByID(rs.getInt(2))                        
                );
                provincia.setNome(rs.getString(3));
            }
         
            Conexao.fecharConexao();
        
            return provincia;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(ProvinciaModelo provincia)
    {
        if ( provinciaNaoExiste())
        {
            String query = "INSERT INTO provincia(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, provincia.getNome());

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
     
    public Boolean editar(ProvinciaModelo provincia)
    {
        String query = "UPDATE provincia SET nome = ? WHERE pk_provincia = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, provincia.getNome());
            preparedStatement.setInt(2, provincia.getPk_provincia());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (ProvinciaModelo provincia)
    {
        String query = "DELETE FROM provincia WHERE pk_provincia = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, provincia.getPk_provincia());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean provinciaNaoExiste ()
    {
        String query = "SELECT pk_provincia FROM provincia WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, provincia.getNome());
            
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
    
    public int getIdProvincia( String nome )
    {
        try
        {
            
            String query = "SELECT pk_provincia FROM provincia WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (provincia == null)
                provincia = new ProvinciaModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                provincia.setPk_provincia(resultados.getInt(1) );
            }
            
            return provincia.getPk_provincia();
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
            
            String query = "SELECT nome FROM provincia WHERE pk_provincia = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (provincia == null)
                provincia = new ProvinciaModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                provincia.setNome(resultados.getString(1) );
            }
            
            return provincia.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }    
}
