import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;


public class telacartao extends JFrame {
    public telacartao(NotaFiscal nota) {
        int contador = nota.getTotais_nota();

        JLabel imgcartao = new JLabel(new ImageIcon("imagemtelacartao.jpeg"));

        setSize(488, 264);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel cx1 = new JLabel();
        cx1.setOpaque(true);
        cx1.setBackground(contador >= 1 ? Color.GREEN : Color.WHITE);

        JLabel cx2 = new JLabel();
        cx2.setOpaque(true);
        cx2.setBackground(contador >= 2 ? Color.GREEN : Color.WHITE);

        JLabel cx3 = new JLabel();
        cx3.setOpaque(true);
        cx3.setBackground(contador >= 3 ? Color.GREEN : Color.WHITE);

        JLabel cx4 = new JLabel();
        cx4.setOpaque(true);
        cx4.setBackground(contador >= 4 ? Color.GREEN : Color.WHITE);

        JLabel cx5 = new JLabel();
        cx5.setOpaque(true);
        cx5.setBackground(contador >= 5 ? Color.GREEN : Color.WHITE);

        JLabel cx6 = new JLabel();
        cx6.setOpaque(true);
        cx6.setBackground(contador >= 6 ? Color.GREEN : Color.WHITE);

        JLabel cx7 = new JLabel();
        cx7.setOpaque(true);
        cx7.setBackground(contador >= 7 ? Color.GREEN : Color.WHITE);

        JLabel cx8 = new JLabel();
        cx8.setOpaque(true);
        cx8.setBackground(contador >= 8 ? Color.GREEN : Color.WHITE);

        JLabel cx9 = new JLabel();
        cx9.setOpaque(true);
        cx9.setBackground(contador >= 9 ? Color.GREEN : Color.WHITE);

        JLabel cx10 = new JLabel();
        cx10.setOpaque(true);
        cx10.setBackground(contador >= 10 ? Color.GREEN : Color.WHITE);

        imgcartao.setBounds(0, 0, 488, 264);
        // CAIXAS DE CIMA
        cx1.setBounds(30, 80, 50, 50);
        cx2.setBounds(110, 80, 50, 50);
        cx3.setBounds(190, 80, 50, 50);
        cx4.setBounds(270, 80, 50, 50);
        cx5.setBounds(350, 80, 50, 50);
        // CAIXAS DE BAIXO
        cx6.setBounds(30, 150, 50, 50);
        cx7.setBounds(110, 150, 50, 50);
        cx8.setBounds(190, 150, 50, 50);
        cx9.setBounds(270, 150, 50, 50);
        cx10.setBounds(350, 150, 50, 50);

        // LABEL COM O NOME E CPF
        JLabel cpfLabel = new JLabel("CPF");
        JLabel nomeLabel = new JLabel("Nome");
        Font fonte = new Font("Arial", Font.BOLD, 14);
        cpfLabel.setForeground(Color.BLACK);
        nomeLabel.setForeground(Color.BLACK);
        cpfLabel.setFont(fonte);
        nomeLabel.setFont(fonte);

        // Estilizando os labels de CPF e nome
        cpfLabel.setBounds(30, 10, 100, 50);
        cpfLabel.setHorizontalAlignment(SwingConstants.CENTER);
        cpfLabel.setOpaque(true);
        cpfLabel.setBackground(Color.WHITE);
        cpfLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        cpfLabel.setFont(new Font("Arial", Font.BOLD, 14));

        nomeLabel.setBounds(200, 10, 100, 50);
        nomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nomeLabel.setOpaque(true);
        nomeLabel.setBackground(Color.WHITE);
        nomeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nomeLabel.setFont(new Font("Arial", Font.BOLD, 14));
        
        if(cx10.getBackground() == Color.GREEN){
            JOptionPane.showMessageDialog(null, "Parabéns, você ganhou 50% de desconto na próxima compra");
        }
        // Alterando o texto de cpf e nome
        cpfLabel.setText(nota.getCPF());
        nomeLabel.setText(nota.getNome_Cliente());

        add(cpfLabel);
        add(nomeLabel);
        add(cx10);
        add(cx9);
        add(cx8);
        add(cx7);
        add(cx6);
        add(cx5);
        add(cx4);
        add(cx3);
        add(cx2);
        add(cx1);
        add(imgcartao);
        setVisible(true);
    }
}
