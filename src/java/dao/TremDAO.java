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
import modelo.TremModelo;
import util.Conexao;

/**
 *
 * @author coxe
 */
public class TremDAO 
{
 private TremModelo trem;
    private PreparedStatement preparedStatement;

    public TremDAO() { }

    public TremDAO(TremModelo trem)
    {
        this.trem = trem;
    }
      
    public ArrayList<TremModelo> listar()
    {
        ArrayList<TremModelo> lista = new ArrayList<TremModelo>();
        
        String query ="SELECT pk_trem, matricula, fk_engenheiro, fk_tipotrem FROM trem";
        
        try
        {
            if(Conexao.conexao == null) Conexao.getConexao();

            preparedStatement = Conexao.conexao.prepareStatement(query);
                        
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next())
            {
                trem = new TremModelo();
                
                trem.setPk_trem(rs.getInt(1));
                trem.setMatricula(rs.getString(2));
                trem.setEngenheiro(
                        new EngenheiroDAO().getByID(rs.getInt(3))                        
                );
                trem.setTipoTrem(
                        new TipoTremDAO().getByID(rs.getInt(4))                        
                );
                                
                lista.add(trem);
            }
    
            return lista;

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
      
    public TremModelo getByID(int id)
    {
        
        String query ="SELECT * FROM trem WHERE pk_trem = ?";
        
        try
        {
            trem.setPk_trem(id);

            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, trem.getPk_trem());
                        
            trem = new TremModelo();

            ResultSet rs = preparedStatement.executeQuery();
            
            trem.setPk_trem(rs.getInt("pk_trem"));
            trem.setMatricula(rs.getString("matricula"));
            trem.setTipoTrem(
                    new TipoTremDAO().getByID(rs.getInt("fk_tipotrem"))                        
            );
            trem.setEngenheiro(
                    new EngenheiroDAO().getByID(rs.getInt("fk_engenheiro"))                        
            );
         
            Conexao.fecharConexao();
        
            return trem;
        
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
        return null;
    
    }
    
     
    public Boolean inserir(TremModelo trem)
    {
//        if ( tremNaoExiste(trem))
//        {
            String query = "INSERT INTO trem(matricula, fk_engenheiro, fk_tipotrem) VALUES(?, ?, ?)";

            try
            {
                if (Conexao.conexao == null)
                    Conexao.getConexao ();

                preparedStatement = Conexao.conexao.prepareStatement(query);                
                preparedStatement.setString(1, trem.getMatricula());
                preparedStatement.setInt(2, trem.getEngenheiro().getPk_engenheiro());
                preparedStatement.setInt(3, trem.getTipoTrem().getPk_tipotrem());
                
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
     
    public Boolean editar(TremModelo trem)
    {
        String query = "UPDATE trem SET matricula = ?, fk_tipotrem = ?, fk_engenheiro = ? WHERE pk_trem = ?"; 

        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();

            System.out.printf(query, null);
            JOptionPane.showMessageDialog(null, query);

            preparedStatement = Conexao.conexao.prepareStatement(query);                
            preparedStatement.setString(1, trem.getMatricula());
            preparedStatement.setInt(2, trem.getTipoTrem().getPk_tipotrem());
            preparedStatement.setInt(3, trem.getEngenheiro().getPk_engenheiro());
            preparedStatement.setInt(4, trem.getPk_trem());

            preparedStatement.execute();

            Conexao.fecharConexao();

            return true;         
        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        return false;
    
    }
     
    public void eliminar (TremModelo trem)
    {
        String query = "DELETE FROM trem WHERE pk_trem = ?"; 
        
        try
        {      
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setInt(1, trem.getPk_trem());

            preparedStatement.execute();        }
        catch(Exception e) {
            e.printStackTrace();        
        }
        
        Conexao.fecharConexao();
    
    }
    
    public boolean tremNaoExiste (TremModelo trem)
    {
        String query = "SELECT pk_trem FROM trem WHERE pk_en = ";
        
        try
        {
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            //preparedStatement.setString(1, trem.getNome());
            
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
    
    public int getIdTrem( String nome )
    {
        try
        {
            
            String query = "SELECT pk_trem FROM trem WHERE matricula = ?";
            
            
            if (Conexao.conexao == null)
                Conexao.getConexao ();
            
            if (trem == null)
                trem = new TremModelo ();
            
            preparedStatement = Conexao.conexao.prepareStatement(query);
            preparedStatement.setString(1, nome);
            
            ResultSet resultados = preparedStatement.executeQuery();
            resultados.next ();
            
            
            if (resultados.getInt(1) != 0)
            {
                trem.setPk_trem(resultados.getInt(1) );
            }
            
            return trem.getPk_trem();
        }
        
        catch (SQLException excepcao)
        {
            System.out.println("Erro de SQL: " + excepcao.getMessage());
        }

        return -1;
    }
    
    public String getDesignacao( int codigo )
    {
//        try
//        {
//            
//            String query = "SELECT nome FROM trem WHERE pk_trem = ?";
//            
//            
//            if (Conexao.conexao == null)
//                Conexao.getConexao ();
//            
//            if (trem == null)
//                trem = new TremModelo ();
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
//                //trem.setNome(resultados.getString(1) );
//            }
//            
//            return trem.getNome();
//        }
//        
//        catch (SQLException excepcao)
//        {
//            System.out.println("Erro de SQL: " + excepcao.getMessage());
//        }

        return null;
    }   
}
