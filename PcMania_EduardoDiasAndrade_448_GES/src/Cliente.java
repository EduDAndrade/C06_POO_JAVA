public class Cliente {

    String nome;
    long cpf;
    Computador [] computadoresAdquiridos = new Computador[3];

    public Cliente(String nome, long cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    float calculaTotalCompra(){
        float totalDaCompra = 0;
        for(int i = 0; i < computadoresAdquiridos.length; i++){
            if(computadoresAdquiridos[i] != null){
                totalDaCompra = totalDaCompra + computadoresAdquiridos[i].preco;
            }
        }
        return totalDaCompra;
    }
}