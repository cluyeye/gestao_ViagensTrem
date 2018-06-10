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
import modelo.EngenheiroModelo;
import modelo.PessoaModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class EngenheiroDAO 
{
    private EngenheiroModelo engenheiro;
    private PessoaModelo pessoa;

    
    private PreparedStatement preparedStatement;

    public EngenheiroDAO() { }

    public EngenheiroDAO(EngenheiroModelo engenheiro)
    {
        this.engenheiro = engenheiro;
    }
      
    public ArrayList<EngenheiroModelo> listar()
    {
        ArrayList<EngenheiroModelo> lista = new ArrayList<EngenheiroModelo>();
        
        String query ="SELECT pk_engenheiro, fk_pessoa FROM engenheiro";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                engenheiro = new EngenheiroModelo();
        
                engenheiro.setPk_engenheiro(rs.getInt("pk_engenheiro"));
                engenheiro.setPessoa(
                    new PessoaDAO().getByID(rs.getInt("fk_pessoa"))                        
                );
                
                JOptionPane.showMessageDialog(null, engenheiro.toString());
                lista.add(engenheiro);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public EngenheiroModelo getByID(int id)
    {
        
        String query ="SELECT * FROM engenheiro WHERE pk_engenheiro = " + id;
        
        try
        {

//            preparedStatement = Conexao.conexao.prepareStatement(query);
//            preparedStatement.setInt(1, engenheiro.getPk_engenheiro());
//                        
//            
//
//            ResultSet rs = preparedStatement.executeQuery();
            
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                engenheiro = new EngenheiroModelo();
                
                engenheiro.setPk_engenheiro(rs.getInt(1));
                engenheiro.setPessoa(
                    new PessoaDAO().getByID(rs.getInt(2))                        
                );
            }
         
            Conexao.fecharConexao();
        
            return engenheiro;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(EngenheiroModelo engenheiro)
    {
        if ( engenheiroNaoExiste())
        {
            String query = "INSERT INTO engenheiro(fk_pessoa) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setInt(1, engenheiro.getPessoa().getPk_pessoa());

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
     
    public Boolean editar(EngenheiroModelo engenheiro)
    {
        String query = "UPDATE engenheiro SET fk_pessoa = ? WHERE pk_engenheiro = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, engenheiro.getPessoa().getPk_pessoa());
            preparedStatement.setInt(2, engenheiro.getPk_engenheiro());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (EngenheiroModelo engenheiro)
    {
        String query = "DELETE FROM engenheiro WHERE pk_engenheiro = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, engenheiro.getPk_engenheiro());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    }
    
    public boolean engenheiroNaoExiste ()
    {
        String query = "SELECT pk_engenheiro FROM engenheiro WHERE fk_pessoa = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, engenheiro.getPessoa().getPk_pessoa());
            
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
            
            String query = "SELECT pk_engenheiro FROM engenheiro WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (engenheiro == null)
                engenheiro = new EngenheiroModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getInt(1) != 0)
            {
                engenheiro.setPk_engenheiro(rs.getInt(1) );
            }
            
            return engenheiro.getPk_engenheiro();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getNomeCompleto( int codigo )
    {
        try
        {
            
            String query = "SELECT fk_pessoa FROM engenheiro WHERE pk_engenheiro = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (engenheiro == null)
                engenheiro = new EngenheiroModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet rs = preparedStatement.executeQuery();
            rs.next ();
            
            
            if (rs.getString(1) != null)
            {
                return new PessoaDAO().getNomeCompleto(rs.getInt(""));
            }
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }
    
}
