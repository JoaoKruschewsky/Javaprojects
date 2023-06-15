import java.sql.*;
public class conexaoaobd {
    public Connection solicitaConexao(String host, String banco, String usuario, String senha){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("\nOcorrreu um Probmela!\n Driver não encontrado!!!\n" + e.toString());
            System.exit(1);
        }
        try {
             return DriverManager.getConnection("jdbc:postgresql://" + host + "/" + banco + "?useTimezone=true&serverTimezone=UTC", usuario,senha);
        } catch (SQLException e) {
            System.out.println("\nOcorrreu um Probmela!\n Driver não encontrado!!!\n" + e.toString());
            System.exit(2);
            return null;
        }
    }
}