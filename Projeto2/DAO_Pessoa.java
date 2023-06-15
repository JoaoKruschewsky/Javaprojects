import java.sql.*;
public class DAO_Pessoa {
    private Connection conexao;

public DAO_Pessoa(){
    conexao = new conexaoaobd().solicitaConexao("localhost:5432","postgres","postgres","joaopedro12");
}
public void insere(NotaFiscal notas){
    String sql = "insert into Pessoa " + 
        "(nome, endereco, fone) " + 
        "values (?,?,?)";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, notas.getNome_Cliente());
            stmt.setString(2,notas.getID_Nota());
            stmt.setString(3,notas.getNome_Cliente());
            
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}
}

 
  