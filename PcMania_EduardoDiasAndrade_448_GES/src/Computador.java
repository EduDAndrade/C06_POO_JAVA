public class Computador {

    String marca;
    float preco;
    SistemaOperacional sistema;
    HardwareBasico hardware;
    MemoriaUSB memoria;

    public Computador(String marca, float preco, SistemaOperacional sistema, HardwareBasico hardware){ //Construtor
        this.marca = marca;
        this.preco = preco;
        this.sistema = sistema;
        this.hardware = hardware;
    }

    void mostraConfigs(){
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Hardware: " + hardware.nome + " " + hardware.capacidade + " GB");
        System.out.println("Sistema Operacional: " + sistema.nome + " (" + sistema.tipo + ")");
        System.out.println("Memória Extra: " + memoria.nome + " com " + memoria.capacidade + " GB");
    }

    void addMemoriaUSB(MemoriaUSB musb){
        hardware.capacidade = hardware.capacidade + musb.capacidade;
    }
}