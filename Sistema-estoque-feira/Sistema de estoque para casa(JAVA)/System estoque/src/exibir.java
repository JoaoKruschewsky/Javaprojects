import javax.swing.*;
import javax.swing.table.DefaultTableModel;
class exibir extends JFrame{
    /* aqui estou chamando a matriz para usar na tela */
    private Object[][] dados;
    public  exibir(Object[][] dados){
        this.dados = dados;}

    public  void exibirtabela(){

        String[] colunasnome = {"Nome Produto" , "quantidade" };
        DefaultTableModel model = new DefaultTableModel(dados, colunasnome);
        model.setColumnIdentifiers(colunasnome);
        JTable table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);
        scroll.setSize(400, 400);
        
        
        setBounds(50,50,400,400);
        add(scroll);
        setVisible(true);
        


       
    }
}
