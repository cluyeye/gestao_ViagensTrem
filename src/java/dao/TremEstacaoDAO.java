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
import java.util.Calendar;
import javax.swing.JOptionPane;
import modelo.TremEstacaoModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class TremEstacaoDAO 
{
    private TremEstacaoModelo tremestacao;
    private PreparedStatement preparedStatement;

    public TremEstacaoDAO() { }

    public TremEstacaoDAO(TremEstacaoModelo tremestacao)
    {
        this.tremestacao = tremestacao;
    }
      
    public ArrayList<TremEstacaoModelo> listar()
    {
        ArrayList<TremEstacaoModelo> lista = new ArrayList<TremEstacaoModelo>();
        
        String query ="SELECT fk_trem, fk_estacao, fk_tipoviagem, dataviagem, horaviagem FROM tremestacao";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                tremestacao = new TremEstacaoModelo();
                
                tremestacao.setTrem(
                        new TremDAO().getByID(
                        rs.getInt("fk_trem"))
                );
                tremestacao.setEstacao(
                        new EstacaoDAO().getByID(rs.getInt("fk_estacao"))                        
                );
                tremestacao.setTipoViagem(
                        new TipoViagemDAO().getByID(rs.getInt("fk_tipoviagem"))                        
                );
                
                tremestacao.setDataViagem(rs.getString("dataviagem"));
                tremestacao.setHoraViagem(rs.getString("horaviagem"));
                
                lista.add(tremestacao);
            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return lista;
    
    }
      
    public TremEstacaoModelo getByID(TremEstacaoModelo tremestacao)
    {
        
        String query ="SELECT * FROM tremestacao WHERE fk_trem = ? AND fk_estacao = ?";
        
        try
        {
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
//            preparedStatement.setInt(1, tremestacao.getTrem().getPk_trem());
//            preparedStatement.setInt(2, tremestacao.getEstacao().getPk_estacao());
//            preparedStatement.setInt(3, tremestacao.getTipoViagem().getPk_tipoviagem());
//            preparedStatement.setDate(4, tremestacao.getDataViagem(), new Calendar);
//            preparedStatement.setInt(5, tremestacao.getTrem().getPk_trem());
//            preparedStatement.setInt(6, tremestacao.getEstacao().getPk_estacao());
                        
            tremestacao = new TremEstacaoModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            tremestacao.setTrem(
                    new TremDAO().getByID(rs.getInt(1))                        
            );
            tremestacao.setEstacao(
                    new EstacaoDAO().getByID(rs.getInt(2))                        
            );
            tremestacao.setTipoViagem(
                    new TipoViagemDAO().getByID(rs.getInt(3))                        
            );
            
            tremestacao.setDataViagem(rs.getString(4));
            tremestacao.setHoraViagem(rs.getString(5));
         
            Conexao.fecharConexao();
        
            return tremestacao;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }    
     
    public Boolean inserir(TremEstacaoModelo tremestacao)
    {
        if ( tremestacaoNaoExiste())
        {
            String query = "INSERT INTO tremestacao(fk_trem, fk_estacao, fk_tipoviagem, dataviagem, horaviagem) VALUES(?, ?, ?, ?, ?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);    
                preparedStatement.setInt(1, tremestacao.getTrem().getPk_trem());
                preparedStatement.setInt(2, tremestacao.getEstacao().getPk_estacao());            
                preparedStatement.setInt(3, tremestacao.getTipoViagem().getPk_tipoviagem());
                preparedStatement.setString(4, tremestacao.getDataViagem());
                preparedStatement.setString(5, tremestacao.getHoraViagem());                

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
     
    public Boolean editar(TremEstacaoModelo tremestacao)
    {
        String query = "UPDATE tremestacao SET fk_trem = ?, fk_estacao = ? fk_tipoviagem = ?, dataviagem = ? WHERE fk_trem = ? AND estacao = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);                
            preparedStatement.setInt(1, tremestacao.getTrem().getPk_trem());
            preparedStatement.setInt(2, tremestacao.getEstacao().getPk_estacao());
            preparedStatement.setInt(3, tremestacao.getTipoViagem().getPk_tipoviagem());
//            preparedStatement.setInt(4, tremestacao.getDataViagem().toString());
            preparedStatement.setInt(5, tremestacao.getTrem().getPk_trem());
            preparedStatement.setInt(6, tremestacao.getEstacao().getPk_estacao());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (TremEstacaoModelo tremestacao)
    {
        String query = "DELETE FROM tremestacao WHERE fk_trem = ? AND fk_estacao = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tremestacao.getTrem().getPk_trem());
            preparedStatement.setInt(2, tremestacao.getEstacao().getPk_estacao());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean tremestacaoNaoExiste ()
    {
        String query = "SELECT fk_tremestacao FROM tremestacao WHERE fk_trem = ? AND fk_estacao = ?";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, tremestacao.getTrem().getPk_trem());
            preparedStatement.setInt(2, tremestacao.getEstacao().getPk_estacao());
            
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
    
    
    public String getDesignacao( int codigo )
    {
//        try
//        {
//            
//            String query = "SELECT nome FROM tremestacao WHERE fk_tremestacao = ?";
//            
//            
//            if (Conexao.conexao == null)
//                Conexao.getConexao ();
//            
//            if (tremestacao == null)
//                tremestacao = new TremEstacaoModelo ();
//            
//            preparedStatement = Conexao.conexao.prepareStatement(query);
//            preparedStatement.setInt(1, codigo);
//            
//            ResultSet resultados = preparedStatement.executeQuery();
//            resultados.next ();
//            
//            
//            if (resultados.getString(1) != null)
//            {
//                //tremestacao.setNome(resultados.getString(1) );
//            }
//            
//            return tremestacao.getNome();
//        }
//        
//        catch (SQLException excepcao)
//        {
//            System.out.println("Erro de SQL: " + excepcao.getMessage());
//        }

        return null;
    }      
}
