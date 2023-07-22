import javax.swing.*;
import java.awt.event.*;

public class menu extends JFrame {
    public menu() {
        JTextArea telaaviso = new JTextArea();
        JTextField caixanomeprod = new JTextField();
        JTextField caixaqnt = new JTextField();
        JTextField caixaprocurar = new JTextField();
        JTextField caixaatualizar = new JTextField();
        JButton insere = new JButton();
        JButton procurar = new JButton();
        JButton atualizar = new JButton();
        JButton exibir = new JButton();
        JButton aviso = new JButton("Aviso");
        JLabel nome1 = new JLabel();
        JLabel nome2 = new JLabel();
        JLabel nomeprocurar = new JLabel();
        acessobd bd = new acessobd();
        Estoque estoque = new Estoque();

        // Todos os JLABEL
        nome1.setText("Nome do produto");
        nome1.setBounds(50, 20, 100, 50);
        nome2.setText("Quantidade");
        nome2.setBounds(200, 20, 100, 50);
        nomeprocurar.setText("Nome do produto");
        nomeprocurar.setBounds(50, 130, 100, 50);

        // COMANDOS JTextField
        caixanomeprod.setBounds(50, 60, 100, 50);
        caixaqnt.setBounds(200, 60, 100, 50);
        caixaprocurar.setBounds(50, 170, 100, 50);
        caixaatualizar.setBounds(50, 250, 100, 50);
        JScrollPane scroll = new JScrollPane(telaaviso);
        scroll.setBounds(300,175,100,100);

        //COMANDOS Button
        insere.setBounds(320, 65, 100, 40);
        insere.setText("inserir");
        insere.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                estoque.setNomeProduto(caixanomeprod.getText());
                int quant = Integer.parseInt(caixaqnt.getText());
                estoque.setQuantidade(quant);
                bd.insere(estoque);

            }
        });

        procurar.setBounds(180, 175, 100, 40);
        procurar.setText("procurar");
        procurar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                estoque.setNomeProduto(caixaprocurar.getText());
                bd.procurar(estoque);
            }
        });

        atualizar.setBounds(300, 350, 100, 40);
        atualizar.setText("atualizar");
        atualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String diminuiraumentar = JOptionPane.showInputDialog("1.Aumentar/2.Diminuir.Escolha[1/2]");
                String escolha = JOptionPane.showInputDialog(null, "Qual produto voce deseja atualizar? ");
                String escolhaquantidade = JOptionPane.showInputDialog(null, "Qual a quantidade? ");
                int escolhaqnt = Integer.parseInt(escolhaquantidade);
                int dimiaument = Integer.parseInt(diminuiraumentar);
                estoque.setNomeProduto(escolha);
                bd.atualizar(estoque, escolhaqnt, dimiaument);

            }
        });

        exibir.setBounds(300, 400, 150, 40);
        exibir.setText("exibir tabela");
        exibir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bd.exibir();

            }
        });
        /*
         * aviso.setBounds(200,400,150,50);
         * aviso.addActionListener(new ActionListener() {
         * public void actionPerformed(ActionEvent e) {
         * bd.aviso();
         * 
         * }
         * });
         */
        // COMANDOS  JFrame
        setSize(500, 500);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Thread serve pra atualizar a tabelinha de avisos acada 5 segundos.
        new Thread(() -> {
            while (true) {
                bd.aviso(telaaviso);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // Tudo que é pra adicionar no JFrame
        add(caixanomeprod);
        add(caixaqnt);
        add(caixaprocurar);
        add(aviso);;
        add(scroll);
        add(nomeprocurar);
        add(exibir);
        add(insere);
        add(procurar);
        add(atualizar);
        add(nome1);
        add(nome2);
        setVisible(true);
    }
}