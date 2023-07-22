import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class login extends JFrame {

    login() {

        usuarios user = new usuarios();
        acessobd banco = new acessobd();
        banco.setLogin(this);
        JTextField inpt1 = new JTextField();
        JTextField inpt2 = new JTextField();
        JLabel nomeinpt1 = new JLabel("Usuario");
        JLabel nomeinpt2 = new JLabel("Senha");
        JButton login = new JButton("Login");
        JButton cadastro = new JButton("Deseja se cadastrar?");

        // JTEXTFIELD
        inpt1.setBounds(100, 50, 200, 50);
        inpt2.setBounds(100, 150, 200, 50);

        // JLABEL
        nomeinpt1.setBounds(50, 50, 50, 50);
        nomeinpt2.setBounds(50, 150, 50, 50);

        // JBUTTON
        cadastro.setBounds(150, 200, 200, 20);
        cadastro.setContentAreaFilled(false);
        Border emptyBorder = new EmptyBorder(0, 0, 0, 0);
        cadastro.setBorder(emptyBorder);
        cadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                cadastro cadastro = new cadastro();
                cadastro.setVisible(true);
                dispose();
            }
        });
        login.setBounds(130, 230, 150, 50);
        login.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                user.setUsuario(inpt1.getText());
                user.setSenha(inpt2.getText());
                banco.analisarlogin(user);
            }
        });

        // JFRAME
        setLayout(null);
        setSize(400, 400);
        setLocationRelativeTo(null);

        add(login);
        add(cadastro);
        add(inpt1);
        add(inpt2);
        add(nomeinpt1);
        add(nomeinpt2);
        setVisible(true);
    }
}
