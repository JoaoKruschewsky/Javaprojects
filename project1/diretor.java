public class diretor extends funcionario {
   
    public int numerodepartamentogerenciados;
    
    public double getbonificacao(){
        return salario * 0.30 + salario;
    }
    public void setnumerodepartamentogerenciados( int numerodepartamentogerenciados){
        this.numerodepartamentogerenciados = numerodepartamentogerenciados;
    }
    public int getnumerodepartamentogerenciados(){
        return numerodepartamentogerenciados;
    }
}   
