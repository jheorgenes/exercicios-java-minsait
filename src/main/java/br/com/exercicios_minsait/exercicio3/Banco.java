package br.com.exercicios_minsait.exercicio3;

import java.math.BigDecimal;
import java.util.List;

public class Banco {
    private final List<Conta> contas;

    public Banco(List<Conta> contas) {
        this.contas = contas;
    }

    public void transferir(Conta origem, Conta destino, BigDecimal valor) {

        Conta primeira = origem.getId() < destino.getId() ? origem : destino;
        Conta segunda = origem.getId() < destino.getId() ? destino : origem;

        synchronized (primeira) {
            synchronized (segunda) {
                if(origem.getSaldo().compareTo(valor) >= 0) {
                    origem.sacar(valor);
                    destino.depositar(valor);
                    System.out.printf("Transferência de R$:%s da conta %d para a %d\n", valor.toPlainString(), origem.getId(), destino.getId());
                } else {
                    System.out.printf("Saldo insuficiente na conta %d para transferir R$:%s \n", origem.getId(), valor.toPlainString());
                }
            }
        }
    }

    public void mostrarSaldos() {
        for (Conta conta : contas) {
            System.out.printf("Saldo da conta %d: R$:%s\n", conta.getId(), conta.getSaldo().toPlainString());
        }
    }
}
