package br.com.exercicios_minsait.exercicio3;

import java.math.BigDecimal;

public class Conta {
    private final int id;
    private BigDecimal saldo;

    public Conta(int id, BigDecimal saldoInicial) {
        this.id = id;
        this.saldo = saldoInicial;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public synchronized void depositar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public synchronized void sacar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }
}
