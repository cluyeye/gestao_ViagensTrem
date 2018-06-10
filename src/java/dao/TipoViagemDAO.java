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
import modelo.TipoViagemModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class TipoViagemDAO 
{
    private TipoViagemModelo tipoviagem;
    private PreparedStatement preparedStatement;

    public TipoViagemDAO() { }

    public TipoViagemDAO(TipoViagemModelo tipoviagem)
    {
        this.tipoviagem = tipoviagem;
    }
      
    public ArrayList<TipoViagemModelo> listar()
    {
        ArrayList<TipoViagemModelo> lista = new ArrayList<TipoViagemModelo>();
        
        String query ="SELECT * FROM tipoviagem";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        

            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {            
                tipoviagem = new TipoViagemModelo();
                
                tipoviagem.setPk_tipoviagem(rs.getInt("pk_tipoviagem"));
                tipoviagem.setNome(rs.getString("nome"));
                lista.add(tipoviagem);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public TipoViagemModelo getByID(int id)
    {
        
        String query ="SELECT * FROM tipoviagem WHERE pk_tipoviagem = ?";
        
        try
        {
            tipoviagem.setPk_tipoviagem(id);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tipoviagem.getPk_tipoviagem());
                        
            tipoviagem = new TipoViagemModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            tipoviagem.setPk_tipoviagem(rs.getInt("pk_tipoviagem"));
            tipoviagem.setNome(rs.getString("nome"));
         
            Conexao.fecharConexao();
        
            return tipoviagem;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(TipoViagemModelo tipoviagem)
    {
        if ( tipoviagemNaoExiste())
        {
            String query = "INSERT INTO tipoviagem(nome) VALUES(?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);
                preparedStatement.setString(1, tipoviagem.getNome());

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
     
    public Boolean editar(TipoViagemModelo tipoviagem)
    {
        String query = "UPDATE tipoviagem SET nome = ? WHERE pk_tipoviagem = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipoviagem.getNome());
            preparedStatement.setInt(2, tipoviagem.getPk_tipoviagem());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (TipoViagemModelo tipoviagem)
    {
        String query = "DELETE FROM tipoviagem WHERE pk_tipoviagem = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tipoviagem.getPk_tipoviagem());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean tipoviagemNaoExiste ()
    {
        String query = "SELECT pk_tipoviagem FROM tipoviagem WHERE nome = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, tipoviagem.getNome());
            
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
    
    public int getIdTipoviagem( String nome )
    {
        try
        {
            
            String query = "SELECT pk_tipoviagem FROM tipoviagem WHERE nome = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipoviagem == null)
                tipoviagem = new TipoViagemModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                tipoviagem.setPk_tipoviagem(resultados.getInt(1) );
            }
            
            return tipoviagem.getPk_tipoviagem();
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
            
            String query = "SELECT nome FROM tipoviagem WHERE pk_tipoviagem = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (tipoviagem == null)
                tipoviagem = new TipoViagemModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, codigo);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getString(1) != null)
            {
                tipoviagem.setNome(resultados.getString(1) );
            }
            
            return tipoviagem.getNome();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return null;
    }    

    
}
