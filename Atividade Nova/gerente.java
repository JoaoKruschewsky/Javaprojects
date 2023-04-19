public class gerente extends funcionario {
    
    public int numerofuncionariosgerenciados;

    public double getbonificacao(){
        return salario * 0.15 + salario;
    }
    public void setnumerofuncionariosgerenciados(int numerofuncionariosgerenciados){
        this.numerofuncionariosgerenciados = numerofuncionariosgerenciados;
    }
    public int getnumerofuncionariosgerenciados(){
        return numerofuncionariosgerenciados;
    }
}
