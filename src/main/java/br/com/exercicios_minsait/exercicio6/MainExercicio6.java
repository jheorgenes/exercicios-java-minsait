package br.com.exercicios_minsait.exercicio6;

import br.com.exercicios_minsait.exercicio6.solid.DiscountOrderTotalCalculator;
import br.com.exercicios_minsait.exercicio6.solid.Item;
import br.com.exercicios_minsait.exercicio6.solid.Order;
import br.com.exercicios_minsait.exercicio6.solid.OrderTotalCalculator;

public class MainExercicio6 {
    public static void main(String[] args) {
        Order order = new Order();
        order.addItem(new Item("Café", 5.0));
        order.addItem(new Item("Pão", 10.0));

        OrderTotalCalculator calculator = new DiscountOrderTotalCalculator(0.1); //10% de desconto
        double total = calculator.calculate(order);
        System.out.println("Total do pedido: R$ " + total);
    }
}
