
package br.edu.ifnmg.projets_001.percistence;

import br.edu.ifnmg.projets_001.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class repository_aluno {
    // Essa classe é para fazer a conexão com a tabela de banco de dados e gerenciar os dados dos alunos no banco
    public BancoDados bd;//Essa variável é para fazer a conexão com o banco de dados
    
    public repository_aluno(){
        bd = new BancoDados();
    }
    
    public boolean Salvar(Student obj){
        try{
            //DriverManager
            //O statement tem dois método, execute update e o 
            PreparedStatement sql = bd.getConexao().prepareStatement("insert into aluno(nome, cpf) values(?,?)", Statement.RETURN_GENERATED_KEYS);
            // O banco de dados vai retornar um id, então retorne para mim que id é esse
            //As interrogações "?" são para colocar na ordem que está preescrito acima e abaixo
            //Statement é uma declaração
            //PreteretStatement aceita paramentros e declara
            sql.setString(1, obj.getName());//O 1 significa que onde ele vai ser inserido acima
            sql.setString(2, obj.getCpf().replace("."," ").replace("-",""));// O replace é para tirar esses elementos do CPF
            //O executeUpdate retorn sempre um inteiro, se retorna uma número igual a zero significa que não ouve alteração
            //Se eu mandar uma consulta errada para o meu banco de dados, vai ser gerado/lançar uma exceção SQLExeception
            if(sql.executeUpdate() > 0){// se o return for maior a zero significa que ouve alteração
                // essa função é para retornar o Id que o banco de dados colocou para aquele aluno
                ResultSet chave = sql.getGeneratedKeys();
                chave.next();
                obj.setId(chave.getInt(1));
                return true;
            }
            else{
                return false;
            }//Essa parte é para se por acaso tiver essa pessoa cadastrada no banco, ele irá atualizar
            //PreparedStatement sql = bd.getConexao().prepareStatement("update aluno set nome = ?, cpf = ?, sexo = ? where id = ?");
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public Student Abrir(int id){// a pesquisa é em busca desse aluno com esse id
        try {
             PreparedStatement sql = bd.getConexao().prepareStatement("select id, nome, cpf from Alunos where id = ?");
             //encontre o aluno com esse id
             sql.setInt(1, id);//ele está mandando o id buscado para o select
             // ele vai para o primeiro elemento da lista
             //ResultSet cria uma lista na memória
             //A função somente é executada no banco de dados quando o executeQuery()
             ResultSet resultado = sql.executeQuery();// Salva os dados da minha pesquisa
             
            resultado.next();// O next é uma função que retorna um boolean, ele sempre vai para o proximo registro 
            // o .absolute() -  ele vai para um registro em questão
            Student student = new Student();//Criu um usuário vazio
             // Criei um objeto vazio e estou inserindo os dados salvo em resultado e coloco no objeto
             student.setId(resultado.getInt("id"));
             student.setName(resultado.getString("name"));
             student.setCpf((resultado.getString("cpf")));
             
        
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public Student apagar(){
    return null;
    }
    
    public List<Student> Buscar(Student filtro){
        try {
            String where = "";// where vai ser uma variável de ajuda
            //where vai ser o filtro
            // O isEmpty() é um método da classe string
            if(filtro.getName() != null || !filtro.getName().isEmpty())
                where += "nome like '%"+filtro.getName()+"%'";
            //Ele vai olhar se o nome está vazio ou nulo. O empty significa
            if(filtro.getCpf() != null && !filtro.getCpf().isEmpty()){// O comando isEmpty vereifica se a satring está vazia ou não
                if(where.length() > 0)
                    where += "and";
               where += "name cpf = '"+filtro.getCpf().replace("."," ").replace("-"," ")+"'";
                       
            }
            
            String consulta = "select * from Students";
            
            if(where.length() > 0)
                consulta += "where" + where;
            
            PreparedStatement sql = bd.getConexao();
            
            
        }
    }
}
