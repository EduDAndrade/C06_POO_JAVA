import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente("Eduardo Dias Andrade", 1256356565);

        //Criando S.0
        SistemaOperacional sistema1 = new SistemaOperacional("Linux Ubuntu", 32);
        SistemaOperacional sistema2 = new SistemaOperacional("Windows 8", 64);
        SistemaOperacional sistema3 = new SistemaOperacional("Windows 10", 64);

        //Criando hardware
        HardwareBasico hard1 = new HardwareBasico("Pentium Core i3", 500);
        HardwareBasico hard2 = new HardwareBasico("Pentium Core i5", 1000);
        HardwareBasico hard3 = new HardwareBasico("Pentium Core i7", 2000);

        //Criando os compiuters
        Computador comp1 = new Computador("Apple", 448, sistema1, hard1);
        Computador comp2 = new Computador("Samsung", 1682, sistema2, hard2);
        Computador comp3 = new Computador("Dell", 6126, sistema3, hard3);

        //Criando as memórias extras
        MemoriaUSB mem1 = new MemoriaUSB("Pen-drive", 16);
        MemoriaUSB mem2 = new MemoriaUSB("Pen-drive", 32);
        MemoriaUSB mem3 = new MemoriaUSB("HD Externo", 1000);

        //Associando as meemorias extras aos computadores
        comp1.memoria = mem1;

        comp2.memoria = mem2;

        comp3.memoria = mem3;

        MemoriaUSB[] memorias = {mem1, mem2, mem3};
        Computador[] computadores = {comp1, comp2, comp3};
        int pedido, numPedidos = 0;

        System.out.println();

        //Indo pas compra
        do {
            System.out.println("Promoções disponíveis:");
            System.out.println();

            //Mostra as promoção
            for (int i = 0; i < computadores.length; i++) {
                if (computadores[i] != null) {
                    System.out.println("Promoção (" + (i + 1) + "): ");
                    computadores[i].mostraConfigs();
                    System.out.println();
                }
            }

            //Seleciona as promoção
            do {
                System.out.println("Selecione a promoção desejada: (1), (2) ou (3). Digite (0) para seguir ao caixa.");
                System.out.println();
                pedido = scanner.nextInt();
                System.out.println();

                if (pedido < 0 || pedido > 3) {
                    System.out.print("Entrada inválida! Por favor, ");
                }
            } while (pedido < 0 || pedido > 3);

            //Se tiver estoque, add ao cliente
            if (pedido != 0) {
                if (computadores[pedido - 1] == null) {
                    System.out.print("O computador " + pedido + " está fora de estoque, ");
                } else {
                    for (int i = 0; i < cliente.computadoresAdquiridos.length; i++) {
                        if (cliente.computadoresAdquiridos[i] == null) {
                            computadores[pedido - 1].addMemoriaUSB(memorias[pedido -1]);
                            cliente.computadoresAdquiridos[i] = computadores[pedido - 1];
                            System.out.println("Computador (" + pedido + ") adicionado ao carrinho de compras.");
                            System.out.println();
                            computadores[pedido - 1] = null;
                            numPedidos++;
                            break;
                        }
                    }
                }
            }
        } while (pedido != 0 && numPedidos < 3);

        //Finalizar a compra
        System.out.println("Finalizando compra...");
        System.out.println("-------------------------");
        System.out.println("Cliente: " + cliente.nome);
        System.out.println("CPF: " + cliente.cpf);
        System.out.println("-------------------------");
        System.out.println();

        //Mostra os pczes adquiridos
        System.out.println("Computadores adquiridos:");
        for (int i = 0; i < cliente.computadoresAdquiridos.length; i++) {
            if (cliente.computadoresAdquiridos[i] != null) {
                System.out.println("Computador " + (i + 1) + ":");
                cliente.computadoresAdquiridos[i].mostraConfigs();
                System.out.println();
            }
        }

        //Mostra o preço total da compra
        System.out.println("Valor total do pedido: R$ " + cliente.calculaTotalCompra());
    }
}
