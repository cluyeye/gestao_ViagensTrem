/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.sql.*;

/**
 *
 * @author coxe
 */
public class Conexao 
{
    
    public static Connection conexao;
    
    public static Statement statement;
    
    public static void getConexao()
    {
        String driver = "org.postgresql.Driver";
        String url = "jdbc:postgresql://localhost:5432/universidadedb";
            
        String username = "postgres";
        String senha = "postgres";
            
        
        try 
        {
            Class.forName (driver);
            
            conexao = DriverManager.getConnection (url, username, senha);
            statement = conexao.createStatement ();
        }
        
        catch (ClassNotFoundException excepcao) 
        {
            System.err.println("Erro na localização da classe: " + excepcao.getMessage());
        } 
        catch (SQLException excepcao) 
        {
            System.err.println("Erro de SQL: " + excepcao.getMessage());
        }
    }
    
    
    public static void fecharConexao()
    {
        try 
        {
            statement.close();
            conexao.close();
            
            statement = null;
            conexao = null;
        }
        
        catch (SQLException ex) 
        {
            System.err.println("Erro de SQL: " + ex.getMessage());
        }
    }
}
