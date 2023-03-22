import javax.swing.JOptionPane;

public class exer3 {
    public static void main(String[] args) {
        //Dados
        String nome;
        Float nota;
        Float media = 0.0f;
        String pergunta = "";
        int x = 0;
        Float[] numeros = new Float[20];
        String[] nomes = new String[20];
        //Entrada dos dados
        while (!pergunta.equals("não") && x < 20) {            //Aqui o while vai pegar a respota da pergunta e verificar se é diferente de nao por conta da exclamao que nega 

            nome = JOptionPane.showInputDialog(null, "Digite o nome do " + (x + 1) + "º aluno\n"); // Nome do aluno
            for (int i = 0; i < 4; i++) {
                nota = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite sua nota:\n")); //Notas
                media += nota;
            }
            numeros[x] = media / 4; // Calculo da media

            nomes[x] = nome;
            media = 0.0f;
            x++;
            pergunta = JOptionPane.showInputDialog(null, "Quer continuar ? sim/não");
        }

        for (int y = 0; y < 20; y++) { //Média
            if (nomes[y] == null) /*Aqui só pra caso a pessoa nao digitar nada*/ {
                break;
            } else {
                JOptionPane.showMessageDialog(null, " A média de " + nomes[y] + " é igual a " + numeros[y]);
            }
        }
    }
}