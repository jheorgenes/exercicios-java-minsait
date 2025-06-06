package br.com.exercicios_minsait.exercicio3;

import java.math.BigDecimal;
import java.util.Arrays;

public class MainExercicio3 {
    public static void main(String[] args) throws InterruptedException {
        Conta c1 = new Conta(1, new BigDecimal("1000.00"));
        Conta c2 = new Conta(2, new BigDecimal("1000.00"));
        Conta c3 = new Conta(3, new BigDecimal("1000.00"));

        Banco banco = new Banco(Arrays.asList(c1, c2, c3));

        // Criando as transferencias paralelas
        Runnable t1 = () -> banco.transferir(c1, c2, new BigDecimal("300.00"));
        Runnable t2 = () -> banco.transferir(c2, c3, new BigDecimal("500.00"));
        Runnable t3 = () -> banco.transferir(c3, c1, new BigDecimal("700.00"));

        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        Thread thread3 = new Thread(t3);

        // Executando as transferencias
        thread1.start();
        thread2.start();
        thread3.start();

        // Aguardando as transferencias terminarem
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("\n Saldos finais:");
        banco.mostrarSaldos();
    }
}
