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
import modelo.EnderecoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class EnderecoDAO 
{
    
    private EnderecoModelo endereco;
    private PreparedStatement preparedStatement;

    public EnderecoDAO() { }

    public EnderecoDAO(EnderecoModelo endereco)
    {
        this.endereco = endereco;
    }
      
    public ArrayList<EnderecoModelo> listar()
    {
        ArrayList<EnderecoModelo> lista = new ArrayList<EnderecoModelo>();
        EnderecoModelo endereco;
        
        String query ="SELECT * FROM endereco";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            endereco = new EnderecoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                endereco.setPk_endereco(rs.getInt("pk_endereco"));
                endereco.setMunicipio(
                    new MunicipioDAO().getByID(rs.getInt("fk_municipio"))                        
                );
                endereco.setBairro(rs.getString("bairro"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumeroCasa(rs.getString("numeroCasa"));
                
                lista.add(endereco);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public EnderecoModelo getByID(int id)
    {
        
        String query ="SELECT * FROM endereco WHERE pk_endereco = ?";
        
        try
        {

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, endereco.getPk_endereco());
                        
            endereco = new EnderecoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            endereco.setPk_endereco(rs.getInt("pk_endereco"));
            endereco.setMunicipio(
                new MunicipioDAO().getByID(rs.getInt("fk_municipio"))                        
            );
            endereco.setBairro(rs.getString("bairro"));
            endereco.setRua(rs.getString("rua"));
            endereco.setNumeroCasa(rs.getString("numeroCasa"));
                
            Conexao.fecharConexao();
        
            return endereco;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(EnderecoModelo endereco)
    {
        if ( enderecoNaoExiste())
        {
            String query = "INSERT INTO endereco(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setInt(1, endereco.getMunicipio().getPk_municipio());
                preparedStatement.setString(2, endereco.getBairro());
                preparedStatement.setString(3, endereco.getRua());
                preparedStatement.setString(4, endereco.getNumeroCasa());

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
     
    public Boolean editar(EnderecoModelo endereco)
    {
        String query = "UPDATE endereco SET fk_municipio = ?, bairro = ?"
                     + ", rua = ?, numerocasa = ?, WHERE pk_endereco = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, endereco.getMunicipio().getPk_municipio());
            preparedStatement.setString(2, endereco.getBairro());
            preparedStatement.setString(3, endereco.getRua());
            preparedStatement.setString(4, endereco.getNumeroCasa());
            preparedStatement.setInt(5, endereco.getPk_endereco());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (EnderecoModelo endereco)
    {
        String query = "DELETE FROM endereco WHERE pk_endereco = ?"; 
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, endereco.getPk_endereco());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean enderecoNaoExiste ()
    {
        String query = "SELECT pk_endereco FROM endereco WHERE pk_endereco = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, endereco.getPk_endereco());
            
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
    
    public int getIdEndereco( String nome )
    {
        try
        {
            
            String query = "SELECT pk_endereco FROM endereco WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (endereco == null)
                endereco = new EnderecoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getInt(1) != 0)
            {
                endereco.setPk_endereco(rs.getInt(1) );
            }
            
            return endereco.getPk_endereco();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getBairro( int codigo )
    {
        try
        {
            
            String query = "SELECT nome FROM endereco WHERE pk_endereco = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (endereco == null)
                endereco = new EnderecoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getString(1) != null)
            {
                endereco.setBairro(rs.getString(1) );
            }
            
            return endereco.getBairro();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    } 
    
}
