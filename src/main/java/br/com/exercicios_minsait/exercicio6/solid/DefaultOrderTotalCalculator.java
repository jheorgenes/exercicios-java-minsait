package br.com.exercicios_minsait.exercicio6.solid;

public class DefaultOrderTotalCalculator implements OrderTotalCalculator {

    @Override
    public double calculate(Order order) {
        return order.getItems().stream()
                .mapToDouble(Item::getPrice)
                .sum();
    }
}
