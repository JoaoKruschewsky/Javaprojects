
import javax.swing.JOptionPane;

public class exer2 {
    public static void main(String[] args) {
        float geral = 0.0f;
        float notas;
        float soma = 0.0f;
        String[] alunos = new String[5];
        float[] notasalunos = new float[5];
        // Entrada de dados
        for (int i = 0; i < 5; i++) {
            alunos[i] = JOptionPane.showInputDialog(null, "Digite seu nome "); // Nome do alunos repete 5 vezes após a
                                                                               // notas

            for (int b = 0; b < 4; b++) {

                notas = Float.parseFloat(JOptionPane.showInputDialog(null, " Digite aqui as notas: ")); // Notas dos
                                                                                                        // alunos
                soma += notas; // Aqui pra somar as 4 notas que colocar
            }
            notasalunos[i] = soma / 4; // Soma e divide por 4 que já vai direto pra média.
            soma = 0.0f;
        }

        for (int z = 0; z < 5; z++) {

            // A média de todos os alunos

            JOptionPane.showMessageDialog(null, "A média de " + alunos[z] + " é igual a " + notasalunos[z]);

        }
        for (int j = 0; j < notasalunos.length; j++) {
            geral += notasalunos[j];

        }
        JOptionPane.showMessageDialog(null, " E a média geral foi : " + geral);

    }
}