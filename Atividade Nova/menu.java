import javax.swing.JOptionPane;

public class menu {
    public static void main(String[] args) {
        funcionario funcionario = new funcionario(); // Chamando a classe funcionario pra usar na main
        String escolha;
        String continuacao = "sim"; // variavel pra o equals comparar caso o usario escolha sim
        // Entrada de Dados do Usuario
        while (continuacao.equals("sim")) {
            String nomecompleto = JOptionPane.showInputDialog(null, "Digite seu nome completo");
            double salario = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite seu salário: "));
            String cpf = JOptionPane.showInputDialog(null, "Digite seu cpf: ");
            funcionario.setnomecompleto(nomecompleto); // Setar o nome dele na classe funcionario (classe mae)
            funcionario.setsalario(salario); // Setar o salario na classe funcionario (classe mae)
            funcionario.setcpf(cpf); // Setar o cpf na classe funcionario (classe mae)
            JOptionPane.showMessageDialog(null, "Seu nome completo é  " + funcionario.getnomecompleto() + " \n "
                    + "Seu salario é " + funcionario.getsalario() + "\n" + " Seu cpf é " + funcionario.getcpf());
            // Pergunta pra ele escolher oque quer aparecer
            escolha = JOptionPane.showInputDialog(null,
                    " Se voce é do cargo funcionario digite funcioario \n se voce é gerente digite gerente \n se vc é secretario digite secretario \n se voce é diretor digite diretor \n se voce é engenheiro digite engenheiro");
            // O switch pra puxar o que ele pediu
            switch (escolha) {
                case "funcionario":
                    JOptionPane.showMessageDialog(null, " Olá funcionario sua bonificacao é de 10% e seu salario fica "
                            + funcionario.getbonificacao());// resultado
                    // o get ele puxa o salario já com a soma
                    break;
                case "secretario":
                    secretario secretario = new secretario();
                    JOptionPane.showMessageDialog(null, " Olá funcionario sua bonificacao é de 5% e seu salario fica "
                            + secretario.getbonificacao());

                    break;
                case "gerente":
                    gerente gerente = new gerente();// classe gerente
                    int gerenciados = Integer
                            .parseInt(JOptionPane.showInputDialog("Quantos funcionarios voce genrenciou ? "));
                    gerente.setnumerofuncionariosgerenciados(gerenciados);// Aqui eu seto o tanto de funcionarios que
                                                                          // ele gerenciou na classe gerente
                    JOptionPane.showMessageDialog(null, "Voce gerenciou " + gerente.getnumerofuncionariosgerenciados()
                            + "\n" + "Sua bonificacao é 15% e seu salario fica " + gerente.getbonificacao());
                    // Aí aparece o resultado e o get ele pegar o valor que foi setado la em cima na
                    // classe gerente
                    break;
                case "diretor":
                    // funcionario.bonificacao(0.30 * salario);
                    diretor diretor = new diretor();
                    int gerenciados2 = Integer
                            .parseInt(JOptionPane.showInputDialog("Quantos departamentos voce genrenciou ? "));
                    diretor.setnumerodepartamentogerenciados(gerenciados2);
                    JOptionPane.showMessageDialog(null, "Voce gerenciou " + diretor.getnumerodepartamentogerenciados()
                            + "\n" + "Sua bonificacao é 30% e seu salario fica " + diretor.getbonificacao());
                    break;
                case "engenheiro":
                    engenheiro engenheiro = new engenheiro();
                    JOptionPane.showMessageDialog(null, " Olá funcionario sua bonificacao é de 20% e seu salario fica "
                            + engenheiro.getbonificacao());

                    break;

                default:
                    break;
            }
            continuacao = JOptionPane.showInputDialog(null,
                    "Deseja continuar usando o MENU ? \n Digite sim pra continuar \n Digite nao para sair");// pergunta
                                                                                                            // se pra
                                                                                                            // chamar o
                                                                                                            // while
        }
    }
}
