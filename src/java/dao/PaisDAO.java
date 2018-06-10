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
import util.Conexao;

/**
 *
 * @author coxe
 */
public class PaisDAO 
{
    private PaisModelo pais;
    private PreparedStatement preparedStatement;

    public PaisDAO() { }

    public PaisDAO(PaisModelo pais)
    {
        this.pais = pais;
    }
      
    public ArrayList<PaisModelo> listar()
    {
        ArrayList<PaisModelo> lista = new ArrayList<PaisModelo>();
        
        String query ="SELECT * FROM pais";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                pais = new PaisModelo();

                pais.setPk_pais(rs.getInt(1));
                pais.setNome(rs.getString(2));                
                                
                lista.add(pais);
            }

            return lista;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;    
    }
      
    public PaisModelo getByID(int id)
    {
        
        String query ="SELECT * FROM pais WHERE pk_pais = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                pais = new PaisModelo();

                pais.setPk_pais(rs.getInt(1));
                pais.setNome(rs.getString(2));                
            }
            
            Conexao.fecharConexao();
        
            return pais;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(PaisModelo pais)
    {
        if ( paisNaoExiste())
        {
            String query = "INSERT INTO pais(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, pais.getNome());

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
     
    public Boolean editar(PaisModelo pais)
    {
        String query = "UPDATE pais SET nome = ? WHERE pk_pais = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.setInt(2, pais.getPk_pais());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (PaisModelo pais)
    {
        String query = "DELETE FROM pais WHERE pk_pais = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, pais.getPk_pais());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean paisNaoExiste ()
    {
        String query = "SELECT pk_pais FROM pais WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, pais.getNome());
            
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
    
    public int getIdPais( String nome )
    {
        try
        {
            
            String query = "SELECT pk_pais FROM pais WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (pais == null)
                pais = new PaisModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                pais.setPk_pais(resultados.getInt(1) );
            }
            
            return pais.getPk_pais();
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
            
            String query = "SELECT nome FROM pais WHERE pk_pais = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (pais == null)
                pais = new PaisModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                pais.setNome(resultados.getString(1) );
            }
            
            return pais.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }
}
