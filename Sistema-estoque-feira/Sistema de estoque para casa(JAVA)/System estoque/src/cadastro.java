import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class cadastro extends JFrame {
    cadastro() {
        usuarios user = new usuarios();
        acessobd banco = new acessobd();
        banco.setCadastro(this);
        JTextField inpt1 = new JTextField();
        JTextField inpt2 = new JTextField();
        JTextField inpt3 = new JTextField();
        JLabel nomeinpt1 = new JLabel("Usuario");
        JLabel nomeinpt2 = new JLabel("Senha");
        JLabel nomeinpt3 = new JLabel("Digite novamente sua senha");
        Font font = new Font("Arial", 10, 13);
        JButton cadastrar = new JButton("Cadastrar");
        // JTEXTFIELD

        inpt1.setBounds(200, 50, 150, 50);
        inpt2.setBounds(200, 150, 150, 50);
        inpt3.setBounds(200, 250, 150, 50);

        // JLABEL

        nomeinpt1.setBounds(150, 50, 50, 50);
        nomeinpt2.setBounds(150, 150, 50, 50);
        nomeinpt3.setBounds(20, 250, 250, 50);
        nomeinpt1.setFont(font);
        nomeinpt2.setFont(font);
        nomeinpt3.setFont(font);

        // JBUTTON
        cadastrar.setBackground(Color.RED);
        cadastrar.setForeground(Color.black);
        cadastrar.setBounds(200, 330, 150, 30);
        cadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {                        
                String comparar1 = inpt2.getText();    
                String comparar2 = inpt3.getText();                     
                if ( comparar2.length() >= 8 && comparar1.length() >= 8) {    
                if (comparar1.equals(comparar2)) {
                    user.setUsuario(inpt1.getText());
                    user.setSenha(comparar2);
                    banco.cadastro(user);
                } else {
                    JOptionPane.showMessageDialog(null, "As senhas precisam ser iguais.");
                }
            } else {
                JOptionPane.showMessageDialog(null,"Senha precisa ser igual ou maior que 8 digitos.");
            }
            }
        });
        // JFRAME

        setSize(500, 450);
        setLocationRelativeTo(null);
        setLayout(null);

        add(cadastrar);
        add(inpt1);
        add(inpt2);
        add(inpt3);
        add(nomeinpt1);
        add(nomeinpt2);
        add(nomeinpt3);
        setVisible(true);

    }
}
