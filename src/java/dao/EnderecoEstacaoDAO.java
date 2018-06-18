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
import modelo.EnderecoEstacaoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class EnderecoEstacaoDAO {
    
    private EnderecoEstacaoModelo enderecoestacao;
    private PreparedStatement preparedStatement;

    public EnderecoEstacaoDAO() { }

    public EnderecoEstacaoDAO(EnderecoEstacaoModelo enderecoestacao)
    {
        this.enderecoestacao = enderecoestacao;
    }
      
    public ArrayList<EnderecoEstacaoModelo> listar()
    {
        ArrayList<EnderecoEstacaoModelo> lista = new ArrayList<EnderecoEstacaoModelo>();
        EnderecoEstacaoModelo enderecoestacao;
        
        String query ="SELECT pk_enderecoestacao, fk_municipio, cidade, numero FROM enderecoestacao";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                enderecoestacao = new EnderecoEstacaoModelo();
    
                enderecoestacao.setPk_enderecoestacao(rs.getInt("pk_enderecoestacao"));
                enderecoestacao.setMunicipio(
                    new MunicipioDAO().getByID(rs.getInt("fk_municipio"))                        
                );
                enderecoestacao.setCidade(rs.getString("cidade"));
                enderecoestacao.setNumero(rs.getString("numero"));
                
                lista.add(enderecoestacao);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public EnderecoEstacaoModelo getByID(int id)
    {
        
        String query ="SELECT * FROM enderecoestacao WHERE pk_enderecoestacao = " + id;
        
        try
        {

            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {  
                enderecoestacao = new EnderecoEstacaoModelo();

                enderecoestacao.setPk_enderecoestacao(rs.getInt(1));
                enderecoestacao.setMunicipio(
                    new MunicipioDAO().getByID(rs.getInt(2))                        
                );
                enderecoestacao.setCidade(rs.getString(3));
                enderecoestacao.setNumero(rs.getString(4));
            }
                
            Conexao.fecharConexao();
        
            return enderecoestacao;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(EnderecoEstacaoModelo enderecoestacao)
    {
//        if ( enderecoestacaoNaoExiste())
//        {
            String query = "INSERT INTO enderecoestacao(fk_municipio, cidade, numero) VALUES(?, ?, ?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setInt(1, enderecoestacao.getMunicipio().getPk_municipio());
                preparedStatement.setString(2, enderecoestacao.getCidade());
                preparedStatement.setString(3, enderecoestacao.getNumero());

                preparedStatement.execute();
                
                Conexao.fecharConexao();
                return true;
            }

            catch (SQLException excepcao)
            {
                System.out.println("Erro de SQL: " + excepcao.getMessage());
            }
//        }
        
        return false;
    
    }
     
    public Boolean editar(EnderecoEstacaoModelo enderecoestacao)
    {
        String query = "UPDATE enderecoestacao SET fk_municipio = ?, cidade = ?"
                     + ", rua = ?, numerocasa = ?, WHERE pk_enderecoestacao = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, enderecoestacao.getMunicipio().getPk_municipio());
            preparedStatement.setString(2, enderecoestacao.getCidade());
            preparedStatement.setString(3, enderecoestacao.getNumero());
            preparedStatement.setInt(5, enderecoestacao.getPk_enderecoestacao());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (EnderecoEstacaoModelo enderecoestacao)
    {
        String query = "DELETE FROM enderecoestacao WHERE pk_enderecoestacao = ?"; 

        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, enderecoestacao.getPk_enderecoestacao());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean enderecoestacaoNaoExiste ()
    {
        String query = "SELECT pk_enderecoestacao FROM enderecoestacao WHERE pk_enderecoestacao = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, enderecoestacao.getPk_enderecoestacao());
            
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
    
    public int getIdEnderecoEstacao( EnderecoEstacaoModelo endereco)
    {
        try
        {
            
            String query = "SELECT pk_enderecoestacao FROM enderecoestacao WHERE fk_municipio = ? AND cidade = ? AND numero = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
                        
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, endereco.getMunicipio().getPk_municipio());
            preparedStatement.setString(2, endereco.getCidade());
            preparedStatement.setString(3, endereco.getNumero());
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();            
            
            enderecoestacao = new EnderecoEstacaoModelo();
            
            if (rs.getInt(1) != 0)
            {
                enderecoestacao.setPk_enderecoestacao(rs.getInt(1) );
            }
            
            return enderecoestacao.getPk_enderecoestacao();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getCidade( int codigo )
    {
        try
        {
            
            String query = "SELECT nome FROM enderecoestacao WHERE pk_enderecoestacao = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (enderecoestacao == null)
                enderecoestacao = new EnderecoEstacaoModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getString(1) != null)
            {
                enderecoestacao.setCidade(rs.getString(1) );
            }
            
            return enderecoestacao.getCidade();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    } 
}
