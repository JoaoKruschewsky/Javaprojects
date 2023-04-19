
public class funcionario {

    private String cpf;
    public double salario;
    private String nomecompleto;

    public funcionario() {

    }


    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public void setsalario(double salario) {
        this.salario = salario;
    }

    public void setnomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getcpf() {
        return cpf;
    }

    public double getsalario() {
        return salario;
    }

    public String getnomecompleto() {
        return nomecompleto;
    }

    public double getbonificacao(){
        return salario * 0.10 + salario;
    }
}
