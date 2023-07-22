/*import java.util.Scanner;

import javax.swing.JOptionPane;

public class teste {
    public static void main(String[] args) {

        String escolha = "";
        Scanner n = new Scanner(System.in);
        Object[][] comidas = new Object[20][20];
        comidas[0][0] = "Pao";
        comidas[0][1] = 5;
        comidas[1][0] = "Arroz";
        comidas[1][1] = 10;
        comidas[2][0] = "feijao";
        comidas[2][1] = 4;
        comidas[3][0] = "Carne";
        comidas[3][1] = 0;
        comidas[4][0] = "Cuscuz";
        comidas[4][1] = 0;
        comidas[5][0] = "Presunto";
        comidas[5][1] = 0;
        do {
            System.out.println(" 1.Procurar itens \n 2.Atualizar quantidade.\n 3.Em falta");
            System.out.println("Escolha uma das opcoes");
            String opcao = n.nextLine();
            switch (opcao) {

                case "1":
                    System.out.print("Qual nome do produto você deseja saber? ");
                    String nome = n.nextLine();
                    boolean itemexiste = false;

                    for (int i = 0; i < comidas.length; i++) {
                        if (comidas[i][0] != null && comidas[i][0].toString().equalsIgnoreCase(nome)) {
                            if (comidas[i][1].equals(0)) {
                                System.out.println("Este item está em falta.");
                            } else {
                                System.out.println("A quantidade desse item é " + comidas[i][1]);
                            }
                            itemexiste = true;
                            break;
                        }
                    }
                    if (!itemexiste) {
                        System.out.println("Esse item nao existe digite novamente.");
                    }
                    break;
                case "2":
                    System.out.println("1.Adicionar ou 2.Diminuir: ");
                    String usado = n.nextLine();

                    boolean existe = false;
                    if (usado.equals("1")) {
                        System.out.println("Qual produto deseja?");
                        String nomeprod = n.nextLine();
                        for (int i = 0; i < comidas.length; i++) {

                            if (comidas[i][0] != null && comidas[i][0].toString().equalsIgnoreCase(nomeprod)) {
                                System.out.println("Deseja adicionar quantos? ");
                                String valor = n.nextLine();
                                int addqnt = Integer.valueOf(valor);
                                if ((int) comidas[i][1] >= 0) {
                                    int num = (int) comidas[i][1];
                                    int result = num + addqnt;
                                    comidas[i][1] = result;
                                    System.out.println("Agora tem " + comidas[i][1] + " do " + nomeprod);
                                    existe = true;
                                    break;
                                }
                                existe = true;
                                break;
                            }

                        }
                        if (!existe) {
                            System.out.println("Essse item nao existe digite novamente.");

                        }
                    }

                    if (usado.equals("2")) {
                        System.out.println("Qual produto deseja?");
                        String nomeprod = n.nextLine();
                        for (int i = 0; i < comidas.length; i++) {
                            if (comidas[i][0] != null && comidas[i][0].toString().equalsIgnoreCase(nomeprod)) {

                                if ((int) comidas[i][1] == 0) {
                                    System.out.println("Nao há nada desse item");
                                    existe = true;
                                    break;
                                } else {
                                    System.out.println("Quantos deseja diminuir? ");
                                    String qntprod = n.nextLine();
                                    int num = (int) comidas[i][1];
                                    int diminuir = num - Integer.parseInt(qntprod);
                                    System.out.println("Voce diminuiu " + qntprod + " desse produto\n agora voce tem: "
                                            + diminuir);

                                }
                                existe = true;
                                break;
                            }
                        }
                        if (!existe) {
                            System.out.println("Esse produto nao existe digite novamente. ");
                        }
                    }

                    break;
                case "3":
                    boolean itemencontrado = false;
                    for (int i = 0; i < comidas.length; i++) {
                        if (comidas[i][0] != null) {
                            if ((int) comidas[i][1] == 0) {

                                System.out.println("Os itens que estao em falta sao: " + comidas[i][0]);
                                ;
                                itemencontrado = true;
                            }

                        }
                    }
                    if (!itemencontrado) {
                        System.out.println("Nao há nenhum item em falta");
                    }
                    break;
                default:
                    System.out.println("Escolha invalida digite novamente");
                    continue;
            }

            System.out.println("Deseja continuar olhando? ");
            escolha = n.nextLine();

        } while (!escolha.equalsIgnoreCase("nao"));

        JOptionPane.showMessageDialog(null, "Obrigado por nos consultar!");

        n.close();
    }

}
*/