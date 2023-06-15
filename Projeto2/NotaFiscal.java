

public class NotaFiscal{
    private String CPF;
    private String Nome_Cliente;
    private String ID_Nota;
    private String Total;
    private Integer totais_nota;

   
    public String getCPF() {
        return CPF;
    }

    public void setCPF(String cpf) {
        CPF = cpf;
    }
    public String getNome_Cliente() {
        return Nome_Cliente;
    }

    public void setNome_Cliente(String nome_Cliente) {
        Nome_Cliente = nome_Cliente;
    }

    public String getID_Nota() {
        return ID_Nota;
    }

    public void setID_Nota(String iD_Nota) {
        ID_Nota = iD_Nota;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String total) {
        Total = total;
    }
    public String TOSTRING(){
        return "nome: " + getNome_Cliente() + "\nCPF: " + getCPF() + "\nid da nota: " + getID_Nota() + "\ntotal: R$" + getTotal();
    }

    public Integer getTotais_nota() {
        return totais_nota;
    }

    public void setTotais_nota(Integer totais_nota) {
        this.totais_nota = totais_nota;
    }

   
}