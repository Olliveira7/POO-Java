
package br.edu.ifnmg.projets_001.percistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BancoDados {
    // Essa classe é para conecatar com o banco de dados e usuário
    private Connection conexao;
    //oi
    public BancoDados() {
        try {
            //Carregar o driver do Mysql na memória
            Class.forName("com.mysql.jdbc.Driver");
            
            //Conectar com o banco de dados
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/teste","teste","victoriagabriella1999");
        }catch (ClassNotFoundException ex){
            // Exceção para mostrar que não conectou com o driver jdbc
            System.out.println("Driver de banco de dados não foi encontrado");
        }catch (SQLException ex){
            // Exceção para mostrar que ouve problema com a conexão com o banco de dados
            System.out.println("Os dados da conexão com o banco de dados estão erradas!");
            System.out.println(ex.getMessage());
        }
    }
    
    public Connection getConexao(){
        // Esse método serve para outras classes fazer a ultilização dessa conexão, pois a variável é do tipo private
        return conexao;
    }
}
