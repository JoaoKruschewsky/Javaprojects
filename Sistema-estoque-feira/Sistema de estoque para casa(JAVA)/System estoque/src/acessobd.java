import java.sql.*;
import java.util.*;
import javax.swing.*;
import org.mindrot.jbcrypt.BCrypt;
public class acessobd {
    private Connection conexao;
    public acessobd() {
        conexao = new conexaobd().solicitaConexao("localhost:5432", "postgres", "postgres", "joaopedro12");
    }
    private login login; // Adicionando o atributo para representar a tela de login

    public void setLogin(login login) {
        this.login = login;
    }
    private cadastro cadastro; // Adicionando o atributo para representar a tela de login

    public void setCadastro(cadastro cadastro) {
        this.cadastro = cadastro;
    }
    public void insere(Estoque feira) {
        String sql = "select * from feira where nome_produtos = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, feira.getNomeProduto());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                JOptionPane.showMessageDialog(null, "Esse produto ja existe no sistema.");
            } else {
                String insert = "insert into feira (nome_produtos,quantidade) values (?,?)";
                PreparedStatement stmt2 = conexao.prepareStatement(insert);
                stmt2.setString(1, feira.getNomeProduto());
                stmt2.setInt(2, feira.getQuantidade());
                stmt2.execute();
                JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!.");
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void procurar(Estoque feira) {
        String sql = "select * from feira where nome_produtos = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, feira.getNomeProduto());
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                String nomeproduto = result.getString("nome_produtos");
                int coluna2 = result.getInt("quantidade");

                String nome = "Produto: " + nomeproduto + "\nQuantidade: " + coluna2;

                JOptionPane.showMessageDialog(null, nome);
            } else {
                JOptionPane.showMessageDialog(null, "Nao há nenhum produto com esse nome.");
            }

            stmt.close();
            result.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void atualizar(Estoque feira, int escolhaqnt, int diminuiraumentar) {
        String sql = "select * from feira where nome_produtos = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, feira.NomeProduto);
            ResultSet result = stmt.executeQuery();
            //Aqui ele o usuario escolhe 2 opcoes 1 - para aumentar ou 2 - para diminuir.
            if (result.next()) {
                String nomeproduto = result.getString("nome_produtos");
                int resultadoquantidade = result.getInt("quantidade");
                switch (diminuiraumentar) {
                    case 1:
                        if (resultadoquantidade != 0) {
                            String sql2 = "update feira " +
                                    "set quantidade = quantidade + ? " +
                                    "where nome_produtos = ? ";
                            PreparedStatement stmt2 = conexao.prepareStatement(sql2);
                            stmt2.setInt(1, escolhaqnt);
                            stmt2.setString(2, nomeproduto);
                            stmt2.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Atualizacao executada com sucesso.");

                        }
                        break;
                    case 2:
                        if (resultadoquantidade != 0) {
                            String sql2 = "update feira " +
                                    "set quantidade = quantidade - ? " +
                                    "where nome_produtos = ? ";
                            PreparedStatement stmt2 = conexao.prepareStatement(sql2);
                            stmt2.setInt(1, escolhaqnt);
                            stmt2.setString(2, nomeproduto);
                            stmt2.executeUpdate();

                            JOptionPane.showMessageDialog(null, "Atualizacao executada com sucesso.");

                        }
                        break;
                    default:
                        break;

                }
            } else {
                JOptionPane.showMessageDialog(null, "Esse produto nao existe no sistema.");
            }
            stmt.close();
            result.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void exibir() {
        String sql = "select * from feira";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            //Exibir a tabela
            List<Object[]> linhas = new ArrayList<>();/* No caso cada item que existir e quantidade equivale
                                                        a uma  no linha no array list*/ 
            while (result.next()) {
                String coluna1 = result.getString(1);
                String coluna2 = result.getString(2);

                Object[] linha = { coluna1, coluna2 };// aqui armazena no array
                linhas.add(linha);//depois o array ele adiciona lista

            }
            Object[][] dados = new Object[linhas.size()][];/*Nessa matriz ela vai ter o tamanho de linhas que existir no
                                                            no arraylist. */
                                                            /* o for ele usado pra preencher a matriz */
            for (int i = 0; i < linhas.size(); i++) {
                dados[i] = linhas.get(i);
            }
            exibir exibir = new exibir(dados);
            exibir.exibirtabela();
            stmt.close();
            result.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void aviso(JTextArea telaaviso) {
        String sql = "select * from feira where quantidade <= 2";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            StringBuilder alert = new StringBuilder();
            while (result.next()) {
                String nome_produto = result.getString("nome_produtos");
                int quantidade = result.getInt("quantidade");
                String aviso = "Restam " + quantidade + " do produto " + nome_produto + " \u26A0";
                alert.append(aviso).append("\n");
            }
            if (alert.length() > 0) {
                telaaviso.setText(alert.toString());
            } else {
                telaaviso.setText("Os produtos estao em ordem!!");
            }
            ;
            stmt.execute();
            stmt.close();
            result.close();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    public void cadastro(usuarios usuarios) {
        String sqlteste = "select * from usuarios where nome = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sqlteste);
            stmt.setString(1, usuarios.Usuario);
            ResultSet result = stmt.executeQuery();
            if (!result.next()) {
                String senhauser = usuarios.getSenha();
                String senhahash = BCrypt.hashpw(senhauser, BCrypt.gensalt());
                String sql = "insert into usuarios(nome,senha_hash) values (?,?)";
                PreparedStatement stmt2 = conexao.prepareStatement(sql);
                stmt2.setString(1, usuarios.Usuario);
                stmt2.setString(2, senhahash);
                stmt2.execute();
                stmt2.close();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Cadastro concluido!!");
                login login = new login();
                login.setVisible(true);
                cadastro.dispose();
            } else {
                JOptionPane.showMessageDialog(null,"Usuario já existe tente outro porfavor.");
               
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void analisarlogin(usuarios usuarios) {
        String sql = "select * from usuarios where nome = ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,usuarios.Usuario);
            ResultSet result = stmt.executeQuery();
            if (result.next()) {
                 String senha = result.getString("senha_hash");
                 String senhafornecida = usuarios.getSenha();
                 String senhaarmazenada = senha;
                 if (BCrypt.checkpw(senhafornecida,senhaarmazenada)) {
                    menu menu = new menu();
                    menu.setVisible(true);
                    login.dispose();
                 } else {
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretas.");
            } 
            } else {
                 JOptionPane.showMessageDialog(null, "Usuario ou senha incorretas.");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}