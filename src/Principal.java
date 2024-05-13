import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        byte continuar = 1;

        System.out.println("Digite o limite do cartão: ");
        CartaoDeCredito cartao = new CartaoDeCredito(sc.nextDouble());

        while(continuar != 0){
            System.out.println("Digite a descrição da compra: ");
            String descricao = sc.next();

            System.out.println("Digite o valor da compra: ");
            double valor = sc.nextDouble();

            Compra novaCompra = new Compra(descricao, valor);

            if (cartao.podeComprar(novaCompra)){
                System.out.println("""
                    Compra realizada!
                                        
                    Digite 0 para sair ou 1 para continuar
                    """);
                continuar = sc.nextByte();
                if (continuar == 0){
                    cartao.exibeCompras();
                }
            } else {
                System.out.println("Saldo insuficiente!");
                cartao.exibeCompras();
                break;
            }
      }
    }
}
