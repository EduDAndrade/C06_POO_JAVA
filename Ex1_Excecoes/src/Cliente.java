public class Cliente {

    private String nome;
    private String cpf; //pra formatar bonitnho com ponto e traço

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}