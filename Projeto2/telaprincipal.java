import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.*;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class telaprincipal extends JFrame {

    public telaprincipal() {
        // parametros do botão e da tela

        JButton botao_iniciar = new JButton("Iniciar");
        JLabel backgroundimg = new JLabel(new ImageIcon("imagemtelaprincipal.jpg"));
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

         // Criando um objeto GridBagConstraints para configurar a posição e o tamanho do botão
         GridBagConstraints gbc = new GridBagConstraints();
         gbc.gridx = 0; // Coluna 0
         gbc.gridy = 0; // Linha 0
         gbc.gridwidth = 1; // Ocupa 1 coluna
         gbc.gridheight = 1; // Ocupa 1 linha
         gbc.insets = new Insets(13, 0, 0, 0); // Define as margens (topo, esquerda, baixo, direita)
         gbc.anchor = GridBagConstraints.CENTER; // Centraliza o componente
        


        // colocando uma referência de outra tela para o botão
        botao_iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                telavenda t = new telavenda();
                dispose();
                t.setVisible(true);
            }
        });

        backgroundimg.setBounds(0, 0, 488, 264);

        botao_iniciar.setBackground(Color.BLACK);
        botao_iniciar.setForeground(Color.WHITE);

        Border bordaRedonda = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        );
        botao_iniciar.setBorder(bordaRedonda);
        botao_iniciar.setFocusPainted(false);
        botao_iniciar.setContentAreaFilled(false);
        botao_iniciar.setOpaque(true);
        botao_iniciar.setBounds(50, 50, 100, 100);
        
        // adicionando o botão e mostrando a tela

        add(backgroundimg);
        add(botao_iniciar, gbc);
        setVisible(true);
    }

}
