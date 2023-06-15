import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

class telavenda extends JFrame {
    private Connection conexao = new conexaoaobd().solicitaConexao("localhost:5432", "postgres", "postgres",
            "joaopedro12");;
    public String CPFcliente;

    public telavenda() {

        // TELA
        setBounds(518, 396, 988, 764);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // LABEL
        JLabel ID_Cliente = new JLabel("ID_Cliente");
        JLabel Nome_Cliente = new JLabel("Nome_Cliente");
        JLabel Total = new JLabel("Total");
        JLabel img_venda = new JLabel(new ImageIcon("imagemtelaprincipal.jpg"));

        // FRONT LABEL - TAMANHO / CORES / POSIÇÃO
        ID_Cliente.setBounds(50, 174, 122, 24);
        Nome_Cliente.setBounds(50, 254, 158, 24);
        Total.setBounds(50, 368, 170, 34);
        img_venda.setBounds(0, 0, 988, 764);
        ID_Cliente.setForeground(Color.white);
        Nome_Cliente.setForeground(Color.white);
        Total.setForeground(Color.white);
        Font fonte = ID_Cliente.getFont().deriveFont(20f);
        ID_Cliente.setFont(fonte);
        Nome_Cliente.setFont(fonte);
        Total.setFont(fonte);

        // INPUTS
        JTextField inpt_id_cliente = new JTextField();
        JTextField inpt_nome_cliente = new JTextField();
        JTextField inpt_total = new JTextField();

        // FRONT INPUT - TAMANHO / CORES / POSIÇÃO
        inpt_id_cliente.setBounds(189, 174, 170, 34);
        inpt_nome_cliente.setBounds(189, 254, 510, 34);
        inpt_total.setBounds(181, 357, 170, 34);

        // BUTTONS
        JButton botao_busca = new JButton("Buscar cartão");
        JButton botao_vender = new JButton("Vender");

        // FRONT BUTTONS - TAMANHO / CORES / POSIÇÃO
        botao_busca.setBounds(350, 450, 150, 100);
        botao_vender.setBounds(550, 450, 100, 100);

        botao_vender.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CAPTURANDO OS DADOS
                String idCliente = inpt_id_cliente.getText();
                String nomeCliente = inpt_nome_cliente.getText();
                String total = inpt_total.getText();

                // Verificar se o idCliente contém apenas números
                if (!idCliente.matches("\\d+")) {
                    JOptionPane.showMessageDialog(null, "CPF Inválido", "Erro", JOptionPane.ERROR_MESSAGE);
                    inpt_id_cliente.setText("");
                    return; // Sai do método actionPerformed sem inserir no banco de dados
                }

                // Verificar se o idCliente tem exatamente 11 dígitos
                if (idCliente.length() != 11) {
                    JOptionPane.showMessageDialog(null, "CPF Inválido", "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    inpt_id_cliente.setText("");
                    return; // Sai do método actionPerformed sem inserir no banco de dados
                }

                // Consulta ao banco de dados para verificar o nome do cliente
                String sql = "SELECT Nome_cliente FROM compradores WHERE CPF = ?";
                try {
                    PreparedStatement stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, idCliente);
                    ResultSet rs = stmt.executeQuery();

                    if (rs.next()) {
                        String nomeBanco = rs.getString("Nome_cliente");

                        // Verificar se o nome digitado é o mesmo que está no banco de dados
                        if (!nomeCliente.equals(nomeBanco)) {
                            JOptionPane.showMessageDialog(null, "Nome do cliente não corresponde ao CPF informado",
                                    "Erro",
                                    JOptionPane.ERROR_MESSAGE);
                            inpt_id_cliente.setText("");
                            inpt_nome_cliente.setText("");
                            return; // Sai do método actionPerformed sem inserir no banco de dados
                        }
                    }

                    rs.close();
                    stmt.close();
                } catch (SQLException errinho) {
                    JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + errinho.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return; // Sai do método actionPerformed sem inserir no banco de dados
                }

                // INSERIR OS DADOS NO BANCO DE DADOS MY SQL
                String sqlInserir = "INSERT INTO compradores (CPF, Nome_cliente, total) VALUES (?, ?, ?)";
                try {
                    PreparedStatement stmt = conexao.prepareStatement(sqlInserir);
                    stmt.setString(1, idCliente);
                    stmt.setString(2, nomeCliente);
                    stmt.setString(3, total);

                    stmt.execute();
                    stmt.close();

                    JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro ao inserir dados no banco de dados: " + erro.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }

                // ZERAR OS CAMPOS DE TEXTO
                inpt_id_cliente.setText("");
                inpt_nome_cliente.setText("");
                inpt_total.setText("");
            }
        });

        botao_busca.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    NotaFiscal nota = new NotaFiscal();

                    String con = JOptionPane.showInputDialog("Digite o CPF a ser buscado");

                    String sql2 = "SELECT COUNT(total) AS total, cpf, Nome_cliente FROM compradores WHERE cpf = ? GROUP BY cpf, Nome_cliente";
                    PreparedStatement stmtt = conexao.prepareStatement(sql2);
                    stmtt.setString(1, con);

                    ResultSet rs = stmtt.executeQuery();

                    boolean encontrado = false;

                    while (rs.next()) {
                        if (rs.getString("CPF").equals(con)) {

                            encontrado = true;

                            String totalNotasString = rs.getString("total");

                            int totalnotas = Integer.parseInt(totalNotasString);
                            nota.setTotais_nota(totalnotas);
                            nota.setCPF(rs.getString("CPF"));
                            nota.setNome_Cliente(rs.getString("Nome_cliente"));

                            new telacartao(nota);
                        }

                    }

                    rs.close();
                    stmtt.close();

                    if (!encontrado) {

                    }
                } catch (SQLException errinho) {
                    JOptionPane.showMessageDialog(null, "Erro ao executar consulta: " + errinho.getMessage(), "Erro",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // DEIXANDO VISIVEL TUDO ISSO ACIMA NA TELA
        add(Total);
        add(Nome_Cliente);
        add(ID_Cliente);
        add(inpt_id_cliente);
        add(inpt_nome_cliente);
        add(inpt_total);
        add(botao_busca);
        add(botao_vender);
        add(img_venda);
        setVisible(true);
    }
}