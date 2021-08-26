package listaduplamenteencadeadacliente;

public class Cliente {
    
    private String nome;
    private int cpf, codigo;
    
    public Cliente() {
        
    }

    public Cliente(String nome, int cpf, int codigo) {
        this.nome = nome;
        this.cpf = cpf;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", cpf=" + cpf + ", codigo=" + codigo + '}';
    }

}
