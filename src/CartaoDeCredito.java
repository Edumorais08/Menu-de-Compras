import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CartaoDeCredito {

    private double saldo;
    private double limite;
    private List<Compra> listaDecompras;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.listaDecompras = new ArrayList<>();
    }

    public boolean podeComprar(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.listaDecompras.add(compra);
            return true;
        }
        return false;
    }

    public void exibeCompras() {
        listaDecompras.sort(Comparator.comparing(Compra::getValor));
        System.out.println("");
        System.out.println("COMPRAS REALIZADAS: ");
        System.out.println("");
        for (Compra item : listaDecompras) {
            System.out.println(item.toString());
            System.out.println("");
        }

        System.out.println("Saldo do cartão: " + this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite() {
        return limite;
    }

    public List<Compra> getListaDecompras() {
        return listaDecompras;
    }
}
