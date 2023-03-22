
import javax.swing.JOptionPane;

public class exer1 {
    public static void main(String[] args) {
        String entrada;
        float nota = 0.0f;
        //Entrada de dados
        entrada = JOptionPane.showInputDialog(null, "Qual nome do aluno? "); //Nome do aluno

        for (int i = 0; i < 4; i++) {
            Float notas = Float.parseFloat(JOptionPane.showInputDialog(null, " Digite aqui as notas: "));// As quatros notas dele
            nota += notas;

        }
        //Saída dos dados com o resultado
        JOptionPane.showMessageDialog(null, "Olá " + entrada + " Sua media foi de " + nota / 4);

    }
}