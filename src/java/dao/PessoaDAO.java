/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.PessoaModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class PessoaDAO 
{
 
    private PessoaModelo pessoa;
    private PreparedStatement preparedStatement;

    public PessoaDAO() { }

    public PessoaDAO(PessoaModelo pessoa)
    {
        this.pessoa = pessoa;
    }
      
    public ArrayList<PessoaModelo> listar()
    {
        ArrayList<PessoaModelo> lista = new ArrayList<PessoaModelo>();
        
        String query ="SELECT * FROM pessoa";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                           
            preparedStatement.setDate(8, new Date( pessoa.getDataNascimento().getTimeInMillis()));
            preparedStatement.setDate(9, new Date( pessoa.getDataCriacao().getTimeInMillis()));

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {    
                pessoa.setPk_pessoa(rs.getInt(1));
                pessoa.setSexo(
                        new SexoDAO().getByID(rs.getInt(2))
                );
                pessoa.setEstadoCivil(
                        new EstadoCivilDAO().getByID(rs.getInt(3))
                );
                pessoa.setEndereco(
                        new EnderecoDAO().getByID(rs.getInt(4))
                );
                pessoa.setNome(rs.getString(5));
                pessoa.setSobrenome(rs.getString(6));
                pessoa.setTelefone(rs.getString(7));
                
                lista.add(pessoa);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public PessoaModelo getByID(int id)
    {
        
        String query ="SELECT * FROM pessoa WHERE pk_pessoa = " + id;
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            preparedStatement.setDate(8, new Date( pessoa.getDataNascimento().getTimeInMillis()));
            preparedStatement.setDate(9, new Date( pessoa.getDataCriacao().getTimeInMillis()));

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {    
                pessoa.setPk_pessoa(rs.getInt(1));
                pessoa.setSexo(
                        new SexoDAO().getByID(rs.getInt(2))
                );
                pessoa.setEstadoCivil(
                        new EstadoCivilDAO().getByID(rs.getInt(3))
                );
                pessoa.setEndereco(
                        new EnderecoDAO().getByID(rs.getInt(4))
                );
                pessoa.setNome(rs.getString(5));
                pessoa.setSobrenome(rs.getString(6));
                pessoa.setTelefone(rs.getString(7));
//                pessoa.setDataNascimento(rs.getDate(8, new Date( pessoa.getDataNascimento().getTimeInMillis())));
//                pessoa.setDataCriacao(rs.getDate(8, new Date( pessoa.getDataCriacao().getTimeInMillis()));
            }

            Conexao.fecharConexao();
        
            return pessoa;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(PessoaModelo pessoa)
    {
        if ( pessoaNaoExiste())
        {
            String query = "INSERT INTO pessoa(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, pessoa.getNome());

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
     
    public Boolean editar(PessoaModelo pessoa)
    {
        String query = "UPDATE pessoa SET nome = ? WHERE pk_pessoa = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setInt(2, pessoa.getPk_pessoa());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (PessoaModelo pessoa)
    {
        String query = "DELETE FROM pessoa WHERE pk_pessoa = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, pessoa.getPk_pessoa());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    }
    
    public boolean pessoaNaoExiste ()
    {
        String query = "SELECT pk_pessoa FROM pessoa WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, pessoa.getNome());
            
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
            
            String query = "SELECT pk_pessoa FROM pessoa WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (pessoa == null)
                pessoa = new PessoaModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getInt(1) != 0)
            {
                pessoa.setPk_pessoa(rs.getInt(1) );
            }
            
            return pessoa.getPk_pessoa();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getNomeCompleto( int codigo )
    {
        String nome = null;
        
        try
        {
            
            String query = "SELECT nome, sobrenome FROM pessoa WHERE pk_pessoa = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (pessoa == null)
                pessoa = new PessoaModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next ();
            if (rs.getString(1) != null)
            {
                pessoa.setNome(rs.getString(1) );
            }
            
            rs.next ();
            if (rs.getString(2) != null)
            {
                pessoa.setSobrenome(rs.getString(2));
            }
            
            return pessoa.getNome() + " " + pessoa.getSobrenome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }
}
