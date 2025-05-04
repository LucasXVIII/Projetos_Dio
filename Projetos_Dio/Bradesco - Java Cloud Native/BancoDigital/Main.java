import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Cliente maria = new Cliente("Maria");
        Conta cc = new ContaCorrente(maria);
        Conta poupanca = new ContaPoupanca(maria);

        cc.depositar(1000);
        cc.transferir(300, poupanca);

        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
