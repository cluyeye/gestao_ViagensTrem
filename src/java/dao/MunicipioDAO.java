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
import modelo.MunicipioModelo;
import dao.ProvinciaDAO;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class MunicipioDAO 
{
    private MunicipioModelo municipio;
    private PreparedStatement preparedStatement;

    public MunicipioDAO() { }

    public MunicipioDAO(MunicipioModelo municipio)
    {
        this.municipio = municipio;
    }
      
    public ArrayList<MunicipioModelo> listar()
    {
        ArrayList<MunicipioModelo> lista = new ArrayList<MunicipioModelo>();
        
        String query ="SELECT * FROM municipio";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                municipio = new MunicipioModelo();
                
                municipio.setPk_municipio(rs.getInt("pk_municipio"));
                municipio.setProvincia(
                    new ProvinciaDAO().getByID(rs.getInt("fk_provincia"))                        
                );
                municipio.setNome(rs.getString("nome"));
                lista.add(municipio);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public MunicipioModelo getByID(int id)
    {
        
        String query ="SELECT * FROM municipio WHERE pk_municipio = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                municipio = new MunicipioModelo();
                
                municipio.setPk_municipio(rs.getInt(1));
                municipio.setProvincia(
                   new ProvinciaDAO().getByID(rs.getInt(2))                        
                );
                municipio.setNome(rs.getString(3));               
            }
                        
            Conexao.fecharConexao();
        
            return municipio;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(MunicipioModelo municipio)
    {
        if ( municipioNaoExiste())
        {
            String query = "INSERT INTO municipio(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, municipio.getNome());

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
     
    public Boolean editar(MunicipioModelo municipio)
    {
        String query = "UPDATE municipio SET nome = ? WHERE pk_municipio = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, municipio.getNome());
            preparedStatement.setInt(2, municipio.getPk_municipio());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (MunicipioModelo municipio)
    {
        String query = "DELETE FROM municipio WHERE pk_municipio = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, municipio.getPk_municipio());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean municipioNaoExiste ()
    {
        String query = "SELECT pk_municipio FROM municipio WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, municipio.getNome());
            
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
    
    public int getIdMunicipio( String nome )
    {
        try
        {
            
            String query = "SELECT pk_municipio FROM municipio WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (municipio == null)
                municipio = new MunicipioModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                municipio.setPk_municipio(resultados.getInt(1) );
            }
            
            return municipio.getPk_municipio();
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
            
            String query = "SELECT nome FROM municipio WHERE pk_municipio = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (municipio == null)
                municipio = new MunicipioModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                municipio.setNome(resultados.getString(1) );
            }
            
            return municipio.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }
    
}
