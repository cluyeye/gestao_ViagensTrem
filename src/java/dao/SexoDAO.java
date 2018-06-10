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
import modelo.SexoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class SexoDAO 
{
    private SexoModelo sexo;
    private PreparedStatement preparedStatement;

    public SexoDAO() { }

    public SexoDAO(SexoModelo sexo)
    {
        this.sexo = sexo;
    }
      
    public ArrayList<SexoModelo> listar()
    {
        ArrayList<SexoModelo> lista = new ArrayList<SexoModelo>();
        
        String query ="SELECT * FROM sexo";
        
        try
        {
            
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                sexo = new SexoModelo();
                
                sexo.setPk_sexo(rs.getInt(1));
                sexo.setNome(rs.getString(2));
                lista.add(sexo);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public SexoModelo getByID(int id)
    {
        
        String query ="SELECT * FROM sexo WHERE pk_sexo = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();
        
            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                sexo = new SexoModelo();

                sexo.setPk_sexo(rs.getInt(1));
                sexo.setNome(rs.getString(2));
            }  
         
            Conexao.fecharConexao();
        
            return sexo;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(SexoModelo sexo)
    {
        if ( sexoNaoExiste())
        {
            String query = "INSERT INTO sexo(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, sexo.getNome());

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
     
    public Boolean editar(SexoModelo sexo)
    {
        String query = "UPDATE sexo SET nome = ? WHERE pk_sexo = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, sexo.getNome());
            preparedStatement.setInt(2, sexo.getPk_sexo());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (SexoModelo sexo)
    {
        String query = "DELETE FROM sexo WHERE pk_sexo = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, sexo.getPk_sexo());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean sexoNaoExiste ()
    {
        String query = "SELECT pk_sexo FROM sexo WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, sexo.getNome());
            
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
            
            String query = "SELECT pk_sexo FROM sexo WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (sexo == null)
                sexo = new SexoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                sexo.setPk_sexo(resultados.getInt(1) );
            }
            
            return sexo.getPk_sexo();
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
            
            String query = "SELECT nome FROM sexo WHERE pk_sexo = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (sexo == null)
                sexo = new SexoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                sexo.setNome(resultados.getString(1) );
            }
            
            return sexo.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }    
}
