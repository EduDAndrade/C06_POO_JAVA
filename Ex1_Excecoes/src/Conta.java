import java.util.HashSet;

public class Conta {

    private float saldo;
    private float limite;
    private HashSet<Cliente> clientes;

    public Conta(float saldo, float limite) {
        this.saldo = saldo;
        this.limite = limite;
        this.clientes = new HashSet<>();
    }

    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void mostraInfo() {
        System.out.println("\n=-=-= Dados da Conta =-=-=");
        System.out.println("* Saldo: " + saldo);
        System.out.println("* Limite: " + limite);
        System.out.println("\n-- Clientes --");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        for (Cliente cliente : clientes) {
            try {
                System.out.println("* Nome: " + cliente.getNome());
                System.out.println("* CPF: " + cliente.getCpf());
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            } catch (NullPointerException e) {
                System.out.println("Nenhum cliente foi encontrado na posição");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            }
        }
    }
}