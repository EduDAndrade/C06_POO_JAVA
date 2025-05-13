public class Main {

    public static void main(String[] args) {

        Conta conta = new Conta(1050, 3200);

        Cliente cli1 = new Cliente("Eduardo Dias Andrade", "125.635.123-45");
        Cliente cli2 = new Cliente("Jesus Christinho", "344.456.098-01");

        conta.addCliente(cli1);
        conta.addCliente(cli2);
        conta.addCliente(null); //um cliente nulo de teste

        conta.mostraInfo();

        System.out.println("\n=-=-= Programa executado com êxito =-=-=");
    }
}